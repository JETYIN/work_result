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
public class ShareWrapper extends FuncellStatActivityStub implements InterfaceShare{
	private String TAG = "ShareWrapper";
	
	private static ShareWrapper mInstance;
	public static ShareWrapper getInstance() {
		if (mInstance == null) {
			synchronized (ShareWrapper.class) {
				if (mInstance == null) {
					mInstance = new ShareWrapper();
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
	public void share(FuncellShareChannelType shareChannelType,FuncellShareType shareType,ParamsContainer paramsContainer,
			IFuncellShareCallBack callBack) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.SharePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getShareChannel_callMethod = localClass.getMethod("getShareChannel");
					String shareChannel = (String) getShareChannel_callMethod.invoke(instance);
					if(shareChannelType.toString().equalsIgnoreCase(shareChannel)){
						Method callMethod = localClass.getMethod("share",new Class[] { FuncellShareChannelType.class, FuncellShareType.class,ParamsContainer.class,IFuncellShareCallBack.class});
						callMethod.invoke(instance,shareChannelType,shareType,paramsContainer,callBack);
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
	public String getShareChannel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object callFunction(Activity ctx,FuncellShareChannelType shareChannelType, String FunctionName,Object... params) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.SharePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getShareChannel_callMethod = localClass.getMethod("getShareChannel");
					String shareChannel = (String) getShareChannel_callMethod.invoke(instance);
					if(shareChannelType.toString().equalsIgnoreCase(shareChannel)){
						Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class, FuncellShareChannelType.class,String.class,Object[].class});
						return callMethod.invoke(instance,ctx,shareChannelType,FunctionName,params);
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
	 * 
	 * @param ctx
	 * @param shareChannelType
	 * @param FunctionName
	 * @param params
	 * @return
	 */
	public Object callFunction(Activity ctx,String shareChannelType, String FunctionName,Object... params) {
		// TODO Auto-generated method stub
		String _ret = null;
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.SharePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getShareChannel_callMethod = localClass.getMethod("getShareChannel");
					String shareChannel = (String) getShareChannel_callMethod.invoke(instance);
					if(shareChannelType.equalsIgnoreCase(shareChannel)){
						Method callMethod = localClass.getMethod("callFunction",new Class[] { Activity.class, String.class,String.class,Object[].class});
						return callMethod.invoke(instance,ctx,shareChannelType,FunctionName,params);
					}
				}catch(NoSuchMethodException noSuchMethodException){
					_ret = "This callFunction({ Activity.class,String.class, String.class,Object[].class }) is not found in an instance,please check the "+shareChannelType +" plugin version!";
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return _ret;
	}


	@Override
	public void share(String shareChannelType, String shareType,
			ParamsContainer paramsContainer, IFuncellShareCallBack callBack) {
		// TODO Auto-generated method stub
		Vector<String> plugins = FuncellPluginHelper.getSupportPlugins(FuncellPluginType.SharePlugins);
		for (int i = 0; i < plugins.size(); i++) {
			Object instance = getPluginInstance(plugins.get(i));
			if(instance != null){
				try {
					Class localClass = Class.forName(plugins.get(i));
					Method getShareChannel_callMethod = localClass.getMethod("getShareChannel");
					String shareChannel = (String) getShareChannel_callMethod.invoke(instance);
					if(shareChannelType.equalsIgnoreCase(shareChannel)){
						Method callMethod = localClass.getMethod("share",new Class[] { String.class, String.class,ParamsContainer.class,IFuncellShareCallBack.class});
						callMethod.invoke(instance,shareChannelType,shareType,paramsContainer,callBack);
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
