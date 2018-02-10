package com.funcell.platform.android.plugin.wrapper;

import java.lang.reflect.Method;
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
import com.funcell.platform.android.plugin.Interface.InterfaceHelpShift;
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
public class HelpShiftWrapper extends FuncellStatActivityStub implements InterfaceHelpShift{
	private String TAG = "HelpShiftWrapper";
	
	private static HelpShiftWrapper mInstance;
	public static HelpShiftWrapper getInstance() {
		if (mInstance == null) {
			synchronized (HelpShiftWrapper.class) {
				if (mInstance == null) {
					mInstance = new HelpShiftWrapper();
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
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.HelpShiftPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method callFunction_callMethod = localClass.getMethod("callFunction",new Class[] {Activity.class, String.class,Object[].class});
					return callFunction_callMethod.invoke(instance,ctx,FunctionName,params);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public void showHelpShift(Activity ctx) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.HelpShiftPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method showHelpShift_callMethod = localClass.getMethod("showHelpShift",new Class[] {Activity.class});
					showHelpShift_callMethod.invoke(instance,ctx);
				}catch (Exception e) {
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
	public String getHelpShiftChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object callFunction(Activity ctx, String helpChannelType,
			String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.HelpShiftPlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getHelpShiftChannel_callMethod = localClass.getMethod("getHelpShiftChannel");
					String helpShiftChannel = (String) getHelpShiftChannel_callMethod.invoke(instance);
					if(helpChannelType.equalsIgnoreCase(helpShiftChannel)){
						Method callFunction_callMethod = localClass.getMethod("callFunction",new Class[] {Activity.class,String.class, String.class,Object[].class});
						return callFunction_callMethod.invoke(instance,ctx,helpChannelType,FunctionName,params);
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
	
}
