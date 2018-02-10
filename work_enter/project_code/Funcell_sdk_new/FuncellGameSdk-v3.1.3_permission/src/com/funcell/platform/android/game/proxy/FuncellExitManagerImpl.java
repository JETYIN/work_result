package com.funcell.platform.android.game.proxy;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.funcell.platform.android.game.proxy.exit.ExitCallBackType;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitCallBack;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitManager;
import com.funcell.platform.android.game.proxy.util.FuncellTools;

/**
 * ����Ϊ����ʵ���߼��࣬������Զ��滻�ɲ�ͬ������ʵ���࣬Ĭ����demo
 * ��Ҫ������Ϸ�˳����Ƿ��������˳�����
 * @author Administrator
 *
 */
public class FuncellExitManagerImpl implements IFuncellExitManager{
	private String TAG = getClass().getName().toString();
	private static FuncellExitManagerImpl mInstance;
	private static LinearLayout layout;
	private TextView textTitle;
	private LinearLayout.LayoutParams textTitleParams;
	private TextView textContent;
	private LinearLayout.LayoutParams textContentParams;
	private static LinearLayout buttonLayout;
	private static LinearLayout.LayoutParams buttonParams;
	private static Button btgame;
	private static Button btchannel;
	private LinearLayout channelLayout;
	private LinearLayout.LayoutParams channelParams;
	private Button channelsure;
	private Button channelcancle;
	private static View view;
	  
	
	public static FuncellExitManagerImpl getInstance() {
		if (mInstance == null) {
			synchronized (FuncellExitManagerImpl.class) {
				if (mInstance == null) {
					mInstance = new FuncellExitManagerImpl();
				}
			}
		}
		return mInstance;
	}

	@Override
	public void exit(final Activity ctx, final IFuncellExitCallBack callBack) {
		// TODO Auto-generated method stub
		ctx.runOnUiThread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				showDialog(ctx, "�����˳��߼�", "ѡ���˳���ʽ");
				FuncellExitManagerImpl.buttonLayout = new LinearLayout(ctx);
				FuncellExitManagerImpl.buttonParams = new LinearLayout.LayoutParams(-1, 
			      -2);
			    
				FuncellExitManagerImpl.buttonParams.setMargins(FuncellTools.dip2px(ctx, 15.0F), 
			      FuncellTools.dip2px(ctx, 15.0F), FuncellTools.dip2px(ctx, 15.0F), 
			      FuncellTools.dip2px(ctx, 15.0F));
				FuncellExitManagerImpl.buttonLayout.setOrientation(1);
				FuncellExitManagerImpl.btgame = new Button(ctx);
				FuncellExitManagerImpl.btgame.setText("ģ���������˳�����");
				FuncellExitManagerImpl.btgame.setLayoutParams(new LinearLayout.LayoutParams(
			      -1, -2));
				FuncellExitManagerImpl.btchannel = new Button(ctx);
				FuncellExitManagerImpl.btchannel.setText("ģ���������˳�����");
			    LinearLayout.LayoutParams btcancleParams = new LinearLayout.LayoutParams(
			      -1, -2);
			    btcancleParams.setMargins(0, FuncellTools.dip2px(ctx, 10.0F), 0, 0);
			    FuncellExitManagerImpl.buttonLayout.addView(FuncellExitManagerImpl.btgame);
			    FuncellExitManagerImpl.buttonLayout.addView(FuncellExitManagerImpl.btchannel, btcancleParams);
			    FuncellExitManagerImpl.layout.addView(FuncellExitManagerImpl.buttonLayout, FuncellExitManagerImpl.buttonParams);
			    

			    FuncellExitManagerImpl.view = new View(ctx);
			    FuncellExitManagerImpl.view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
			    FuncellExitManagerImpl.view.setBackgroundColor(Color.parseColor("#cccccc"));
			    FuncellExitManagerImpl.layout.addView(FuncellExitManagerImpl.view);
			    


			    ScrollView scrollView = new ScrollView(ctx);
			    FrameLayout.LayoutParams scrollViewParams = new FrameLayout.LayoutParams(
			      -1, 
			      -1);
			    scrollView.setBackgroundColor(Color.parseColor("#eeeeee"));
			    scrollView.setPadding(FuncellTools.dip2px(ctx, 15.0F), 
			      FuncellTools.dip2px(ctx, 10.0F), FuncellTools.dip2px(ctx, 15.0F), 0);
			    TextView noticeView = new TextView(ctx);
			    noticeView
			      .setText("�����˳����棺\n\n1.��������Ҫ����Ҵ����˳��߼�ʱ�����뵯���������˳����棬������������˳������˳���Ϸ\n\n2.��������û���Լ����˳����棬��Щ����Ҫ�󣬵���Ҵ����˳��߼�ʱ�����뵯����Ϸ���˳����棬�������Ϸ���˳������˳�\n\n3.�����ڽ���ʱ���˳��ӿڵ����ֻص���Ҫ����Ϸʵ�֣��˽���ֻ����ĸ���г��֣������մ�����������У��ҷ�SDK����ݲ�ͬ���������˳��ӿڶ�Ӧ�Ļص�����������������Ϸ���˳�����");
			    noticeView.setTextColor(-16777216);
			    noticeView.setTextSize(14.0F);
			    scrollView.addView(noticeView);
			    FuncellExitManagerImpl.layout.addView(scrollView, scrollViewParams);
			    

			    final Dialog dialog = new Dialog(ctx);
			    dialog.requestWindowFeature(1);
			    Window win = dialog.getWindow();
			    win.setFlags(1024, 
			      1024);
			    win.setContentView(FuncellExitManagerImpl.layout);
			    FuncellExitManagerImpl.btgame.setOnClickListener(new View.OnClickListener()
			    {
			      public void onClick(View v)
			      {
			        dialog.dismiss();
			        Toast.makeText(ctx, "����Ϸ�����˳�", 1).show();
			        callBack.onGameExit();
//			        BaseFuncellGameSdkProxy.getInstance().BaseExitCallBack(callBack, ExitCallBackType.onGameExit);
			      }
			    });
			    FuncellExitManagerImpl.btchannel.setOnClickListener(new View.OnClickListener()
			    {
			      public void onClick(View v)
			      {
			        dialog.dismiss();
			       showDialog(ctx, "�����˳�����", "ȷ���˳���Ϸ");
			        
			       channelLayout = new LinearLayout(ctx);
			       channelParams = new LinearLayout.LayoutParams(
			          -1, -2);
			       channelParams.setMargins(FuncellTools.dip2px(ctx, 15.0F), 
			          FuncellTools.dip2px(ctx, 15.0F), 
			          FuncellTools.dip2px(ctx, 15.0F), 
			          FuncellTools.dip2px(ctx, 15.0F));
			       channelLayout.setOrientation(0);
			       channelsure = new Button(ctx);
			       channelsure.setText("ȷ��");
			       channelsure.setLayoutParams(new LinearLayout.LayoutParams(0, 
			          -2, 1.0F));
			       channelcancle = new Button(ctx);
			       channelcancle.setText("ȡ��");
			        LinearLayout.LayoutParams channelcancleParams = new LinearLayout.LayoutParams(
			          0, -2, 1.0F);
			        channelcancleParams.setMargins(FuncellTools.dip2px(ctx, 15.0F), 0, 
			          0, 0);
			       channelLayout.addView(channelsure);
			       channelLayout.addView(channelcancle, channelcancleParams);
			       layout.addView(channelLayout,channelParams);
			        
			        final Dialog channelDialog = new Dialog(ctx);
			        channelDialog.requestWindowFeature(1);
			        Window win = channelDialog.getWindow();
			        win.setFlags(1024, 
			          1024);
			        win.setContentView(layout);
			       channelsure.setOnClickListener(new View.OnClickListener()
			        {
			          public void onClick(View v)
			          {
			            callBack.onChannelExit();
//			        	BaseFuncellGameSdkProxy.getInstance().BaseExitCallBack(callBack, ExitCallBackType.onChannelExit);
			          }
			        });
			       channelcancle.setOnClickListener(new View.OnClickListener()
			        {
			          public void onClick(View v)
			          {
			            channelDialog.dismiss();
			          }
			        });
			        channelDialog.show();
			      }
			    });
			    dialog.show();
			}
		});
	}

	@Override
	public int GetExitUI(Activity ctx) {
		// TODO Auto-generated method stub
		return 1;
	}
	
	public void showDialog(Activity context, String title, String content) {
		this.layout = new LinearLayout(context);
		this.layout.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
		this.layout.setOrientation(1);
		this.layout.setBackgroundColor(Color.parseColor("#ffffff"));

		this.textTitle = new TextView(context);
		this.textTitleParams = new LinearLayout.LayoutParams(-1, -2);
		this.textTitleParams.setMargins(0, FuncellTools.dip2px(context, 10.0F),
				0, FuncellTools.dip2px(context, 10.0F));
		this.textTitle.setGravity(17);
		this.textTitle.setText(title);
		this.textTitle.setTextColor(-16777216);
		this.textTitle.setTextSize(20.0F);
		this.layout.addView(this.textTitle, this.textTitleParams);

		this.view = new View(context);
		this.view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
		this.view.setBackgroundColor(Color.parseColor("#cccccc"));
		this.layout.addView(this.view);

		this.textContent = new TextView(context);
		this.textContentParams = new LinearLayout.LayoutParams(-1, -2);
		this.textContentParams.setMargins(FuncellTools.dip2px(context, 10.0F),
				FuncellTools.dip2px(context, 10.0F), 0,
				FuncellTools.dip2px(context, 10.0F));
		this.textContent.setText(content);
		this.textContent.setTextColor(-16777216);
		this.textContent.setTextSize(20.0F);
		this.layout.addView(this.textContent, this.textContentParams);

		this.view = new View(context);
		this.view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
		this.view.setBackgroundColor(Color.parseColor("#cccccc"));
		this.layout.addView(this.view);
	}
}
