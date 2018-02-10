package com.funcell.platform.android.game.proxy;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.widget.ImageView;

import com.funcell.platform.android.game.proxy.session.FuncellSession;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionManager;
import com.funcell.platform.android.game.proxy.session.SessionCallbackType;
import com.funcell.platform.android.game.proxy.util.FuncellTools;
import com.funcell.platform.android.game.proxy.util.JsonObjectCoder;
import com.funcell.platform.android.http.FuncellHttpUtils;
import com.funcell.platform.android.http.FuncellResponseCallback;
import com.funcell.platform.android.http.volley.VolleyError;

/**
 * ����Ϊ����ʵ���߼��࣬������Զ��滻�ɲ�ͬ������ʵ���࣬Ĭ����demo ��Ҫ������¼���˳�
 * 
 * @author Administrator
 * 
 */
public class FuncellSessionManagerImpl implements IFuncellSessionManager {
	private String TAG = getClass().getName().toString();
	private static FuncellSessionManagerImpl mInstance;
	private IFuncellSessionCallBack mFuncellSessionCallBack;
	private String mAppid = "10000";
	private String mAppkey = "f35y546ku5gd2aed562t5";
	public static String hw_access_token;

	public static FuncellSessionManagerImpl getInstance() {
		if (mInstance == null) {
			synchronized (FuncellSessionManagerImpl.class) {
				if (mInstance == null) {
					mInstance = new FuncellSessionManagerImpl();
				}
			}
		}
		return mInstance;
	}

	@Override
	public void Login(Activity ctx, IFuncellSessionCallBack callBack) {
		// TODO Auto-generated method stub
		Log.e(TAG, "Login ...");
		mFuncellSessionCallBack = callBack;
		// use lower 16 bits for requestCode (0-65535)
		int requestCode = 55555;
		Intent intent = new Intent(ctx, FuncellSDKLoginActivity.class);
		ctx.startActivityForResult(intent, requestCode);
	}

	@Override
	public void Logout(Activity ctx, IFuncellSessionCallBack callBack) {
		// TODO Auto-generated method stub
		Log.e(TAG, "Logout ...");
		mFuncellSessionCallBack = callBack;
		mFuncellSessionCallBack.onLogout();
		// BaseFuncellGameSdkProxy.getInstance().BaseSessionCallBack(mFuncellSessionCallBack,
		// SessionCallbackType.onSessionLogout);
		FuncellVar.user = null;
		FuncellActivityStubImpl.getInstance().hideFloatButton(ctx);
	}

	public void onTestLoginSuccess(Activity context, String username) {

		String pwd = "123";
		if ("demo1".equals(username)) {
			pwd = username;
		}
		if ("demo2".equals(username)) {
			pwd = username;
		}
		if ("demo3".equals(username)) {
			pwd = username;
		}
		/**
		 * ��Ҫ����ƽ̨�Ĳ��Ի�������¼��ȷ�����ظ���Ϸ��������������ȷ�ģ����Գɹ�У�鲢��¼
		 */

//		FuncellSession user = new FuncellSession("funcell", username, username,
//				"funcell_test_token", "channel_123", "channel_test_userName",
//				"173","");
//		FuncellVar.user = user;
		new LoginTask(context).PostExecute(context, username, username);
		// mFuncellSessionCallBack.onLoginSuccess(user);
	}

	public void onTestLoginFail(Activity context) {
		mFuncellSessionCallBack.onLoginFailed("fail");
		// BaseFuncellGameSdkProxy.getInstance().BaseSessionCallBack(mFuncellSessionCallBack,
		// SessionCallbackType.onFailure);
	}

	private ImageView bannerSpinner;
	public static String userAccount = null;
	private String pwd = null;
	private String hw_platform = null;
	private String cpId = null;
	private String fid = null;
	private static final String REGIST_URL_DOMIAN = "http://auth-beta.553.com/authorize";

	public class LoginTask {
		Boolean isCurrentQuickLogin = false;

		public LoginTask(Activity ctx) {

		}

		public void PostExecute(final Activity ctx, String name, String strpwd) {
			userAccount = name;

			hw_platform = FuncellTools.getChannelCode(ctx);

			pwd = FuncellTools.stringToBase64(strpwd);

			cpId = mAppid;

			HashMap<String, String> postData = new HashMap<String, String>();

			postData.put("cp_id", cpId);

			postData.put("grant_type", "login");
			postData.put("password", pwd);// base64
			postData.put("username", userAccount);

			postData.put("platform", hw_platform);
			postData.put("sign", getHWSign(ctx));
			postData.put("ext_data", getHWExtData(ctx));

			FuncellTools.logError(TAG, "postData = " + postData);

			FuncellHttpUtils.getInstance(ctx).post(
					String.valueOf(System.currentTimeMillis()),
					REGIST_URL_DOMIAN, postData, new FuncellResponseCallback() {

						@Override
						public void onResponse(String response) {
							// TODO Auto-generated method stub
							AnalyticalData(ctx, response);
						}

						@Override
						public void onErrorResponse(String error) {
							// TODO Auto-generated method stub
							AnalyticalData(ctx, error);
						}

						@Override
						public void onErrorResponse(VolleyError error) {
							// TODO Auto-generated method stub

						}

					});

		}

		private void AnalyticalData(Activity ctx, String result) {
			// DissmissProgressBar();
			if (null == result) {

				FuncellTools.logError(TAG, "login response is null...");
				return;
			}

			Map<String, Object> responseDataMap = (Map<String, Object>) JsonObjectCoder
					.decode(result, null);
			String errorCode = "";
			if (result.indexOf("error_code") >= 0) {
				errorCode = null == responseDataMap.get("error_code") ? ""
						: responseDataMap.get("error_code").toString(); // �˴������⣬�������ݿ��ܲ���json����Ҫ���������ȷ��
			}
			String errorMsg = "";
			if (result.indexOf("message") >= 0) {
				errorMsg = null == responseDataMap.get("message") ? ""
						: responseDataMap.get("message").toString();
			}
			if ("P1111".equals(errorCode)) {// success
				FuncellTools.logError(TAG, "login success ,errorCode = "
						+ errorCode);

				Map<String, String> successDataMap = (Map<String, String>) responseDataMap.get("data");
				hw_access_token = successDataMap.get("access_token");
				String hw_refresh_token = successDataMap.get("refresh_token");

				String guestUserName = successDataMap.get("username");
				String guestPwd = successDataMap.get("password");
				
				fid=successDataMap.get("fid");
				if(null!=guestUserName&&0<guestUserName.trim().length()){
					userAccount=guestUserName;
				}
				
				FuncellSession user = new FuncellSession("funcell", fid, guestUserName,hw_access_token, fid, guestUserName,"100",result);
				FuncellVar.user = user;
				FuncellTools.logError(TAG, "login success ,guestUserName = "
						+ guestUserName + " , guestPwd = " + guestPwd);

				/**
				 * ������¼�ɹ�����Ҫ��������������ƽ̨��֤��
				 */
				BaseFuncellGameSdkProxy.getInstance().BaseLoginSuccess(ctx,
						fid, fid, hw_access_token,
						mFuncellSessionCallBack);
				return;
			}
			mFuncellSessionCallBack.onLoginFailed("login onLoginFailed");
			// BaseFuncellGameSdkProxy.getInstance().BaseSessionCallBack(mFuncellSessionCallBack,
			// SessionCallbackType.onFailure);
			if ("A1001".equals(errorCode)) {// �˺Ų�����
				FuncellTools.logError(TAG, "account is not exist ,errorCode = "
						+ errorCode);
			} else if ("A1002".equals(errorCode)) {// �û���Ȩ��¼
				FuncellTools.logError(TAG,
						"account no permission ,errorCode = " + errorCode);
			} else if ("A1003".equals(errorCode)) {// �������
				FuncellTools.logError(TAG, "pwd is error ,errorCode = "
						+ errorCode);
			} else if ("A1009".equals(errorCode)) {// �˺Ÿ�ʽ����
				FuncellTools.logError(TAG, "pwd is error ,errorCode = "
						+ errorCode);
			} else if ("A1019".equals(errorCode)) {// �˺Ÿ�ʽ����
				FuncellTools.logError(TAG, "token is expired ,errorCode = "
						+ errorCode);
			} else {// ����ʧ�����
				FuncellTools.logError(TAG, "login error ,errorCode = "
						+ errorCode);
			}
		}

		private void DissmissProgressBar() {
			bannerSpinner.clearAnimation();
			FuncellSDKLoginActivity.getLinearLayout().removeView(bannerSpinner);
		}
	}

	private String getHWSign(Activity ctx) {
		StringBuilder sign = new StringBuilder();
		sign.append("cp_id=").append(cpId).append("&");
		sign.append("ext_data=").append(getHWExtData(ctx)).append("&");

		sign.append("grant_type=login&");
		sign.append("password=").append(pwd).append("&");
		sign.append("platform=").append(hw_platform).append("&");
		sign.append("username=").append(userAccount);

		sign.append("#").append(mAppkey);

		return FuncellTools.stringTo32LowerCaseMD5(sign.toString());
	}

	private String getHWExtData(Activity ctx) {
		JSONObject extDataJSONObject = new JSONObject();
		try {
			extDataJSONObject.put("device_id", FuncellTools.getAndroidId(ctx));
			extDataJSONObject.put("os", FuncellTools.getPhoneVersion());
			extDataJSONObject.put("model", FuncellTools.getPhoneModel());
			extDataJSONObject.put("network", FuncellTools.getNetType(ctx));
			extDataJSONObject.put("platform", hw_platform);

		} catch (JSONException e) {
			e.printStackTrace();
		}

		// FuncellTools.logError(TAG, "extdata = " +
		// extDataJSONObject.toString());

		return FuncellTools.stringToBase64(extDataJSONObject.toString());
	}
}
