package com.funcell.platform.android.plugin.Interface;


import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsEventType;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsType;

import android.app.Activity;

public abstract interface InterfaceAnalytics {
	public static final int PluginType = 1;

	public abstract void startSession();

	public abstract void stopSession();

	public abstract void setSessionContinueMillis(int paramInt);

	public abstract void setCaptureUncaughtException(boolean paramBoolean);

	public abstract void setDebugMode(boolean paramBoolean);

	public abstract void logError(FuncellAnalyticsType type,String paramString1, String paramString2);

	public abstract void logEvent(FuncellAnalyticsEventType eventType,ParamsContainer paramsContainer);

	public abstract void logEvent(FuncellAnalyticsType type,FuncellAnalyticsEventType eventType,ParamsContainer paramsContainer);
	
	public abstract void logEvent(String AnalyticsType,String AnalyticsEventType,ParamsContainer paramsContainer);

	public abstract void logTimedEventBegin(String paramString);

	public abstract void logTimedEventEnd(String paramString);

	public abstract String getSDKVersion();

	public abstract String getPluginVersion();
	
	public abstract String getAnalyticsChannel();
	
	public abstract Object callFunction(Activity ctx,FuncellAnalyticsType type, String FunctionName, Object... params);
}
