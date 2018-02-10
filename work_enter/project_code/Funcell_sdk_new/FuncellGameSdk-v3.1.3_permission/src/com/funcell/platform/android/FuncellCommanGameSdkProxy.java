package com.funcell.platform.android;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import com.funcell.platform.android.game.proxy.BaseFuncellGameSdkProxy;
import com.funcell.platform.android.game.proxy.FuncellCustomManagerImpl;
import com.funcell.platform.android.game.proxy.FuncellPlatformInterface;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.IGameSdkProxy;
import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.IFuncellDataManager;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitCallBack;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitManager;
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
import com.funcell.platform.android.permissions.FuncellPermissionsBuilder;
import com.funcell.platform.android.permissions.FuncellPermissionsCallbacks;
import com.funcell.platform.android.permissions.FuncellPermissionsManager;
import com.funcell.platform.android.permissions.FuncellPermissionsRequestCodeOffset;
import com.funcell.platform.android.plugin.FuncellPluginHelper;
import com.funcell.platform.android.plugin.FuncellPluginWrapper;

/**
 *
 * @author Administrator
 *
 */
public class FuncellCommanGameSdkProxy implements IGameSdkProxy {

	private String TAG = "FuncellCommanGameSdkProxy";
	private IFuncellActivityStub mStub;
	private IFuncellSessionManager mSessionManager;
	private IFuncellChargerManager mChargerManager;
	private IFuncellExitManager mFuncellExitManager;
	private IFuncellDataManager mFuncellDataManager;
	// private IFuncellSessionCallBack mSessionCallBack;
	// private IFuncellPayCallBack mFuncellPayCallBack;

	protected FuncellCommanGameSdkProxy(IFuncellActivityStub stub, IFuncellSessionManager sessionManager,
			IFuncellChargerManager chargerManager, IFuncellExitManager exitManager,
			IFuncellDataManager extDataManager) {
		mStub = stub;
		mSessionManager = sessionManager;
		mChargerManager = chargerManager;
		mFuncellExitManager = exitManager;
		mFuncellDataManager = extDataManager;
	}

	@Override
	public void onCreate(Activity ctx) {
		// TODO Auto-generated method stub
		FuncellPluginWrapper.getInstance().onCreate(ctx);
		if (mStub != null)
			mStub.onCreate(ctx);

	}

	@Override
	public void onStart(Activity ctx) {
		// TODO Auto-generated method stubo
		if (mStub != null)
			mStub.onStart(ctx);
	}

	@Override
	public void onRestart(Activity ctx) {
		// TODO Auto-generated method stub
		if (mStub != null)
			mStub.onRestart(ctx);
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		FuncellPluginWrapper.getInstance().onResume(ctx);
		if (mStub != null)
			mStub.onResume(ctx);
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		if (mStub != null)
			mStub.onStop(ctx);
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		FuncellPluginWrapper.getInstance().onPause(ctx);
		if (mStub != null)
			mStub.onPause(ctx);
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub3
		FuncellPluginWrapper.getInstance().onDestroy(ctx);
		if (mStub != null)
			mStub.onDestroy(ctx);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		if (mStub != null)
			mStub.onSaveInstanceState(outState);
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		FuncellPluginWrapper.getInstance().onNewIntent(paramIntent);
		if (mStub != null)
			mStub.onNewIntent(paramIntent);

	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		FuncellPluginWrapper.getInstance().onActivityResult(ctx, requestCode, resultCode, data);
		if (mStub != null)
			mStub.onActivityResult(ctx, requestCode, resultCode, data);
	}

	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
			Log.e(TAG, "****onRequestPermissionsResult grant");
		} else {
			Log.e(TAG, "----onRequestPermissionsResult deny");
		}
		FuncellPluginWrapper.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (mStub != null)
			mStub.onRequestPermissionsResult(requestCode, permissions, grantResults);

	}

	@Override
	public void Init(Activity ctx, IFuncellInitCallBack initCallBack, IFuncellSessionCallBack sessionCallBack,
			IFuncellPayCallBack payCallBack) {
		// TODO Auto-generated method stub
		/**
		 * 判断是否有推送、统计、分享等三方SDK加入到母包中
		 */
		FuncellPluginWrapper.getInstance().init(ctx);
		BaseFuncellGameSdkProxy.getInstance().BaseInit(ctx, mStub, initCallBack, sessionCallBack, payCallBack);
		// super.BaseInit(ctx,mStub, initCallBack, sessionCallBack,
		// payCallBack);
		// mSessionCallBack = sessionCallBack;
		// mFuncellPayCallBack = payCallBack;
		// mStub.applicationInit(ctx, initCallBack, sessionCallBack,
		// payCallBack);
		requestPermission(ctx);
	}

	/**
	 * 游戏必须继承onRequest..方法，并接入v4包
	 * 
	 * @param mContext
	 */
	private void requestPermission(Activity mContext) {
		Log.e("funcell", "****invoke--requestPermission");
		FuncellPermissionsManager mFuncellPermissionsManager;
		FuncellPermissionsBuilder permissionsBuilder = new FuncellPermissionsBuilder(mContext)
				.onFuncellPermissionsCallbacks(new FuncellPermissionsCallbacks() {

					@Override
					public void onPermissionsDenied(int requestCode, List perms) {
						// TODO Auto-generated method stub
						Log.e(TAG, "----permission deny");
					}

					@Override
					public void onPermissionsGranted(int requestCode, List perms) {
						// TODO Auto-generated method stub
						Log.e(TAG, "****permission grant");
					}
				}).rationale4ReqPer(mContext.getResources().getString(FuncellRUtils.string(mContext, "funcell_tip")))
				.rationale4NeverAskAgain(
						mContext.getResources().getString(FuncellRUtils.string(mContext, "funcell_tip")));

		permissionsBuilder.requestCode(permissionsBuilder.getmShareBasicsRequestCode()
				+ FuncellPermissionsRequestCodeOffset.READ_PHONE_STATE.toRequestCode());
		mFuncellPermissionsManager = permissionsBuilder.build();
		mFuncellPermissionsManager.requestPermissions(Manifest.permission.READ_PHONE_STATE);
	}

	@Override
	public void Login(Activity ctx) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().BaseLogin(ctx, mSessionManager);
		// super.BaseLogin(ctx,mSessionManager,obj);
		// mSessionManager.Login(ctx, mSessionCallBack, (String)obj, obj);
	}

	@Override
	public void Logout(Activity ctx) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().BaseLogout(ctx, mSessionManager);
		// super.BaseLogout(ctx, mSessionManager,obj);
		// mSessionManager.Logout(ctx, mSessionCallBack, (String)obj, obj);
	}

	@Override
	public void Pay(Activity ctx, FuncellPayParams PayParams) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().BasePay(ctx, mChargerManager, PayParams);
		// super.BasePay(ctx, mChargerManager, PayParams);
		// mChargerManager.pay(ctx, PayParams, mFuncellPayCallBack);
	}

	@Override
	public int Exit(Activity ctx, IFuncellExitCallBack callBack) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().exitGame(ctx, callBack);
		mFuncellExitManager.exit(ctx, callBack);
		return GetExitUI(ctx);
	}

	@Override
	public int GetExitUI(Activity ctx) {
		// TODO Auto-generated method stub
		return mFuncellExitManager.GetExitUI(ctx);
	}

	@Override
	public void setDatas(Activity ctx, FuncellDataTypes paramDataTypes, ParamsContainer paramParamsContainer) {
		// TODO Auto-generated method stub
		/**
		 * 将统计数据传入三方SDK中进行各个插件的处理 已知功能需求:Google推送
		 */
		FuncellPluginWrapper.getInstance().callFunction(ctx, "setDatas", paramDataTypes, paramParamsContainer);
		BaseFuncellGameSdkProxy.getInstance().setDatas(ctx, mFuncellDataManager, paramDataTypes, paramParamsContainer);
		// mFuncellDataManager.setDatas(ctx, paramDataTypes,
		// paramParamsContainer);

	}

	@Override
	public String GetEveData() {
		// TODO Auto-generated method stub
		return BaseFuncellGameSdkProxy.getInstance().EveData();
	}

	@Override
	public boolean GetLoginFlag() {
		// TODO Auto-generated method stub
		return BaseFuncellGameSdkProxy.getInstance().GetLoginFlag();
	}

	@Override
	@Deprecated
	public void GetServerList(Activity ctx, IPlatformServerListCallBack callBack, String... white_key) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().GetServerList(ctx, callBack, white_key);
	}

	@Override
	@Deprecated
	public void GetNoticeList(Activity ctx, IPlatformNoticeListCallBack callBack, String type, String... server_id) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().GetNoticeList(ctx, type, callBack, server_id);
	}

	@Override
	public Object callFunction(Activity ctx, String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		FuncellCustomManagerImpl cls = FuncellCustomManagerImpl.getInstance();
		return FuncellPluginHelper.callFunction(ctx, cls, FunctionName.trim(), params);
	}

	@Override
	public void GetPayList(Activity ctx, boolean isStrange, String category, IFuncellPayListCallBack payListCallBack) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().BaseGetPayList(ctx, isStrange, category, payListCallBack);
	}

	@Override
	public String GetPlatformParams(Activity ctx, PlatformParamsType platformParamsType) {
		// TODO Auto-generated method stub
		return BaseFuncellGameSdkProxy.getInstance().GetPlatformParams(ctx, platformParamsType);
	}

	@Override
	public void onConfigurationChanged(Activity ctx, Configuration newConfig) {
		// TODO Auto-generated method stub
		if (mStub != null)
			mStub.onConfigurationChanged(ctx, newConfig);
	}

	@Override
	public String GetCustomParams(Activity ctx, String... key) {
		// TODO Auto-generated method stub
		return BaseFuncellGameSdkProxy.getInstance().GetCustomParams(ctx, key);
	}

	@Override
	public void LogMark(Activity ctx, String sign, String body) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().BaseLogMark(ctx, sign, body);
	}

	@Override
	public void GetServerList(Activity ctx, IPlatformServerListCallBack callBack, ParamsContainer params) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().GetServerList(ctx, callBack, params);
	}

	@Override
	public void GetNoticeList(Activity ctx, IPlatformNoticeListCallBack callBack, String type, ParamsContainer params) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().GetNoticeList(ctx, type, callBack, params);
	}

	@Override
	public void setConfigParams(Activity ctx, @NonNull Object... params) {
		// TODO Auto-generated method stub
		BaseFuncellGameSdkProxy.getInstance().setConfigParams(ctx, params);
	}

}
