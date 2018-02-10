package com.funcell.platform.android.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.Interface.InterfaceCrash;
import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;
import com.funcell.platform.android.plugin.wrapper.CrashWrapper;

/**
 * 
 * @author Administrator
 *
 */
public class FuncellSDKCrash extends FuncellStatActivityStub implements InterfaceCrash{
	
	private static FuncellSDKCrash mInstance;
	public static FuncellSDKCrash getInstance() {
		if (mInstance == null) {
			synchronized (FuncellSDKCrash.class) {
				if (mInstance == null) {
					mInstance = new FuncellSDKCrash();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
		Log.e("FuncellSDKCrash", "----------->initSDK");
	}
	
	@Override
	public void setUserIdentifier(String userid) {
		// TODO Auto-generated method stub
		CrashWrapper.getInstance().setUserIdentifier(userid);
	}

	@Override
	public void reportException(String name, String crash) {
		// TODO Auto-generated method stub
		CrashWrapper.getInstance().reportException(name, crash);
	}

	@Override
	public void leaveBreadcrumb(String paramString) {
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
	public boolean isFunctionSupported(String paramString) {
		// TODO Auto-generated method stub
		return false;
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
	public Object callFunction(Activity ctx, String FunctionName,
			Object... params) {
		// TODO Auto-generated method stub
		return CrashWrapper.getInstance().callFunction(ctx, FunctionName.trim(), params);
	}

	@Override
	public Object callFunction(Activity ctx, FuncellCrashChannelType type,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return CrashWrapper.getInstance().callFunction(ctx, type, FunctionName.trim(), params);
	}
	
	/**
	 * extend callFunction
	 * @param ctx
	 * @param CrashChannelType
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx, String CrashChannelType,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return CrashWrapper.getInstance().callFunction(ctx, CrashChannelType, FunctionName.trim(), params);
	}

	@Override
	public String getCrashChannel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
