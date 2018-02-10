package com.funcell.platform.android.game.proxy.exit;

import android.app.Activity;

public abstract interface IFuncellExitManager {
	@Deprecated
	public abstract void exit(Activity ctx, IFuncellExitCallBack callBack);
	
	public abstract int GetExitUI(Activity ctx);
}
