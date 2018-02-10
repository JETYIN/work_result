package com.funcell.platform.android.game.proxy;

import org.cocos2dx.lib.Cocos2dxActivity;

import com.funcell.platform.android.FuncellGameSdkProxy;
import com.funcell.platform.android.FuncellGameSdkProxyNativeStub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

/**
 * cocos2dx主界面，该类为游戏接入者需要继承的基类
 * @author Administrator
 *
 */
public class FuncellCocos2dxActivity extends Cocos2dxActivity {
	private String TAG = getClass().getName().toString();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		/**
		 * 初始化相关SDK---FuncellGameSdkProxyNativeStub
		 */
		FuncellGameSdkProxyNativeStub.init(this, FuncellGameSdkProxy.getInstance(), new FuncellGLThreadRunner(){

			@Override
			public void runOnGLThread(Runnable paramRunnable) {
				// TODO Auto-generated method stub
				Log.e(TAG,"-------runOnGLThread--------调用");
				FuncellCocos2dxActivity.this.runOnGLThread(paramRunnable);
			}
		});
		FuncellGameSdkProxy.getInstance().onCreate(this);
	}

	@Override
	public void onResume() {
		super.onResume();
		FuncellGameSdkProxy.getInstance().onResume(this);
	}

	@Override
	public void onPause() {
		super.onPause();
		FuncellGameSdkProxy.getInstance().onPause(this);
	}

	@Override
	public void onStop() {
		super.onStop();
		FuncellGameSdkProxy.getInstance().onStop(this);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		FuncellGameSdkProxy.getInstance().onDestroy(this);
	}

	@Override
	public void onRestart() {
		super.onRestart();
		FuncellGameSdkProxy.getInstance().onRestart(this);
	}

	@Override
	protected void onNewIntent(Intent intent) {
		// TODO Auto-generated method stub
		super.onNewIntent(intent);
		FuncellGameSdkProxy.getInstance().onNewIntent(intent);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		FuncellGameSdkProxy.getInstance().onActivityResult(this, requestCode, resultCode, data);
	}
	
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		FuncellGameSdkProxy.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
	}
}