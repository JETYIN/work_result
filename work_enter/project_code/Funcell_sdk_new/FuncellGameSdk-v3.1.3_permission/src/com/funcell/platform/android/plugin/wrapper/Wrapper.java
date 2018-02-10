package com.funcell.platform.android.plugin.wrapper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.plugin.FuncellPluginWrapper;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import android.util.Log;

/**
 * ����Ϊ�����װ��ľ���ʵ�֣���ѯ��Щ����SDK�����뵽ĸ����
 * @author Administrator
 *
 */
public class Wrapper {
	/**
	 * ��ȡassetĿ¼����������ļ�
	 * �������ļ������ȡclassName���������������SDK�İ���,Ȼ������setActivityCallback
	 * Ŀǰ��ʱʹ�������򵥷�ʽ����ȡ�ֶΣ������ڽ����Ż�
	 */
	private static String TAG = "Wrapper";
//	private static Hashtable<String, Hashtable<String, String>> mPluginInfo = new Hashtable();
	public static Vector<ParamsContainer> mSupportForPlugins = new Vector(); //total Plugins
	public static Vector<String> mSupportAnalyticsPlugins = new Vector(); //Analytics Plugins
	public static Vector<String> mSupportCrashPlugins = new Vector(); //Crash Plugins
	public static Vector<String> mSupportPushPlugins = new Vector(); //Push Plugins
	public static Vector<String> mSupportSharePlugins = new Vector(); //Share Plugins
	public static Vector<String> mSupportHelpShiftPlugins = new Vector(); //Share Plugins
	public static Vector<String> mSupportForumPlugins = new Vector<String>(); //Forum Plugins
	
	/**notice����**/
	public static Vector<String> mSupportYoumVoicePlugins=new Vector();//youm Voice Plugins
	public static void analysisDeveloperInfo(Activity ctx){
		/**
		 * 
		 */
		try {
			boolean flag = false;
			AssetManager assets = ctx.getAssets();
			String fileNames[] =ctx.getAssets().list("");
			for (String fileName : fileNames) {
				if(fileName.equalsIgnoreCase("funcellplugin.xml")){
					flag = true;
					break;
				}
	        }
			if(!flag) return;
			InputStream file = assets.open("funcellplugin.xml");
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(file);
			Element root = document.getDocumentElement();
			NodeList items = root.getChildNodes();
			for (int i = 0; i < items.getLength(); i++) {
				if (items.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element item = (Element) items.item(i);
					if (item.getNodeName().equals("pluginLs")) {
						NodeList pluginNode = item.getChildNodes();
						for (int j = 0; j < pluginNode.getLength(); j++) {
							if (pluginNode.item(j).getNodeType() == Node.ELEMENT_NODE) {
								String typePlugin = "",channel = "";
								Element plugin = (Element) pluginNode.item(j);
								NodeList pluginNodeList = plugin.getChildNodes();
								for (int k = 0; k < pluginNodeList.getLength(); k++) {
									if (pluginNodeList.item(k).getNodeType() == Node.ELEMENT_NODE) {
										Element itemNode = (Element) pluginNodeList.item(k);
										if (itemNode.getNodeName().equals("typePlugin")) {
											typePlugin = itemNode.getTextContent();
										}else if(itemNode.getNodeName().equals("channel")){
											channel = itemNode.getTextContent();
										}
									}
								}
								Log.e(TAG, "typePlugin:"+typePlugin+" | "+"channel:"+channel);
								String pluginName="";
								if(typePlugin.equalsIgnoreCase("analytics")){
									pluginName = "com.funcell.platform.android.plugin"+"."+typePlugin+"."+channel+"."+"FuncellSDKAnalytics";
									mSupportAnalyticsPlugins.add(pluginName);
								}else if (typePlugin.equalsIgnoreCase("push")) {
									pluginName = "com.funcell.platform.android.plugin"+"."+typePlugin+"."+channel+"."+"FuncellSDKPush";
									mSupportPushPlugins.add(pluginName);
								}else if (typePlugin.equalsIgnoreCase("crash")) {
									pluginName = "com.funcell.platform.android.plugin"+"."+typePlugin+"."+channel+"."+"FuncellSDKCrash";
									mSupportCrashPlugins.add(pluginName);
								}else if(typePlugin.equalsIgnoreCase("share")){
									pluginName = "com.funcell.platform.android.plugin"+"."+typePlugin+"."+channel+"."+"FuncellSDKShare";
									mSupportSharePlugins.add(pluginName);
								}else if(typePlugin.equalsIgnoreCase("helpshift")){
									pluginName = "com.funcell.platform.android.plugin"+"."+typePlugin+"."+channel+"."+"FuncellSDKHelpShift";
									mSupportHelpShiftPlugins.add(pluginName);
								}
								/**notice youm**/
								else if(typePlugin.equalsIgnoreCase("voice")){
									pluginName = "com.funcell.platform.android.plugin"+"."+typePlugin+"."+channel+"."+"FuncellSDKVoice";
									mSupportYoumVoicePlugins.add(pluginName);
								}else if(typePlugin.equalsIgnoreCase("forum")){
									pluginName = "com.funcell.platform.android.plugin"+"."+typePlugin+"."+channel+"."+"FuncellSDKForum";
									mSupportForumPlugins.add(pluginName);
								}
								if(!TextUtils.isEmpty(pluginName)){
									ParamsContainer paramsContainer = new ParamsContainer();
									paramsContainer.putString("pluginName", pluginName);
									paramsContainer.putString("typePlugin", typePlugin);
									paramsContainer.putString("channel", channel);
									mSupportForPlugins.add(paramsContainer);
								}
							}
						}
					}
				}
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for (int i = 0; i < mSupportForPlugins.size(); i++) {
			String pluginName = mSupportForPlugins.get(i).getString("pluginName");
			String typePlugin = mSupportForPlugins.get(i).getString("typePlugin");
			String channel = mSupportForPlugins.get(i).getString("channel");
			InitPlugins(pluginName,ctx,typePlugin,channel);
		}
		
	}
	
	private static void InitPlugins(String className,Activity ctx,String typePlugin,String channel){
		Class localClass = null;
		try {
			localClass = Class.forName(className);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		try {
			/**
			 * ������������SDK��ʼ��
			 */
			Method getInstance_Method = localClass.getMethod("getInstance");
			Object Instance = getInstance_Method.invoke(null);
			Method initSDK_Method = localClass.getMethod("initSDK", new Class[] {Activity.class,String.class,String.class});
			FuncellPluginWrapper.getInstance().setActivityCallback((IFuncellActivityStub)(Instance));//ע�����
			initSDK_Method.invoke(Instance, ctx,typePlugin,channel);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
