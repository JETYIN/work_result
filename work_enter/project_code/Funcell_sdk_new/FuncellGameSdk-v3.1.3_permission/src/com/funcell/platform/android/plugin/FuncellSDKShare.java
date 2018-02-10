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
import com.funcell.platform.android.plugin.Interface.InterfaceShare;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareType;
import com.funcell.platform.android.plugin.wrapper.ShareWrapper;

public class FuncellSDKShare extends FuncellStatActivityStub implements InterfaceShare{
	private String TAG = "FuncellSDKShare";
	
	private static FuncellSDKShare mInstance;
	public static FuncellSDKShare getInstance() {
		if (mInstance == null) {
			synchronized (FuncellSDKShare.class) {
				if (mInstance == null) {
					mInstance = new FuncellSDKShare();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
		Log.e("FuncellSDKShare", "----------->initSDK");
		
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
		return ShareWrapper.getInstance().callFunction(ctx, FunctionName.trim(), params);
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
	public void share(FuncellShareChannelType shareChannelType,FuncellShareType shareType,ParamsContainer paramsContainer,
			IFuncellShareCallBack callBack) {
		// TODO Auto-generated method stub
		ShareWrapper.getInstance().share(shareChannelType, shareType, paramsContainer, callBack);
	}

	@Override
	public String getShareChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object callFunction(Activity ctx,FuncellShareChannelType shareChannelType, String FunctionName,Object... params) {
		// TODO Auto-generated method stub
		return ShareWrapper.getInstance().callFunction(ctx, shareChannelType, FunctionName.trim(), params);
	}
	
	/**
	 * extend callFunction
	 * @param ctx
	 * @param shareChannelType
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx,String shareChannelType, String FunctionName,Object... params) {
		// TODO Auto-generated method stub
		return ShareWrapper.getInstance().callFunction(ctx, shareChannelType, FunctionName.trim(), params);
	}
	
	@Override
	public void share(String shareChannelType, String shareType,
			ParamsContainer paramsContainer, IFuncellShareCallBack callBack) {
		// TODO Auto-generated method stub
		ShareWrapper.getInstance().share(shareChannelType, shareType, paramsContainer, callBack);
	}
	
}
