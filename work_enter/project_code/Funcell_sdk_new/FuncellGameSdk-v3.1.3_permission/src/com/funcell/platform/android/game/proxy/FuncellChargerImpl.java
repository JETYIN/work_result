package com.funcell.platform.android.game.proxy;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.funcell.platform.android.FuncellRUtils;
import com.funcell.platform.android.game.proxy.pay.FuncellPayParams;
import com.funcell.platform.android.game.proxy.pay.IFuncellChargerManager;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.pay.PayCallBackType;
import com.funcell.platform.android.game.proxy.pay.funcell.FunSdkUiActivity;
import com.funcell.platform.android.game.proxy.util.FuncellTools;

public class FuncellChargerImpl implements IFuncellChargerManager {
	private String TAG = getClass().getName().toString();
	private FuncellPayParams mPayParams;
	
	private static FuncellChargerImpl mInstance;
	public static FuncellChargerImpl getInstance() {
		if (mInstance == null) {
			synchronized (FuncellChargerImpl.class) {
				if (mInstance == null) {
					mInstance = new FuncellChargerImpl();
				}
			}
		}
		return mInstance;
	}
	
	@Deprecated
	@Override
	public void pay(Context ctx, FuncellPayParams paramFuncellPayParams) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pay(final Activity ctx, final FuncellPayParams paramFuncellPayParams,
			final IFuncellPayCallBack callBack) {
		// TODO Auto-generated method stub
		ctx.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (FuncellVar.user == null) {
					Toast.makeText(ctx, ctx.getResources().getString(FuncellRUtils.string(ctx, "FUNCELL_NOT_LOGIN_FLAG_TEST")), 0).show();
					return;
				}
				Log.e(TAG, "支付的数据--------:"+paramFuncellPayParams.getmBundle().toString());
				int fen = paramFuncellPayParams.getmItemAmount().valueOfMoney().intValue();
//				if (fen < 1) {
//					Toast.makeText(ctx, "为兼容渠道，请传入大于1元的整数", 0).show();
//					return;
//				}
				LinearLayout content = new LinearLayout(ctx);
				content.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
				content.setOrientation(1);
				content.setBackgroundColor(Color.parseColor("#ffffff"));

				TextView tvTitle = new TextView(ctx);
				LinearLayout.LayoutParams tvTitleParams = new LinearLayout.LayoutParams(
						-1, -2);
				tvTitleParams.setMargins(0, FuncellTools.dip2px(ctx, 10.0F), 0,
						FuncellTools.dip2px(ctx, 10.0F));
				tvTitle.setGravity(17);
				tvTitle.setText("收银台（注意商品描述！）");
				tvTitle.setTextColor(-16777216);
				tvTitle.setTextSize(20.0F);
				content.addView(tvTitle, tvTitleParams);

				ImageView line1 = new ImageView(ctx);
				line1.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
				line1.setBackgroundColor(Color.parseColor("#cccccc"));
				content.addView(line1);

				TextView tvNotice = new TextView(ctx);
				LinearLayout.LayoutParams tvNoticeParams = new LinearLayout.LayoutParams(
						-1, -2);
				tvNotice.setTextColor(-16777216);
				tvNotice.setTextSize(16.0F);
				tvNotice.setText("您将购买"
						+ paramFuncellPayParams.getmItemCount()
						+ paramFuncellPayParams.getmItemType()
						+ "!（注意！）\n接入注意！：\n如点击购买100钻石，请输入数量为100，商品名为钻石，不要写数量1，商品名100钻石！请确保上方描述正确！如显示错误，请技术同学检查代码中传入的参数是否正确！");
				content.addView(tvNotice, tvNoticeParams);

				ImageView line2 = new ImageView(ctx);
				line2.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
				line2.setBackgroundColor(Color.parseColor("#cccccc"));
				content.addView(line2);

				LinearLayout llButtons = new LinearLayout(ctx);
				LinearLayout.LayoutParams llButtonsParams = new LinearLayout.LayoutParams(
						-1, -2);

				llButtons.setOrientation(0);
				Button btConfirm = new Button(ctx);
				btConfirm.setText("确定");

				Button btCancel = new Button(ctx);
				btCancel.setText("取消");

				LinearLayout.LayoutParams llConfirmParams = new LinearLayout.LayoutParams(
						FuncellTools.dip2px(ctx, 135.0F), -2);
				llConfirmParams.setMargins(18, 0, 0, 0);
				llButtons.addView(btConfirm, llConfirmParams);
				llButtons.addView(btCancel,
						new LinearLayout.LayoutParams(FuncellTools.dip2px(ctx, 135.0F),
								-2));

				content.addView(llButtons, llButtonsParams);

				final Dialog dialog = new Dialog(ctx);
				dialog.requestWindowFeature(1);
				Window win = dialog.getWindow();
				win.setFlags(1024, 1024);
				win.setContentView(content);
				dialog.show();

				btConfirm.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
						/**
						 * 拿到平台返回的参数后，请求funcell渠道支付
						 */
						funcellpay(ctx, paramFuncellPayParams, callBack);
					}
				});
				btCancel.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
						callBack.onCancel("pay onCancel");
//						BaseFuncellGameSdkProxy.getInstance().BasePayCallBack(callBack, PayCallBackType.onCancel);
					}
				});
			}
		});
	}
	
	private void funcellpay(Activity ctx,FuncellPayParams paramFuncellPayParams,IFuncellPayCallBack callBack){
		mPayParams = paramFuncellPayParams;
		FunSdkUiActivity.setRechargeCallBack(callBack);
		FunSdkUiActivity.setFuncellPayParams(paramFuncellPayParams);
		Intent intent = new Intent(ctx, FunSdkUiActivity.class);
		ctx.startActivity(intent);
	}

	@Override
	public FuncellPayParams GetPayParams() {
		// TODO Auto-generated method stub
		return mPayParams;
	}
}
