package com.funcell.platform.android.game.log;

import java.util.Map;

import com.funcell.platform.android.FuncellGameSdkProxy;
import com.funcell.platform.android.game.proxy.FuncellCustomManagerImpl;
import com.funcell.platform.android.game.proxy.FuncellPlatformInterface;
import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.init.PlatformParamsType;
import com.funcell.platform.android.game.proxy.session.FuncellSession;
import com.funcell.platform.android.game.proxy.util.FuncellTools;
import com.funcell.platform.android.game.proxy.util.UploadUtils;
import com.funcell.platform.android.plugin.FuncellPluginHelper;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;


public class FuncellGameLogUploadTask {
	private String TAG = "FuncellGameAnalyticsUploadTask";
	private static FuncellGameLogUploadTask mInstance;
	
	public static FuncellGameLogUploadTask getInstance() {
		if (mInstance == null) {
			synchronized (FuncellGameLogUploadTask.class) {
				if (mInstance == null) {
					mInstance = new FuncellGameLogUploadTask();
				}
			}
		}
		return mInstance;
	}
	
	/**
	 * 日志采集
	 * @param ctx
	 * @param json
	 * @param type
	 */
	public void PostExecute(Activity ctx,String json,String type){
		switch (type) {
		case "auth": //登录
			PostExecuteByAuth(ctx,json);
			break;
		case "payment": //支付
			PostExecuteByPayment(ctx,json);
			break;
		case "serverlist"://服务器列表
			PostExecuteByServerlist(ctx, json);
			break;
		case "notice"://公告
			PostExecuteByNotice(ctx, json);
			break;
		case "activation": //激活码

			break;
		case "init":
			PostExecuteByInit(ctx, json);
			break;
		default:
			break;
		}
	}
	
	/**
	 * 打点记录
	 * @param ctx
	 * @param json
	 * @param type
	 */
	public void PostExecuteByMark(Activity ctx,String type,String json){
		String gameId = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.GameID);
		String area = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.Area);
		UploadUtils.getInstance(ctx).countActivite(type,json, area, gameId, false);
	}
	
	private void PostExecuteByAuth(Activity ctx,String json){
		String gameId = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.GameID);
		String channelId =  FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.PlatformType);
		if(!TextUtils.isEmpty((String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel"))){
			channelId = (String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel");
		}
		String gameVersion = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.AppVersion);
		String androidId = TextUtils.isEmpty(FuncellTools.getAndroidId(ctx)) ?  "null" : FuncellTools.getAndroidId(ctx);
		String area = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.Area);
		
		StringBuffer log = new StringBuffer();
		log.append("Android");//platform
		log.append("~@");
		log.append(gameId + ""); //gameID
		log.append("~@");
		log.append(area);  //area
		log.append("~@");
		log.append(channelId+"");  //channelID
		log.append("~@");
		log.append("null"); //serverID
		log.append("~@");
		log.append("null"); //accountID
		log.append("~@");
		log.append(androidId + "");  //androidID
		log.append("~@");
		log.append("null"); //roleID
		log.append("~@");
		log.append(gameVersion+"");  //gameVersion
		log.append("~@");
		log.append("auth");  //errorType
		log.append("~@");
		log.append(json + "");  //error
		log.append("~@");
		log.append(System.currentTimeMillis() + "");  //timestamp
		
		Log.e(TAG,"PostExecuteByAuth");
		UploadUtils.getInstance(ctx).uploadErrorLog("error",log.toString().trim(),area,gameId);
	}
	
	private void PostExecuteByPayment(Activity ctx,String json){
		String gameId = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.GameID);
		String channelId =  FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.PlatformType);
		if(!TextUtils.isEmpty((String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel"))){
			channelId = (String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel");
		}
		String gameVersion = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.AppVersion);
		String androidId = TextUtils.isEmpty(FuncellTools.getAndroidId(ctx)) ?  "null" : FuncellTools.getAndroidId(ctx);
		String area = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.Area);
		Map<FuncellDataTypes, ParamsContainer> paramsContainers = FuncellPlatformInterface.getInstance().GetDatasMap();
		ParamsContainer paramsContainer = paramsContainers.get(FuncellDataTypes.DATA_SERVER_ROLE_INFO);
		if(paramsContainer != null){
			String serverID = TextUtils.isEmpty(paramsContainer.getString("serverno"))?  "null": paramsContainer.getString("serverno");
			FuncellSession seesion = FuncellGameLogSeesion.getInstance().getSession();
			String accountID = "null";
			if(seesion != null){
				accountID = TextUtils.isEmpty(FuncellGameLogSeesion.getInstance().getSession().getmUserID()) ? "null" :FuncellGameLogSeesion.getInstance().getSession().getmUserID();
			}
			String roleID = TextUtils.isEmpty(paramsContainer.getString("role_id")) ? "null" : paramsContainer.getString("role_id");
			
			StringBuffer log = new StringBuffer();
			log.append("Android");//platform
			log.append("~@");
			log.append(gameId + ""); //gameID
			log.append("~@");
			log.append(area);  //area
			log.append("~@");
			log.append(channelId+"");  //channelID
			log.append("~@");
			log.append(serverID); //serverID
			log.append("~@");
			log.append(accountID); //accountID
			log.append("~@");
			log.append(androidId + "");  //androidID
			log.append("~@");
			log.append(roleID); //roleID
			log.append("~@");
			log.append(gameVersion+"");  //gameVersion
			log.append("~@");
			log.append("payment");  //errorType
			log.append("~@");
			log.append(json + "");  //error
			log.append("~@");
			log.append(System.currentTimeMillis() + "");  //timestamp
			Log.e(TAG,"PostExecuteByPayment");
			UploadUtils.getInstance(ctx).uploadErrorLog("error",log.toString().trim(),area,gameId);
		}
	}
	
	private void PostExecuteByServerlist(Activity ctx,String json){
		String gameId = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.GameID);
		String channelId =  FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.PlatformType);
		if(!TextUtils.isEmpty((String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel"))){
			channelId = (String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel");
		}
		String gameVersion = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.AppVersion);
		String androidId = TextUtils.isEmpty(FuncellTools.getAndroidId(ctx)) ?  "null" : FuncellTools.getAndroidId(ctx);
		String area = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.Area);
		
		StringBuffer log = new StringBuffer();
		log.append("Android");//platform
		log.append("~@");
		log.append(gameId + ""); //gameID
		log.append("~@");
		log.append(area);  //area
		log.append("~@");
		log.append(channelId+"");  //channelID
		log.append("~@");
		log.append("null"); //serverID
		log.append("~@");
		log.append("null"); //accountID
		log.append("~@");
		log.append(androidId + "");  //androidID
		log.append("~@");
		log.append("null"); //roleID
		log.append("~@");
		log.append(gameVersion+"");  //gameVersion
		log.append("~@");
		log.append("serverlist");  //errorType
		log.append("~@");
		log.append(json + "");  //error
		log.append("~@");
		log.append(System.currentTimeMillis() + "");  //timestamp
		Log.e(TAG,"PostExecuteByServerlist");
		UploadUtils.getInstance(ctx).uploadErrorLog("error",log.toString().trim(),area,gameId);
	}
	
	private void PostExecuteByNotice(Activity ctx,String json){
		String gameId = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.GameID);
		String channelId =  FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.PlatformType);
		if(!TextUtils.isEmpty((String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel"))){
			channelId = (String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel");
		}
		String gameVersion = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.AppVersion);
		String androidId = TextUtils.isEmpty(FuncellTools.getAndroidId(ctx)) ?  "null" : FuncellTools.getAndroidId(ctx);
		String area = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.Area);
		
		StringBuffer log = new StringBuffer();
		log.append("Android");//platform
		log.append("~@");
		log.append(gameId + ""); //gameID
		log.append("~@");
		log.append(area);  //area
		log.append("~@");
		log.append(channelId+"");  //channelID
		log.append("~@");
		log.append("null"); //serverID
		log.append("~@");
		log.append("null"); //accountID
		log.append("~@");
		log.append(androidId + "");  //androidID
		log.append("~@");
		log.append("null"); //roleID
		log.append("~@");
		log.append(gameVersion+"");  //gameVersion
		log.append("~@");
		log.append("notice");  //errorType
		log.append("~@");
		log.append(json + "");  //error
		log.append("~@");
		log.append(System.currentTimeMillis() + "");  //timestamp
		Log.e(TAG,"PostExecuteByNotice");
		UploadUtils.getInstance(ctx).uploadErrorLog("error",log.toString().trim(),area,gameId);
	}
	
	private void PostExecuteByInit(Activity ctx,String json){
		String gameId = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.GameID);
		String channelId =  FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.PlatformType);
		if(!TextUtils.isEmpty((String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel"))){
			channelId = (String)FuncellPluginHelper.callFunction(ctx, FuncellCustomManagerImpl.getInstance(), "getSubChannel");
		}
		String gameVersion = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.AppVersion);
		String androidId = TextUtils.isEmpty(FuncellTools.getAndroidId(ctx)) ?  "null" : FuncellTools.getAndroidId(ctx);
		String area = FuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, PlatformParamsType.Area);
		
		StringBuffer log = new StringBuffer();
		log.append("Android");//platform
		log.append("~@");
		log.append(gameId + ""); //gameID
		log.append("~@");
		log.append(area);  //area
		log.append("~@");
		log.append(channelId+"");  //channelID
		log.append("~@");
		log.append("null"); //serverID
		log.append("~@");
		log.append("null"); //accountID
		log.append("~@");
		log.append(androidId + "");  //androidID
		log.append("~@");
		log.append("null"); //roleID
		log.append("~@");
		log.append(gameVersion+"");  //gameVersion
		log.append("~@");
		log.append("init");  //errorType
		log.append("~@");
		log.append(json + "");  //error
		log.append("~@");
		log.append(System.currentTimeMillis() + "");  //timestamp
		Log.e(TAG,"PostExecuteByInit");
		UploadUtils.getInstance(ctx).uploadErrorLog("error",log.toString().trim(),area,gameId);
	}
	
}
