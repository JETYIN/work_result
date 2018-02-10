package com.funcell.platform.android.game.authentication.ui;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import com.funcell.platform.android.FuncellRUtils;
import com.funcell.platform.android.game.proxy.IFuncellCallBack;
import com.funcell.platform.android.game.proxy.util.FuncellTools;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

@SuppressLint({ "SetJavaScriptEnabled", "JavascriptInterface" })
abstract class AbstractWebViewDialog<T> extends AbstractDialog {

	private static final String TAG = "AbstractWebViewDialog";

	// --------------------------------------------------------------------------------

	private LinearLayout containerLayout;
	private HeaderView headerView;
	private FooterView footerView;
	private WebView webView;

	protected WebViewClient webViewClient;

	protected String state;

	// --------------------------------------------------------------------------------
	// Constructor

	/**
	 * Constructor
	 * 
	 * @param context
	 */
	public AbstractWebViewDialog(Context context) {
		super(context);
	}

	/**
	 * Constructor
	 * 
	 * @param context
	 * @param theme
	 */
	public AbstractWebViewDialog(Context context, int theme) {
		super(context, theme);
	}

	// --------------------------------------------------------------------------------
	// Abstract Methods

	abstract void loadUrl();

	// --------------------------------------------------------------------------------
	// Override Methods

	@Override
	public void dismiss() {
		if (webView != null) {
			webView.stopLoading();
		}
		super.dismiss();
	}

	@Override
	public void onAttachedToWindow() {
		super.onAttachedToWindow();
		loadUrl();
	}

	@Override
	public void onBackPressed() {
		if (webView != null && webView.canGoBack()) {
			webView.goBack();
		}
		else {
			super.onBackPressed();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);

		initView();
	}

	// --------------------------------------------------------------------------------
	// Public Methods

	public void setSize(int width, int height) {
		WindowManager.LayoutParams params = getWindow().getAttributes();
		params.width = width;
		params.height = height;
		getWindow().setAttributes(params);
	}
	
	// WebView
	public WebView getWebView() {
		return webView;
	}
	
	//CallBack
	private IFuncellCallBack<T> mFuncellCallBack;
	public void setOnWebViewCallBack(IFuncellCallBack<T> callBack) {
		mFuncellCallBack = callBack;
	}
	
	// Header View

	public HeaderView getHeaderView() {
		return headerView;
	}

	public void showHeaderView() {
		headerView.setVisibility(View.VISIBLE);
	}

	public void hideHeaderView() {
		headerView.setVisibility(View.GONE);
	}

	// Footer View

	public FooterView getFooterView() {
		return footerView;
	}

	public void showFooterView() {
		footerView.setVisibility(View.VISIBLE);
	}

	public void hideFooterView() {
		footerView.setVisibility(View.GONE);
	}

	// --------------------------------------------------------------------------------
	// Private Methods

	private void initView() {
		
		containerLayout = new LinearLayout(getContext());
		containerLayout.setOrientation(LinearLayout.VERTICAL);
		containerLayout.setBackgroundColor(Color.WHITE);

			
		headerView = new HeaderView(getContext());
		headerView.setVisibility(View.GONE);
		containerLayout.addView(headerView, 0);
		
		webView = new WebView(getContext());
		webView.setLayoutParams(new TableLayout.LayoutParams(
				TableLayout.LayoutParams.WRAP_CONTENT,
				TableLayout.LayoutParams.WRAP_CONTENT, 1f));
		webView.setVerticalScrollBarEnabled(false);
		webView.setHorizontalScrollBarEnabled(false);
		if (webViewClient == null) {
			webViewClient = new DefaultWebViewClient();
		}
		webView.setWebViewClient(webViewClient);
		webView.setWebChromeClient(new MyWebChromeClient());
		webView.getSettings().setJavaScriptEnabled(true);
		webView.getSettings().setSavePassword(false);
		containerLayout.addView(webView, 1);
			
		footerView = new FooterView(getContext());
		footerView.setVisibility(View.GONE);
		containerLayout.addView(footerView, 2);
		
		addContentView(containerLayout, new ViewGroup.LayoutParams(
				ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.MATCH_PARENT));
	}

	// --------------------------------------------------------------------------------
	//
	// Inner Classes
	//
	// --------------------------------------------------------------------------------

	// --------------------------------------------------------------------------------
	// HeaderView

	public class HeaderView extends RelativeLayout {

		public final static int DEFAULT_HEIGHT = 46; // dip
		public final static int DEFAULT_BACKGROUND_COLOR = -4079931; // #c1bec5
		public final static int DEFAULT_TITLE_COLOR = Color.WHITE;
		public final static int DEFAULT_TITLE_SIZE = 18; // dip

		private TextView titleView;
		private Button closeButton;

		public HeaderView(Context context) {
			super(context);
			initView();
		}

		public TextView getTitleView() {
			return titleView;
		}

		public Button getCloseButton() {
			return closeButton;
		}

		private void initView() {
			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.MATCH_PARENT,
					FuncellTools.dp2Pixel(getContext(), DEFAULT_HEIGHT));
			setLayoutParams(params1);
			setBackgroundColor(DEFAULT_BACKGROUND_COLOR);

			RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
			params2.addRule(RelativeLayout.CENTER_IN_PARENT);
			titleView = new TextView(getContext());
			titleView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, DEFAULT_TITLE_SIZE);
			titleView.setTextColor(DEFAULT_TITLE_COLOR);
			titleView.setLayoutParams(params2);
			addView(titleView);

			RelativeLayout.LayoutParams params3 = new RelativeLayout.LayoutParams(
					ViewGroup.LayoutParams.WRAP_CONTENT,
					ViewGroup.LayoutParams.WRAP_CONTENT);
			params3.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
			Button closeButton = new Button(getContext());
//			closeButton.setText( FuncellRUtils.string(getContext(), "raink_sdk_close") );
			closeButton.setText("close");
			closeButton.setLayoutParams(params3);
			closeButton.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					dismiss();
				}
			});
			addView(closeButton);
		}
	}

	// --------------------------------------------------------------------------------
	// FooterView

	public class FooterView extends RelativeLayout {

		public final static int DEFAULT_BACKGROUND_COLOR = -4079931; // #c1bec5
		public final static int DEFAULT_HEIGHT = 46; // dip

		public FooterView(Context context) {
			super(context);
			initView();
		}

		public void initView() {
			RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
					RelativeLayout.LayoutParams.MATCH_PARENT,
					FuncellTools.dp2Pixel(getContext(), DEFAULT_HEIGHT));
			setLayoutParams(params1);
			setBackgroundColor(DEFAULT_BACKGROUND_COLOR);
		}
	}

	// --------------------------------------------------------------------------------
	// WebViewClient

	protected class DefaultWebViewClient extends WebViewClient {

		@Override
		public boolean shouldOverrideUrlLoading(WebView view, String url){
			if(mFuncellCallBack != null){
				try {
					url = URLDecoder.decode(url, "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String result = "success";
				mFuncellCallBack.onSuccess((T)result);
			}
			view.loadUrl(url);
			return true;
		}

//		@Override
//		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
//		}
//
//		@Override
//		public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
//		}

		@Override
		public void onPageStarted(WebView view, String url, Bitmap favicon) {
			super.onPageStarted(view, url, favicon);

			Log.d(TAG, "WebView loading URL: " + url);

			if (!isDetached) {
				spinner.show();
//				mSpinner.start();
			}
		}

		@Override
		public void onPageFinished(WebView view, String url) {
			super.onPageFinished(view, url);

			if (!isDetached) {
				spinner.dismiss();
//				mSpinner.stop();
			}
			webView.setVisibility(View.VISIBLE);
		}
	}

	// --------------------------------------------------------------------------------
	// WebChromeClient

	private class MyWebChromeClient extends WebChromeClient {

		@Override
		public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, Message resultMsg) {
			return super.onCreateWindow(view, dialog, userGesture, resultMsg);
		}

		@Override
		public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {

			new AlertDialog.Builder(view.getContext())
					.setTitle("알림")
					.setMessage(message)
					.setPositiveButton(android.R.string.ok,
							new AlertDialog.OnClickListener() {
								public void onClick(DialogInterface dialog, int which) {
									result.confirm();
								}
							}).setCancelable(false).create().show();
			return true;
		}

		@Override
		public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {

			new AlertDialog.Builder(view.getContext())
					.setTitle("알림")
					.setMessage(message)
					.setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							result.confirm();
						}
					})
					.setNegativeButton(android.R.string.cancel, new AlertDialog.OnClickListener() {
						public void onClick(DialogInterface dialog, int which) {
							result.cancel();
						}
					}).setCancelable(false).create().show();
			return true;
		}
	}

}
