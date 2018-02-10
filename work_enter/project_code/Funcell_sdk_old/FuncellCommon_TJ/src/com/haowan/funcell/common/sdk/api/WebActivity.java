/**
 * create data: 2013-5-5
 * create time: 下午02:43:39
 * @author : Administrator
 * <一句话功能描述>
 * <功能详情1...>
 * 修改记录（记录作者，修改内容，修改时间）：
 * 
 */
package com.haowan.funcell.common.sdk.api;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout.LayoutParams;

/**
 * @author : Administrator <一句话功能描述> <功能详情1...>
 */
@SuppressLint("SetJavaScriptEnabled")
public class WebActivity extends Activity {

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		WebView webView = new WebView(this);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.setWebViewClient(new WebViewClient() {
			public boolean shouldOverrideUrlLoading(WebView view, String url) {
				view.loadUrl(url);
				return true;
			}
		});

		webView.loadUrl(getIntent().getExtras().getString("data"));

		LayoutParams layoutParams=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		setContentView(webView,layoutParams);
	}
}
