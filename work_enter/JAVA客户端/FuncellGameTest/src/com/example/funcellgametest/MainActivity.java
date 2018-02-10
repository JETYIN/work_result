package com.example.funcellgametest;


import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.funcell.platform.android.FuncellGameSdkProxy;
import com.funcell.platform.android.game.proxy.data.FuncellDataTypes;
import com.funcell.platform.android.game.proxy.data.ParamsContainer;
import com.funcell.platform.android.game.proxy.exit.IFuncellExitCallBack;
import com.funcell.platform.android.game.proxy.init.IFuncellInitCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformNoticeListCallBack;
import com.funcell.platform.android.game.proxy.init.IPlatformServerListCallBack;
import com.funcell.platform.android.game.proxy.pay.FuncellPayParams;
import com.funcell.platform.android.game.proxy.pay.FuncellRoleInfo;
import com.funcell.platform.android.game.proxy.pay.IFuncellPayCallBack;
import com.funcell.platform.android.game.proxy.session.FuncellSession;
import com.funcell.platform.android.game.proxy.session.IFuncellSessionCallBack;
import com.funcell.platform.android.plugin.FuncellSDKAnalytics;
import com.funcell.platform.android.plugin.FuncellSDKCrash;
import com.funcell.platform.android.plugin.FuncellSDKHelpShift;
import com.funcell.platform.android.plugin.FuncellSDKShare;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsEventKey;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsEventType;
import com.funcell.platform.android.plugin.analytics.FuncellAnalyticsType;
import com.funcell.platform.android.plugin.callback.IFuncellShareCallBack;
import com.funcell.platform.android.plugin.share.FuncellShareChannelType;
import com.funcell.platform.android.plugin.share.FuncellShareKey;
import com.funcell.platform.android.plugin.share.FuncellShareType;


public class MainActivity extends Activity implements OnClickListener{
	
	private String TAG = "MainActivity";
	private Button mLoginBtn;
	private Button mPayBtn;
	private Button mLogoutBtn;
	private Button mExitBtn;
	private Button mCreateRoleEventBtn;
	private Button mLoginEvevtBtn;
	private Button mRoleLevelUpEventBtn;
	private Button mServerRoleEvevtBtn;
	private FuncellSession mUser;
	private Dialog dialog;
	FuncellSession mSession;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		doInit();
		FuncellGameSdkProxy.getInstance().onCreate(this);
		
		mLoginBtn = (Button) findViewById(R.id.login_button);
		mPayBtn = (Button) findViewById(R.id.pay_button);
		mLogoutBtn = (Button) findViewById(R.id.logout_button);
		mExitBtn = (Button) findViewById(R.id.exit_button);
		mCreateRoleEventBtn = (Button) findViewById(R.id.creatrole_event);
		mLoginEvevtBtn = (Button) findViewById(R.id.login_evevt);
		mRoleLevelUpEventBtn = (Button) findViewById(R.id.rolelevelup_event);
		mServerRoleEvevtBtn = (Button) findViewById(R.id.server_role_evevt);
		mLoginBtn.setOnClickListener(this);
		mPayBtn.setOnClickListener(this);
		mLogoutBtn.setOnClickListener(this);
		mExitBtn.setOnClickListener(this);
		mCreateRoleEventBtn.setOnClickListener(this);
		mLoginEvevtBtn.setOnClickListener(this);
		mRoleLevelUpEventBtn.setOnClickListener(this);
		mServerRoleEvevtBtn.setOnClickListener(this);
		
	}
	
	private void doInit() {
		
		FuncellGameSdkProxy.getInstance().Init(this, new IFuncellInitCallBack(){

			@Override
			public void onInitFailure(String paramString) {
				// TODO Auto-generated method stub
				Log.e(TAG,"-------onInitFailure:"+paramString);
			}

			@Override
			public void onInitSuccess() {
				// TODO Auto-generated method stub
				Log.e(TAG,"------onInitSuccess");
			}
			
		}, new IFuncellSessionCallBack(){

			@Override
			public void onLoginSuccess(FuncellSession session) {
				// TODO Auto-generated method stub
				Log.e(TAG,"-------onLoginSuccess");
				Log.e(TAG,"-------session"+session.getmToken());
				mSession = session;
			}

			@Override
			public void onLoginCancel() {
				// TODO Auto-generated method stub
				Log.e(TAG,"------onLoginCancel");
			}

			@Override
			public void onLoginFailed(String paramString) {
				// TODO Auto-generated method stub
				Log.e(TAG,"paramString:"+paramString);
				Log.e(TAG,"------onLoginFailed");
			}

			@Override
			public void onLogout() {
				// TODO Auto-generated method stub74
				Log.e(TAG,"------onLogout");
				/**
				 * 游戏需要返回登录界面
				 */
			}

			@Override
			public void onSwitchAccount(FuncellSession session) {
				// TODO Auto-generated method stub
				/**
				 * 切换帐号回调(使用回调信息进行登录验证)
				 * 部分渠道在切换帐号回调中，可能是以登录成功回调来 回调给SDK
				 * 因此当接到该回调信息时候，需要先通知游戏退回登录主界面进行当前角色切换
				 */
				Log.e(TAG,"------onSwitchAccount");
			}
			
		}, new IFuncellPayCallBack(){


			@Override
			public void onFail(String paramString) {
				// TODO Auto-generated method stub
				Log.e(TAG,"IFuncellPayCallBack onFail");
			}

			@Override
			public void onCancel(String paramString) {
				// TODO Auto-generated method stub
				Log.e(TAG,"IFuncellPayCallBack onCancel");
				
			}

			@Override
			public void onSuccess(String cpOrder, String sdkOrder,
					String extrasParams) {
				// TODO Auto-generated method stub
				/**
				 * 渠道充值成功，不代表游戏服务器到账，请知晓
				 * 返回的参数，如果游戏接入者有自己的逻辑，可以不试用以上参数
				 */
				Log.e(TAG,"IFuncellPayCallBack onSuccess");
				Log.e(TAG,"cpOrder:"+cpOrder); //游戏方的订单，
				Log.e(TAG,"sdkOrder:"+sdkOrder);//平台订单号
				Log.e(TAG,"extrasParams:"+extrasParams);//透传参数
				
			}

			@Override
			public void onClosePayPage(String cpOrder, String sdkOrder, String extrasParams) {
				// TODO Auto-generated method stub
				/**
				 * 渠道充值关闭界面
				 * 可能由于某些SDK的支付方式中，采用网页形式进行支付，但是又不能明确支付的状态（成功，失败，取消等）
				 */
			}
			
		});
		
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
	public void onStart() {
		super.onStart();
		FuncellGameSdkProxy.getInstance().onStart(this);
	}

	@Override
	public void onRestart() {
		super.onRestart();
		FuncellGameSdkProxy.getInstance().onRestart(this);
	}
	
	public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults) {
		FuncellGameSdkProxy.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		FuncellGameSdkProxy.getInstance().onActivityResult(this, requestCode, resultCode,data);
	}

	@Override
	public void onNewIntent(Intent intent){
		super.onNewIntent(intent);
		FuncellGameSdkProxy.getInstance().onNewIntent(intent);
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (mLoginBtn == v) {
			doLogin();
		} else if (mPayBtn == v) {
			doPay();
		} else if (mLogoutBtn == v) {
			doLogout();
		} else if (mExitBtn == v) {
			doExit();
		}else if (mCreateRoleEventBtn == v) {
			CreatRoleEvent();
		}else if (mLoginEvevtBtn == v) {
			LoginEvent();
		}else if (mRoleLevelUpEventBtn == v) {
			RoleLevelUpEvent();
		}else if (mServerRoleEvevtBtn == v) {
			Server_RoleEvent();
//			getServerList();
//			getNoticeList();
		}
		
	}
	
	private void doPay(){
		FuncellRoleInfo roleInfo = new FuncellRoleInfo(); 
		roleInfo.setGameGoldBalance("888");
		roleInfo.setGameUnionName("游戏工会");
		roleInfo.setRoleId("123");
		roleInfo.setRoleLevel("2");
		roleInfo.setRoleName("test");
		roleInfo.setServerId("998");
		roleInfo.setServerName("天下");
		roleInfo.setVipLevel("3");
		
		FuncellPayParams PayParams = new FuncellPayParams();
		PayParams.setmExtrasParams("test"); //透传参数，支付成功后，返回给客户端的数据
		PayParams.setmItemAmount("99"); //商品价格，
		PayParams.setmItemCount(10);//钻石数量 ,10个元宝
		PayParams.setmItemDescription("商品描述");
//		PayParams.setmItemId("100002"); //商品ID
		PayParams.setmItemId("com.immoralconquest.fc.50"); //商品ID
		PayParams.setmItemName("10元宝"); //商品名
		PayParams.setmItemType("元宝"); //商品类型
		PayParams.setmCurrency("RMB");//货币设置
		PayParams.setmOrderId("游戏接入方订单号"); //游戏方订单号，若无则不传该参数或者不设置，该字段为支付成功后，返回的数据
		PayParams.setmRoleInfo(roleInfo);
		FuncellGameSdkProxy.getInstance().Pay(MainActivity.this, PayParams);
	}
	
	private void getServerList(){
		FuncellGameSdkProxy.getInstance().GetServerList(MainActivity.this, new IPlatformServerListCallBack(){

			@Override
			public void onFailure(String arg0) {
				// TODO Auto-generated method stub
				Log.e(TAG,"onFailure:"+arg0);
			}

			@Override
			public void onSuccess(String arg0) {
				// TODO Auto-generated method stub
				Log.e(TAG,"onSuccess:"+arg0);
			}
			
		});
	}
	
	private void getNoticeList(){
		FuncellGameSdkProxy.getInstance().GetNoticeList(MainActivity.this, new IPlatformNoticeListCallBack(){

			@Override
			public void onFailure(String arg0) {
				// TODO Auto-generated method stub
				Log.e(TAG,"onFailure:"+arg0);
			}

			@Override
			public void onSuccess(String arg0) {
				// TODO Auto-generated method stub
				Log.e(TAG,"onSuccess:"+arg0);
			}
			
		}, "activity");
	}
	
	private void doExit() {
		FuncellGameSdkProxy.getInstance().Exit(this, new IFuncellExitCallBack(){

			@Override
			public void onChannelExit() {
				// TODO Auto-generated method stub
				Log.e(TAG, "-------onChannelExit");
				/**
				 * 以下为demo演示，游戏接入时候，按照自己的需求进行
				 */
//				Toast.makeText(MainActivity.this, "渠道界面退出",Toast.LENGTH_LONG).show();
				finish();
				android.os.Process.killProcess(android.os.Process.myPid());
			}

			@Override
			public void onGameExit() {
				// TODO Auto-generated method stub
				Log.e(TAG, "-------onGameExit");
						AlertDialog.Builder builder = new Builder(
								MainActivity.this);
						builder.setTitle("游戏退出界面");
						builder.setPositiveButton("退出",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();

										/**** 退出逻辑需确保能够完全销毁游戏 ****/
										finish();
										android.os.Process
												.killProcess(android.os.Process
														.myPid());
										/**** 退出逻辑请根据游戏实际情况，勿照搬Demo ****/
									}
								});
						builder.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();
									}
								});

						dialog = builder.create();
				dialog.show();
			}
			
		});
	}
	
	private void doLogout() {
		FuncellGameSdkProxy.getInstance().Logout(MainActivity.this);
	}
	
	private void doLogin() {
		FuncellGameSdkProxy.getInstance().Login(MainActivity.this);
	}
	
	private void CreatRoleEvent(){
		if(mSession == null){
			Toast.makeText(MainActivity.this, "尚未登录，请登录", 0).show();
			return;
		}
		/**
		 * 收集不到的字段传空字符串
		 */
		ParamsContainer pc = new ParamsContainer();
	    pc.putString("usermark", mSession.getmUserID());
	    pc.putString("role_id", "123");
	    pc.putString("serverno", "998");
	    pc.putString("server_name", "天下");
	    pc.putString("role_name", "test");
	    
	    pc.putString("role_gamegold_balance", "游戏玩家金币余额"); //游戏金币，并非充值后的钻石数量
	    pc.putString("role_gameunion_name", "公会名字");
	    pc.putString("role_vip_level", "1");//VIP等级
	    pc.putString("role_level", "1"); //角色等级
	    pc.putString("role_creat_time", String.valueOf(System.currentTimeMillis()));//角色创建时间
	    pc.putString("role_upgrade_time", String.valueOf(System.currentTimeMillis())); //角色升级时间
	    
	    pc.putString("role_recharge_balance", "游戏玩家充值游戏币余额"); //充值后的游戏币余额(钻石、元宝等余额)
	    FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_CREATE_ROLE, pc); 
	}
	
	private void LoginEvent(){
		if(mSession == null){
			Toast.makeText(MainActivity.this, "尚未登录，请登录", 0).show();
			return;
		}
		ParamsContainer pc = new ParamsContainer();
		pc.putString("usermark", mSession.getmUserID());
		pc.putString("serverno", "998");
		FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_LOGIN, pc); 
	}
	

	private void RoleLevelUpEvent(){
		if(mSession == null){
			Toast.makeText(MainActivity.this, "尚未登录，请登录", 0).show();
			return;
		}
		ParamsContainer pc = new ParamsContainer();
		pc.putString("usermark", mSession.getmUserID());
		pc.putString("serverno", "998");
		pc.putString("role_level", "999");
		pc.putString("role_id", "123");
		pc.putString("role_name", "test");
		pc.putString("server_name","天下");
		
		pc.putString("role_gamegold_balance", "游戏玩家金币余额"); //游戏金币，并非充值后的钻石数量
	    pc.putString("role_gameunion_name", "公会名字");
	    pc.putString("role_vip_level", "1");//VIP等级
	    pc.putString("role_creat_time", String.valueOf(System.currentTimeMillis()));//角色创建时间
	    pc.putString("role_upgrade_time", String.valueOf(System.currentTimeMillis())); //角色升级时间
	    
	    pc.putString("role_recharge_balance", "游戏玩家充值游戏币余额"); //充值后的游戏币余额(钻石、元宝等余额)
		FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_ROLE_LEVELUP, pc);
		
		
	}
	
	private void Server_RoleEvent(){
		if(mSession == null){
			Toast.makeText(MainActivity.this, "尚未登录，请登录", 0).show();
			return;
		}
		ParamsContainer pc = new ParamsContainer();
		pc.putString("usermark", mSession.getmUserID());
		pc.putString("role_id", "123");
		pc.putString("role_level", "999");
		pc.putString("role_name", "test");
		pc.putString("role_gameunion_name", "工会");
		pc.putString("role_vip_level", "VIP等级");
		pc.putString("serverno", "998");
		pc.putString("server_name", "天下");
		pc.putString("role_gamegold_balance", "游戏玩家金币余额"); //游戏金币，并非充值后的钻石数量
	    pc.putString("role_creat_time", String.valueOf(System.currentTimeMillis()));//角色创建时间
	    pc.putString("role_upgrade_time", String.valueOf(System.currentTimeMillis())); //角色升级时间
	    
	    pc.putString("role_recharge_balance", "游戏玩家充值游戏币余额"); //充值后的游戏币余额(钻石、元宝等余额)
		FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_SERVER_ROLE_INFO, pc);
		
	}
	
	/**
	 * 扩展方法调用
	 * @return
	 */
	private Object callFunction(){
		return FuncellGameSdkProxy.getInstance().callFunction(MainActivity.this, "showFuncellAccount");
	} 
	
	private void analytics(){
		/**
		 * 以下统计均为三方SDK使用部分，如，appsflyer、facebook
		 */
		
		//appsflyer相关统计
		/**
		 * 登录的统计
		 */
		ParamsContainer paramsContainer1 = new ParamsContainer();
		paramsContainer1.put(FuncellAnalyticsEventKey.login, "aflogin"); //登录 eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.login, paramsContainer1);
		
		/**
		 * 充值成功的统计
		 */
		ParamsContainer paramsContainer2 = new ParamsContainer();
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_success, "afpurchase"); //充值 eventName
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_revenue, "revenue");
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_content_type, "content_type");
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_content_id, "content_id");
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_currency, "currency");
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.purchase_success, paramsContainer2);
		
		/**
		 * 新手引导完成统计
		 */
		ParamsContainer paramsContainer3 = new ParamsContainer();
		paramsContainer3.put(FuncellAnalyticsEventKey.tutorial_completed, "tutorial_completion"); //引导完成  eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.tutorial_completed, paramsContainer3);
		
		/**
		 * 角色升级统计
		 */
		ParamsContainer paramsContainer4 = new ParamsContainer();
		paramsContainer4.put(FuncellAnalyticsEventKey.level_achieved, "level_achieved"); //角色升级  eventName
		paramsContainer4.put(FuncellAnalyticsEventKey.level, "level");
		paramsContainer4.put(FuncellAnalyticsEventKey.level_score, "level_score");
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.level_achieved, paramsContainer4);
		
		/**
		 * 创建角色的统计
		 */
		ParamsContainer paramsContainer5 = new ParamsContainer();
		paramsContainer5.put(FuncellAnalyticsEventKey.create_role, "create_roleEventName");//创建角色 eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.create_role, paramsContainer5);
		
		//facebook相关统计
		/**
		 * 登录的统计
		 */
		ParamsContainer paramsContainer6 = new ParamsContainer();
		paramsContainer6.put(FuncellAnalyticsEventKey.login, "fb_mobile_complete_registration"); //登录 eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.login, paramsContainer6);
		
		/**
		 * 充值成功的统计
		 */
		ParamsContainer paramsContainer7 = new ParamsContainer();
		paramsContainer7.put(FuncellAnalyticsEventKey.purchase_revenue, "revenue");
		paramsContainer7.put(FuncellAnalyticsEventKey.purchase_currency, "currency");
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.purchase_success, paramsContainer7);
		
		/**
		 * 新手引导完成统计
		 */
		ParamsContainer paramsContainer8 = new ParamsContainer();
		paramsContainer8.put(FuncellAnalyticsEventKey.tutorial_completed, "tutorial_completion"); 
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.tutorial_completed, paramsContainer8);
		
		/**
		 * 角色升级统计
		 */
		ParamsContainer paramsContainer9 = new ParamsContainer();
		paramsContainer9.put(FuncellAnalyticsEventKey.level_achieved, "level_achieved");
		paramsContainer9.put(FuncellAnalyticsEventKey.level, "level"); 
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.level_achieved, paramsContainer9);
		
		/**
		 * 创建角色的统计
		 */
		ParamsContainer paramsContainer10 = new ParamsContainer();
		paramsContainer10.put(FuncellAnalyticsEventKey.create_role, "create_roleEventName"); 
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.create_role, paramsContainer10);
		
	}
	
	private void share(){
		/**
		 * 以下分享均为三方SDK使用部分，如，facebook、sharesdk...
		 */
		ParamsContainer paramsContainer = new ParamsContainer();
		paramsContainer.put(FuncellShareKey.title, "title");
		paramsContainer.put(FuncellShareKey.subtitle, "subtitle");
		paramsContainer.put(FuncellShareKey.description, "description");
		paramsContainer.put(FuncellShareKey.imageurl, "imageurl");
		paramsContainer.put(FuncellShareKey.contenturl, "contenturl");
		FuncellSDKShare.getInstance().share(FuncellShareChannelType.facebook, FuncellShareType.text, paramsContainer, new IFuncellShareCallBack(){

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				/**
				 * 分享取消
				 */
			}

			@Override
			public void onFailed(String arg0) {
				// TODO Auto-generated method stub
				/**
				 * 分享失败
				 */
			}

			@Override
			public void onSuccess(ParamsContainer arg0) {
				// TODO Auto-generated method stub
				/**
				 * 分享成功
				 */
			}
			
		});
	}
	
	private void like(){
		/**
		 * 点赞
		 */
		ParamsContainer paramsContainer = new ParamsContainer();
		paramsContainer.put(FuncellShareKey.likeurl, "likeurl");
		FuncellSDKShare.getInstance().callFunction(MainActivity.this, FuncellShareChannelType.facebook, "faceBookLike", paramsContainer.toString());
		
	}
	
	/**
	 * 显示客服系统
	 */
	private void showHelpShift(){
		FuncellSDKHelpShift.getInstance().showHelpShift(this);
	}
	
	private void shareFacebookByPhoto(){
		Bitmap photo = null;
		ParamsContainer paramsContainer = new ParamsContainer();
		
		paramsContainer.put(FuncellShareKey.image, photo);
		FuncellSDKShare.getInstance().share(FuncellShareChannelType.facebook, FuncellShareType.photo, paramsContainer, new IFuncellShareCallBack(){

			@Override
			public void onSuccess(ParamsContainer paramsContainer) {
				// TODO Auto-generated method stub
				String callbackType = paramsContainer.getString("callbackType"); //分享的类型回调. text:文本分享   photo:本地图片分享
			}

			@Override
			public void onCancel() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFailed(String paramString) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
}
