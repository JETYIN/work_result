package com.funcell.platform.android.game.authentication.ui;

import com.funcell.platform.android.game.proxy.IFuncellCallBack;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

public class DefaultWebViewDialog<T> extends AbstractWebViewDialog<T> {

	private String url;
	private Activity mParentActivity;
	
	public DefaultWebViewDialog(Context context, String url) {
		super(context);
		this.url = url;
		this.mParentActivity = (Activity)context;
	}

	@Override
	public void loadUrl() {
		getWebView().loadUrl(url);
	}

	@Override
	public void setOnWebViewCallBack(IFuncellCallBack<T> callBack) {
		// TODO Auto-generated method stub
		super.setOnWebViewCallBack(callBack);
	}

	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		try {
			if(mParentActivity != null && !mParentActivity.isFinishing()){
				super.dismiss();
			}
		} catch (Exception e) {
			// TODO: handle exception
			Log.e("DefaultWebViewDialog", e.toString());
		}
	}
	
}
