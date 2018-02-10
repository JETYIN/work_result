package com.funcell.platform.android.plugin.Interface;


import android.app.Activity;

import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareType;

public interface InterfaceShare {
	public static final int PluginType = 1;
	
	public abstract void share(FuncellShareChannelType shareChannelType,FuncellShareType shareType, ParamsContainer paramsContainer,IFuncellShareCallBack callBack);
	
	public abstract void share(String shareChannelType,String shareType, ParamsContainer paramsContainer,IFuncellShareCallBack callBack);
	
	public abstract void setDebugMode(boolean paramBoolean);
	
	public abstract String getSDKVersion();
	
	public abstract String getPluginVersion();
	
	public abstract String getShareChannel();
	
	public abstract Object callFunction(Activity ctx,FuncellShareChannelType shareChannelType, String FunctionName, Object... params);
}
