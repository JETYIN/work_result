package com.funcell.platform.android.plugin;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.Interface.InterfaceHelpShift;
import com.funcell.platform.android.plugin.Interface.InterfaceShare;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareType;
import com.funcell.platform.android.plugin.wrapper.HelpShiftWrapper;
import com.funcell.platform.android.plugin.wrapper.ShareWrapper;

public class FuncellSDKHelpShift extends FuncellStatActivityStub implements InterfaceHelpShift{
	private String TAG = "FuncellSDKHelpShift";
	
	private static FuncellSDKHelpShift mInstance;
	public static FuncellSDKHelpShift getInstance() {
		if (mInstance == null) {
			synchronized (FuncellSDKHelpShift.class) {
				if (mInstance == null) {
					mInstance = new FuncellSDKHelpShift();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
		Log.e("FuncellSDKHelpShift", "----------->initSDK");
		
	}

	@Override
	public void applicationInit(Activity ctx,
			IFuncellInitCallBack initCallBack,
			IFuncellSessionCallBack sessionCallBack,
			IFuncellPayCallBack payCallBack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRestart(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode,
			Intent data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		
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
	public String getHelpShiftChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object callFunction(Activity ctx, String FunctionName,
			Object... params) {
		// TODO Auto-generated method stub
		return HelpShiftWrapper.getInstance().callFunction(ctx, FunctionName.trim(), params);
	}

	@Override
	public void showHelpShift(Activity ctx) {
		// TODO Auto-generated method stub
		HelpShiftWrapper.getInstance().showHelpShift(ctx);
	}

	@Override
	public Object callFunction(Activity ctx, String helpChannelType,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return HelpShiftWrapper.getInstance().callFunction(ctx, helpChannelType, FunctionName.trim(), params);
	}
	
}
