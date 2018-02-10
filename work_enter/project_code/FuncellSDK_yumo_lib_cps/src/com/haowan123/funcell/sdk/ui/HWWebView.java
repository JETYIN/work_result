package com.haowan123.funcell.sdk.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.haowan123.funcell.sdk.util.HWUtils;
import com.haowan123.funcell.sdk.util.RUtils;

public class HWWebView extends WebView {
	private static final String TAG = "HWWebView";
	private String urlString;
	private static final String URL_HEAD = "funcell://";
	// private static final String FUNCELL_DOMAIN =
	// "https://mainland-sdk-channel.raink.com.cn";//:1044
	// private static final String FUNCELL_DOMAIN = "http://sdk.553.com";//
	// :1044正式
	/** 之前地址 **/

	// private static final String FUNCELL_DOMAIN =
	// "https://mainland-sdk-channel.raink.com.cn";
	// private static final String FUNCELL_DOMAIN =
	// "http://mainaland.sdk-channel.raink.com.cn";// 雨墨
	// private static final String FUNCELL_DOMAIN =
	// "http://mainaland.sdk-channel.rejoy123.com";// 瑞邦

	public static final String PAY_CALLBACK_CODE_FAIL = "fail";
	public static final String PAY_CALLBACK_CODE_ERROR = "error";
	public static final String PAY_CALLBACK_CODE_NO_PAY = "nopay";
	public static final String PAY_CALLBACK_CODE_SUCCESS = "success";
	public static final String ACTION_CALLBACK_CODE_RELOGIN = "relogin";
	public static final String ACTION_CALLBACK_CODE_CHANGE_USER = "change_user";
	public static final String ACTION_CALLBACK_CODE_CLOSE = "close";
	public static final String ACTION_CALLBACK_CODE_CLOSE_PAY = "close/pay";
	public static final String ACTION_CALLBACK_CODE_REPAY = "repay";
	public static final String ACTION_CALLBACK_CODE_PAY = "pay";
	public static final String ACTION_CALLBACK_CODE_NORMAL_CLOSE = "normal_close";
	public static final String ACTION_CALLBACK_CODE_WECHAT_PAY = "weixinapp";
	private ProgressBar progressBar;
	private LinearLayout refreshLinearLayout;
	private Button refreshButton;
	private String imeiStr, channelStr, appCodeStr;
	private Activity mContext;
	private boolean mIsErrorPage = false;
	private HWWebView mMebView;
	private RelativeLayout webParentView;
	private boolean isLoading;
	protected static HWWebViewCallback mHwWebViewCallback;

	protected static void setOnWebViewCallBack(HWWebViewCallback hwWebViewCallback) {
		mHwWebViewCallback = hwWebViewCallback;
	}

	@SuppressLint("SetJavaScriptEnabled")
	@SuppressWarnings("deprecation")
	public HWWebView(Activity context) {
		super(context);
		mMebView = this;
		this.mContext = context;

		int screenWidth = context.getWindowManager().getDefaultDisplay().getWidth(); // 屏幕宽（像素，如：480px）
		int screenHeight = context.getWindowManager().getDefaultDisplay().getHeight(); // 屏幕高（像素，如：800p）

		progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyle);
		progressBar.setVisibility(View.GONE);

		AbsoluteLayout.LayoutParams progressBarParams = new AbsoluteLayout.LayoutParams(60, 60, (screenWidth - 60) / 2,
				(screenHeight - 60) / 2);

		this.addView(progressBar, progressBarParams);
		// 微信
		WebSettings set = this.getSettings();
		set.setSavePassword(false);
		set.setSaveFormData(false);
		set.setJavaScriptEnabled(true);
		set.setJavaScriptCanOpenWindowsAutomatically(true);
		//
		set.setDomStorageEnabled(true);
		this.setWebViewClient(new HWWebViewClient());

	}

	public void loadurl(String url) {
		urlString = HWUtils.getPayUrl(mContext) + url;
		HWUtils.logError(TAG, "gurlString is " + urlString);
		super.loadUrl(urlString);
	}

	public void loadurl1(String url) {
		urlString = url;
		HWUtils.logError(TAG, "gurlString is " + urlString);
		super.loadUrl(urlString);
	}

	public void posturl(String url, byte[] postData) {
		urlString = HWUtils.getPayUrl(mContext) + url;
		HWUtils.logError(TAG, "purlString is " + urlString);
		super.postUrl(urlString, postData);
	}

	private class HWWebViewClient extends WebViewClient {

		@Override
		public void onPageFinished(WebView view, String url) {
			// TODO Auto-generated method stub
			Log.e(TAG, "****onPageFinished,当前url是:" + url);
			progressBar.setVisibility(View.GONE);
			view.setVisibility(View.VISIBLE);
			super.onPageFinished(view, url);
		}

		@Override
		public void onLoadResource(WebView view, String url) {
			// TODO Auto-generated method stub
			super.onLoadResource(view, url);
			Log.e(TAG, "****即将被加载的url是:" + url);

		}

		@Override
		public void onPageStarted(final WebView view, String url, Bitmap favicon) {
			// TODO Auto-generated method stub
			Log.e(TAG, "****onPageStarted,当前url是:" + url);
			progressBar.setVisibility(View.VISIBLE);
			view.setVisibility(View.VISIBLE);
			super.onPageStarted(view, url, favicon);
		}

		@Override
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			// TODO Auto-generated method stub
			Log.e(TAG, "****onReceivedError");
			view.stopLoading();
			HWUtils.logError(TAG, errorCode + "\n" + description + "\n" + failingUrl);
			view.clearView();
			showErrorPage();
			super.onReceivedError(view, errorCode, description, failingUrl);
		}

		@Override
		public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
			// TODO Auto-generated method stub
			// super.onReceivedSslError(view, handler, error);
			handler.proceed();
		}

		@Override
		public boolean shouldOverrideUrlLoading(final WebView view, String url) {
			// TODO Auto-generated method stub
			Log.e(TAG, "****shouldOverrideUrlLoading,当前url是" + url);

			/*
			 * try { url = URLDecoder.decode(url, "UTF-8"); } catch
			 * (UnsupportedEncodingException e) { // TODO Auto-generated catch
			 * block e.printStackTrace(); }
			 */

			// 支付宝h5
			// ------ 对alipays:相关的scheme处理 -------
			if (url.startsWith("alipays:") || url.startsWith("alipay")) {
				Log.e(TAG, "****拦截到alipay");
				try {
					mContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
				} catch (Exception e) {
					Log.e(TAG, "-----未安装支付宝app");
				}
				return true;
			}

			// 微信h5
			if (url.startsWith("weixin://wap/pay?")) {
				Log.e(TAG, "***拦截到微信h5支付");
				try {
					Intent intent = new Intent();
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(Uri.parse(url));
					mContext.startActivity(intent);

				} catch (Exception e) {
					Log.e(TAG, "----未安装微信app");
					Toast.makeText(mContext, "请安装微信app", Toast.LENGTH_SHORT).show();
				}

				return true;
			}
			/** 兼容微信，需要转码 **/
			if (url.startsWith(URL_HEAD)) {
				String action = url.replaceAll(URL_HEAD, "");
				HWUtils.logError(TAG, "action = " + action);

				// 关闭
				if (action.startsWith(ACTION_CALLBACK_CODE_CLOSE)) {
					mContext.finish();
				}
				if (action.startsWith(ACTION_CALLBACK_CODE_PAY)) {
					if (action.endsWith(PAY_CALLBACK_CODE_SUCCESS)) {

						String[] actionArray = action.split("/");
						HWUtils.logError(TAG, "orderid = " + actionArray[1]);

						mHwWebViewCallback.callBack(PAY_CALLBACK_CODE_SUCCESS, actionArray[1]);
					} else if (action.endsWith(PAY_CALLBACK_CODE_ERROR)) {
						mHwWebViewCallback.callBack(PAY_CALLBACK_CODE_ERROR, null);

					} else if (action.endsWith(PAY_CALLBACK_CODE_FAIL)) {
						mHwWebViewCallback.callBack(PAY_CALLBACK_CODE_FAIL, null);

					} else if (action.endsWith(PAY_CALLBACK_CODE_NO_PAY)) {
						mHwWebViewCallback.callBack(PAY_CALLBACK_CODE_NO_PAY, null);

					}
				} else {
					mHwWebViewCallback.callBack(action, null);
				}
				return true;
			}

			view.loadUrl(url);
			return false;
		}
	}

	/**
	 * 显示自定义错误提示页面
	 */
	protected void showErrorPage() {
		webParentView = (RelativeLayout) getParent();

		initErrorPage();

		while (webParentView.getChildCount() > 0) {
			webParentView.removeView(mMebView);
		}

		refreshLinearLayout.setVisibility(View.VISIBLE);

		RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		// lp.addRule(RelativeLayout.CENTER_IN_PARENT);
		webParentView.addView(refreshLinearLayout, 0, lp);

		mIsErrorPage = true;
	}

	/**
	 * 隐藏自定义错误提示页面，同时加载mMebView
	 */
	protected void hideErrorPage() {

		refreshLinearLayout.setVisibility(View.GONE);

		mIsErrorPage = false;
		while (webParentView.getChildCount() > 0) {
			webParentView.removeView(refreshLinearLayout);
		}
		mMebView.clearView();
		webParentView.addView(mMebView);
	}

	/**
	 * 初始化错误提示view
	 */
	protected void initErrorPage() {
		if (null == refreshLinearLayout) {

			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			View child = inflater.inflate(RUtils.layout(mContext, "fun_error_page"), null);
			ImageButton backGameBtn = (ImageButton) child
					.findViewById(RUtils.id(mContext, "fun_error_page_back_game_btn"));
			Button refreshBtn = (Button) child.findViewById(RUtils.id(mContext, "fun_error_page_btn"));

			refreshLinearLayout = (LinearLayout) child;
			backGameBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					mHwWebViewCallback.callBack(ACTION_CALLBACK_CODE_NORMAL_CLOSE, null);

				}
			});
			refreshBtn.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					hideErrorPage();
					mMebView.reload();

				}
			});
			refreshLinearLayout.setOnClickListener(null);
		}
	}
}
