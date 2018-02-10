package com.funcell.platform.android.game.proxy.pay;

import android.app.Activity;
import android.content.Context;

public abstract interface IFuncellChargerManager {
	@Deprecated
	public abstract void pay(Context ctx,FuncellPayParams paramFuncellPayParams);
	
	public abstract void pay(Activity ctx,FuncellPayParams paramFuncellPayParams,IFuncellPayCallBack callBack);
	
	public abstract FuncellPayParams GetPayParams();
	/**
	 * .......
	 */
}
