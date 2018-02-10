package com.funcell.platform.android.game.authentication.ui;

import com.funcell.platform.android.FuncellRUtils;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

abstract class AbstractDialog extends Dialog {

	protected static final int DEFAULT_THEME = android.R.style.Theme_Translucent_NoTitleBar_Fullscreen;

	protected static final String DEFAULT_SPINNER_MESSAGE = "Loading...";

	protected boolean isDetached = true;
	
//	protected ProgressDialog spinner;
	protected FuncellLoadingDialog spinner;

	// --------------------------------------------------------------------------------
	// Constructor

	/**
	 * Constructor
	 * 
	 * @param context
	 */
	public AbstractDialog(Context context) {
		super(context, DEFAULT_THEME);
	}

	/**
	 * Constructor
	 * 
	 * @param context
	 * @param theme
	 */
	public AbstractDialog(Context context, int theme) {
		super(context, theme);
	}

	// --------------------------------------------------------------------------------
	// Override Methods

	@Override
	public void show() {
		if (isDetached) {
			super.show();
		}
	}

	@Override
	public void dismiss() {
		if (!isDetached) {
			if (spinner.isShowing()) {
				spinner.dismiss();
				
			}
			super.dismiss();
		}
	}

	@Override
	public void onDetachedFromWindow() {
		isDetached = true;
		super.onDetachedFromWindow();
	}

	@Override
	public void onAttachedToWindow() {
		isDetached = false;
		super.onAttachedToWindow();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		requestWindowFeature(Window.FEATURE_NO_TITLE);
		
		getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

		// Spinner
//		spinner = new ProgressDialog(getContext());
//		spinner.requestWindowFeature(Window.FEATURE_NO_TITLE);
//		spinner.setIndeterminateDrawable(getContext().getResources().getDrawable(FuncellRUtils.drawable(getContext(), "funcell_loading_progress_rotate")));
//		spinner.setMessage(DEFAULT_SPINNER_MESSAGE);
		
		spinner = new FuncellLoadingDialog(getContext(),FuncellRUtils.style(getContext(), "FuncellLoadingDialog"));
	}
	
	// --------------------------------------------------------------------------------
	// Helper Methods

	protected Context getApplicationContext() {
		return getContext().getApplicationContext();
	}

	protected SharedPreferences getSharedPreferences(String name) {
		return getContext().getApplicationContext().getSharedPreferences(name, Context.MODE_PRIVATE);
	}

	protected Resources getResources() {
		return getContext().getResources();
	}

	protected Configuration getConfiguration() {
		return getContext().getResources().getConfiguration();
	}

}
