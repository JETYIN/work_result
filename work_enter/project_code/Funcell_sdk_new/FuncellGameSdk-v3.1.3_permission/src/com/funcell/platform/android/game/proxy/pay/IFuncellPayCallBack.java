package com.funcell.platform.android.game.proxy.pay;

public abstract interface IFuncellPayCallBack {
	
	public abstract void onSuccess(String cpOrder,String sdkOrder,String extrasParams);

	public abstract void onFail(String paramString);
	
	public abstract void onCancel(String paramString);
	
	public abstract void onClosePayPage(String cpOrder,String sdkOrder,String extrasParams);
}
