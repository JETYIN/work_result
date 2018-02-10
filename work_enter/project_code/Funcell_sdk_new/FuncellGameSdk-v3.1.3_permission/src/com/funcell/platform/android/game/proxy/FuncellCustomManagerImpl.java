package com.funcell.platform.android.game.proxy;

import org.json.JSONObject;

import android.app.Activity;
import android.util.Log;

/**
 * 
 * @author Administrator
 *
 */
public class FuncellCustomManagerImpl{
	private String TAG = getClass().getName().toString();
	private static FuncellCustomManagerImpl mInstance;
	
	public static FuncellCustomManagerImpl getInstance() {
		if (mInstance == null) {
			synchronized (FuncellCustomManagerImpl.class) {
				if (mInstance == null) {
					mInstance = new FuncellCustomManagerImpl();
				}
			}
		}
		return mInstance;
	}
	
	public int functionTest(Activity ctx,Object... params){
		Log.e(TAG, "functionTest invoke:");
		if(params.length > 0 && params[0] instanceof JSONObject){
			Log.e(TAG, "params[0]:"+params[0]);
		}
		if(params.length > 0 && params[params.length - 1] instanceof IFuncellCallBack){
			IFuncellCallBack<String> callBack = (IFuncellCallBack<String>) params[params.length - 1];
			callBack.onSuccess("is test");
			callBack.onError(new FuncellException("is test excption"));
		}
		return 1;
		
	}
	
}
