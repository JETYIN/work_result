package com.funcell.platform.android.game.proxy;

import com.funcell.platform.android.FuncellGameSdkProxy;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.init.InitCallBackType;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * 此类为渠道实现逻辑类，打包会自动替换成不同渠道的实现类，默认是demo
 * 主要包含初始化和周期的实现类
 * @author Administrator
 *
 */
public class FuncellActivityStubImpl extends FuncellStatActivityStub{
	private String TAG = getClass().getName().toString();
	
	private static FuncellActivityStubImpl mInstance;
	private Activity mContext;
	private ProgressDialog mInitDialog;
	private boolean floatShow = false;
	private WindowManager mWindowManager;
	private WindowManager.LayoutParams wmParams;
	private LinearLayout mFloatLayout;
	private int startX;
	private int startY;
	private int SUCCESS = 888;
	private IFuncellInitCallBack mInitCallBack;
	
	Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			if ((SUCCESS == msg.what) && (mInitDialog != null && mInitDialog.isShowing())) {
				mInitCallBack.onInitSuccess();
//				BaseFuncellGameSdkProxy.getInstance().BaseInitCallBack(mInitCallBack,InitCallBackType.onInitSuccess);
				mInitDialog.dismiss();
			}
		}
	};
	
	public static FuncellActivityStubImpl getInstance() {
		if (mInstance == null) {
			synchronized (FuncellActivityStubImpl.class) {
				if (mInstance == null) {
					mInstance = new FuncellActivityStubImpl();
				}
			}
		}
		return mInstance;
	}
	
	@Override
	public void applicationInit(Activity ctx,
			IFuncellInitCallBack initCallBack,
			IFuncellSessionCallBack sessionCallBack, IFuncellPayCallBack payCallBack) {
		// TODO Auto-generated method stub
		Log.e(TAG,"applicationInit");
		mInitCallBack = initCallBack;
		super.applicationInit(ctx, initCallBack, sessionCallBack, payCallBack);
		mContext = ctx;
		showInitDialog(mContext);
	}
	
	public void showInitDialog(Activity ctx) {
		if (this.mInitDialog == null) {
			this.mInitDialog = new ProgressDialog(ctx);
		}
		this.mInitDialog.setCancelable(false);
		this.mInitDialog.setProgress(0);
		this.mInitDialog.setMessage("初始化...");
		this.mInitDialog.show();
		this.mHandler.postDelayed(new Runnable() {
			public void run() {
				mHandler.sendEmptyMessage(SUCCESS);
			}
		}, 3000L);
	}
	
	public void showFloatButton(final Activity context) {
		if (FuncellVar.user != null) {
			this.mWindowManager = ((WindowManager) context
					.getSystemService("window"));
			final int width = this.mWindowManager.getDefaultDisplay()
					.getWidth();
			int height = this.mWindowManager.getDefaultDisplay().getHeight();
			SharedPreferences sp = context.getSharedPreferences(
					"funcell_float_button", 0);
			final SharedPreferences.Editor editor = sp.edit();
			int floatX = sp.getInt("floatX", width);
			int floatY = sp.getInt("floatY", height / 2);
			Log.i(TAG, "floatX=" + floatX + ",floatY=" + floatY);
			this.wmParams = new WindowManager.LayoutParams();

			Log.i(TAG, "Display==>width=" + width + ",height=" + height);
			this.wmParams.format = 1;
			this.wmParams.flags = 65832;

			this.wmParams.gravity = 51;
			this.wmParams.x = floatX;
			this.wmParams.y = floatY;
			this.wmParams.width = -2;
			this.wmParams.height = -2;
			if (this.mFloatLayout == null) {
				this.mFloatLayout = new LinearLayout(context);
				Button button = new Button(context);
				button.setText("浮标");

				button.setOnTouchListener(new View.OnTouchListener() {
					public boolean onTouch(View v, MotionEvent event) {
						Log.d(TAG, "ontouch");
						int action = event.getAction();
						int tempX = (int) event.getRawX()
								- mFloatLayout.getWidth() / 2;
						int tempY = (int) event.getRawY()
								- mFloatLayout.getHeight() / 2;
						switch (action) {
						case 0:
							startX = ((int) event.getRawX());
							startY = ((int) event.getRawY());
							break;
						case 2:
							break;
						case 1:
							if (tempX < width / 2) {
								tempX = 0;
							} else {
								tempX = width;
							}
							int endX = (int) event.getRawX();
							int endY = (int) event.getRawY();
							if ((Math.abs(endX - startX) <= 5)
									&& (Math.abs(endY - startY) <= 5)
									&& (event.getEventTime()
											- event.getDownTime() < 200L)) {
								v.performClick();
							}
							break;
						}
						wmParams.x = tempX;
						wmParams.y = tempY;
						Log.i(TAG, "X=" + wmParams.x + ",Y=" + wmParams.y);
						editor.putInt("floatX", wmParams.x);
						editor.putInt("floatY", wmParams.y);
						editor.commit();
						if(mWindowManager != null && mFloatLayout != null && floatShow){
							mWindowManager.updateViewLayout(mFloatLayout, wmParams);
						}
						return true;
					}
				});
				button.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						FuncellGameSdkProxy.getInstance().Logout(context);
					}
				});
				this.mFloatLayout.addView(button, -2, -2);
			}
			try {
				this.mWindowManager.addView(this.mFloatLayout, this.wmParams);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		this.floatShow = true;
	}

	public void hideFloatButton(Activity context) {
		try {
			if ((mWindowManager != null) && (floatShow)) {
				mWindowManager.removeView(mFloatLayout);
				floatShow = false;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void onCreate(Activity ctx) {
		// TODO Auto-generated method stub
		super.onCreate(ctx);
		Log.e(TAG,"onCreate");
		
	}

	@Override
	public void onStart(Activity ctx) {
		// TODO Auto-generated method stub
		super.onStart(ctx);
	}

	@Override
	public void onRestart(Activity ctx) {
		// TODO Auto-generated method stub
		super.onRestart(ctx);
	}

	@Override
	public void onResume(Activity ctx) {
		// TODO Auto-generated method stub
		super.onResume(ctx);
		showFloatButton(ctx);
	}

	@Override
	public void onStop(Activity ctx) {
		// TODO Auto-generated method stub
		super.onStop(ctx);
	}

	@Override
	public void onPause(Activity ctx) {
		// TODO Auto-generated method stub
		super.onPause(ctx);
		hideFloatButton(ctx);
	}

	@Override
	public void onDestroy(Activity ctx) {
		// TODO Auto-generated method stub
		super.onDestroy(ctx);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onNewIntent(Intent paramIntent) {
		// TODO Auto-generated method stub
		super.onNewIntent(paramIntent);
	}

	@Override
	public void onActivityResult(Activity ctx, int requestCode, int resultCode,
			Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(ctx, requestCode, resultCode, data);
		if (resultCode == 55555) {
			boolean result = data.getBooleanExtra("result", false);
			String username = data.getStringExtra("username");
			if (result) {
				FuncellSessionManagerImpl.getInstance().onTestLoginSuccess(ctx,username);
			} else {
				FuncellSessionManagerImpl.getInstance().onTestLoginFail(ctx);
			}
		}
	}

	@Override
	public void onRequestPermissionsResult(int requestCode,
			String[] permissions, int[] grantResults) {
		// TODO Auto-generated method stub
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

}
