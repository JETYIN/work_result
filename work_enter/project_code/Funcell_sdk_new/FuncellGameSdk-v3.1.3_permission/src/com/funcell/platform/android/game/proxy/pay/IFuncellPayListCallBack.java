package com.funcell.platform.android.game.proxy.pay;

public abstract interface IFuncellPayListCallBack {
	
	public abstract void onSuccess(String response);

	public abstract void onFail(String paramString);
}
