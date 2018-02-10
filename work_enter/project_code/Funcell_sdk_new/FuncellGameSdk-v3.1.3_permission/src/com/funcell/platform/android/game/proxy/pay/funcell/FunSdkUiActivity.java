package com.funcell.platform.android.game.proxy.pay.funcell;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.funcell.platform.android.game.proxy.BaseFuncellGameSdkProxy;
import com.funcell.platform.android.game.proxy.FuncellSessionManagerImpl;
import com.funcell.platform.android.game.proxy.pay.FuncellBundleKey;
import com.funcell.platform.android.game.proxy.pay.FuncellPayParams;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.pay.PayCallBackType;
import com.funcell.platform.android.game.proxy.util.FuncellTools;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebSettings;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class FunSdkUiActivity extends Activity {
	private static final String TAG = "FunSdkUiActivity";
	private FuncellWebView mWebView;
	private RelativeLayout webViewLayout;

	private String urlString;
	private StringBuilder postData = new StringBuilder();

	private String cp_orderid = null;
	private Float price = null;
	private String ext_data = null;

	private Integer amount = null;
	private String product_id = null;
	private String product_name = null;

	private String hw_access_token = null;
	private String cp_id = null;
	private String platform = null;
	private int create_time;
	
	private String mAppkey = "f35y546ku5gd2aed562t5";
	private String mAppid = "10000";
	
	@SuppressLint("SetJavaScriptEnabled")
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		
		recharge(mFuncellPayParams);

		initViews();

		initEvents();
	}

	private void initEvents() {
		FuncellWebView.setOnWebViewCallBack(new FuncellWebViewCallback() {

			@Override
			public void callBack(String action, String data) {
				FuncellTools.logError(TAG, "action is " + action + ",  data is "
						+ data);

				if (FuncellWebView.PAY_CALLBACK_CODE_SUCCESS.equals(action)) {
//					mRechargeCallBack.rechargeSuccess(data);
					String cpOrder = mFuncellPayParams.getmOrderId();
					String extrasParams = mFuncellPayParams.getmExtrasParams();
					String sdkOrder = mFuncellPayParams.getmBundle().getString(FuncellBundleKey.ORDER_STRING);
					mRechargeCallBack.onSuccess(cpOrder, sdkOrder, extrasParams);
//					BaseFuncellGameSdkProxy.getInstance().BasePayCallBack(mRechargeCallBack, PayCallBackType.onSuccess, cpOrder,sdkOrder,extrasParams);
				} else if (FuncellWebView.PAY_CALLBACK_CODE_ERROR.equals(action)) {
//					mRechargeCallBack.rechargeFail(FunErrorCode.FUN_ERROR_CODE_PAY_FAIL, "pay error");
					mRechargeCallBack.onFail("pay error");
//					BaseFuncellGameSdkProxy.getInstance().BasePayCallBack(mRechargeCallBack, PayCallBackType.onFail);
				} else if (FuncellWebView.PAY_CALLBACK_CODE_FAIL.equals(action)) {
//					mRechargeCallBack.rechargeFail(FunErrorCode.FUN_ERROR_CODE_PAY_CANCEL,"cancel pay");
					mRechargeCallBack.onCancel("cancel pay");
//					BaseFuncellGameSdkProxy.getInstance().BasePayCallBack(mRechargeCallBack, PayCallBackType.onCancel);
				} else if (FuncellWebView.PAY_CALLBACK_CODE_NO_PAY.equals(action)) {
//					mRechargeCallBack.rechargeFail(FunErrorCode.FUN_ERROR_CODE_PAY_CANCEL, "no pay");
					mRechargeCallBack.onFail("no pay");
//					BaseFuncellGameSdkProxy.getInstance().BasePayCallBack(mRechargeCallBack, PayCallBackType.onFail);
				} else if (FuncellWebView.ACTION_CALLBACK_CODE_CLOSE.equals(action)) {	
				} else if (FuncellWebView.ACTION_CALLBACK_CODE_CHANGE_USER.equals(action)) {
				} else if (FuncellWebView.ACTION_CALLBACK_CODE_RELOGIN.equals(action)) {
				} else if (FuncellWebView.ACTION_CALLBACK_CODE_NORMAL_CLOSE.equals(action)) {
				}
				finish();
			}
		});
	}

	private void initViews() {
		webViewLayout = new RelativeLayout(this);
		webViewLayout.setBackgroundColor(0xFFFFFFFF);
		webViewLayout.setLayoutParams(new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));

		mWebView = new FuncellWebView(this);
		mWebView.setBackgroundColor(0xFFFFFFFF);
		mWebView.clearCache(true);
		mWebView.setFocusable(true);
		mWebView.requestFocus();
		mWebView.requestFocusFromTouch();
		mWebView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
		mWebView.setVerticalScrollBarEnabled(false);
		mWebView.setHorizontalScrollBarEnabled(false);
		LinearLayout.LayoutParams myWebViewParams = new LinearLayout.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT);
		mWebView.setLayoutParams(myWebViewParams);

		webViewLayout.addView(mWebView, myWebViewParams);

		setContentView(webViewLayout);
		mWebView.loadurl(urlString + "?" + postData.toString());

		FuncellTools.logError(TAG, "postData = " + postData.toString());
		// mWebView.posturl(urlString,
		// EncodingUtils.getBytes(postData.toString(), "base64"));

		WebSettings set = mWebView.getSettings();
		set.setSavePassword(false);
		set.setSaveFormData(false);
		set.setJavaScriptEnabled(true);
		set.setJavaScriptCanOpenWindowsAutomatically(true);
	}

	/**
	 * 获取充值请求数据
	 * 
	 * @param mFunPayInfo
	 */

	public void recharge(FuncellPayParams paramFuncellPayParams) {

		if (null == paramFuncellPayParams) {
			FuncellTools.logError(TAG, "初始化支付页面失败");
			return;
		}
		String account = FuncellSessionManagerImpl.userAccount;

		cp_orderid = paramFuncellPayParams.getmBundle().getString(FuncellBundleKey.ORDER_STRING);
		price = Float.valueOf(paramFuncellPayParams.getmBundle().getFloat(FuncellBundleKey.INT_MONEY));
		ext_data = paramFuncellPayParams.getmExtrasParams();

		amount = paramFuncellPayParams.getmBundle().getInt(FuncellBundleKey.PAY_ITEM_NUM);
		product_id = paramFuncellPayParams.getmBundle().getString(FuncellBundleKey.PAY_ITEM_STRING);
		product_name = paramFuncellPayParams.getmBundle().getString(FuncellBundleKey.PAY_ITEM_NMAE);

		hw_access_token = FuncellSessionManagerImpl.hw_access_token;
		cp_id = mAppid;
		platform = FuncellTools.getChannelCode(FunSdkUiActivity.this);
		create_time = Integer.valueOf(FuncellTools.getTimestamp());

		if (null == cp_orderid || 0 == cp_orderid.trim().length()) {
			FuncellTools.logError(TAG, "cp orderid is required!");
			return;
		}

		if (null == product_name || 0 == product_name.trim().length()) {
			FuncellTools.logError(TAG, "cp product name is required!");
			return;
		}

		getPayPostData();

		urlString = "/charge";

		try {
			urlString = URLDecoder.decode(urlString, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

	/**
	 * 获取充值请求数据
	 */
	private void getPayPostData() {

		if (null != price && 0 < price) {
			postData.append("price=").append(price).append("&");
		}

		if (null != amount && 0 < amount) {
			postData.append("amount=").append(amount).append("&");
		}

		if (null != ext_data && 0 < ext_data.trim().length()) {
			postData.append("ext_data=")
					.append(FuncellTools.stringToBase64(ext_data))
					.append("&");
		}

		if (null != product_id && 0 < product_id.trim().length()) {
			postData.append("product_id=").append(product_id).append("&");
		}

		postData.append("product_name=")
				.append(FuncellTools.stringToBase64(product_name))
				.append("&");

		postData.append("cp_orderid=").append(cp_orderid).append("&");
		postData.append("access_token=").append(hw_access_token).append("&");
		postData.append("cp_id=").append(cp_id).append("&");
		postData.append("platform=").append(platform).append("&");
		postData.append("create_time=").append(create_time).append("&");
		postData.append("sign=").append(getPayHWSign());
	}

	/**
	 * 获取充值协议加密串
	 * 
	 * @return
	 */
	private String getPayHWSign() {
		StringBuilder mSign = new StringBuilder();
		mSign.append("access_token=").append(hw_access_token.trim())
				.append("&");

		if (null != amount && 0 < amount) {
			mSign.append("amount=").append(amount).append("&");
		}

		mSign.append("cp_id=").append(cp_id).append("&");
		mSign.append("cp_orderid=").append(cp_orderid).append("&");
		mSign.append("create_time=").append(create_time).append("&");

		if (null != ext_data && 0 < ext_data.trim().length()) {
			mSign.append("ext_data=")
					.append(FuncellTools.stringToBase64(ext_data.trim()))
					.append("&");
		}

		mSign.append("platform=").append(platform.trim()).append("&");

		if (null != price && 0 < price) {
			mSign.append("price=").append(price).append("&");
		}

		if (null != product_id && 0 < product_id.trim().length()) {
			mSign.append("product_id=").append(product_id.trim()).append("&");
		}

		mSign.append("product_name=").append(
				FuncellTools.stringToBase64(product_name.trim()));

		mSign.append("#").append(mAppkey);

		FuncellTools.logError(TAG, "HWSign : " + mSign.toString());
		return FuncellTools.stringTo32LowerCaseMD5(mSign.toString().trim());
	}



	public void dissmiss() {
		finish();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			return true;
		}
		return false;
	}

	private static IFuncellPayCallBack mRechargeCallBack;
	private static FuncellPayParams mFuncellPayParams;

	public static void setRechargeCallBack(IFuncellPayCallBack rechargeCallBack) {
		mRechargeCallBack = rechargeCallBack;
	}
	public static void setFuncellPayParams(FuncellPayParams paramFuncellPayParams) {
		mFuncellPayParams = paramFuncellPayParams;
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}

}
