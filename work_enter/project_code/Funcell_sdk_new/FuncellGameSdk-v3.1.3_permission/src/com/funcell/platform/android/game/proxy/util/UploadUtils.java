package com.funcell.platform.android.game.proxy.util;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.funcell.platform.android.FuncellGameSdkProxy;
import com.funcell.platform.android.game.proxy.BaseFuncellGameSdkProxy;
import com.funcell.platform.android.game.proxy.FuncellPlatformInterface;
import com.funcell.platform.android.game.proxy.init.PlatformParamsType;
import com.funcell.platform.android.http.FuncellHttpUtils;
import com.funcell.platform.android.http.FuncellResponseCallback;
import com.funcell.platform.android.http.volley.VolleyError;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

public class UploadUtils {

	private static final String TAG = "UploadUtils";

	private static JSONObject phoneJson;

	private static Activity sContext;

	// private final static String mDefault_Url =
	// "http://gather-client-data.funcell123.com:5140";

	/***************** 处理日志上传失败 *****************/
	/**
	 * 失败后上传的次数
	 */
	private static int count = 1;

	private final static int ONE = 1;

	private final static int TWO = 2;

	private final static int THREE = 3;

	private final static long Second_30 = 30 * 1000;

	private final static long Minute_3 = 3 * 60 * 1000;

	private final static long Minute_5 = 5 * 60 * 1000;

	private final static int TIME = 3;

	public static UploadUtils instance;

	public static boolean errorAppear;

	public UploadUtils(Activity context) {
		sContext = context;
	}

	public static UploadUtils getInstance(Activity context) {
		if (instance == null) {
			synchronized (UploadUtils.class) {
				if (instance == null) {
					instance = new UploadUtils(context);
				}
			}
		}
		return instance;
	}

	/***************** end *****************/

	/**
	 * 
	 * @param type
	 *            统计类型
	 * @param area
	 *            用户所在区域
	 * @param gameId
	 *            游戏id
	 * @param log
	 *            统计内容
	 */
	public void countActivite(String type, String log, String area, String gameID, boolean isNeedPhoneInfo) {
		JSONObject json = new JSONObject();
		try {
			json.put("area", area);
			json.put("gameID", gameID);
			json.put("sign", type);
		} catch (JSONException e) {
			Log.i(TAG, "第一个json+： " + e);
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("headers", json);
		StringBuffer sb = new StringBuffer(log);

		if (isNeedPhoneInfo) {
			sb.append("~@");
			sb.append(getPhoneInfoJson().toString());
			sb.append("~@");
			sb.append(System.currentTimeMillis() + "");
			map.put("body", sb.toString());
		} else {
			sb.append("~@");
			sb.append(System.currentTimeMillis() + "");
			map.put("body", sb.toString());
		}
		uploadLog(map);
		Log.e(TAG, "****日志上传countActivite数据:" + map.toString());
	}

	public void uploadErrorLog(String type, String log, String area, String gameID) {
		JSONObject json = new JSONObject();
		try {
			json.put("area", area);
			json.put("gameID", gameID);
			json.put("sign", type);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("headers", json);
		StringBuffer sb = new StringBuffer(log);
		map.put("body", sb.toString());
		uploadLog(map);
		Log.e(TAG, "****日志上传uploadErrorLog数据:" + map.toString());
	}

	/**
	 * 上传日志
	 * 
	 * @param map
	 */
	@SuppressWarnings("deprecation")
	public void uploadLog(final Map<String, Object> map) {
		Log.i(TAG, "uploadLog:" + map.toString());
		try {
			String url = FuncellGameSdkProxy.getInstance().GetPlatformParams(sContext, PlatformParamsType.BiUrl);
			String evedata = BaseFuncellGameSdkProxy.getInstance().EveData();
			if (!TextUtils.isEmpty(evedata)) {
				JSONObject jsondata = new JSONObject(evedata);
				if (jsondata.has("datacenter_service")) {
					url = jsondata.getString("datacenter_service");
				}
			}
			if (TextUtils.isEmpty(url))
				return;

			// FuncellRetrofitUtils.getInstance().post(url, map,new
			// FuncellRetrofitCallback() {
			//
			// @Override
			// public void onResponse(String response) {
			// // TODO Auto-generated method stub
			// Log.i(TAG, "Retrofit onResponse");
			// }
			//
			// @Override
			// public void onFailure(String throwable) {
			// // TODO Auto-generated method stub
			// Log.i(TAG, "Retrofit onFailure");
			// }
			// });

			FuncellHttpUtils.getInstance(sContext).postByJsonArray(String.valueOf(System.currentTimeMillis()), url, map,
					new FuncellResponseCallback() {

						@Override
						public void onResponse(String response) {
							Log.i(TAG, "上传成功");
						}

						@Override
						public void onErrorResponse(String error) {
							Log.i(TAG, "上传失败");
						}

						@Override
						public void onErrorResponse(VolleyError error) {
							try {

								if (error != null && error.getCause() != null && error.getCause().getClass() != null
										&& error.getCause().getClass() == JSONException.class) {
									return;

								} else {
									Log.e(TAG, "上传失败，重新上传");
									Message msg = new Message();
									msg.obj = map;
									switch (count) {
									case ONE:
										mHandler.sendMessageDelayed(msg, Second_30);
										count++;
										break;
									case TWO:
										mHandler.sendMessageDelayed(msg, Minute_3);
										count++;
										break;
									case THREE:
										mHandler.sendMessageDelayed(msg, Minute_5);
										count++;
										break;
									}
								}

							} catch (Exception e) {
								// TODO: handle exception

							}
						}
					});
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@SuppressLint("HandlerLeak")
	public Handler mHandler = new Handler() {
		@SuppressWarnings("unchecked")
		public void handleMessage(Message msg) {
			Log.i(TAG, "upload");
			if (count <= TIME) {
				uploadLog((Map<String, Object>) msg.obj);
			}
		};
	};

	public JSONObject getPhoneInfoJson() {
		phoneJson = new JSONObject();

		try {
			phoneJson.put("mo", FuncellTools.getPhoneModel());// 终端机型
			phoneJson.put("sy", "anzhuo");// 系统
			phoneJson.put("imei", FuncellTools.getImei(sContext));// 终端唯一标识
			phoneJson.put("ID", FuncellTools.getAndroidId(sContext));// androidId
			phoneJson.put("ve", FuncellTools.getPhoneVersion());// 终端系统版本
			phoneJson.put("cpu", FuncellTools.getCPU());// cpu
			phoneJson.put("me", FuncellTools.getRAM(sContext));// 终端内存
			phoneJson.put("re", FuncellTools.getScreenPiexl(sContext));// 分辨率
			phoneJson.put("ne", FuncellTools.getNetType(sContext));// 联网方式
			phoneJson.put("op", FuncellTools.getMobileServiceProvider(sContext));// 运营商
		} catch (Exception e) {
			Log.e(TAG, "--------ERROR-----" + e.toString());
			e.printStackTrace();
		}
		return phoneJson;

	}

	public void setIsFirstOpen(Context context, boolean isFirst) {
		SharedPreferences sp = context.getSharedPreferences("funcell", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean("isFirst", isFirst);
		editor.commit();
	}

	public boolean getIsFirstOpen(Context context) {
		SharedPreferences sp = context.getSharedPreferences("funcell", Context.MODE_PRIVATE);
		return sp.getBoolean("isFirst", true);
	}

}
