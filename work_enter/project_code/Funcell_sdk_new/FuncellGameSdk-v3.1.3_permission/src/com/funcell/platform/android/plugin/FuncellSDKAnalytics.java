package com.funcell.platform.android.plugin;

import java.util.Hashtable;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.Interface.InterfaceAnalytics;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsEventType;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsType;
import com.funcell.platform.android.plugin.wrapper.AnalyticsWrapper;


/**
 *
 * @author Administrator
 *
 */
public class FuncellSDKAnalytics extends FuncellStatActivityStub implements InterfaceAnalytics{
	
	private static FuncellSDKAnalytics mInstance;
	public static FuncellSDKAnalytics getInstance() {
		if (mInstance == null) {
			synchronized (FuncellSDKAnalytics.class) {
				if (mInstance == null) {
					mInstance = new FuncellSDKAnalytics();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
		AnalyticsWrapper.getInstance().initSDK(ctx);
	}
	
	@Override
	public void startSession() {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().startSession();
	}

	@Override
	public void stopSession() {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().stopSession();
	}

	@Override
	public void setSessionContinueMillis(int paramInt) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().setSessionContinueMillis(paramInt);
	}

	@Override
	public void setCaptureUncaughtException(boolean paramBoolean) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().setCaptureUncaughtException(paramBoolean);
	}

	@Override
	public void setDebugMode(boolean paramBoolean) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().setDebugMode(paramBoolean);
	}

	@Override
	public void logError(FuncellAnalyticsType type,String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().logError(type,paramString1,paramString2);
	}

	@Override
	public void logEvent(FuncellAnalyticsEventType eventType,ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().logEvent(eventType,paramsContainer);
	}

	@Override
	public void logEvent(FuncellAnalyticsType type,FuncellAnalyticsEventType eventType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().logEvent(type,eventType,paramsContainer);
	}

	@Override
	public void logTimedEventBegin(String paramString) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().logTimedEventBegin(paramString);
	}

	@Override
	public void logTimedEventEnd(String paramString) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().logTimedEventEnd(paramString);
	}

	@Override
	public String getSDKVersion() {
		// TODO Auto-generated method stub
		return AnalyticsWrapper.getInstance().getSDKVersion();
	}

	@Override
	public String getPluginVersion() {
		// TODO Auto-generated method stub
		return AnalyticsWrapper.getInstance().getPluginVersion();
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
		Log.e("FuncellSDKAnalytics", "----------->onRestart");
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		Log.e("FuncellSDKAnalytics", "----------->onResume");
		
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		Log.e("FuncellSDKAnalytics", "----------->onStop");
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		Log.e("FuncellSDKAnalytics", "----------->onPause");
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub
		Log.e("FuncellSDKAnalytics", "----------->onDestroy");
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		Log.e("FuncellSDKAnalytics", "----------->onNewIntent");
	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode,
			Intent data) {
		// TODO Auto-generated method stub
		Log.e("FuncellSDKAnalytics", "----------->onActivityResult");
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
	}
	
	/**
	 * 直接调用所有FuncellAnalytics类，并返回函数执行结果的集合
	 */
	@Override
	public Object callFunction(Activity ctx, String FunctionName,
			Object... params) {
		// TODO Auto-generated method stub
		return AnalyticsWrapper.getInstance().callFunction(ctx, FunctionName.trim(), params);
	}

	@Override
	public String getAnalyticsChannel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 根据type类型来调用指定的FuncellAnalytics类,并返回函数的执行结果
	 */
	@Override
	public Object callFunction(Activity ctx, FuncellAnalyticsType type,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		return AnalyticsWrapper.getInstance().callFunction(ctx, type, FunctionName.trim(), params);
	}
	
	/**
	 * extend callFunction
	 * @param ctx
	 * @param type
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx, String AnalyticsType,String FunctionName, Object... params) {
		return AnalyticsWrapper.getInstance().callFunction(ctx,AnalyticsType, FunctionName.trim(), params);
	}
	
	@Override
	public void logEvent(String AnalyticsType, String AnalyticsEventType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		AnalyticsWrapper.getInstance().logEvent(AnalyticsType, AnalyticsEventType, paramsContainer);
	}
	
}
