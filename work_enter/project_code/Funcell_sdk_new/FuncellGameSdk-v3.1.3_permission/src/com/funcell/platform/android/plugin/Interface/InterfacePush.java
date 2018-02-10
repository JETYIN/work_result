package com.funcell.platform.android.plugin.Interface;

import java.util.ArrayList;

import com.funcell.platform.android.game.proxy.data.ParamsContainer;

import android.app.Activity;

public abstract interface InterfacePush {
	public static final int PluginType = 1;

	public abstract void startPush(Activity ctx,String PushChannelType,Object... params);

	public abstract void closePush(Activity ctx,String PushChannelType,Object... params);

	public abstract void setAlias(String paramString,String PushChannelType);

	public abstract void delAlias(String paramString,String PushChannelType);

	public abstract void setTags(ArrayList<String> paramArrayList,String PushChannelType);

	public abstract void delTags(ArrayList<String> paramArrayList,String PushChannelType);

	public abstract void setDebugMode(boolean paramBoolean);

	public abstract String getSDKVersion();

	public abstract String getPluginVersion();
	
	public abstract String getPushChannel();
	
	public abstract Object callFunction(Activity ctx,String PushChannelType, String FunctionName, Object... params);
	
}
