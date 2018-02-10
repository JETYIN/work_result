package com.funcell.platform.android.plugin.wrapper;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.FuncellPluginHelper;
import com.funcell.platform.android.plugin.FuncellPluginType;
import com.funcell.platform.android.plugin.Interface.InterfacePush;
import com.funcell.platform.android.plugin.Interface.InterfaceShare;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsEventType;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsType;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareType;


/**
 * 
 * @author Administrator
 *
 */
public class PushWrapper extends FuncellStatActivityStub implements InterfacePush{
	private String TAG = "PushWrapper";
	
	private static PushWrapper mInstance;
	public static PushWrapper getInstance() {
		if (mInstance == null) {
			synchronized (PushWrapper.class) {
				if (mInstance == null) {
					mInstance = new PushWrapper();
				}
			}
		}
		return mInstance;
	}
	
	public void initSDK(Activity ctx){
		
	}

	/**
	 * »ñÈ¡ÊµÀý
	 * @param className
	 * @return
	 */
	private Object getPluginInstance(String className){
		Class localClass = null;
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
	public void applicationInit(Activity ctx,
			IFuncellInitCallBack initCallBack,
			IFuncellSessionCallBack sessionCallBack,
			IFuncellPayCallBack payCallBack) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCreate(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRestart(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode,
			Intent data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object callFunction(Activity ctx, String FunctionName,
			Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startPush(Activity ctx, String PushChannelType,
			Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.PushPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getPushChannel_callMethod = localClass.getMethod("getPushChannel");
					String pushChannel = (String) getPushChannel_callMethod.invoke(instance);
					if(PushChannelType.equalsIgnoreCase(pushChannel)){
						Method callMethod = localClass.getMethod("startPush",new Class[] {Activity.class, String.class, Object[].class });
						callMethod.invoke(instance,ctx,PushChannelType,params);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void closePush(Activity ctx, String PushChannelType,
			Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.PushPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getPushChannel_callMethod = localClass.getMethod("getPushChannel");
					String pushChannel = (String) getPushChannel_callMethod.invoke(instance);
					if(PushChannelType.equalsIgnoreCase(pushChannel)){
						Method callMethod = localClass.getMethod("closePush",new Class[] {Activity.class, String.class, Object[].class });
						callMethod.invoke(instance,ctx,PushChannelType,params);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void setAlias(String paramString, String PushChannelType) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.PushPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getPushChannel_callMethod = localClass.getMethod("getPushChannel");
					String pushChannel = (String) getPushChannel_callMethod.invoke(instance);
					if(PushChannelType.equalsIgnoreCase(pushChannel)){
						Method callMethod = localClass.getMethod("setAlias",new Class[] { String.class, String.class });
						callMethod.invoke(instance,paramString,PushChannelType);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delAlias(String paramString, String PushChannelType) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.PushPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getPushChannel_callMethod = localClass.getMethod("getPushChannel");
					String pushChannel = (String) getPushChannel_callMethod.invoke(instance);
					if(PushChannelType.equalsIgnoreCase(pushChannel)){
						Method callMethod = localClass.getMethod("delAlias",new Class[] { String.class, String.class });
						callMethod.invoke(instance,paramString,PushChannelType);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void setTags(ArrayList<String> paramArrayList, String PushChannelType) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.PushPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getPushChannel_callMethod = localClass.getMethod("getPushChannel");
					String pushChannel = (String) getPushChannel_callMethod.invoke(instance);
					if(PushChannelType.equalsIgnoreCase(pushChannel)){
						Method callMethod = localClass.getMethod("setTags",new Class[] { ArrayList.class, String.class });
						callMethod.invoke(instance,paramArrayList,PushChannelType);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void delTags(ArrayList<String> paramArrayList, String PushChannelType) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.PushPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getPushChannel_callMethod = localClass.getMethod("getPushChannel");
					String pushChannel = (String) getPushChannel_callMethod.invoke(instance);
					if(PushChannelType.equalsIgnoreCase(pushChannel)){
						Method callMethod = localClass.getMethod("delTags",new Class[] { ArrayList.class, String.class });
						callMethod.invoke(instance,paramArrayList,PushChannelType);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
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
	public Object callFunction(Activity ctx, String PushChannelType,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		String _ret = null;
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.PushPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getPushChannel_callMethod = localClass.getMethod("getPushChannel");
					String pushChannel = (String) getPushChannel_callMethod.invoke(instance);
					if(PushChannelType.equalsIgnoreCase(pushChannel)){
						Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class,String.class, String.class,Object[].class });
						return callMethod.invoke(instance,ctx,PushChannelType,FunctionName,params);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return _ret;
	}

	@Override
	public String getPushChannel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
