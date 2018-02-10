package com.funcell.platform.android.game.proxy.session;

import android.app.Activity;

public abstract interface IFuncellSessionManager {
	
	/**
	 * 
	 * @param ctx
	 * @param callBack
	 * @param paramString 可能是渠道的标识
	 * @param paramObject
	 */
	public abstract void Login(Activity ctx, IFuncellSessionCallBack callBack);
	
	public abstract void Logout(Activity ctx, IFuncellSessionCallBack callBack);

}
