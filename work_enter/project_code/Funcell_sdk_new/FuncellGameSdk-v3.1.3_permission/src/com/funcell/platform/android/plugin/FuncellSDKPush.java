package com.funcell.platform.android.plugin;

import java.util.ArrayList;

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
import com.funcell.platform.android.plugin.Interface.InterfacePush;
import com.funcell.platform.android.plugin.wrapper.PushWrapper;

/**
 * 
 * @author Administrator
 *
 */
public class FuncellSDKPush extends FuncellStatActivityStub implements InterfacePush{
	
	private static FuncellSDKPush mInstance;
	public static FuncellSDKPush getInstance() {
		if (mInstance == null) {
			synchronized (FuncellSDKPush.class) {
				if (mInstance == null) {
					mInstance = new FuncellSDKPush();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
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
	public Object callFunction(Activity ctx, String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return PushWrapper.getInstance().callFunction(ctx, FunctionName, params);
	}

	@Override
	public void startPush(Activity ctx, String PushChannelType,Object... params) {
		// TODO Auto-generated method stub
		PushWrapper.getInstance().startPush(ctx, PushChannelType, params);
	}

	@Override
	public void closePush(Activity ctx, String PushChannelType,Object... params) {
		// TODO Auto-generated method stub
		PushWrapper.getInstance().closePush(ctx, PushChannelType, params);
	}

	@Override
	public void setAlias(String paramString, String PushChannelType) {
		// TODO Auto-generated method stub
		PushWrapper.getInstance().setAlias(paramString, PushChannelType);
	}

	@Override
	public void delAlias(String paramString, String PushChannelType) {
		// TODO Auto-generated method stub
		PushWrapper.getInstance().delAlias(paramString, PushChannelType);
	}

	@Override
	public void setTags(ArrayList<String> paramArrayList, String PushChannelType) {
		// TODO Auto-generated method stub
		PushWrapper.getInstance().setTags(paramArrayList, PushChannelType);
	}

	@Override
	public void delTags(ArrayList<String> paramArrayList, String PushChannelType) {
		// TODO Auto-generated method stub
		PushWrapper.getInstance().delTags(paramArrayList, PushChannelType);
	}

	@Override
	public Object callFunction(Activity ctx, String PushChannelType,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return PushWrapper.getInstance().callFunction(ctx, PushChannelType, FunctionName, params);
	}

	@Override
	public String getPushChannel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
