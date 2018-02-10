package com.funcell.platform.android.game.proxy;

import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public abstract interface IFuncellActivityStub {
	/**
	 * Activity Lifecycle
	 * @param ctx
	 */
	public abstract void applicationInit(Activity ctx,IFuncellInitCallBack initCallBack,IFuncellSessionCallBack sessionCallBack, IFuncellPayCallBack payCallBack);
	
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

	public abstract Object callFunction(Activity ctx, String FunctionName, Object... params);
}
