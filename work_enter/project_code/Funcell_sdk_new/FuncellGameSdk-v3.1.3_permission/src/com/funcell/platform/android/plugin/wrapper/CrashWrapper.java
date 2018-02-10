package com.funcell.platform.android.plugin.wrapper;

import java.lang.reflect.Method;
import java.util.Vector;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.FuncellPluginHelper;
import com.funcell.platform.android.plugin.FuncellPluginType;
import com.funcell.platform.android.plugin.Interface.InterfaceCrash;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsType;
import com.funcell.platform.android.plugin.crash.FuncellCrashChannelType;


/**
 * 
 * @author Administrator
 *
 */
public class CrashWrapper extends FuncellStatActivityStub implements InterfaceCrash{
	private String TAG = "CrashWrapper";
	
	private static CrashWrapper mInstance;
	public static CrashWrapper getInstance() {
		if (mInstance == null) {
			synchronized (CrashWrapper.class) {
				if (mInstance == null) {
					mInstance = new CrashWrapper();
				}
			}
		}
		return mInstance;
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
	
	public void initSDK(Activity ctx){
		
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
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.CrashPlugins);
		ParamsContainer paramsContainer = new ParamsContainer();
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getCrashChannel_callMethod = localClass.getMethod("getCrashChannel");
					String crashChannel = (String) getCrashChannel_callMethod.invoke(instance);
					Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class, String.class,Object[].class });
					Object result = callMethod.invoke(instance,ctx,FunctionName,params);
					Log.e(TAG, "callFunction result:"+result);
					paramsContainer.put(crashChannel, result);
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return paramsContainer;
	}

	@Override
	public void setUserIdentifier(String userid) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.CrashPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod("setUserIdentifier",new Class[] {String.class});
					callMethod.invoke(instance,userid);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void reportException(String name, String crash) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.CrashPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callMethod = localClass.getMethod("reportException",new Class[] {String.class,String.class});
					callMethod.invoke(instance,name,crash);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void leaveBreadcrumb(String paramString) {
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
	public boolean isFunctionSupported(String paramString) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object callFunction(Activity ctx, FuncellCrashChannelType type,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.CrashPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getCrashChannel_callMethod = localClass.getMethod("getCrashChannel");
					String crashChannel = (String) getCrashChannel_callMethod.invoke(instance);
					if(type.toString().equalsIgnoreCase(crashChannel)){
						Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class,FuncellCrashChannelType.class, String.class,Object[].class });
						return callMethod.invoke(instance,ctx,type,FunctionName,params);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * extend callFunction
	 * @param ctx
	 * @param CrashChannelType
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx, String CrashChannelType,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		String _ret = null;
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.CrashPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getCrashChannel_callMethod = localClass.getMethod("getCrashChannel");
					String crashChannel = (String) getCrashChannel_callMethod.invoke(instance);
					if(CrashChannelType.equalsIgnoreCase(crashChannel)){
						Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class,String.class, String.class,Object[].class });
						return callMethod.invoke(instance,ctx,CrashChannelType,FunctionName,params);
					}
				} catch(NoSuchMethodException noSuchMethodException){
					_ret = "This callFunction({ Activity.class,String.class, String.class,Object[].class }) is not found in an instance,please check the "+CrashChannelType +" plugin version!";
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return _ret;
	}

	@Override
	public String getCrashChannel() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
