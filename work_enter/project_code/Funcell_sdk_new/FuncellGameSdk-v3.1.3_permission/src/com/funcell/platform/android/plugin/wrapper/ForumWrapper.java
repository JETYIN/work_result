package com.funcell.platform.android.plugin.wrapper;

import java.lang.reflect.Method;
import java.util.Vector;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.FuncellPluginHelper;
import com.funcell.platform.android.plugin.FuncellPluginType;
import com.funcell.platform.android.plugin.Interface.InterfaceForum;
import com.funcell.platform.android.plugin.Interface.InterfaceHelpShift;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.callback.IFuncellForumCallBack.OnActivityStatusChangedListener;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareType;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;


/**
 * 
 * @author Administrator
 *
 */
public class ForumWrapper extends FuncellStatActivityStub implements InterfaceForum{
	
	private static ForumWrapper mInstance;
	public static ForumWrapper getInstance() {
		if (mInstance == null) {
			synchronized (ForumWrapper.class) {
				if (mInstance == null) {
					mInstance = new ForumWrapper();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
		
	}

	/**
	 * 获取实例
	 * @param className
	 * @return
	 */
	private Object getPluginInstance(String className){
		Class<?> localClass = null;
		try {
			localClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		try {
			Method getInstance_Method = localClass.getMethod("getInstance");
			Object Instance = getInstance_Method.invoke(null);
			return Instance;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void showForum(Activity ctx, String forumChannelType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.ForumPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class<?> localClass = Class.forName(plugins.get(i));
					Method getForumChannel_callMethod = localClass.getMethod("getForumChannel");
					String forumChannel = (String) getForumChannel_callMethod.invoke(instance);
					if(forumChannelType.toString().equalsIgnoreCase(forumChannel)){
						Method callMethod = localClass.getMethod("showForum",new Class[] { Activity.class, String.class,ParamsContainer.class});
						callMethod.invoke(instance,ctx,forumChannelType,paramsContainer);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public boolean isEnabled(String forumChannelType) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.ForumPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class<?> localClass = Class.forName(plugins.get(i));
					Method getForumChannel_callMethod = localClass.getMethod("getForumChannel");
					String forumChannel = (String) getForumChannel_callMethod.invoke(instance);
					if(forumChannelType.toString().equalsIgnoreCase(forumChannel)){
						Method callMethod = localClass.getMethod("isEnabled",new Class[] {String.class});
						return (boolean) callMethod.invoke(instance,forumChannelType);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}

	@Override
	public void setOnActivityStatusChangedListener(Activity ctx,
			String forumChannelType, OnActivityStatusChangedListener<?> callback) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.ForumPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class<?> localClass = Class.forName(plugins.get(i));
					Method getForumChannel_callMethod = localClass.getMethod("getForumChannel");
					String forumChannel = (String) getForumChannel_callMethod.invoke(instance);
					if(forumChannelType.toString().equalsIgnoreCase(forumChannel)){
						Method callMethod = localClass.getMethod("setOnActivityStatusChangedListener",new Class[] {Activity.class, String.class,OnActivityStatusChangedListener.class});
						callMethod.invoke(instance,ctx,forumChannelType,callback);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void setLanguage(Activity ctx, String forumChannelType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.ForumPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class<?> localClass = Class.forName(plugins.get(i));
					Method getForumChannel_callMethod = localClass.getMethod("getForumChannel");
					String forumChannel = (String) getForumChannel_callMethod.invoke(instance);
					if(forumChannelType.toString().equalsIgnoreCase(forumChannel)){
						Method callMethod = localClass.getMethod("setLanguage",new Class[] {Activity.class, String.class,ParamsContainer.class});
						callMethod.invoke(instance,ctx,forumChannelType,paramsContainer);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public Object callFunction(Activity ctx, String forumChannelType,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.ForumPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class<?> localClass = Class.forName(plugins.get(i));
					Method getForumChannel_callMethod = localClass.getMethod("getForumChannel");
					String forumChannel = (String) getForumChannel_callMethod.invoke(instance);
					if(forumChannelType.equalsIgnoreCase(forumChannel)){
						Method callMethod = localClass.getMethod("callFunction",new Class[] {Activity.class, String.class,String.class,Object[].class});
						return callMethod.invoke(instance,ctx,forumChannelType,FunctionName,params);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void setDebugMode(boolean paramBoolean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getSDKVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPluginVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getForumChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applicationInit(Activity ctx,
			IFuncellInitCallBack initCallBack,
			IFuncellSessionCallBack sessionCallBack,
			IFuncellPayCallBack payCallBack) {
		// TODO Auto-generated method stub
		super.applicationInit(ctx, initCallBack, sessionCallBack, payCallBack);
	}

	@Override
	public void onCreate(Activity ctx) {
		// TODO Auto-generated method stub
		super.onCreate(ctx);
	}

	@Override
	public void onStart(Activity ctx) {
		// TODO Auto-generated method stub
		super.onStart(ctx);
	}

	@Override
	public void onRestart(Activity ctx) {
		// TODO Auto-generated method stub
		super.onRestart(ctx);
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		super.onResume(ctx);
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		super.onStop(ctx);
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		super.onPause(ctx);
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub
		super.onDestroy(ctx);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		super.onNewIntent(paramIntent);
	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode,
			Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(ctx, requestCode, resultCode, data);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	@Override
	public Object callFunction(Activity ctx, String FunctionName,
			Object... params) {
		// TODO Auto-generated method stub
		return super.callFunction(ctx, FunctionName, params);
	}

	@Override
	public void onConfigurationChanged(Activity ctx, Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(ctx, newConfig);
	}
	
}
