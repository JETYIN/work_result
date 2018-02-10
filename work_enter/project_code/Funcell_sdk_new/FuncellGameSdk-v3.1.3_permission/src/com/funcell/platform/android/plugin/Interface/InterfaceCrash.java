package com.funcell.platform.android.plugin.Interface;


import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;

import android.app.Activity;

public abstract interface InterfaceCrash {
	public static final int PluginType = 1;

	public abstract void setUserIdentifier(String paramString);

	public abstract void reportException(String paramString1,String paramString2);

	public abstract void leaveBreadcrumb(String paramString);

	public abstract String getSDKVersion();

	public abstract String getPluginVersion();

	public abstract boolean isFunctionSupported(String paramString);
	
	public abstract String getCrashChannel();
	
	public abstract Object callFunction(Activity ctx,FuncellCrashChannelType type, String FunctionName, Object... params);
	
}
