package com.funcell.platform.android.game.authentication.ui;

import com.funcell.platform.android.FuncellRUtils;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

public class FuncellLoadingDialog extends Dialog{

	private FuncellLoadingView mLoadingView;
	private static int DEFAULT_THEME = android.R.style.Theme_Translucent_NoTitleBar_Fullscreen;
	
	public FuncellLoadingDialog(Context context) {
		this(context,DEFAULT_THEME);
		// TODO Auto-generated constructor stub
	}
	
	public FuncellLoadingDialog(Context context,int theme) {
		super(context,theme);
		// TODO Auto-generated constructor stub
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(FuncellRUtils.layout(getContext(), "fun_loading_dialog"));
		mLoadingView = (FuncellLoadingView) findViewById(FuncellRUtils.id(getContext(), "funcell_loadingview"));
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		if(mLoadingView != null && !mLoadingView.isShown()){
			mLoadingView.start();
		}
		super.show();
	}

	@Override
	public void dismiss() {
		// TODO Auto-generated method stub
		if(mLoadingView != null && mLoadingView.isShown()){
			mLoadingView.stop();
		}
		super.dismiss();
	}

	public void setSize(int width, int height) {
		WindowManager.LayoutParams params = getWindow().getAttributes();
		params.width = width;
		params.height = height;
		getWindow().setAttributes(params);
	}
}
