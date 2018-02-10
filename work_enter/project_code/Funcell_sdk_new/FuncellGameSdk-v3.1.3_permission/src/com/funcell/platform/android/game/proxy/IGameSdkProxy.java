package com.funcell.platform.android.game.proxy;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitCallBack;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformNoticeListCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformServerListCallBack;
import com.funcell.platform.android.game.proxy.init.PlatformParamsType;
import com.funcell.platform.android.game.proxy.pay.FuncellPayParams;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayListCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;

public abstract interface IGameSdkProxy {
	/*Business logic function*/
	
	/**
	 * 提供游戏设置一部分参数(clientid等)
	 * @param params
	 */
	public abstract void setConfigParams(Activity ctx,Object... params);
	
	public abstract void Init(Activity ctx, IFuncellInitCallBack initCallBack,IFuncellSessionCallBack sessionCallBack, IFuncellPayCallBack payCallBack);
	
	public abstract void Login(Activity ctx);
	
	public abstract void Logout(Activity ctx);

	public abstract void Pay(Activity ctx,FuncellPayParams PayParams);
	
	public abstract void setDatas(Activity ctx, FuncellDataTypes paramDataTypes,ParamsContainer paramParamsContainer);
	
	public abstract int Exit(Activity ctx, IFuncellExitCallBack callBack);
	
	public abstract int GetExitUI(Activity ctx);
	
	public abstract boolean GetLoginFlag();
	
	public abstract String GetEveData();
	
	@Deprecated
	public abstract void GetServerList(Activity ctx,IPlatformServerListCallBack callBack,String... white_key);
	
	public abstract void GetServerList(Activity ctx,IPlatformServerListCallBack callBack,ParamsContainer params);
	
	@Deprecated
	public abstract void GetNoticeList(Activity ctx,IPlatformNoticeListCallBack callBack,String type,String... server_id);
	
	public abstract void GetNoticeList(Activity ctx,IPlatformNoticeListCallBack callBack,String type,ParamsContainer params);
	
	public abstract void GetPayList(Activity ctx,boolean isStrange, final String category,IFuncellPayListCallBack payListCallBack);
	
	public abstract String GetPlatformParams(Activity ctx,PlatformParamsType platformParamsType);
	
	public abstract String GetCustomParams(Activity ctx,String... key);
	
	public abstract void LogMark(Activity ctx,String type, String str);
	
	/**
	 * Activity Lifecycle
	 * @param ctx
	 */
	public abstract void onCreate(Activity ctx);
	
	public abstract void onStart(Activity ctx);
	
	public abstract void onRestart(Activity ctx);

	public abstract void onResume(Activity ctx);
	
	public abstract void onStop(Activity ctx);

	public abstract void onPause(Activity ctx);

	public abstract void onDestroy(Activity ctx);
	
	public abstract void onSaveInstanceState(Bundle outState);
	
	public abstract void onNewIntent(Intent paramIntent);
	
	public abstract void onActivityResult(Activity ctx, int requestCode, int resultCode, Intent data);
	
	public abstract void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults);
	
	public abstract void onConfigurationChanged(Activity ctx,Configuration newConfig);

	/**
	 * Extension method
	 * @param ctx
	 * @param FunctionName
	 * @param params
	 * @return Object
	 */
	public abstract Object callFunction(Activity ctx, String FunctionName, Object... params);
}
