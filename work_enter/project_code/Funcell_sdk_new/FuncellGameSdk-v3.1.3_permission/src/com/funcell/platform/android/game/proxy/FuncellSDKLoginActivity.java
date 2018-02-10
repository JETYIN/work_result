package com.funcell.platform.android.game.proxy;

import com.funcell.platform.android.game.proxy.util.FuncellTools;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class FuncellSDKLoginActivity extends Activity {
	private String TAG = getClass().getName().toString();
	private View view;
	private LinearLayout.LayoutParams layoutParams;
	private TextView textView;
	private LinearLayout.LayoutParams textviewParams;
	private LinearLayout llusername;
	private LinearLayout.LayoutParams usernameParams;
	private TextView tvusername;
	private Spinner spusername;
	private LinearLayout llpassword;
	private LinearLayout.LayoutParams passwordParams;
	private TextView tvpassword;
	private EditText etpassword;
	private LinearLayout llbutton;
	private LinearLayout.LayoutParams buttonParams;
	private Button btlogin;
	private Button btcancle;
	private TextView noticeView;
	private ScrollView scrollView;
	private FrameLayout.LayoutParams scrollViewParams;
	public static final int layoutId = 90;
	public static final int textViewId = 100;
	public static final int llusernameId = 110;
	public static final int llpasswordId = 120;
	public static final int llbuttonId = 130;
	public static final int scrollViewId = 140;
	public static LinearLayout layout;
	public static String username;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		layout = new LinearLayout(this);
		this.layoutParams = new LinearLayout.LayoutParams(-1, -1);
		layout.setOrientation(1);
		layout.setId(90);
		layout.setBackgroundColor(Color.parseColor("#ffffff"));

		this.textView = new TextView(this);
		this.textviewParams = new LinearLayout.LayoutParams(-1, FuncellTools.dip2px(
				this, 40.0F));
		this.textviewParams.topMargin = 5;
		this.textView.setId(100);
		this.textView.setText("测试渠道登录");
		this.textView.setTextColor(-16777216);
		this.textView.setTextSize(20.0F);
		this.textView.setGravity(17);
		layout.addView(this.textView, this.textviewParams);

		this.view = new View(this);
		this.view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
		this.view.setBackgroundColor(Color.parseColor("#cccccc"));
		layout.addView(this.view);

		this.llusername = new LinearLayout(this);
		this.usernameParams = new LinearLayout.LayoutParams(-1, -2);
		this.llusername.setOrientation(0);
		this.llusername.setId(110);
		this.llusername.setFocusable(true);
		this.llusername.setFocusableInTouchMode(true);
		this.usernameParams.setMargins(FuncellTools.dip2px(this, 20.0F),
				FuncellTools.dip2px(this, 5.0F), FuncellTools.dip2px(this, 20.0F), 5);

		this.tvusername = new TextView(this);
		this.tvusername.setLayoutParams(new LinearLayout.LayoutParams(0,
				FuncellTools.dip2px(this, 45.0F), 1.0F));
		this.tvusername.setText("用户名:");
		this.tvusername.setTextColor(-16777216);

		String[] users = { "demo1", "demo2", "demo3" };
		this.spusername = new Spinner(this);
		this.spusername.setLayoutParams(new LinearLayout.LayoutParams(0,
				FuncellTools.dip2px(this, 45.0F), 4.0F));
		ArrayAdapter<CharSequence> adapterUsername = new ArrayAdapter(this,17367049, users);
		this.spusername.setAdapter(adapterUsername);
		this.spusername.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					public void onItemSelected(AdapterView<?> parent,
							View view, int position, long id) {
						TextView tv = (TextView) view;
						tv.setTextColor(-16777216);
					}

					public void onNothingSelected(AdapterView<?> parent) {
					}
				});
		this.llusername.addView(this.tvusername);
		this.llusername.addView(this.spusername);

		layout.addView(this.llusername, this.usernameParams);

		this.llpassword = new LinearLayout(this);
		this.passwordParams = new LinearLayout.LayoutParams(-1, -2);
		this.llpassword.setOrientation(0);
		this.llpassword.setId(120);
		this.passwordParams.setMargins(FuncellTools.dip2px(this, 20.0F),
				FuncellTools.dip2px(this, 5.0F), FuncellTools.dip2px(this, 20.0F), 5);

		this.tvpassword = new TextView(this);
		this.tvpassword.setLayoutParams(new LinearLayout.LayoutParams(0, -2,
				1.0F));
		this.tvpassword.setText("密\t  码:");
		this.tvpassword.setTextColor(-16777216);

		this.etpassword = new EditText(this);
		this.etpassword.setLayoutParams(new LinearLayout.LayoutParams(0,
				FuncellTools.dip2px(this, 45.0F), 4.0F));
		this.etpassword.setText("funcelltest");
		this.etpassword.setTextColor(-16777216);
		this.etpassword.setTextSize(18.0F);
		this.etpassword.setEnabled(false);
		this.etpassword.setInputType(129);

		this.llpassword.addView(this.tvpassword);
		this.llpassword.addView(this.etpassword);
		layout.addView(this.llpassword, this.passwordParams);

		this.llbutton = new LinearLayout(this);
		this.llbutton.setId(130);
		this.llbutton.setOrientation(0);
		this.buttonParams = new LinearLayout.LayoutParams(-1, -2);
		this.buttonParams.setMargins(FuncellTools.dip2px(this, 20.0F),
				FuncellTools.dip2px(this, 5.0F), FuncellTools.dip2px(this, 20.0F),
				FuncellTools.dip2px(this, 5.0F));

		this.btlogin = new Button(this);
		this.btlogin.setText("模拟登录");
		this.btlogin
				.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0F));
		this.btcancle = new Button(this);

		this.btcancle.setText("取消登录");
		LinearLayout.LayoutParams btcancleParams = new LinearLayout.LayoutParams(
				0, -2, 1.0F);
		btcancleParams.setMargins(FuncellTools.dip2px(this, 15.0F), 0, 0, 0);
		this.llbutton.addView(this.btlogin);
		this.llbutton.addView(this.btcancle, btcancleParams);
		layout.addView(this.llbutton, this.buttonParams);

		this.view = new View(this);
		this.view.setLayoutParams(new ViewGroup.LayoutParams(-1, 1));
		this.view.setBackgroundColor(Color.parseColor("#cccccc"));
		layout.addView(this.view);

		this.scrollView = new ScrollView(this);
		this.scrollViewParams = new FrameLayout.LayoutParams(-1, -1);
		this.scrollView.setId(140);
		this.scrollView.setBackgroundColor(Color.parseColor("#eeeeee"));
		this.scrollView.setPadding(FuncellTools.dip2px(this, 20.0F),
				FuncellTools.dip2px(this, 5.0F), FuncellTools.dip2px(this, 20.0F), 0);
		this.noticeView = new TextView(this);
		this.noticeView
				.setText("说明：\n\n1.此界面为测试渠道登录界面，仅会出现在游戏母包中，在打出的渠道包中此界面会被替换成各个渠道的登录界面\n\n2.登录成功后，会回调onLoginSuccess\n\n3.登录失败或取消登录后，通常情况下会回调onLoginFailed，但有部分渠道不会进行回调；所以为了兼容所有渠道，建议游戏添加登录按钮，同时勿在登陆界面做阻塞操作\n\n4.为了让游戏兼容更多渠道，请查阅我方官网的《接入渠道SDK游戏开发指南》");
		this.noticeView.setTextColor(-16777216);
		this.noticeView.setTextSize(16.0F);
		this.scrollView.addView(this.noticeView);
		layout.addView(this.scrollView, this.scrollViewParams);

		WindowManager m = getWindowManager();
		Display d = m.getDefaultDisplay();
		WindowManager.LayoutParams p = getWindow().getAttributes();
		p.height = ((int) (d.getHeight() * 0.85D));
		p.width = ((int) (d.getWidth() * 0.85D));
		p.alpha = 1.0F;
		p.dimAmount = 0.0F;
		p.format = 1;
		getWindow().setAttributes(p);

		setContentView(layout, this.layoutParams);

		this.btlogin.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				username = (String)spusername.getSelectedItem();
				Log.e(TAG, "username:"+username);
				Intent intent = new Intent();
				intent.putExtra("result", true);
				intent.putExtra("username", username);
				setResult(55555, intent);
				finish();
			}
		});
		this.btcancle.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent();
				intent.putExtra("result", false);
				setResult(55555, intent);
				finish();
			}
		});
	}

	public static LinearLayout getLinearLayout(){
		return layout;
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == 4) {
			Intent intent = new Intent();
			intent.putExtra("result", false);
			setResult(55555, intent);
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}

}
