package com.funcell.platform.android.game.proxy;

import android.app.Activity;
import android.util.Log;

import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.IFuncellDataManager;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitCallBack;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformNoticeListCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformServerListCallBack;
import com.funcell.platform.android.game.proxy.init.PlatformParamsType;
import com.funcell.platform.android.game.proxy.pay.FuncellPayParams;
import com.funcell.platform.android.game.proxy.pay.IFuncellChargerManager;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayListCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionManager;

/**
 * 此类作为业务基础类，主要业务为和平台的交互
 * 
 * @author Administrator
 * 
 */
public class BaseFuncellGameSdkProxy {
	private String TAG = getClass().getName().toString();
	private static BaseFuncellGameSdkProxy mInstance;
	private IFuncellSessionCallBack mSessionCallBack;
	private IFuncellSessionManager mSessionManager;
	private IFuncellPayCallBack mFuncellPayCallBack;
	private IFuncellInitCallBack mFuncellInitCallBack;
	private IFuncellExitCallBack mFuncellExitCallBack;

	private boolean mLoginFlag = false;

	public static BaseFuncellGameSdkProxy getInstance() {
		if (mInstance == null) {
			synchronized (BaseFuncellGameSdkProxy.class) {
				if (mInstance == null) {
					mInstance = new BaseFuncellGameSdkProxy();
				}
			}
		}
		return mInstance;
	}

	public void setConfigParams(Activity ctx, Object... params) {
		FuncellPlatformInterface.getInstance().setConfigParams(ctx, params);
	}

	public void BaseInit(final Activity ctx, final IFuncellActivityStub stub, final IFuncellInitCallBack initCallBack,
			final IFuncellSessionCallBack sessionCallBack, final IFuncellPayCallBack payCallBack) {
		Log.e(TAG, "----------BaseInit---------");
		/**
		 * 初始化平台，在平台初始化成功的回调中，继续初始化渠道的初始化
		 * 平台初始化失败后，直接返回初始化失败initCallBack.onInitFailure()
		 */
		mSessionCallBack = sessionCallBack;
		mFuncellPayCallBack = payCallBack;
		mFuncellInitCallBack = initCallBack;
		// stub.applicationInit(ctx, initCallBack, sessionCallBack,
		// payCallBack);
		// initCallBack.onInitSuccess();

		FuncellPlatformInterface.getInstance().PlatformInit(ctx, new IFuncellInitCallBack() {

			@Override
			public void onInitFailure(String paramString) {
				// TODO Auto-generated method stub
				if (paramString.equalsIgnoreCase("network_error")) { // -1:无网络
					initCallBack.onInitFailure(paramString);
				} else {
					initCallBack.onInitFailure("PlatformInit onInitFailure:" + paramString);
				}
				// BaseInitCallBack(initCallBack,InitCallBackType.onInitFailure);

			}

			@Override
			public void onInitSuccess() {
				// TODO Auto-generated method stub
				Log.e(TAG, "----------PlatformInit onInitSuccess---------");
				/**
				 * eve初始化成功的情况 1:非登录触发的情况 2:登录接口触发的eve初始化
				 */
				if (mLoginFlag) {
					stub.applicationInit(ctx, new IFuncellInitCallBack() {

						@Override
						public void onInitFailure(String paramString) {
							// TODO Auto-generated method stub
							// initCallBack.onInitFailure("onInitFailure:"+
							// paramString);//此处初始化回调去掉,只需返回登录接口失败原因
							sessionCallBack.onLoginFailed("onInitFailure" + paramString);
							// BaseInitCallBack(initCallBack,InitCallBackType.onInitFailure);
							// BaseSessionCallBack(sessionCallBack,SessionCallbackType.onFailure);
						}

						@Override
						public void onInitSuccess() {
							// TODO Auto-generated method stub
							// 平台初始化成功
							// initCallBack.onInitSuccess();
							// //此处初始化回调去掉，cp可能也会有重试机制，可能会导致递归
							// BaseInitCallBack(initCallBack,InitCallBackType.onInitSuccess);
							mSessionManager.Login(ctx, sessionCallBack);

						}

					}, sessionCallBack, payCallBack);
				} else {
					stub.applicationInit(ctx, initCallBack, sessionCallBack, payCallBack);
				}
				mLoginFlag = false;
			}

		});
	}

	public void BaseInitFailure(Activity ctx, String json, IFuncellInitCallBack initCallBack) {
		FuncellPlatformInterface.getInstance().PlatformInitFailure(ctx, json, initCallBack);
	}

	public void BaseInitSuccess(Activity ctx, IFuncellInitCallBack initCallBack) {
		FuncellPlatformInterface.getInstance().PlatformInitSuccess(ctx, initCallBack);
	}

	public void BaseLogin(final Activity ctx, final IFuncellSessionManager sessionManager) {
		Log.e(TAG, "----------BaseLogin---------");
		// sessionManager.Login(ctx, mSessionCallBack);
		mSessionManager = sessionManager;
		mLoginFlag = true;
		ctx.runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				FuncellPlatformInterface.getInstance().PlatformLogin(ctx, sessionManager, mSessionCallBack);
			}
		});
	}

	public void BaseLogout(Activity ctx, IFuncellSessionManager sessionManager) {
		Log.e(TAG, "----------BaseLogout---------");
		// sessionManager.Logout(ctx, mSessionCallBack);
		FuncellPlatformInterface.getInstance().PlatformLogout(ctx, sessionManager, mSessionCallBack);
	}

	public void BasePay(Activity ctx, IFuncellChargerManager chargerManager, FuncellPayParams PayParams) {
		Log.e(TAG, "----------BasePay---------");
		// chargerManager.pay(ctx, PayParams, mFuncellPayCallBack);
		FuncellPlatformInterface.getInstance().PlatformPay(ctx, chargerManager, PayParams, mFuncellPayCallBack);
	}

	public void BasePayFailure(Activity ctx, String json, IFuncellPayCallBack payCallBack) {
		Log.e(TAG, "----------BasePayFailure---------");
		FuncellPlatformInterface.getInstance().PlatformPayFailure(ctx, json, payCallBack);
	}

	public void BaseExit(Activity ctx) {
		Log.e(TAG, "----------BaseExit---------");

	}

	public void BaseGetPayList(Activity ctx, boolean isStrange, String category,
			IFuncellPayListCallBack payListCallBack) {
		Log.e(TAG, "----------BaseGetPayList---------");
		FuncellPlatformInterface.getInstance().PlatformGetPayList(ctx, isStrange, category, payListCallBack);
	}

	public void BaseLoginSuccess(Activity ctx, String userName, String uid, String token,
			IFuncellSessionCallBack sessionCallBack, boolean... flag) {
		/**
		 * 平台登录信息验证，验证成功后，回调成功信息
		 */
		Log.e(TAG, "----------BaseLoginSuccess---------");
		FuncellPlatformInterface.getInstance().PlatformLoginSuccess(ctx, userName, uid, token, sessionCallBack, flag);
	}

	public void BaseLoginFailure(Activity ctx, String json, IFuncellSessionCallBack sessionCallBack) {
		Log.e(TAG, "----------BaseLoginFailure---------");
		FuncellPlatformInterface.getInstance().PlatformLoginFailure(ctx, json, sessionCallBack);
	}

	public void BaseLogoutSuccess(IFuncellSessionCallBack sessionCallBack) {
		FuncellPlatformInterface.getInstance().SetLoginFlag(false);
		sessionCallBack.onLogout();
	}

	public void setDatas(Activity ctx, IFuncellDataManager dataManager, FuncellDataTypes paramDataTypes,
			ParamsContainer paramParamsContainer) {
		FuncellPlatformInterface.getInstance().PlatformSetDatas(ctx, dataManager, paramDataTypes, paramParamsContainer);
	}

	public void exitGame(Activity ctx, IFuncellExitCallBack callBack) {
		mFuncellExitCallBack = callBack;
		FuncellPlatformInterface.getInstance().PlatFormExitGame(ctx, callBack);
	}

	public String GetPlatformParams(Activity ctx, PlatformParamsType platformParamsType) {
		return FuncellPlatformInterface.getInstance().GetPlatformParams(ctx, platformParamsType);
	}

	public String GetCustomParams(Activity ctx, String... key) {
		return FuncellPlatformInterface.getInstance().GetCustomParams(ctx, key);
	}

	public IFuncellExitCallBack getExitCallBack() {
		return mFuncellExitCallBack;
	}

	public IFuncellSessionCallBack GetSessionCallBack() {
		return mSessionCallBack;
	}

	public IFuncellPayCallBack GetFuncellPayCallBack() {
		return mFuncellPayCallBack;
	}

	public IFuncellInitCallBack GetFuncellInitCallBack() {
		return mFuncellInitCallBack;
	}

	public String EveData() {
		return FuncellPlatformInterface.getInstance().EveData();
	}

	public boolean GetLoginFlag() {
		return FuncellPlatformInterface.getInstance().GetLoginFlag();
	}

	public void GetServerList(Activity ctx, IPlatformServerListCallBack callBack, String... white_key) {
		FuncellPlatformInterface.getInstance().GetServerList(ctx, callBack, white_key);
	}

	public void GetServerList(Activity ctx, IPlatformServerListCallBack callBack, ParamsContainer... paramsContainers) {
		FuncellPlatformInterface.getInstance().GetServerList(ctx, callBack, paramsContainers);
	}

	public void BaseServerListFailure(Activity ctx, String json, IPlatformServerListCallBack callBack) {
		FuncellPlatformInterface.getInstance().PlatformServerListFailure(ctx, json, callBack);
	}

	public void GetNoticeList(Activity ctx, String type, IPlatformNoticeListCallBack callBack, String... server_id) {
		FuncellPlatformInterface.getInstance().GetNoticeList(ctx, type, callBack, server_id);
	}

	public void GetNoticeList(Activity ctx, String type, IPlatformNoticeListCallBack callBack,
			ParamsContainer... paramsContainers) {
		FuncellPlatformInterface.getInstance().GetNoticeList(ctx, type, callBack, paramsContainers);
	}

	public void BaseNoticeListFailure(Activity ctx, String json, IPlatformNoticeListCallBack callBack) {
		FuncellPlatformInterface.getInstance().PlatformNoticeListFailure(ctx, json, callBack);
	}

	public void BaseLogMark(Activity ctx, String type, String str) {
		FuncellPlatformInterface.getInstance().PlatformLogMark(ctx, type, str);
	}
	/**
	 * 去除以下直接根据引擎类型来判断的回调， 原因：举例，cocos2d环境对接人封装了一层，不实用cpp文件的方式
	 */
	/*
	 * public void BaseInitCallBack(IFuncellInitCallBack
	 * initCallBack,InitCallBackType initCallBackType){ Log.e(TAG,
	 * "BaseInitCallBack DevEngineType:"+FuncellTools.DevEngine());
	 * if(FuncellTools.DevEngine() == DevEngineType.Java ||
	 * FuncellTools.DevEngine() == DevEngineType.Unity3D ||
	 * FuncellTools.DevEngine() == DevEngineType.AdobeAir){ if(initCallBackType
	 * == InitCallBackType.onInitSuccess){ initCallBack.onInitSuccess(); }else{
	 * initCallBack.onInitFailure("onInitFailure"); } }else
	 * if(FuncellTools.DevEngine() == DevEngineType.Cocos2dx){
	 * if(initCallBackType == InitCallBackType.onInitSuccess){
	 * FuncellJniHelper.onInitSuccess(); }else{
	 * FuncellJniHelper.onInitFailure("onInitFailure"); } } }
	 * 
	 * public void BaseSessionCallBack(IFuncellSessionCallBack
	 * sessionCallBack,SessionCallbackType sessionCallbackType,FuncellSession...
	 * seeSession){ Log.e(TAG,
	 * "BaseSessionCallBack DevEngineType:"+FuncellTools.DevEngine());
	 * if(FuncellTools.DevEngine() == DevEngineType.Java ||
	 * FuncellTools.DevEngine() == DevEngineType.Unity3D||
	 * FuncellTools.DevEngine() == DevEngineType.AdobeAir){
	 * if(sessionCallbackType == SessionCallbackType.onSessionSuccess){
	 * sessionCallBack.onLoginSuccess(seeSession[0]); }else
	 * if(sessionCallbackType == SessionCallbackType.onFailure){
	 * sessionCallBack.onLoginFailed("onLoginFailed"); }else
	 * if(sessionCallbackType == SessionCallbackType.onSessionCancel){
	 * sessionCallBack.onLoginCancel(); }else{
	 * FuncellPlatformInterface.getInstance().SetLoginFlag(false);
	 * sessionCallBack.onLogout(); } }else if(FuncellTools.DevEngine() ==
	 * DevEngineType.Cocos2dx){ if(sessionCallbackType ==
	 * SessionCallbackType.onSessionSuccess){
	 * FuncellJniHelper.onLoginSuccess(seeSession[0]); }else
	 * if(sessionCallbackType == SessionCallbackType.onFailure){
	 * FuncellJniHelper.onLoginFailed("onLoginFailed"); }else
	 * if(sessionCallbackType == SessionCallbackType.onSessionCancel){
	 * FuncellJniHelper.onLoginCancel(); }else{
	 * FuncellPlatformInterface.getInstance().SetLoginFlag(false);
	 * FuncellJniHelper.onLogout(); } } }
	 * 
	 * public void BasePayCallBack(IFuncellPayCallBack
	 * payCallBack,PayCallBackType payCallBackType,String... paStrings){
	 * Log.e(TAG, "BasePayCallBack DevEngineType:"+FuncellTools.DevEngine());
	 * if(FuncellTools.DevEngine() == DevEngineType.Java ||
	 * FuncellTools.DevEngine() == DevEngineType.Unity3D ||
	 * FuncellTools.DevEngine() == DevEngineType.AdobeAir){ if(payCallBackType
	 * == PayCallBackType.onSuccess){ payCallBack.onSuccess(paStrings[0],
	 * paStrings[1], paStrings[2]); }else if(payCallBackType ==
	 * PayCallBackType.onFail){ payCallBack.onFail("onFail"); }else
	 * if(payCallBackType == PayCallBackType.onClosePayPage){
	 * payCallBack.onClosePayPage(paStrings[0], paStrings[1], paStrings[2]);
	 * }else{ payCallBack.onCancel("onCancel"); } }else
	 * if(FuncellTools.DevEngine() == DevEngineType.Cocos2dx){
	 * if(payCallBackType == PayCallBackType.onSuccess){
	 * FuncellJniHelper.onSuccess(paStrings[0], paStrings[1], paStrings[2]);
	 * }else if(payCallBackType == PayCallBackType.onFail){
	 * FuncellJniHelper.onFail("onFail"); }else if(payCallBackType ==
	 * PayCallBackType.onClosePayPage){
	 * FuncellJniHelper.onClosePayPage(paStrings[0], paStrings[1],
	 * paStrings[2]); }else{ FuncellJniHelper.onCancel("onCancel"); } } }
	 * 
	 * public void BaseExitCallBack(IFuncellExitCallBack
	 * exitCallBack,ExitCallBackType exitCallBackType){ Log.e(TAG,
	 * "BaseExitCallBack DevEngineType:"+FuncellTools.DevEngine());
	 * if(FuncellTools.DevEngine() == DevEngineType.Java ||
	 * FuncellTools.DevEngine() == DevEngineType.Unity3D ||
	 * FuncellTools.DevEngine() == DevEngineType.AdobeAir){ if(exitCallBackType
	 * == ExitCallBackType.onChannelExit){ exitCallBack.onChannelExit(); }else{
	 * exitCallBack.onGameExit(); } }else if(FuncellTools.DevEngine() ==
	 * DevEngineType.Cocos2dx){ if(exitCallBackType ==
	 * ExitCallBackType.onChannelExit){ FuncellJniHelper.onChannelExit(); }else{
	 * FuncellJniHelper.onGameExit(); } } }
	 * 
	 * public void BasePayListCallBack(IFuncellPayListCallBack
	 * payListCallBack,PayListCallBackType payListCallBackType,String... json){
	 * Log.e(TAG,
	 * "BasePayListCallBack DevEngineType:"+FuncellTools.DevEngine());
	 * if(FuncellTools.DevEngine() == DevEngineType.Java ||
	 * FuncellTools.DevEngine() == DevEngineType.Unity3D ||
	 * FuncellTools.DevEngine() == DevEngineType.AdobeAir){
	 * if(payListCallBackType == PayListCallBackType.onSuccess){
	 * payListCallBack.onSuccess(json[0]); }else{
	 * payListCallBack.onFail(json[0]); } }else if(FuncellTools.DevEngine() ==
	 * DevEngineType.Cocos2dx){ if(payListCallBackType ==
	 * PayListCallBackType.onSuccess){
	 * FuncellJniHelper.onPayListSuccess(json[0]); }else{
	 * FuncellJniHelper.onPayListFailed(json[0]); } } }
	 * 
	 * public void BaseServerListCallBack(IPlatformServerListCallBack
	 * serverListCallBack,ServerListCallBackType
	 * serverListCallBackType,String... json){ Log.e(TAG,
	 * "BasePayListCallBack DevEngineType:"+FuncellTools.DevEngine());
	 * if(FuncellTools.DevEngine() == DevEngineType.Java ||
	 * FuncellTools.DevEngine() == DevEngineType.Unity3D ||
	 * FuncellTools.DevEngine() == DevEngineType.AdobeAir){
	 * if(serverListCallBackType == ServerListCallBackType.onSuccess){
	 * serverListCallBack.onSuccess(json[0]); }else{
	 * serverListCallBack.onFailure(json[0]); } }else
	 * if(FuncellTools.DevEngine() == DevEngineType.Cocos2dx){
	 * if(serverListCallBackType == ServerListCallBackType.onSuccess){
	 * FuncellJniHelper.onServerListSuccess(json[0]); }else{
	 * FuncellJniHelper.onServerListFailed(json[0]); } } }
	 * 
	 * public void BaseNoticeListCallBack(IPlatformNoticeListCallBack
	 * noticeListCallBack,NoticeListCallBackType
	 * noticeListCallBackType,String... json){ Log.e(TAG,
	 * "BasePayListCallBack DevEngineType:"+FuncellTools.DevEngine());
	 * if(FuncellTools.DevEngine() == DevEngineType.Java ||
	 * FuncellTools.DevEngine() == DevEngineType.Unity3D ||
	 * FuncellTools.DevEngine() == DevEngineType.AdobeAir){
	 * if(noticeListCallBackType == NoticeListCallBackType.onSuccess){
	 * noticeListCallBack.onSuccess(json[0]); }else{
	 * noticeListCallBack.onFailure(json[0]); } }else
	 * if(FuncellTools.DevEngine() == DevEngineType.Cocos2dx){
	 * if(noticeListCallBackType == NoticeListCallBackType.onSuccess){
	 * FuncellJniHelper.onNoticeListSuccess(json[0]); }else{
	 * FuncellJniHelper.onNoticeListFailed(json[0]); } } }
	 */

}
