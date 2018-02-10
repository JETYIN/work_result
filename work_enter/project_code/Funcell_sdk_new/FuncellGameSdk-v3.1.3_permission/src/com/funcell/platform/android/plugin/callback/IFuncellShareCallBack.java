package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;

@FuncellNotProguard
public abstract interface IFuncellShareCallBack {

	public abstract void onSuccess(ParamsContainer paramsContainer);
	
	public abstract void onCancel();

	public abstract void onFailed(String paramString);

}
