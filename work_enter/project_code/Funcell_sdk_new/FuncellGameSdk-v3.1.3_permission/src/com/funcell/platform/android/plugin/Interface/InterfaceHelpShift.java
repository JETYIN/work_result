package com.funcell.platform.android.plugin.Interface;


import android.app.Activity;

import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareType;

public interface InterfaceHelpShift {
	public static final int PluginType = 1;
	
	public abstract void showHelpShift(Activity ctx);
	
	public abstract void setDebugMode(boolean paramBoolean);
	
	public abstract String getSDKVersion();
	
	public abstract String getPluginVersion();
	
	public abstract String getHelpShiftChannel();
	
	public abstract Object callFunction(Activity ctx,String helpChannelType, String FunctionName, Object... params);
	
}
