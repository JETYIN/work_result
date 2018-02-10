package com.funcell.platform.android;

import com.funcell.platform.android.game.proxy.session.FuncellSession;

import android.app.Activity;

/**
 * cocos2d-x接口文件,用于回调cocos2d中的方法
 * @author Administrator
 *
 */
public class FuncellJniHelper{
	
	public static native void onInitCocos2dEnv(Activity ctx);
	
	public static native void onInitSuccess();
	
	public static native void onInitFailure(String paramString);
	
	public static native void onLoginSuccess(FuncellSession session);
	
	public static native void onLoginFailed(String paramString);
	
	public static native void onLoginCancel();
	
	public static native void onLogout();
	
	public static native void onSuccess(String cpOrder,String sdkOrder,String extrasParams);
	
	public static native void onFail(String paramString);
	
	public static native void onCancel(String paramString);
	
	public static native void onClosePayPage(String cpOrder,String sdkOrder,String extrasParams);
	
	public static native void onChannelExit();
	
	public static native void onGameExit();
	
	public static native void onPayListSuccess(String json);
	
	public static native void onPayListFailed(String paramString);
	
	public static native void onServerListSuccess(String json);
	
	public static native void onServerListFailed(String paramString);
	
	public static native void onNoticeListSuccess(String json);
	
	public static native void onNoticeListFailed(String paramString);
	
	/******************share部分*****************************/
	public static native void share_onSuccess(String json);
	
	public static native void share_onCancel();
	
	public static native void share_onFailed(String json);
	
}
