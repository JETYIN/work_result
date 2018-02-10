package com.funcell.platform.android.plugin;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.funcell.platform.android.game.proxy.FuncellCustomManagerImpl;
import com.funcell.platform.android.plugin.wrapper.Wrapper;

/**
 * 此类为获取Wrapper中的方法类
 * 
 * @author Administrator
 * 
 */
public class FuncellPluginHelper {
	/**
	 * 
	 */
	public static Hashtable<String, String> getParamsInfo() {
		/**
		 * 
		 */
		return null;
	}

	/**
	 * 获取插件集合
	 * 
	 * @param pluginType
	 * @return
	 */
	public static Vector<String> getSupportPlugins(FuncellPluginType pluginType) {
		Vector<String> plugins = null;
		switch (pluginType) {
		case AnalyticsPlugins:
			plugins = Wrapper.mSupportAnalyticsPlugins;
			break;
		case CrashPlugins:
			plugins = Wrapper.mSupportCrashPlugins;
			break;
		case PushPlugins:
			plugins = Wrapper.mSupportPushPlugins;
			break;
		case SharePlugins:
			plugins = Wrapper.mSupportSharePlugins;
			break;
		case HelpShiftPlugins:
			plugins = Wrapper.mSupportHelpShiftPlugins;
			break;
		case YoumVoicePlugins:
			plugins = Wrapper.mSupportYoumVoicePlugins;
			break;
		case ForumPlugins:
			plugins = Wrapper.mSupportForumPlugins;
			break;
		default:
			break;
		}
		return plugins;
	}

	/**
	 * 判断类中是否有该方法
	 * 
	 * @param cls
	 * @param FunctionName
	 * @return
	 */
	public static boolean isFunctionSupported(Class<?> cls, String FunctionName) {
		Method[] arrayOfMethod = cls.getDeclaredMethods();
		for (int i = 0; i < arrayOfMethod.length; i++) {
			if (arrayOfMethod[i].getName().equals(FunctionName)) {
				return true;
			}
		}
		return false;
	}

	public static Object callFunction(Activity ctx, Class<?> cls,
			String FunctionName, Object... params) {
		if (cls.getName().equalsIgnoreCase(
				FuncellCustomManagerImpl.getInstance().getClass().getName())) {
			if (isFunctionSupported(cls, FunctionName)) {
				Log.e("FuncellPluginHelper", "FunctionName:" + FunctionName
						+ " invoke.");
				try {
					Method callMethod = cls.getMethod(FunctionName.trim(),
							new Class[] { Activity.class, Object[].class });
					Object result = callMethod
							.invoke(FuncellCustomManagerImpl.getInstance(),
									ctx, params);
					return result;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
		}
		return null;
	}

	public static Object callFunction(Activity ctx, Object instance,
			String FunctionName, Object... params) {
		if (isFunctionSupported(instance.getClass(), FunctionName)) {
			Log.e("FuncellPluginHelper", "FunctionName:" + FunctionName
					+ " invoke.");
			try {
				Method callMethod = instance.getClass().getMethod(
						FunctionName.trim(),
						new Class[] { Activity.class, Object[].class });
				Object result = callMethod.invoke(instance, ctx, params);
				return result;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
