package com.funcell.platform.android.plugin;


import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.Interface.InterfaceForum;
import com.funcell.platform.android.plugin.Interface.InterfaceHelpShift;
import com.funcell.platform.android.plugin.callback.IFuncellForumCallBack.OnActivityStatusChangedListener;
import com.funcell.platform.android.plugin.wrapper.ForumWrapper;
import com.funcell.platform.android.plugin.wrapper.HelpShiftWrapper;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;

public class FuncellSDKForum extends FuncellStatActivityStub implements InterfaceForum{
	
	private static FuncellSDKForum mInstance;
	public static FuncellSDKForum getInstance() {
		if (mInstance == null) {
			synchronized (FuncellSDKForum.class) {
				if (mInstance == null) {
					mInstance = new FuncellSDKForum();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
		Log.e("FuncellSDKForum", "----------->initSDK");
		
	}

	@Override
	public void showForum(Activity ctx, String forumChannelType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		ForumWrapper.getInstance().showForum(ctx, forumChannelType, paramsContainer);
	}

	@Override
	public boolean isEnabled(String forumChannelType) {
		// TODO Auto-generated method stub
		return ForumWrapper.getInstance().isEnabled(forumChannelType);
	}

	@Override
	public void setOnActivityStatusChangedListener(Activity ctx,
			String forumChannelType, OnActivityStatusChangedListener<?> callback) {
		// TODO Auto-generated method stub
		ForumWrapper.getInstance().setOnActivityStatusChangedListener(ctx, forumChannelType, callback);
	}

	@Override
	public void setLanguage(Activity ctx, String forumChannelType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		ForumWrapper.getInstance().setLanguage(ctx, forumChannelType, paramsContainer);
	}

	@Override
	public Object callFunction(Activity ctx, String forumChannelType,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return ForumWrapper.getInstance().callFunction(ctx, forumChannelType, FunctionName.trim(), params);
	}

	@Override
	public void setDebugMode(boolean paramBoolean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSDKVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPluginVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getForumChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applicationInit(Activity ctx,
			IFuncellInitCallBack initCallBack,
			IFuncellSessionCallBack sessionCallBack,
			IFuncellPayCallBack payCallBack) {
		// TODO Auto-generated method stub
		super.applicationInit(ctx, initCallBack, sessionCallBack, payCallBack);
	}

	@Override
	public void onCreate(Activity ctx) {
		// TODO Auto-generated method stub
		super.onCreate(ctx);
	}

	@Override
	public void onStart(Activity ctx) {
		// TODO Auto-generated method stub
		super.onStart(ctx);
	}

	@Override
	public void onRestart(Activity ctx) {
		// TODO Auto-generated method stub
		super.onRestart(ctx);
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		super.onResume(ctx);
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		super.onStop(ctx);
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		super.onPause(ctx);
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub
		super.onDestroy(ctx);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		super.onNewIntent(paramIntent);
	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode,
			Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(ctx, requestCode, resultCode, data);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	@Override
	public Object callFunction(Activity ctx, String FunctionName,
			Object... params) {
		// TODO Auto-generated method stub
		return ForumWrapper.getInstance().callFunction(ctx, FunctionName.trim(), params);
	}

	@Override
	public void onConfigurationChanged(Activity ctx, Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(ctx, newConfig);
	}
	
}
