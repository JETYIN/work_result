package com.funcell.platform.android.game.proxy.data;

import android.app.Activity;

public abstract interface IFuncellDataManager {
	
	public abstract void setDatas(Activity ctx,FuncellDataTypes paramDataTypes, ParamsContainer paramParamsContainer);
}
