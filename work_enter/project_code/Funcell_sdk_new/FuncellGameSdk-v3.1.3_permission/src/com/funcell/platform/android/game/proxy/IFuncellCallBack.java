package com.funcell.platform.android.game.proxy;

public interface IFuncellCallBack<RESULT> {

	public abstract void onSuccess(RESULT result);
	
	public abstract void onError(FuncellException error);

}
