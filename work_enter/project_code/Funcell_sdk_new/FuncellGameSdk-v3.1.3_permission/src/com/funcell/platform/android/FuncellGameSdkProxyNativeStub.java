package com.funcell.platform.android;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import com.funcell.platform.android.game.proxy.FuncellGLThreadRunner;
import com.funcell.platform.android.game.proxy.IGameSdkProxy;
import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitCallBack;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformNoticeListCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformServerListCallBack;
import com.funcell.platform.android.game.proxy.init.PlatformParamsType;
import com.funcell.platform.android.game.proxy.pay.FuncellPayParams;
import com.funcell.platform.android.game.proxy.pay.FuncellRoleInfo;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayListCallBack;
import com.funcell.platform.android.game.proxy.session.FuncellSession;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.game.proxy.util.JsonObjectCoder;
import com.funcell.platform.android.plugin.FuncellSDKAnalytics;
import com.funcell.platform.android.plugin.FuncellSDKShare;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsEventType;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsType;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareType;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

/**
 * cocos2dx 业务逻辑处理接口
 * 
 * @author Administrator
 * 
 */
public class FuncellGameSdkProxyNativeStub {
	private String TAG = "FuncellGameSdkProxyNativeStub";
	private static FuncellGameSdkProxyNativeStub mInstance;
	private Activity mContext;
	private IGameSdkProxy mGameSdkProxy;
	private FuncellGLThreadRunner mGlThreadRunner;

	public static FuncellGameSdkProxyNativeStub getInstance() {
		if (mInstance == null) {
			throw new IllegalStateException("get instance before init instance");
		}
		return mInstance;
	}

	private FuncellGameSdkProxyNativeStub(Activity context,IGameSdkProxy gameProxy, FuncellGLThreadRunner glRunner) {
		mContext = context;
		mGameSdkProxy = gameProxy;
		mGlThreadRunner = glRunner;
	}

	public static void init(final Activity ctx, IGameSdkProxy gameProxy,FuncellGLThreadRunner glRunner) {
		if (mInstance == null) {
			synchronized (FuncellGameSdkProxyNativeStub.class) {
				if (mInstance == null) {
					mInstance = new FuncellGameSdkProxyNativeStub(ctx,gameProxy, glRunner);
					glRunner.runOnGLThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							FuncellJniHelper.onInitCocos2dEnv(ctx);
						}
					});
				}
			}
		}
	}
	
	public void init(){
		/**
		 * 目前在回调成功的时候，直接判断了环境是U3D还是cocos还是其他，如果有问题（可能在判断环境的时候，cocos2d游戏里面使用了unity的jar包），可以在此处将消息返回给cocos2dx
		 */
		mGameSdkProxy.Init(mContext, new IFuncellInitCallBack(){

			@Override
			public void onInitFailure(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onInitFailure("onInitFailure");
			}

			@Override
			public void onInitSuccess() {
				// TODO Auto-generated method stub
				FuncellJniHelper.onInitSuccess();
			}
			
		}, new IFuncellSessionCallBack(){

			@Override
			public void onLoginSuccess(FuncellSession session) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onLoginSuccess(session);
			}

			@Override
			public void onLoginCancel() {
				// TODO Auto-generated method stub
				FuncellJniHelper.onLoginCancel();
			}

			@Override
			public void onLoginFailed(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onLoginFailed(paramString);
			}

			@Override
			public void onLogout() {
				// TODO Auto-generated method stub
				FuncellJniHelper.onLogout();
			}

			@Override
			public void onSwitchAccount(FuncellSession session) {
				// TODO Auto-generated method stub
				
			}
			
		}, new IFuncellPayCallBack(){

			@Override
			public void onSuccess(String cpOrder, String sdkOrder,
					String extrasParams) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onSuccess(cpOrder, sdkOrder, extrasParams);
			}

			@Override
			public void onFail(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onFail(paramString);
			}

			@Override
			public void onCancel(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onCancel(paramString);
			}

			@Override
			public void onClosePayPage(String cpOrder, String sdkOrder,
					String extrasParams) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onClosePayPage(cpOrder, sdkOrder, extrasParams);
			}
			
		});
	}
	
	public void login(){
		mGameSdkProxy.Login(mContext);
	}
	
	public void logout(){
		mGameSdkProxy.Logout(mContext);
	}
	
	public void pay(String ItemName, String ItemId, int ItemCount,
			String ItemDescription, String ItemAmount, String ExtrasParams,
			String ItemType, String OrderId, String RoleName, String RoleId,
			String RoleLevel,String ServerName,String ServerId,String VipLevel,String GameGoldBalance,String GameUnionName) {
		
		FuncellRoleInfo roleInfo = new FuncellRoleInfo();
		roleInfo.setGameGoldBalance(GameGoldBalance);
		roleInfo.setGameUnionName(GameUnionName);
		roleInfo.setRoleId(RoleId);
		roleInfo.setRoleLevel(RoleLevel);
		roleInfo.setRoleName(RoleName);
		roleInfo.setServerId(ServerId);
		roleInfo.setServerName(ServerName);
		roleInfo.setVipLevel(VipLevel);

		FuncellPayParams PayParams = new FuncellPayParams();
		PayParams.setmExtrasParams(ExtrasParams); // 透传参数，支付成功后，返回给客户端的数据
		PayParams.setmItemAmount(ItemAmount); // 商品价格，单位：分
		PayParams.setmItemCount(ItemCount);// 钻石数量 ,10个元宝
		PayParams.setmItemDescription(ItemDescription);
		PayParams.setmItemId(ItemId); // 商品ID
		PayParams.setmItemName(ItemName); // 商品名
		PayParams.setmItemType(ItemType); // 商品类型
		PayParams.setmOrderId(OrderId); // 游戏方订单号，若无则不传该参数或者不设置，该字段为支付成功后，返回的数据
		PayParams.setmRoleInfo(roleInfo);

		mGameSdkProxy.Pay(mContext, PayParams);
	}
	
	public int GetExitUI(){
		return mGameSdkProxy.GetExitUI(mContext);
	}
	
	public void Exit(){
		mGameSdkProxy.Exit(mContext,new IFuncellExitCallBack(){

			@Override
			public void onChannelExit() {
				// TODO Auto-generated method stub
				FuncellJniHelper.onChannelExit();
			}

			@Override
			public void onGameExit() {
				// TODO Auto-generated method stub
				FuncellJniHelper.onGameExit();
			}
			
		});
	}
	
	public enum DataType {
		DATA_LOGIN("DATA_LOGIN"),DATA_CREATE_ROLE("DATA_CREATE_ROLE"),DATA_ROLE_LEVELUP("DATA_ROLE_LEVELUP"),DATA_SERVER_ROLE_INFO("DATA_SERVER_ROLE_INFO");

		private final String name;
		private DataType(String str) {
			name = str;
		}
		public boolean equalsName(String otherName) {
			return otherName == null ? false : name.equals(otherName);
		}
		public String toString() {
			return this.name;
		}
	}
	
	public void setDatas(String dataType,String json){
		Log.e(TAG,"----dataType:"+dataType+"\n------json:"+json);
		if(dataType.equalsIgnoreCase(DataType.DATA_LOGIN.toString())){
			JSONTokener jsonParser = new JSONTokener(json);
			JSONObject person;
			try {
				person = (JSONObject) jsonParser.nextValue();
				String usermark = person.optString("usermark");
				String serverno = person.optString("serverno");
				ParamsContainer pc = new ParamsContainer();
				pc.putString("usermark", usermark);
				pc.putString("serverno", serverno);
				mGameSdkProxy.setDatas(mContext, FuncellDataTypes.DATA_LOGIN, pc);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(dataType.equalsIgnoreCase(DataType.DATA_CREATE_ROLE.toString())){
			JSONTokener jsonParser = new JSONTokener(json);
			JSONObject person;
			try {
				person = (JSONObject) jsonParser.nextValue();
				String usermark = person.optString("usermark");
				String role_id = person.optString("role_id");
				String serverno = person.optString("serverno");
				String server_name = person.optString("server_name");
				String role_name = person.optString("role_name");
				
				ParamsContainer pc = new ParamsContainer();
				pc.putString("usermark", usermark);
			    pc.putString("role_id", role_id);
			    pc.putString("serverno", serverno);
			    pc.putString("server_name", server_name);
			    pc.putString("role_name", role_name);
				mGameSdkProxy.setDatas(mContext, FuncellDataTypes.DATA_CREATE_ROLE, pc);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(dataType.equalsIgnoreCase(DataType.DATA_ROLE_LEVELUP.toString())){
			JSONTokener jsonParser = new JSONTokener(json);
			JSONObject person;
			try {
				person = (JSONObject) jsonParser.nextValue();
				String usermark = person.optString("usermark");
				String serverno = person.optString("serverno");
				String level = person.optString("level");
				String role_id = person.optString("role_id");
				String role_name = person.optString("role_name");
				String server_name = person.optString("server_name");
				
				ParamsContainer pc = new ParamsContainer();
				pc.putString("usermark", usermark);
				pc.putString("serverno", serverno);
				pc.putString("level", level);
				pc.putString("role_id", role_id);
				pc.putString("role_name", role_name);
				pc.putString("server_name",server_name);
				mGameSdkProxy.setDatas(mContext, FuncellDataTypes.DATA_ROLE_LEVELUP, pc);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(dataType.equalsIgnoreCase(DataType.DATA_SERVER_ROLE_INFO.toString())){
			JSONTokener jsonParser = new JSONTokener(json);
			JSONObject person;
			try {
				person = (JSONObject) jsonParser.nextValue();
				String role_id = person.optString("role_id");
				String role_level = person.optString("role_level");
				String role_name = person.optString("role_name");
				String role_gameunion_name = person.optString("role_gameunion_name");
				String role_vip_level = person.optString("role_vip_level");
				String serverno = person.optString("serverno");
				String server_name = person.optString("server_name");
				
				ParamsContainer pc = new ParamsContainer();
				pc.putString("role_id", role_id);
				pc.putInt("role_level", Integer.valueOf(role_level).intValue());
				pc.putString("role_name", role_name);
				pc.putString("role_gameunion_name", role_gameunion_name);
				pc.putString("role_vip_level", role_vip_level);
				pc.putString("serverno", serverno);
				pc.putString("server_name", server_name);
				mGameSdkProxy.setDatas(mContext, FuncellDataTypes.DATA_SERVER_ROLE_INFO, pc);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public String GetEveData() {
		return mGameSdkProxy.GetEveData();
	}
	
	public boolean GetLoginFlag() {
		return mGameSdkProxy.GetLoginFlag();
	}

	public void GetServerList(String white_key){
		mGameSdkProxy.GetServerList(mContext, new IPlatformServerListCallBack(){

			@Override
			public void onFailure(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onServerListFailed(paramString);
			}

			@Override
			public void onSuccess(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onServerListSuccess(paramString);
			}
			
		}, white_key);
	}
	
	public void GetNoticeList(String type,String server_id){
		mGameSdkProxy.GetNoticeList(mContext, new IPlatformNoticeListCallBack(){

			@Override
			public void onFailure(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onNoticeListFailed(paramString);
			}

			@Override
			public void onSuccess(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onNoticeListSuccess(paramString);
			}
			
		}, type, server_id);
	}
	
	public int callIntFunction(String FunctionName,String json) {
		return (int) mGameSdkProxy.callFunction(mContext, FunctionName, json);
	}
	
	public String callStringFunction(String FunctionName,String json) {
		return (String) mGameSdkProxy.callFunction(mContext, FunctionName, json);
	}
	
	public boolean callBoolenFunction(String FunctionName,String json) {
		return (boolean) mGameSdkProxy.callFunction(mContext, FunctionName, json);
	}
	
	public Object callObjectFunction(String FunctionName,String json) {
		return mGameSdkProxy.callFunction(mContext, FunctionName, json);
	}
	
	public void GetPayList(boolean isStrange, String category) {
		mGameSdkProxy.GetPayList(mContext, isStrange, category, new IFuncellPayListCallBack(){

			@Override
			public void onSuccess(String response) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onPayListSuccess(response);
			}

			@Override
			public void onFail(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.onPayListFailed(paramString);
			}
			
		});
	}
	
	public String GetPlatformParams(String platformParamsType) {
		String result = null;
		switch (platformParamsType) {
		case "GameID":
			result = mGameSdkProxy.GetPlatformParams(mContext, PlatformParamsType.GameID);
			break;
		case "PlatformID":
			result = mGameSdkProxy.GetPlatformParams(mContext, PlatformParamsType.PlatformID);
			break;
		case "PlatformType":
			result = mGameSdkProxy.GetPlatformParams(mContext, PlatformParamsType.PlatformType);
			break;
		case "AppVersion":
			result = mGameSdkProxy.GetPlatformParams(mContext, PlatformParamsType.AppVersion);
			break;
		default:
			break;
		}
		return result;
	}
	
	/*********************************Analytics统计相关******************************************/
	private FuncellAnalyticsType getAnalyticsType(String type){
		FuncellAnalyticsType AnalyticsType = null;
		switch (type) {
		case "appsflyer":
			AnalyticsType = FuncellAnalyticsType.appsflyer;
			break;
		case "facebook":
			AnalyticsType = FuncellAnalyticsType.facebook;
			break;
		case "mat":
			AnalyticsType = FuncellAnalyticsType.mat;
			break;
		case "google":
			AnalyticsType = FuncellAnalyticsType.google;
			break;
		case "twitter":
			AnalyticsType = FuncellAnalyticsType.twitter;
			break;
		default:
			break;
		}
		return AnalyticsType;
	}
	
	private FuncellAnalyticsEventType getAnalyticsEventType(String type){
		FuncellAnalyticsEventType analyticsEventType = null;
		switch (type) {
		case "login":
			analyticsEventType = FuncellAnalyticsEventType.login;
			break;
		case "level_achieved":
			analyticsEventType = FuncellAnalyticsEventType.level_achieved;
			break;
		case "purchase_success":
			analyticsEventType = FuncellAnalyticsEventType.purchase_success;
			break;
		case "create_role":
			analyticsEventType = FuncellAnalyticsEventType.create_role;
			break;
		case "tutorial_completed":
			analyticsEventType = FuncellAnalyticsEventType.tutorial_completed;
			break;
		default:
			break;
		}
		return analyticsEventType;
	}
	
	public void Analytics_logEvent(String AnalyticsType,String AnalyticsEventType,String json){
		Log.e(TAG, "Analytics_logEvent invoke");
		ParamsContainer paramsContainer;
		if(TextUtils.isEmpty(json)){
			paramsContainer = null;
		}else{
			paramsContainer = JsonObjectCoder.jsonToParamsContainer(json, null);
		}
		FuncellAnalyticsType type = getAnalyticsType(AnalyticsType);
		FuncellAnalyticsEventType eventType = getAnalyticsEventType(AnalyticsEventType);
		FuncellSDKAnalytics.getInstance().logEvent(type, eventType, paramsContainer);
	}
	
	public void Analytics_startSession(){
		Log.e(TAG, "Analytics_startSession invoke");
		FuncellSDKAnalytics.getInstance().startSession();
	}
	
	public void Analytics_callVoidFunction(String FunctionName,String type,String json){
		Log.e(TAG, "Analytics_callVoidFunction invoke");
		FuncellAnalyticsType AnalyticsType = getAnalyticsType(type);
		FuncellSDKAnalytics.getInstance().callFunction(mContext, AnalyticsType, FunctionName, json);
	}
	
	public int Analytics_callIntFunction(String FunctionName,String type,String json){
		Log.e(TAG, "Analytics_callIntFunction invoke");
		FuncellAnalyticsType AnalyticsType = getAnalyticsType(type);
		return (int) FuncellSDKAnalytics.getInstance().callFunction(mContext, AnalyticsType, FunctionName, json);
	}
	
	public String Analytics_callStringFunction(String FunctionName,String type,String json){
		Log.e(TAG, "Analytics_callStringFunction invoke");
		FuncellAnalyticsType AnalyticsType = getAnalyticsType(type);
		return (String) FuncellSDKAnalytics.getInstance().callFunction(mContext, AnalyticsType, FunctionName, json);
	}
	
	/*******************************Share分享相关********************************************/
	public void Share_share(String shareChannelType,String shareType,String json){
		Log.e(TAG, "Share_share invoke");
		ParamsContainer paramsContainer;
		if(TextUtils.isEmpty(json)){
			paramsContainer = null;
		}else{
			paramsContainer = JsonObjectCoder.jsonToParamsContainer(json, null);
		}
		FuncellShareChannelType channelType = getShareChannelType(shareChannelType);
		FuncellShareType ShareType = null;
		switch (shareType) {
		case "text":
			ShareType = FuncellShareType.text;
			break;
		case "video":
			ShareType = FuncellShareType.video;
			break;
		default:
			break;
		}
		FuncellSDKShare.getInstance().share(channelType,ShareType, paramsContainer, new IFuncellShareCallBack(){

			@Override
			public void onSuccess(ParamsContainer paramsContainer) {
				// TODO Auto-generated method stub
				String json = JsonObjectCoder.paramsContainerToJson(paramsContainer);
				FuncellJniHelper.share_onSuccess(json);
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				FuncellJniHelper.share_onCancel();
			}

			@Override
			public void onFailed(String paramString) {
				// TODO Auto-generated method stub
				FuncellJniHelper.share_onFailed(paramString);
			}
			
		});
	}
	
	public void Share_callVoidFunction(String FunctionName,String shareChannelType,String json){
		Log.e(TAG, "Share_callVoidFunction invoke");
		FuncellShareChannelType channelType = getShareChannelType(shareChannelType);
		FuncellSDKShare.getInstance().callFunction(mContext, channelType, FunctionName, json);
	}
	
	public int Share_callIntFunction(String FunctionName,String shareChannelType,String json){
		Log.e(TAG, "Share_callIntFunction invoke");
		FuncellShareChannelType channelType = getShareChannelType(shareChannelType);
		return (int) FuncellSDKShare.getInstance().callFunction(mContext, channelType, FunctionName, json);
	}
	
	public String Share_callStringFunction(String FunctionName,String shareChannelType,String json){
		Log.e(TAG, "Share_callStringFunction invoke");
		FuncellShareChannelType channelType = getShareChannelType(shareChannelType);
		return (String) FuncellSDKShare.getInstance().callFunction(mContext, channelType, FunctionName, json);
	}
	
	private FuncellShareChannelType getShareChannelType(String shareChannelType){
		FuncellShareChannelType channelType = null;
		switch (shareChannelType) {
		case "facebook":
			channelType = FuncellShareChannelType.facebook;
			break;
		case "sharesdk":
			channelType = FuncellShareChannelType.sharesdk;
			break;
		default:
			break;
		}
		return channelType;
	}
	
	/*****************************************************************/
	
}
