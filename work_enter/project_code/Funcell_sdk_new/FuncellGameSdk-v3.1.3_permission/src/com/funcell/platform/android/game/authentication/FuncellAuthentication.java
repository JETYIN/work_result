package com.funcell.platform.android.game.authentication;

import com.funcell.platform.android.game.authentication.ui.DefaultWebViewDialog;
import com.funcell.platform.android.game.proxy.FuncellException;
import com.funcell.platform.android.game.proxy.IFuncellCallBack;

import android.app.Activity;
import android.view.Display;

public class FuncellAuthentication {

	private static FuncellAuthentication mInstance;
	public static FuncellAuthentication getInstance() {
		if (mInstance == null) {
			synchronized (FuncellAuthentication.class) {
				if (mInstance == null) {
					mInstance = new FuncellAuthentication();
				}
			}
		}
		return mInstance;
	}
	
	public <T> void showAuthentication(Activity ctx,float hRate, float wRate,final IFuncellCallBack<T> callBack){
		final DefaultWebViewDialog<T> webViewDialog = new DefaultWebViewDialog<T>(ctx,"https://www.baidu.com/");
		Display d = ctx.getWindowManager().getDefaultDisplay(); // 为获取屏幕宽、高
		webViewDialog.setSize((int)(d.getWidth() * wRate), (int)(d.getHeight() * hRate));
		webViewDialog.setOnWebViewCallBack(new IFuncellCallBack<T>() {

			@Override
			public void onSuccess(T result) {
				// TODO Auto-generated method stub
				callBack.onSuccess(result);
			}
			@Override
			public void onError(FuncellException error) {
				// TODO Auto-generated method stub
				callBack.onError(error);
			}
		});
		webViewDialog.show();
	}
}
