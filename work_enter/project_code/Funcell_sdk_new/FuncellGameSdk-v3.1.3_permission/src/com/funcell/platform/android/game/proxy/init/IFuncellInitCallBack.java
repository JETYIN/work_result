package com.funcell.platform.android.game.proxy.init;

public abstract interface IFuncellInitCallBack {
	
	public abstract void onInitFailure(String paramString);

	public abstract void onInitSuccess();
}
