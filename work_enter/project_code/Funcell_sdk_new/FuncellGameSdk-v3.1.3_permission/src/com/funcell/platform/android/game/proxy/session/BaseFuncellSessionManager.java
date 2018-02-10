package com.funcell.platform.android.game.proxy.session;

import com.funcell.platform.android.game.proxy.BaseFuncellGameSdkProxy;

import android.app.Activity;
import android.util.Log;

/**
 * 此类为基础类，后续可能添加apk强制更新操作
 * 各个渠道需要继承该类
 * @author Administrator
 *
 */
public abstract class BaseFuncellSessionManager {
	
	private String TAG = getClass().getName().toString();
	private IFuncellSessionCallBack mFuncellSessionCallBack;
	
}
