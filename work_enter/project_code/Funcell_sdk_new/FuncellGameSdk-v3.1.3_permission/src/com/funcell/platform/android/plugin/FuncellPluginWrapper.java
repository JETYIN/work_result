package com.funcell.platform.android.plugin;

import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.funcell.platform.android.game.proxy.FuncellSessionManagerImpl;
import com.funcell.platform.android.game.proxy.FuncellStatActivityStub;
import com.funcell.platform.android.game.proxy.IFuncellActivityStub;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.wrapper.Wrapper;

/**
 * 此类为提供给外部调用类，如初始化三方插件等操作
 * @author Administrator
 * 此类后续添加 各种统计，推送，分享等三方SDK，大致通过interface来实现,三方SDK接入类需要实现IFuncellActivityStub接口
 * Vector<IFuncellActivityStub> mActivityStub = new Vector();
 * mActivityStub.add(IFuncellActivityStub);
 * for (int i = 0; i < mActivityStub.size(); i++) {((IFuncellActivityStub)mActivityStub.get(i)).onStop(); 各种三方SDK的周期函数}
 */
public class FuncellPluginWrapper extends FuncellStatActivityStub{
	/**
	 * 
	 */
	private static FuncellPluginWrapper mInstance;
	private static Vector<IFuncellActivityStub> mActivityStub = new Vector();
	
	public static FuncellPluginWrapper getInstance() {
		if (mInstance == null) {
			synchronized (FuncellPluginWrapper.class) {
				if (mInstance == null) {
					mInstance = new FuncellPluginWrapper();
				}
			}
		}
		return mInstance;
	}
	
	public void init(Activity ctx){
		/**
		 * 
		 */
		Wrapper.analysisDeveloperInfo(ctx);
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
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onCreate(ctx);
		}
	}

	@Override
	public void onStart(Activity ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onStart(ctx);
		}
	}

	@Override
	public void onRestart(Activity ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onRestart(ctx);
		}
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onResume(ctx);
		}
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onStop(ctx);
		}
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onPause(ctx);
		}
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onDestroy(ctx);
		}
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onSaveInstanceState(outState);
		}
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onNewIntent(paramIntent);
		}
	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode,
			Intent data) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onActivityResult(ctx,requestCode,resultCode,data);
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).onRequestPermissionsResult(requestCode, permissions, grantResults);
		}
	}
	
	@Override
	public Object callFunction(Activity ctx,String FunctionName, Object... params) {
		// TODO Auto-generated method stub
		for (int i = 0; i < mActivityStub.size(); i++) {
			((IFuncellActivityStub)mActivityStub.get(i)).callFunction(ctx, FunctionName, params);
		}
		return null;
	}
	
	public void setActivityCallback(IFuncellActivityStub IFuncellActivityStub) {
		mActivityStub.add(IFuncellActivityStub);
	}

}
