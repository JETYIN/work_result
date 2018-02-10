package com.funcell.platform.android.plugin.callback;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public abstract interface IFuncellPushCallBack<RESULT> {
	public abstract void onMessageReceived(String state,RESULT result);
}
