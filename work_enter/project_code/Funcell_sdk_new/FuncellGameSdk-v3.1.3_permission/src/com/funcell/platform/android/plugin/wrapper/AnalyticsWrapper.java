package com.funcell.platform.android.plugin.wrapper;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.FuncellPluginHelper;
import com.funcell.platform.android.plugin.FuncellPluginType;
import com.funcell.platform.android.plugin.Interface.InterfaceAnalytics;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsEventType;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsType;


/**
 * 
 * @author Administrator
 *
 */
public class AnalyticsWrapper extends FuncellStatActivityStub implements InterfaceAnalytics{
	private String TAG = "AnalyticsWrapper";
	
	private static AnalyticsWrapper mInstance;
	public static AnalyticsWrapper getInstance() {
		if (mInstance == null) {
			synchronized (AnalyticsWrapper.class) {
				if (mInstance == null) {
					mInstance = new AnalyticsWrapper();
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
	public void startSession() {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod("startSession");
					callMethod.invoke(instance);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void stopSession() {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod("stopSession");
					callMethod.invoke(instance);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void setSessionContinueMillis(int paramInt) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		
	}

	@Override
	public void setCaptureUncaughtException(boolean paramBoolean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDebugMode(boolean paramBoolean) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logError(FuncellAnalyticsType type,String paramString1, String paramString2) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getAnalyticsChannel_callMethod = localClass.getMethod("getAnalyticsChannel");
					String analyticsChannel = (String) getAnalyticsChannel_callMethod.invoke(instance);
					if(type.toString().equalsIgnoreCase(analyticsChannel)){
						Method logEvent_callMethod = localClass.getMethod("logError",new Class[] { FuncellAnalyticsType.class, String.class,String.class});
						logEvent_callMethod.invoke(instance,type,paramString1,paramString2);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void logEvent(FuncellAnalyticsEventType eventType,ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method logEvent_callMethod = localClass.getMethod("logEvent",new Class[] {FuncellAnalyticsEventType.class,ParamsContainer.class});
					logEvent_callMethod.invoke(instance,eventType,paramsContainer);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void logEvent(FuncellAnalyticsType type,FuncellAnalyticsEventType eventType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getAnalyticsChannel_callMethod = localClass.getMethod("getAnalyticsChannel");
					String analyticsChannel = (String) getAnalyticsChannel_callMethod.invoke(instance);
					if(type.toString().equalsIgnoreCase(analyticsChannel)){
						Method logEvent_callMethod = localClass.getMethod("logEvent",new Class[] { FuncellAnalyticsType.class, FuncellAnalyticsEventType.class,ParamsContainer.class});
						logEvent_callMethod.invoke(instance,type,eventType,paramsContainer);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void logTimedEventBegin(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logTimedEventEnd(String paramString) {
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
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		ParamsContainer paramsContainer = new ParamsContainer();
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getAnalyticsChannel_callMethod = localClass.getMethod("getAnalyticsChannel");
					String analyticsChannel = (String) getAnalyticsChannel_callMethod.invoke(instance);
					Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class, String.class,Object[].class });
					Object result = callMethod.invoke(instance,ctx,FunctionName,params);
					Log.e(TAG, "callFunction result:"+result);
					paramsContainer.put(analyticsChannel, result);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return paramsContainer;
	}
	
	@Override
	public Object callFunction(Activity ctx, FuncellAnalyticsType type,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getAnalyticsChannel_callMethod = localClass.getMethod("getAnalyticsChannel");
					String analyticsChannel = (String) getAnalyticsChannel_callMethod.invoke(instance);
					if(type.toString().equalsIgnoreCase(analyticsChannel)){
						Method callFunction_callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class,FuncellAnalyticsType.class, String.class,Object[].class });
						return callFunction_callMethod.invoke(instance,ctx,type,FunctionName,params);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * extend callFunction
	 * @param ctx
	 * @param AnalyticsType
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx, String AnalyticsType,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		String _ret = null;
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getAnalyticsChannel_callMethod = localClass.getMethod("getAnalyticsChannel");
					String analyticsChannel = (String) getAnalyticsChannel_callMethod.invoke(instance);
					if(AnalyticsType.equalsIgnoreCase(analyticsChannel)){
						Method callFunction_callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class,String.class, String.class,Object[].class });
						return callFunction_callMethod.invoke(instance,ctx,AnalyticsType,FunctionName,params);
					}
				}catch(NoSuchMethodException noSuchMethodException){
					_ret = "This callFunction({ Activity.class,String.class, String.class,Object[].class }) is not found in an instance,please check the "+AnalyticsType +" plugin version!";
				}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
		return _ret;
	}
	
	@Override
	public String getAnalyticsChannel() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void OnReceive(Context ctx, Intent intent){
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method OnReceive_callMethod = localClass.getMethod("OnReceive",new Class[] {Context.class,Intent.class});
					OnReceive_callMethod.invoke(instance,ctx,intent);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void logEvent(String AnalyticsType, String AnalyticsEventType,
			ParamsContainer paramsContainer) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.AnalyticsPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getAnalyticsChannel_callMethod = localClass.getMethod("getAnalyticsChannel");
					String analyticsChannel = (String) getAnalyticsChannel_callMethod.invoke(instance);
					if(AnalyticsType.equalsIgnoreCase(analyticsChannel)){
						Method logEvent_callMethod = localClass.getMethod("logEvent",new Class[] { String.class, String.class,ParamsContainer.class});
						logEvent_callMethod.invoke(instance,AnalyticsType,AnalyticsEventType,paramsContainer);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
