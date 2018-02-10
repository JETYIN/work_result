package com.funcell.platform.android.plugin.Interface;

import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.plugin.callback.IFuncellForumCallBack;
import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;

import android.app.Activity;


public interface InterfaceForum {
	public static final int PluginType = 1;
	
	public abstract void showForum(Activity ctx,String forumChannelType,ParamsContainer paramsContainer);
	
	public abstract boolean isEnabled(String forumChannelType);
	
	public abstract void setOnActivityStatusChangedListener(Activity ctx,String forumChannelType,IFuncellForumCallBack.OnActivityStatusChangedListener<?> callback);
	
	public abstract void setLanguage(Activity ctx,String forumChannelType,ParamsContainer paramsContainer);
	
	public abstract Object callFunction(Activity ctx,String forumChannelType, String FunctionName, Object... params);
	
	public abstract void setDebugMode(boolean paramBoolean);
	
	public abstract String getSDKVersion();
	
	public abstract String getPluginVersion();
	
	public abstract String getForumChannel();
	
	
	
}
