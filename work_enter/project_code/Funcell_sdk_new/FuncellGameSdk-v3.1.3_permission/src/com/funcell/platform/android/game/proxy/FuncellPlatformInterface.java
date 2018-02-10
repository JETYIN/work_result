package com.funcell.platform.android.game.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.AssetManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import com.funcell.platform.android.FuncellRUtils;
import com.funcell.platform.android.game.log.FuncellGameLogSeesion;
import com.funcell.platform.android.game.log.FuncellGameLogType;
import com.funcell.platform.android.game.log.FuncellGameLogUploadTask;
import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.IFuncellDataManager;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitCallBack;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformInitCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformNoticeListCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformServerListCallBack;
import com.funcell.platform.android.game.proxy.init.PlatformParamsType;
import com.funcell.platform.android.game.proxy.pay.FuncellBundleKey;
import com.funcell.platform.android.game.proxy.pay.FuncellPayParams;
import com.funcell.platform.android.game.proxy.pay.IFuncellChargerManager;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayListCallBack;
import com.funcell.platform.android.game.proxy.session.FuncellSession;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionManager;
import com.funcell.platform.android.game.proxy.util.FuncellTools;
import com.funcell.platform.android.game.proxy.util.RUtils;
import com.funcell.platform.android.game.proxy.util.UploadUtils;
import com.funcell.platform.android.http.FuncellHttpUtils;
import com.funcell.platform.android.http.FuncellResponseCallback;
import com.funcell.platform.android.http.FuncellRetrofitCallback;
import com.funcell.platform.android.http.FuncellRetrofitUtils;
import com.funcell.platform.android.http.volley.VolleyError;
import com.funcell.platform.android.plugin.FuncellPluginHelper;

public class FuncellPlatformInterface {
	private String TAG = getClass().getName().toString();
	private static FuncellPlatformInterface mInstance;
	private Integer mGameID;
	private Integer mPlatformID;
	private String mPlatform_type;
	private String mNode;
	private String mAppVersion;
	// ---------eve-------------
	private String[] mEveUrlsArray; // 配置文件中eve数组
	private String mEveUrl;// 当前使用的eve地址
	private int mCurrentNum = 0; // 标志位，标志当前eve地址是数组中的第几项
	// ----------------------
	private String mChannelVersionCode;
	private String mResVersion;
	private String serverListData;
	private String mArea = "China"; // default
	private String mBiUrl;

	private String mCLIENT_ID = null;
	private static boolean isInitSuccessed = false;
	private boolean isLogining = false;// 判断是否在登录流程，登录流程如果初始化失败会做初始化处理，处理方式和未登录不一样。
	private String eve = null;
	private boolean mLoginSuccessFlag = false;

	private IFuncellInitCallBack mInitCallBack;
	private IFuncellSessionCallBack mSessionCallBack;
	private IPlatformInitCallBack mPlatformInitCallBack;
	private OnLoginSuccessedListener mOnLoginSuccessedListener = null;

	private static boolean isExitNormal = false;

	private String ERROR_CODE_LOGIN_FAIL = "0";// 登陆失败
	long readtime = 0;
	private String googleId = "";

	Map<FuncellDataTypes, ParamsContainer> mDatasMap = new HashMap<FuncellDataTypes, ParamsContainer>(); // 存放的各种统计信息，登录事件，创建角色事件...
	ParamsContainer mCustomParams = new ParamsContainer(); // 存放用户打包后台配置的自定义参数
	// private boolean mReadConfigFlag = false;

	// ---------------以下参数均为游戏传递------------------------
	private String init_datacenter = null;
	private String init_gameId = null;
	private String init_platformId = null;
	private String init_eve = null;
	private String init_ChannelVersionCode = null;
	private String init_appVersion = null;
	private String init_platformType = null;
	private String init_area = null;
	private String init_resVersion = null;
	private String init_report = null;
	private JSONObject phoneJson;
	// ---------------------------------------

	public static FuncellPlatformInterface getInstance() {
		if (mInstance == null) {
			synchronized (FuncellPlatformInterface.class) {
				if (mInstance == null) {
					mInstance = new FuncellPlatformInterface();
				}
			}
		}
		return mInstance;
	}

	private void readConfig(Context ctx) {
		File config = new File(ctx.getCacheDir(), "funcellconfig.xml");
		if (config.exists()) {
			try {
				InputStream in = new FileInputStream(config);
				initConfigParams(in);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				AssetManager assets = ctx.getAssets();
				InputStream in = assets.open("funcellconfig.xml");
				initConfigParams(in);
				// mReadConfigFlag = true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	private void initConfigParams(InputStream in) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(in);
			Element root = document.getDocumentElement();
			NodeList items = root.getChildNodes();

			for (int i = 0; i < items.getLength(); i++) {
				if (items.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element item = (Element) items.item(i);
					if (item.getNodeName().equals("platform")) {
						NodeList platformNode = item.getChildNodes();
						for (int j = 0; j < platformNode.getLength(); j++) {
							if (platformNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
								Element platformitem = (Element) platformNode.item(j);
								if (platformitem.getNodeName().equals("datacenter")) {
									if (!TextUtils.isEmpty(init_datacenter)) {
										mNode = init_datacenter;
									} else {
										mNode = platformitem.getTextContent();
									}
								} else if (platformitem.getNodeName().equals("gameId")) {
									if (!TextUtils.isEmpty(init_gameId)) {
										mGameID = Integer.valueOf(init_gameId);
									} else {
										mGameID = Integer.valueOf(platformitem.getTextContent());
									}
								} else if (platformitem.getNodeName().equals("platformId")) {
									if (!TextUtils.isEmpty(init_platformId)) {
										mPlatformID = Integer.valueOf(init_platformId);
									} else {
										mPlatformID = Integer.valueOf(platformitem.getTextContent());
									}
								} else if (platformitem.getNodeName().equals("eve")) {
									// mEveUrl = platformitem.getTextContent();
									if (!TextUtils.isEmpty(init_eve)) {
										mEveUrlsArray = init_eve.split(",");
										mEveUrl = mEveUrlsArray[0]; // 默认使用第一项
									} else {
										mEveUrlsArray = platformitem.getTextContent().split(",");
										mEveUrl = mEveUrlsArray[0]; // 默认使用第一项
									}
								} else if (platformitem.getNodeName().equals("ChannelVersionCode")) {
									if (!TextUtils.isEmpty(init_ChannelVersionCode)) {
										mChannelVersionCode = init_ChannelVersionCode;
									} else {
										mChannelVersionCode = platformitem.getTextContent();
									}
								} else if (platformitem.getNodeName().equals("appVersion")) {
									if (!TextUtils.isEmpty(init_appVersion)) {
										mAppVersion = init_appVersion;
									} else {
										mAppVersion = platformitem.getTextContent();
									}
								} else if (platformitem.getNodeName().equals("platformType")) {
									if (!TextUtils.isEmpty(init_platformType)) {
										mPlatform_type = init_platformType;
									} else {
										mPlatform_type = platformitem.getTextContent();
									}
								} else if (platformitem.getNodeName().equals("area")) {
									if (!TextUtils.isEmpty(init_area)) {
										mArea = init_area;
									} else {
										mArea = platformitem.getTextContent();
									}
								} else if (platformitem.getNodeName().equals("resVersion")) {
									if (!TextUtils.isEmpty(init_resVersion)) {
										mResVersion = init_resVersion;
									} else {
										mResVersion = platformitem.getTextContent();
									}
								} else if (platformitem.getNodeName().equals("report")) {
									if (!TextUtils.isEmpty(init_report)) {
										mBiUrl = init_report;
									} else {
										mBiUrl = platformitem.getTextContent();
									}
								}
							}
						}
					} else if (item.getNodeName().equals("customKey")) {
						NodeList customKeyNode = item.getChildNodes();
						for (int j = 0; j < customKeyNode.getLength(); j++) {
							if (customKeyNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
								Element customKeyitem = (Element) customKeyNode.item(j);
								String key = customKeyitem.getNodeName();
								String value = customKeyitem.getTextContent();
								mCustomParams.put(key, value);
							}
						}
					}
				}
			}

			m_platformConfig.func_ClientID = mGameID + ":" + mPlatformID + ":" + mAppVersion + ":" + mPlatform_type;
			m_platformConfig.func_even_node = mNode;
			m_platformConfig.func_platform_name = mPlatform_type;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setConfigParams(Activity ctx, Object... params) {
		if (params != null && params.length > 0) {
			if (params[0] instanceof String) {
				String initParams = (String) params[0];
				Log.e(TAG, "initParams:" + initParams);
				try {
					JSONObject jsonObject = new JSONObject(initParams);
					for (Iterator<String> keysIterator = jsonObject.keys(); keysIterator.hasNext();) {
						String key = keysIterator.next();
						switch (key) {
						case "datacenter":
							init_datacenter = jsonObject.getString(key);
							savaConfigParams(ctx, "datacenter", init_datacenter);
							break;
						case "gameId":
							init_gameId = jsonObject.getString(key);
							savaConfigParams(ctx, "gameId", init_gameId);
							break;
						case "platformId":
							init_platformId = jsonObject.getString(key);
							savaConfigParams(ctx, "platformId", init_platformId);
							break;
						case "eve":
							init_eve = jsonObject.getString(key);
							savaConfigParams(ctx, "eve", init_eve);
							break;
						case "ChannelVersionCode":
							init_ChannelVersionCode = jsonObject.getString(key);
							savaConfigParams(ctx, "ChannelVersionCode", init_ChannelVersionCode);
							break;
						case "appVersion":
							init_appVersion = jsonObject.getString(key);
							savaConfigParams(ctx, "appVersion", init_appVersion);
							break;
						case "platformType":
							init_platformType = jsonObject.getString(key);
							savaConfigParams(ctx, "platformType", init_platformType);
							break;
						case "area":
							init_area = jsonObject.getString(key);
							savaConfigParams(ctx, "area", init_area);
							break;
						case "resVersion":
							init_resVersion = jsonObject.getString(key);
							savaConfigParams(ctx, "resVersion", init_resVersion);
							break;
						case "report":
							init_report = jsonObject.getString(key);
							savaConfigParams(ctx, "report", init_report);
							break;
						default:
							break;
						}
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private void savaConfigParams(Activity ctx, String key, String value) {
		if (TextUtils.isEmpty(value) || TextUtils.isEmpty(key)) {
			return;
		}
		File config = new File(ctx.getCacheDir(), "funcellconfig.xml");
		if (config.exists()) {
			modifyConfigParams(ctx, key, value);
		} else {
			try {
				InputStream assestInput = ctx.getAssets().open("funcellconfig.xml");
				if (FuncellTools.copyFile(assestInput, config.getAbsolutePath())) {
					modifyConfigParams(ctx, key, value);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void modifyConfigParams(Activity ctx, String key, String value) {
		File config = new File(ctx.getCacheDir(), "funcellconfig.xml");
		try {
			InputStream in = new FileInputStream(config);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(in);

			Element root = document.getDocumentElement();
			NodeList items = root.getChildNodes();
			for (int i = 0; i < items.getLength(); i++) {
				if (items.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element item = (Element) items.item(i);
					if (item.getNodeName().equals("platform")) {
						NodeList platformNode = item.getChildNodes();
						for (int j = 0; j < platformNode.getLength(); j++) {
							if (platformNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
								Node platformitem = (Node) platformNode.item(j);
								if (platformitem.getNodeName().equals(key)) {
									if (platformitem.getTextContent().equals(value)) {
										Log.e(TAG, "key:" + key + ":" + "value:" + value + " not change");
										return;
									}
									platformitem.setTextContent(value);
								}
							}
						}
					}
				}
			}
			TransformerFactory tFactory = TransformerFactory.newInstance();// 将内存中的Dom保存到文件
			Transformer transformer = tFactory.newTransformer();
			// 设置输出的xml的格式，utf-8
			transformer.setOutputProperty("encoding", "utf-8");
			DOMSource source = new DOMSource(document);

			OutputStream out = new FileOutputStream(config);
			StreamResult src = new StreamResult(out);
			transformer.transform(source, src);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String GetCustomParams(Activity ctx, String... key) {
		readConfig(ctx);
		String result = "";
		if (key.length > 0) {
			result = mCustomParams.getString(key[0]);
		} else {
			result = new JSONObject(mCustomParams).toString();
		}
		return result;
	}

	public String EveData() {
		return eve;
	}

	public boolean GetLoginFlag() {
		return mLoginSuccessFlag;
	}

	public void SetLoginFlag(boolean flag) {
		mLoginSuccessFlag = flag;
		/**
		 * 重置funcell session日志信息采集
		 */
		FuncellGameLogSeesion.getInstance().setSession(null);
	}

	private void setClientId(String clientId) {
		mCLIENT_ID = clientId;
	}

	public String getClientId() {
		return mCLIENT_ID;
	}

	public Map<FuncellDataTypes, ParamsContainer> GetDatasMap() {
		return mDatasMap;
	}

	public String GetPlatformParams(Activity ctx, PlatformParamsType platformParamsType) {
		// if(!mReadConfigFlag){
		//
		// }
		readConfig(ctx);
		String ret = "";
		if (PlatformParamsType.GameID == platformParamsType) {
			ret = String.valueOf(mGameID);
		} else if (PlatformParamsType.PlatformID == platformParamsType) {
			ret = String.valueOf(mPlatformID);
		} else if (PlatformParamsType.PlatformType == platformParamsType) {
			ret = mPlatform_type;
		} else if (PlatformParamsType.AppVersion == platformParamsType) {
			ret = mAppVersion;
		} else if (PlatformParamsType.ClientId == platformParamsType) {
			ret = mGameID + ":" + mPlatformID + ":" + mAppVersion + ":" + mPlatform_type;
		} else if (PlatformParamsType.Area == platformParamsType) {
			ret = mArea;
		} else if (PlatformParamsType.ResVersion == platformParamsType) {
			ret = mResVersion;
		} else if (PlatformParamsType.BiUrl == platformParamsType) {
			ret = mBiUrl;
		}
		return ret;
	}

	public void GetServerList(final Activity ctx, final IPlatformServerListCallBack callBack, String... white_key) {
		readConfig(ctx);
		String whitekey = "";
		if (white_key.length > 0) {
			whitekey = white_key[0];
		}
		JSONTokener jsonParser = new JSONTokener(EveData());
		JSONObject person;
		try {
			person = (JSONObject) jsonParser.nextValue();
			String jsonServerlist = person.optString("serverlist");
			String access_token = m_platformConfig.func_access_token;
			String serverlistUrl = jsonServerlist + "serverlist/index?client_id=" + mGameID + ":" + mPlatformID + ":"
					+ mAppVersion + ":" + mPlatform_type + "&white_key=" + whitekey + "&access_token=" + access_token;

			FuncellRetrofitUtils.getInstance().get(serverlistUrl, new FuncellRetrofitCallback() {

				@Override
				public void onResponse(String response) {
					// TODO Auto-generated method stub
					try {
						JSONObject jsonObject = new JSONObject(response);
						if (!(jsonObject.has("error_code")
								&& jsonObject.getString("error_code").equalsIgnoreCase("P1111"))) {
							BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, response, callBack);
						} else {
							callBack.onSuccess(response);
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, e.toString(), callBack);
					}
				}

				@Override
				public void onFailure(String throwable) {
					// TODO Auto-generated method stub
					BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, throwable, callBack);
				}

			});

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, e.toString(), callBack);
		}
	}

	public void GetServerList(final Activity ctx, final IPlatformServerListCallBack callBack,
			ParamsContainer... paramsContainers) {
		readConfig(ctx);
		String whitekey = "";
		String timeout = "";
		if (paramsContainers.length > 0) {
			ParamsContainer params = paramsContainers[0];
			whitekey = params.getString("white_key");
			timeout = params.getString("time_out");
		}

		JSONTokener jsonParser = new JSONTokener(EveData());
		JSONObject person;
		try {
			person = (JSONObject) jsonParser.nextValue();
			String jsonServerlist = person.optString("serverlist");
			String access_token = m_platformConfig.func_access_token;
			String serverlistUrl = jsonServerlist + "serverlist/index?client_id=" + mGameID + ":" + mPlatformID + ":"
					+ mAppVersion + ":" + mPlatform_type + "&white_key=" + whitekey + "&access_token=" + access_token;

			FuncellRetrofitUtils.getInstance().get(serverlistUrl, timeout, new FuncellRetrofitCallback() {

				@Override
				public void onResponse(String response) {
					// TODO Auto-generated method stub
					try {
						JSONObject jsonObject = new JSONObject(response);
						if (!(jsonObject.has("error_code")
								&& jsonObject.getString("error_code").equalsIgnoreCase("P1111"))) {
							BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, response, callBack);
						} else {
							callBack.onSuccess(response);
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, e.toString(), callBack);
					}
				}

				@Override
				public void onFailure(String throwable) {
					// TODO Auto-generated method stub
					BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, throwable, callBack);
				}

			});

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseFuncellGameSdkProxy.getInstance().BaseServerListFailure(ctx, e.toString(), callBack);
		}
	}

	public void PlatformServerListFailure(Activity ctx, String json, IPlatformServerListCallBack callBack) {
		FuncellGameLogUploadTask.getInstance().PostExecute(ctx, json, FuncellGameLogType.serverlist.toString());
		callBack.onFailure(json);
	}

	public void GetNoticeList(final Activity ctx, String type, final IPlatformNoticeListCallBack callBack,
			String... server_id) {
		readConfig(ctx);
		String serverId = "";
		if (server_id.length > 0) {
			serverId = server_id[0];
		}
		JSONTokener jsonParser = new JSONTokener(EveData());
		JSONObject person;
		try {
			person = (JSONObject) jsonParser.nextValue();
			String jsonNotice = person.optString("notice");
			String access_token = m_platformConfig.func_access_token;
			String noticeUrl = jsonNotice + "?client_id=" + mGameID + ":" + mPlatformID + ":" + mAppVersion + ":"
					+ mPlatform_type + "&type=" + type + "&serverid=" + serverId + "&access_token=" + access_token;

			FuncellRetrofitUtils.getInstance().get(noticeUrl, new FuncellRetrofitCallback() {

				@Override
				public void onResponse(String response) {
					// TODO Auto-generated method stub
					try {
						JSONObject jsonObject = new JSONObject(response);
						if (!(jsonObject.has("error_code")
								&& jsonObject.getString("error_code").equalsIgnoreCase("P1111"))) {
							BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, response, callBack);
						} else {
							callBack.onSuccess(response);
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, e.toString(), callBack);
					}
				}

				@Override
				public void onFailure(String throwable) {
					// TODO Auto-generated method stub
					BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, throwable, callBack);
				}

			});

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, e.toString(), callBack);
		}
	}

	public void GetNoticeList(final Activity ctx, String type, final IPlatformNoticeListCallBack callBack,
			ParamsContainer... paramsContainers) {
		readConfig(ctx);
		String serverId = "";
		String timeout = "";
		if (paramsContainers.length > 0) {
			ParamsContainer params = paramsContainers[0];
			serverId = params.getString("server_id");
			timeout = params.getString("time_out");
		}
		JSONTokener jsonParser = new JSONTokener(EveData());
		JSONObject person;
		try {
			person = (JSONObject) jsonParser.nextValue();
			String jsonNotice = person.optString("notice");
			String access_token = m_platformConfig.func_access_token;
			String noticeUrl = jsonNotice + "?client_id=" + mGameID + ":" + mPlatformID + ":" + mAppVersion + ":"
					+ mPlatform_type + "&type=" + type + "&serverid=" + serverId + "&access_token=" + access_token;

			FuncellRetrofitUtils.getInstance().get(noticeUrl, timeout, new FuncellRetrofitCallback() {

				@Override
				public void onResponse(String response) {
					// TODO Auto-generated method stub
					try {
						JSONObject jsonObject = new JSONObject(response);
						if (!(jsonObject.has("error_code")
								&& jsonObject.getString("error_code").equalsIgnoreCase("P1111"))) {
							BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, response, callBack);
						} else {
							callBack.onSuccess(response);
						}
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, e.toString(), callBack);
					}
				}

				@Override
				public void onFailure(String throwable) {
					// TODO Auto-generated method stub
					BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, throwable, callBack);
				}

			});

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			BaseFuncellGameSdkProxy.getInstance().BaseNoticeListFailure(ctx, e.toString(), callBack);
		}
	}

	public void PlatformNoticeListFailure(Activity ctx, String json, IPlatformNoticeListCallBack callBack) {
		FuncellGameLogUploadTask.getInstance().PostExecute(ctx, json, FuncellGameLogType.notice.toString());
		callBack.onFailure(json);
	}

	private void initEve(final Activity ctx, final IFuncellInitCallBack initCallBack) {
		if (!FuncellTools.isNetworkAvailable(ctx)) {
			Log.i(TAG, "无网络连接...初始化失败!!!");
			// 处理网络连接失败问题
			// Builder builder = new AlertDialog.Builder(ctx,
			// AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
			// builder.setTitle(ctx.getResources().getString(
			// RUtils.string(ctx, "funcell_networkerror")));
			// builder.setMessage(ctx.getResources().getString(
			// RUtils.string(ctx, "funcell_checknetwork")));
			//
			// builder.setPositiveButton("", new OnClickListener() {
			//
			// @Override
			// public void onClick(DialogInterface arg0, int arg1) {
			// // TODO Auto-generated method stub
			// if (isLogining) {
			// isLogining = false;
			// }
			// }
			// }).create().show();
			// 无网络连接...初始化失败
			initCallBack.onInitFailure("-1");
			return;
		} else {
			final String url = mEveUrl + m_platformConfig.func_ClientID + "/" + m_platformConfig.func_even_node;
			Log.i(TAG, "url = " + url);
			FuncellHttpUtils.getInstance(ctx).get(String.valueOf(System.currentTimeMillis()), url,
					new FuncellResponseCallback() {

						@Override
						public void onResponse(String response) {
							initTask(ctx, url, initCallBack);
							mCurrentNum = 0;
						}

						@Override
						public void onErrorResponse(String error) {
							initCallBack.onInitFailure("error:" + error);
						}

						@Override
						public void onErrorResponse(VolleyError error) {
							// TODO Auto-generated method stub
							String msg = "unknow";
							if (error != null) {
								msg = "Message:" + error.getMessage();
								Log.e(TAG, "-------------error.getMessage():" + error.getMessage());
								if (error.networkResponse != null) {
									int statusCode = error.networkResponse.statusCode;
									msg = "Message:" + error.getMessage() + " statusCode:" + statusCode;
								}
								FuncellGameLogUploadTask.getInstance().PostExecute(ctx, msg, "init");
							}
							// -------使用eve数组中的下一项地址---------
							mCurrentNum += 1;
							if (mCurrentNum < mEveUrlsArray.length) {
								mEveUrl = mEveUrlsArray[mCurrentNum];
								initEve(ctx, initCallBack);
							} else {
								initCallBack.onInitFailure(msg);
							}
							// ---------------------------------
						}
					}, true);

		}
	}

	public void SetPlatformInitCallBack(IPlatformInitCallBack platformInitCallBack) {
		mPlatformInitCallBack = platformInitCallBack;
	}

	private void initTask(final Activity ctx, String url, final IFuncellInitCallBack initCallBack) {
		FuncellHttpUtils.getInstance(ctx).get(null, url, new FuncellResponseCallback() {

			@Override
			public void onResponse(String response) {
				Log.i(TAG, "init data = " + response);
				eve = response;
				if (null == eve) {
					Log.i(TAG, "init fail : eve is null");
					if (isLogining) {
						isLogining = false;
						mSessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
					}
					return;
				}
				JSONTokener jsonParser = new JSONTokener(eve);
				JSONObject person;
				try {
					person = (JSONObject) jsonParser.nextValue();

					m_platformConfig.func_log_url = person.optString("log");
					m_platformConfig.func_pay_url = person.getString("pay");
					m_platformConfig.func_auth_url = person.getString("auth");
					/** notice--修改成fgi **/
					// m_platformConfig.func_pay_callback = person
					// .getString("callback")
					// + "game/"
					// + mGameID
					// + "/platform/" + mPlatform_type;

					m_platformConfig.func_pay_callback = person.getString("callback") + "fgi/" + mPlatformID;

					if (m_platformConfig.func_auth_url != "" && m_platformConfig.func_pay_url != "") {
						isInitSuccessed = true;
						Log.i(TAG, "初始化成功!!!" + eve);
						if (null != m_platformConfig.func_log_url
								&& 0 < m_platformConfig.func_log_url.trim().length()) {
							// handler.sendEmptyMessage(1001);
						}
						if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
						{
							isLogining = false;
							// mSessionManager.Login(ctx,
							// mSessionCallBack);
						}
						if (mPlatformInitCallBack != null) {
							mPlatformInitCallBack.onInitSuccess();
						}
						initCallBack.onInitSuccess();

					} else {
						Log.i(TAG, "init fail : auth|pay url is null");
						if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
						{
							isLogining = false;
							mSessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
						}
					}
				} catch (Exception e) {
					Log.i(TAG, "init fail : " + eve + " , e : " + e);
					e.printStackTrace();
					if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
					{
						isLogining = false;
						mSessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
					}
				}
			}

			@Override
			public void onErrorResponse(String error) {
				Log.i(TAG, "init error : " + error);
				if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
				{
					isLogining = false;
					mSessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
				}
			}

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub
				Log.e(TAG, "initeve onErrorResponse VolleyError error");
				if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
				{
					isLogining = false;
					mSessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
				} else {
					if (error != null) {
						String msg = "Message:" + error.getMessage();
						Log.e(TAG, "-------------error.getMessage():" + error.getMessage());
						if (error.networkResponse != null) {
							int statusCode = error.networkResponse.statusCode;
							msg = "Message:" + error.getMessage() + " statusCode:" + statusCode;
						}
						FuncellGameLogUploadTask.getInstance().PostExecute(ctx, msg, "init");
						initCallBack.onInitFailure(msg);
					}
				}

			}
		}, true);
	}

	PlatformConfig m_platformConfig = new PlatformConfig();

	public void PlatformInit(Activity ctx, IFuncellInitCallBack initCallBack) {
		mInitCallBack = initCallBack;
		readConfig(ctx);
		if (null == ctx || null == mGameID || null == mPlatformID || null == mPlatform_type || null == mNode
				|| null == mAppVersion) {
			Log.i(TAG, "渠道配置参数不全！！！");
			initCallBack.onInitFailure("渠道配置参数不全");
			return;
		}
		m_platformConfig.func_ClientID = mGameID + ":" + mPlatformID + ":" + mAppVersion + ":" + mPlatform_type;
		m_platformConfig.func_even_node = mNode;
		m_platformConfig.func_platform_name = mPlatform_type;

		setClientId(m_platformConfig.func_ClientID);

		initEve(ctx, initCallBack);
		initGoogleId(ctx);
	}

	/**
	 * 
	 */
	private void initGoogleId(Activity sContext) {

		FuncellTools.initGoogleId(sContext);
	}

	public void PlatformInitSuccess(Activity ctx, IFuncellInitCallBack initCallBack) {
		initCallBack.onInitSuccess();
		// 统计初始化激活
		if (true == UploadUtils.getInstance(ctx).getIsFirstOpen(ctx)) {
			String channel = mPlatform_type;
			if (!TextUtils.isEmpty((String) FuncellPluginHelper.callFunction(ctx,
					FuncellCustomManagerImpl.getInstance(), "getSubChannel"))) {
				channel = (String) FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(),
						"getSubChannel");
			}
			Log.i(TAG, "Active log");
			/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓统计激活↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
			StringBuffer activiteLog = new StringBuffer();
			activiteLog.append(mGameID + "");
			Log.i(TAG, "mGameID= " + mGameID);
			activiteLog.append("~@");
			activiteLog.append(mArea);
			activiteLog.append("~@");
			activiteLog.append(channel);
			Log.i(TAG, "channel= " + channel);
			activiteLog.append("~@");
			activiteLog.append(mAppVersion);
			Log.i(TAG, "mAppVersion= " + mAppVersion);
			UploadUtils.getInstance(ctx).countActivite("Active", activiteLog.toString().trim(), mArea, mGameID + "",
					true);
			Log.i(TAG, "调用了激活接口");
			/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑统计激活↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
			UploadUtils.getInstance(ctx).setIsFirstOpen(ctx, false);
		}
	}

	public void PlatformInitFailure(Activity ctx, String json, IFuncellInitCallBack initCallBack) {
		initCallBack.onInitFailure(json);
		FuncellGameLogUploadTask.getInstance().PostExecute(ctx, json, "init");
	}

	public void PlatformGetPayList(Activity ctx, boolean isStrange, String category,
			final IFuncellPayListCallBack payListCallBack) {
		boolean isRead = false;
		long over = System.currentTimeMillis() - readtime;

		if (over > 3600000) {
			isRead = true;
		}
		if (m_platformConfig.func_pay_json == null || m_platformConfig.func_pay_json.length() < 1) {
			isRead = true;
		}

		if (isStrange) {
			isRead = true;
		}
		// 检查支付字串是否已经设置成功了
		if (isRead) {
			readtime = System.currentTimeMillis();
			// TODO Auto-generated method stub
			String url = m_platformConfig.func_pay_url + "item";
			HashMap<String, String> postData = new HashMap<String, String>();
			postData.put("category", category);
			postData.put("access_token",
					null == m_platformConfig.func_access_token ? "" : m_platformConfig.func_access_token);
			Log.i(TAG, "pay list url = " + url + " , postData = " + postData);
			FuncellHttpUtils.getInstance(ctx).post(String.valueOf(System.currentTimeMillis()), url, postData,
					new FuncellResponseCallback() {

						@Override
						public void onResponse(String response) {
							if (null == response || response.trim().length() == 0 || !response.startsWith("[")) {
								Log.i(TAG, "获取充值列表失败了  " + response);
								payListCallBack.onFail("response:" + response);
								// BaseFuncellGameSdkProxy.getInstance().BasePayListCallBack(payListCallBack,
								// PayListCallBackType.onFail, ""+response);
								return;
							}
							m_platformConfig.func_pay_json = response;
							Log.i(TAG, "pay list  = " + response);
							Log.i(TAG, "获取充值列表成功!!! ");
							payListCallBack.onSuccess(response);
							// BaseFuncellGameSdkProxy.getInstance().BasePayListCallBack(payListCallBack,
							// PayListCallBackType.onSuccess, response);
						}

						@Override
						public void onErrorResponse(String error) {
							Log.i(TAG, "pay list error : " + error);
							payListCallBack.onFail(error);
							// BaseFuncellGameSdkProxy.getInstance().BasePayListCallBack(payListCallBack,
							// PayListCallBackType.onFail, ""+error);
						}

						@Override
						public void onErrorResponse(VolleyError error) {
							// TODO Auto-generated method stub

						}
					});
		}
	}

	public void PlatformLogin(Activity ctx, IFuncellSessionManager sessionManager,
			IFuncellSessionCallBack sessionCallBack) {
		// 删除当前登录限制，
		/*
		 * if (mLoginSuccessFlag) { Toast.makeText(ctx,
		 * FuncellRUtils.string(ctx, "FUNCELL_LOGIN_FLAG_TEST"), 0) .show();
		 * return; }
		 */
		readConfig(ctx);
		Log.i(TAG, "PlatformLogin 开始登录...");
		mSessionCallBack = sessionCallBack;
		if (isLogining) {
			Log.i(TAG, "--------正在初始化-------");
			return;
		}
		if (!isInitSuccessed) {
			Log.i(TAG, "----------初始化未成功就登录，初始化重试----------");
			isLogining = true; // 记录platform_eveInit是在登录环境触发的
			initEve(ctx, mInitCallBack);
			return;
		}
		Log.i(TAG, "--------正常登录--------");
		isLogining = false;
		sessionManager.Login(ctx, sessionCallBack);
	}

	private void StartGame(PlatformConfig platformConfig, IFuncellSessionCallBack sessionCallBack, boolean... flag) {
		mLoginSuccessFlag = true;
		FuncellSession session = new FuncellSession();
		session.setmToken(platformConfig.func_access_token);
		session.setmChannelUserId(platformConfig.func_platform_uid);
		session.setmUserID(platformConfig.func_fed_id);
		session.setmJson(platformConfig.func_login_json);
		/**
		 * funcell统计，用于内部日志信息采集
		 */
		FuncellGameLogSeesion.getInstance().setSession(session);

		if (flag.length > 0) {
			sessionCallBack.onSwitchAccount(session);
			Log.e(TAG, "callback to game by onSwitchAccount");
		} else {
			sessionCallBack.onLoginSuccess(session);
			Log.e(TAG, "callback to game by onLoginSuccess");
		}
		// BaseFuncellGameSdkProxy.getInstance().BaseSessionCallBack(sessionCallBack,
		// SessionCallbackType.onSessionSuccess, session);
	}

	public interface OnLoginSuccessedListener {
		void LoginCallBack(PlatformConfig result);
	}

	public void SetLoginSuccessedListener(OnLoginSuccessedListener listener) {
		mOnLoginSuccessedListener = listener;
	}

	private JSONObject getPhoneInfoJson(Activity sContext) {
		phoneJson = new JSONObject();

		try {
			phoneJson.put("mo", FuncellTools.getPhoneModel());// 终端机型
			phoneJson.put("sy", "anzhuo");// 系统
			phoneJson.put("ID", FuncellTools.getAndroidId(sContext));// androidId
			phoneJson.put("ve", FuncellTools.getPhoneVersion());// 终端系统版本
			phoneJson.put("cpu", FuncellTools.getCPU());// cpu
			phoneJson.put("me", FuncellTools.getRAM(sContext));// 终端内存
			phoneJson.put("re", FuncellTools.getScreenPiexl(sContext));// 分辨率
			phoneJson.put("ne", FuncellTools.getNetType(sContext));// 联网方式
			phoneJson.put("op", FuncellTools.getMobileServiceProvider(sContext));// 运营商
			phoneJson.put("imei", FuncellTools.getImei(sContext));//
			phoneJson.put("phone", FuncellTools.getPhoneNum(sContext));//
			phoneJson.put("googleId", FuncellTools.getAdvertisingId());// googleId
			// 不需权限
		} catch (Exception e) {
			Log.e(TAG, "--------ERROR-----" + e.toString());
			e.printStackTrace();
		}
		return phoneJson;

	}

	public void PlatformLoginSuccess(final Activity ctx, String userName, String uid, String token,
			final IFuncellSessionCallBack sessionCallBack, final boolean... flag) {
		/**
		 * 将渠道的用户发给平台校验，成功后，返回平台的用户信息给游戏接入者
		 */
		String url = m_platformConfig.func_auth_url + "authorize";
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("grant_type", "password");
		postData.put("client_id", m_platformConfig.func_ClientID);
		postData.put("username", m_platformConfig.func_platform_name + ":" + userName);
		String TokenString = Base64.encodeToString(token.getBytes(), Base64.DEFAULT);
		postData.put("password", null == TokenString ? "" : TokenString);
		postData.put("scope", "auth");
		postData.put("device_id", null == FuncellTools.getAndroidId(ctx) ? "" : FuncellTools.getAndroidId(ctx));
		postData.put("sdkver", mChannelVersionCode);
		postData.put("device_info", getPhoneInfoJson(ctx).toString());// 需要传到ums上的硬件参数

		Log.i(TAG, "login url  = " + url + " & data = " + postData);

		FuncellHttpUtils.getInstance(ctx).post(String.valueOf(System.currentTimeMillis()), url, postData,
				new FuncellResponseCallback() {

					@Override
					public void onResponse(String response) {
						Log.i(TAG, "login response = " + response);
						if (TextUtils.isEmpty(response)) {
							sessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
							return;
						}
						JSONTokener jsonParser = new JSONTokener(response);
						JSONObject person = null;
						try {
							person = (JSONObject) jsonParser.nextValue();

							String err_code = person.getString("error_code");
							if (err_code != null)// 登录失败了
							{
								Log.i(TAG, "登录失败...");
								sessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
								BaseFuncellGameSdkProxy.getInstance().BaseLoginFailure(ctx, "login failed:" + response,
										sessionCallBack);
								return;
							}
						} catch (Exception e) {
							Log.i(TAG, "返回了正常的数据");
							if (person == null) {
								Log.i(TAG, "登录验证失败，请重新登录！");
								sessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
								return;
							}
						}
						// 解析登录成功的数据
						try {
							m_platformConfig.func_access_token = person.getString("access_token");
							m_platformConfig.func_refresh_token = person.getString("refresh_token");
							m_platformConfig.func_platform_uid = person.getString("platform_uid");
							m_platformConfig.func_fed_id = person.getString("fed_id");
							if (person.has("new_user")) {
								m_platformConfig.func_new_user = person.getString("new_user");
							}
							m_platformConfig.func_login_json = person.toString();
							/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓统计登录↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
							String channel = m_platformConfig.func_platform_name;
							if (!TextUtils.isEmpty((String) FuncellPluginHelper.callFunction(ctx,
									FuncellCustomManagerImpl.getInstance(), "getSubChannel"))) {
								channel = (String) FuncellPluginHelper.callFunction(ctx,
										FuncellCustomManagerImpl.getInstance(), "getSubChannel");
							}
							Log.i(TAG, "register log");
							StringBuffer registerLog = new StringBuffer();
							registerLog.append(mGameID + "");
							Log.i(TAG, "mGameID= " + mGameID);
							registerLog.append("~@");
							registerLog.append(mArea);
							registerLog.append("~@");
							// registerLog.append(m_platformConfig.func_platform_name);
							registerLog.append(channel);
							Log.i(TAG, "channel= " + channel);
							registerLog.append("~@");
							registerLog.append(mAppVersion);
							Log.i(TAG, "mAppVersion= " + mAppVersion);
							registerLog.append("~@");
							registerLog.append(m_platformConfig.func_fed_id);
							Log.i(TAG, "func_fed_id= " + m_platformConfig.func_fed_id);
							Log.i(TAG, "-----------  isNewUser " + m_platformConfig.func_new_user);
							if (!TextUtils.isEmpty(m_platformConfig.func_new_user)
									&& m_platformConfig.func_new_user.equals("new")) {
								// UploadUtils.getInstance(ctx).countActivite("AccountRegister",registerLog.toString().trim(),
								// mArea,mGameID + "", true);
								// Log.i(TAG, "调用了注册统计接口");
							}
							Log.i(TAG, "login log");
							UploadUtils.getInstance(ctx).countActivite("AccountLogin", registerLog.toString().trim(),
									mArea, mGameID + "", true);
							Log.i(TAG, "调用了统计账号登录接口");

							/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑计激活↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
						} catch (Exception e) {
							sessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
							BaseFuncellGameSdkProxy.getInstance().BaseLoginFailure(ctx, e.toString(), sessionCallBack);
							return;
						}
						if (m_platformConfig.func_platform_uid.length() > 0) {
							Log.i(TAG, "login success...........");
							Log.i(TAG, "func_access_token = " + m_platformConfig.func_access_token + " , func_fed_id = "
									+ m_platformConfig.func_fed_id);

							/**
							 * 平台验证成功，返回平台用户数据给游戏接入者
							 */
							StartGame(m_platformConfig, sessionCallBack, flag);
							Log.i(TAG, "callback to game end...");
						}

						if (person != null) {
							try {
								m_platformConfig.chan_ext_data = null == person.getString("ext_data") ? null
										: person.getString("ext_data");
							} catch (JSONException e) {
							}
						}
						if (null != mOnLoginSuccessedListener) {
							mOnLoginSuccessedListener.LoginCallBack(m_platformConfig); // 登录成功后设置的回调,(熊猫玩SDK需要此回调来获取token信息)
						}
					}

					@Override
					public void onErrorResponse(String error) {
						Log.i(TAG, "login error = " + error);
						sessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
						BaseFuncellGameSdkProxy.getInstance().BaseLoginFailure(ctx, error, sessionCallBack);
					}

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						sessionCallBack.onLoginFailed(ERROR_CODE_LOGIN_FAIL);
						BaseFuncellGameSdkProxy.getInstance().BaseLoginFailure(ctx, error.getLocalizedMessage(),
								sessionCallBack);
					}
				});
	}

	public void PlatformLoginFailure(Activity ctx, String json, IFuncellSessionCallBack sessionCallBack) {
		FuncellGameLogUploadTask.getInstance().PostExecute(ctx, json, FuncellGameLogType.auth.toString());
		sessionCallBack.onLoginFailed(json);
	}

	public PlatformConfig getPlatformConfig() {
		return m_platformConfig;
	}

	private void callChargerImpl(final Activity ctx, final IFuncellChargerManager chargerManager, Bundle bundle,
			final FuncellPayParams PayParams, final IFuncellPayCallBack payCallBack) {
		FuncellPayParams params = new FuncellPayParams();
		params = PayParams;
		params.setmBundle(bundle);
		chargerManager.pay(ctx, params, payCallBack);
	}

	private void SdkPay(final Activity ctx, final IFuncellChargerManager chargerManager,
			final FuncellPayParams PayParams, final IFuncellPayCallBack payCallBack) {
		readConfig(ctx);
		Log.i(TAG, "-------->支付开始<----------");
		FuncellTools.startProgress(ctx.getResources().getString(RUtils.string(ctx, "funcell_startpay")), ctx);

		String PayType = PayParams.getmPayType();
		final String itemID = PayParams.getmItemId();
		final String itemName = PayParams.getmItemName();
		final int itemCount = PayParams.getmItemCount();
		final float moneyAmount = PayParams.getmItemAmount().valueOfMoney().floatValue();
		final short lsID = 0;
		String extData = PayParams.getmExtrasParams();
		final String multPay = PayParams.getmMultPay();
		String cpOrder = PayParams.getmOrderId();
		final String serverId = PayParams.getmRoleInfo().getServerId();
		final String roleId = PayParams.getmRoleInfo().getRoleId();
		final String roleName = PayParams.getmRoleInfo().getRoleName();

		String url = m_platformConfig.func_pay_url + "charge?t=" + String.valueOf(System.currentTimeMillis());
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("category", null == PayType ? "" : PayType);
		postData.put("access_token", m_platformConfig.func_access_token + "");
		postData.put("item", TextUtils.isEmpty(itemID) ? "100002" : itemID);
		// postData.put("item",
		// mEveUrl.equalsIgnoreCase("http://eve-beta.funcell123.com/config/") ?
		// "100002" : itemID);
		postData.put("amount", "1");// 数量,商品数量,一般为1
		postData.put("server_id", null == serverId ? "" : serverId);
		postData.put("character_id", null == roleId ? "" : roleId);
		postData.put("ext_data", null == extData || 0 == extData.trim().length() ? ""
				: Base64.encodeToString(extData.getBytes(), Base64.DEFAULT));
		Log.e(TAG, "url = " + url + " , postData = " + postData);

		FuncellHttpUtils.getInstance(ctx).post(String.valueOf(System.currentTimeMillis()), url, postData,
				new FuncellResponseCallback() {

					@Override
					public void onResponse(String response) {
						if (TextUtils.isEmpty(response)) {
							FuncellTools.dimssProgress(ctx);
							FuncellTools.alert(ctx.getResources().getString(RUtils.string(ctx, "funcell_submitfail")),
									ctx);
							return;
							// 弹出提示
						}
						String order = "";
						JSONTokener jsonParser = new JSONTokener(response);
						JSONObject person = null;
						try {
							person = (JSONObject) jsonParser.nextValue();
							Log.i(TAG, "person = " + person);
							final String err_code = person.getString("error_code");
							if (err_code != null && err_code.trim().length() > 0)// 认证失败了
							{
								if (err_code.equals("EZT2017011801")) {
									FuncellTools.alert(ctx.getResources()
											.getString(RUtils.string(ctx, "funcell_pay_maxnum_error")), ctx);
								}
								Log.e(TAG, "获取订单号失败:" + err_code);
								BaseFuncellGameSdkProxy.getInstance().BasePayFailure(ctx, person.toString(),
										payCallBack);
								return;
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							if (person == null) {
								e.printStackTrace();
								Log.e(TAG, "读取订单号信息出错了＝＝＝＝＝＝");
								FuncellTools.dimssProgress(ctx);
								FuncellTools.alert(
										ctx.getResources().getString(RUtils.string(ctx, "funcell_submitfail")), ctx);
								return;
							}
						}
						String pOrder = null;
						String pSign = null;
						String pSubmitTime = null;
						/**
						 * 步步高交易流水号
						 */
						String transNo = null;
						/**
						 * 步步高签名方法
						 */
						String accesskey = null;

						try {
							order = person.getString("f_orderid");

						} catch (JSONException e) {
							e.printStackTrace();
							Log.e(TAG, "读取订单号信息出错了＝＝orderid error＝＝＝＝");
							FuncellTools.dimssProgress(ctx);
							FuncellTools.alert(ctx.getResources().getString(RUtils.string(ctx, "funcell_submitfail")),
									ctx);
							return;
						}
						try {
							pOrder = person.getString("platform_order");// 渠道订单号
							pSign = person.getString("platform_sign");// 渠道签名--步步高

						} catch (Exception e) {

						}
						try {
							transNo = person.getString("platform_orderNumber");
							accesskey = person.getString("platform_accessKey");
							// pSign = person.getString("platform_sign");//
							// 渠道签名--步步高
						} catch (Exception e) {

						}
						try {
							pSubmitTime = person.getString("platform_submit_time");// 金立支付
						} catch (Exception e) {

						}

						Bundle bundle = new Bundle();
						bundle.putString(FuncellBundleKey.STRING_USER_NAME, roleName);
						bundle.putFloat(FuncellBundleKey.INT_MONEY, moneyAmount);
						bundle.putShort(FuncellBundleKey.SHORT_LS_ID, lsID);
						bundle.putString(FuncellBundleKey.SHORT_GS_ID, serverId);
						bundle.putString(FuncellBundleKey.LONG_Role_ID, roleId);
						bundle.putString(FuncellBundleKey.ORDER_STRING, order);
						// bundle.putString(FuncellBundleKey.PAY_ITEM_STRING,
						// mEveUrl.equalsIgnoreCase("http://eve-beta.funcell123.com/config/")
						// ? "100002" : itemID);
						bundle.putString(FuncellBundleKey.PAY_ITEM_STRING,
								TextUtils.isEmpty(itemID) ? "100002" : itemID);
						bundle.putString(FuncellBundleKey.PAY_ITEM_NMAE, itemName);
						bundle.putInt(FuncellBundleKey.PAY_ITEM_NUM, itemCount);
						bundle.putString(FuncellBundleKey.PAY_PLATFORM_ORDER, pOrder);
						bundle.putString(FuncellBundleKey.PAY_PLATFORM_SIGN, pSign);
						bundle.putString(FuncellBundleKey.PAY_PLATFORM_SUBMIT_TIME, pSubmitTime);
						bundle.putString(FuncellBundleKey.STRING_EXT_DATA, m_platformConfig.chan_ext_data);
						bundle.putString(FuncellBundleKey.PAY_CALLBACK_URL, m_platformConfig.func_pay_callback);
						bundle.putString(FuncellBundleKey.PAY_PLATFORM_UID, m_platformConfig.func_platform_uid);
						bundle.putString(FuncellBundleKey.STRING_ACCESS_TOKEN, m_platformConfig.func_access_token);
						bundle.putString(FuncellBundleKey.PAY_PLATFORM_MULT_PAY_KEY, multPay);
						bundle.putString("platform_orderNumber", transNo);
						bundle.putString("platform_accessKey", accesskey);

						FuncellTools.dimssProgress(ctx);
						/**
						 * 平台订单创建成功，封装平台订单数据，传给渠道支付实现类
						 */
						callChargerImpl(ctx, chargerManager, bundle, PayParams, payCallBack);
					}

					@Override
					public void onErrorResponse(String error) {
						Log.e(TAG, "pay get order error is " + error);
						FuncellTools.dimssProgress(ctx);
						BaseFuncellGameSdkProxy.getInstance().BasePayFailure(ctx, error, payCallBack);
					}

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						BaseFuncellGameSdkProxy.getInstance().BasePayFailure(ctx, error.getLocalizedMessage(),
								payCallBack);
					}
				});

	}

	public void PlatformPay(final Activity ctx, final IFuncellChargerManager chargerManager,
			final FuncellPayParams PayParams, final IFuncellPayCallBack payCallBack) {
		/**
		 * 先创建平台订单信息，在创建平台订单成功回调中，继续调用渠道的支付 平台创建订单失败后，直接回调购买失败的回调
		 */
		ctx.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (!mLoginSuccessFlag) {
					Toast.makeText(ctx,
							ctx.getResources().getString(FuncellRUtils.string(ctx, "FUNCELL_NOT_LOGIN_FLAG_TEST")), 0)
							.show();
					return;
				}
				SdkPay(ctx, chargerManager, PayParams, payCallBack);
			}
		});
	}

	public void PlatformPayFailure(Activity ctx, String json, IFuncellPayCallBack payCallBack) {
		FuncellGameLogUploadTask.getInstance().PostExecute(ctx, json, FuncellGameLogType.payment.toString());
		payCallBack.onFail(json);
	}

	public void PlatformLogout(final Activity ctx, final IFuncellSessionManager sessionManager,
			final IFuncellSessionCallBack sessionCallBack) {
		ctx.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (!mLoginSuccessFlag) {
					Toast.makeText(ctx,
							ctx.getResources().getString(FuncellRUtils.string(ctx, "FUNCELL_NOT_LOGIN_FLAG_TEST")), 0)
							.show();
					return;
				}
				sessionManager.Logout(ctx, sessionCallBack);
				mLoginSuccessFlag = false;
			}
		});

	}

	public void PlatFormExitGame(Activity ctx, IFuncellExitCallBack callBack) {
		readConfig(ctx);
		Log.i(TAG, "run PlatFormExitGame()");
		if (isExitNormal == false) {
			Log.i(TAG, "未进入游戏场景就退出游戏");
			return;
		}
		String channel = m_platformConfig.func_platform_name;
		if (!TextUtils.isEmpty((String) FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(),
				"getSubChannel"))) {
			channel = (String) FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(),
					"getSubChannel");
		}
		Log.i(TAG, "exit game log");
		StringBuffer pauseLog = new StringBuffer();
		pauseLog.append(mGameID + "");// 游戏id
		Log.i(TAG, "mGameID= " + mGameID);
		pauseLog.append("~@");
		pauseLog.append(mArea);// 区域
		pauseLog.append("~@");
		// pauseLog.append(m_platformConfig.func_platform_name);// 渠道标识
		pauseLog.append(channel);// 渠道标识
		Log.i(TAG, "channel= " + channel);
		pauseLog.append("~@");
		pauseLog.append(mAppVersion);// 游戏版本
		Log.i(TAG, "mAppVersion= " + mAppVersion);
		pauseLog.append("~@");
		pauseLog.append(m_platformConfig.func_fed_id);// uid
		Log.i(TAG, "func_fed_id= " + m_platformConfig.func_fed_id);
		pauseLog.append("~@");
		pauseLog.append(GetDatasMap().get(FuncellDataTypes.DATA_SERVER_ROLE_INFO).getString("serverno"));// 服务器
		Log.i(TAG, "serverno= " + GetDatasMap().get(FuncellDataTypes.DATA_SERVER_ROLE_INFO).getString("serverno"));
		pauseLog.append("~@");
		pauseLog.append(GetDatasMap().get(FuncellDataTypes.DATA_SERVER_ROLE_INFO).getString("role_id"));// 角色id
		Log.i(TAG, "role_id= " + GetDatasMap().get(FuncellDataTypes.DATA_SERVER_ROLE_INFO).getString("role_id"));
		pauseLog.append("~@");
		pauseLog.append(GetDatasMap().get(FuncellDataTypes.DATA_SERVER_ROLE_INFO).getString("role_level"));
		Log.i(TAG, "role_level= " + GetDatasMap().get(FuncellDataTypes.DATA_SERVER_ROLE_INFO).getString("role_level"));
		pauseLog.append("~@");
		pauseLog.append(FuncellTools.getAndroidId(ctx));
		// UploadUtils.getInstance(ctx).countActivite("QuitGame",pauseLog.toString().trim(),
		// mArea, mGameID + "", false);
		// Log.i(TAG, "调用了退出游戏上报接口");
	}

	public void PlatformSetDatas(Activity ctx, IFuncellDataManager dataManager, FuncellDataTypes paramDataTypes,
			ParamsContainer paramParamsContainer) {
		readConfig(ctx);
		dataManager.setDatas(ctx, paramDataTypes, paramParamsContainer);
		mDatasMap.put(paramDataTypes, paramParamsContainer);
		Log.i(TAG, "run PlatformSetDatas()");
		String channel = m_platformConfig.func_platform_name;
		if (!TextUtils.isEmpty((String) FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(),
				"getSubChannel"))) {
			channel = (String) FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(),
					"getSubChannel");
		}
		if (paramDataTypes == FuncellDataTypes.DATA_CREATE_ROLE) {
			Log.i(TAG, "create role log");
			/***************** 建角色统计 ****************/
			StringBuffer createLog = new StringBuffer();
			createLog.append(mGameID + "");
			Log.i(TAG, "gameId= " + mGameID);
			createLog.append("~@");
			createLog.append(mArea);
			createLog.append("~@");
			// createLog.append(m_platformConfig.func_platform_name);
			createLog.append(channel);
			Log.i(TAG, "channel= " + channel);
			createLog.append("~@");
			createLog.append(mAppVersion);
			Log.i(TAG, "mAppVersion= " + mAppVersion);
			createLog.append("~@");
			createLog.append(m_platformConfig.func_fed_id);
			Log.i(TAG, "func_fed_id= " + m_platformConfig.func_fed_id);
			createLog.append("~@");
			createLog.append(paramParamsContainer.getString("serverno"));// 服务器id
			Log.i(TAG, "serverno= " + paramParamsContainer.getString("serverno"));
			createLog.append("~@");
			createLog.append(paramParamsContainer.getString("role_id"));// 角色id
			Log.i(TAG, "role_id= " + paramParamsContainer.getString("role_id"));
			createLog.append("~@");
			createLog.append(FuncellTools.getAndroidId(ctx));
			UploadUtils.getInstance(ctx).countActivite("RoleCreate", createLog.toString().trim(), mArea, mGameID + "",
					false);
			Log.i(TAG, "调用了统计创建角色接口");
			/******************* end *****************/
		}
		if (paramDataTypes == FuncellDataTypes.DATA_SERVER_ROLE_INFO) {
			/***************** 进入游戏统计统计 ****************/
			isExitNormal = true;
			Log.i(TAG, "enter game log");
			StringBuffer enterLog = new StringBuffer();
			enterLog.append(mGameID + "");
			Log.i(TAG, "gameId= " + mGameID);
			enterLog.append("~@");
			enterLog.append(mArea);
			enterLog.append("~@");
			// enterLog.append(m_platformConfig.func_platform_name);
			enterLog.append(channel);
			Log.i(TAG, "channel= " + channel);
			enterLog.append("~@");
			enterLog.append(mAppVersion);
			enterLog.append("~@");
			enterLog.append(m_platformConfig.func_fed_id);
			Log.i(TAG, "func_fed_id= " + m_platformConfig.func_fed_id);
			enterLog.append("~@");
			enterLog.append(paramParamsContainer.getString("serverno"));
			Log.i(TAG, "serverno= " + paramParamsContainer.getString("serverno"));
			enterLog.append("~@");
			enterLog.append(paramParamsContainer.getString("role_id"));
			Log.i(TAG, "role_id= " + paramParamsContainer.getString("role_id"));
			enterLog.append("~@");
			enterLog.append(paramParamsContainer.getString("role_level"));
			Log.i(TAG, "role_level= " + paramParamsContainer.getString("role_level"));
			enterLog.append("~@");
			enterLog.append(FuncellTools.getAndroidId(ctx));
			UploadUtils.getInstance(ctx).countActivite("EnterGame", enterLog.toString().trim(), mArea, mGameID + "",
					false);
			Log.i(TAG, "调用了统计进入游戏接口");
			/******************* end *****************/
		}
	}

	public void PlatformLogMark(Activity ctx, String type, String str) {
		FuncellGameLogUploadTask.getInstance().PostExecuteByMark(ctx, type, str);
	}
}
