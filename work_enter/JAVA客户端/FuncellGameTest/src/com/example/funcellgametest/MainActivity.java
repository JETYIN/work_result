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
				 * ��Ϸ��Ҫ���ص�¼����
				 */
			}

			@Override
			public void onSwitchAccount(FuncellSession session) {
				// TODO Auto-generated method stub
				/**
				 * �л��ʺŻص�(ʹ�ûص���Ϣ���е�¼��֤)
				 * �����������л��ʺŻص��У��������Ե�¼�ɹ��ص��� �ص���SDK
				 * ��˵��ӵ��ûص���Ϣʱ����Ҫ��֪ͨ��Ϸ�˻ص�¼��������е�ǰ��ɫ�л�
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
				 * ������ֵ�ɹ�����������Ϸ���������ˣ���֪��
				 * ���صĲ����������Ϸ���������Լ����߼������Բ��������ϲ���
				 */
				Log.e(TAG,"IFuncellPayCallBack onSuccess");
				Log.e(TAG,"cpOrder:"+cpOrder); //��Ϸ���Ķ�����
				Log.e(TAG,"sdkOrder:"+sdkOrder);//ƽ̨������
				Log.e(TAG,"extrasParams:"+extrasParams);//͸������
				
			}

			@Override
			public void onClosePayPage(String cpOrder, String sdkOrder, String extrasParams) {
				// TODO Auto-generated method stub
				/**
				 * ������ֵ�رս���
				 * ��������ĳЩSDK��֧����ʽ�У�������ҳ��ʽ����֧���������ֲ�����ȷ֧����״̬���ɹ���ʧ�ܣ�ȡ���ȣ�
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
		roleInfo.setGameUnionName("��Ϸ����");
		roleInfo.setRoleId("123");
		roleInfo.setRoleLevel("2");
		roleInfo.setRoleName("test");
		roleInfo.setServerId("998");
		roleInfo.setServerName("����");
		roleInfo.setVipLevel("3");
		
		FuncellPayParams PayParams = new FuncellPayParams();
		PayParams.setmExtrasParams("test"); //͸��������֧���ɹ��󣬷��ظ��ͻ��˵�����
		PayParams.setmItemAmount("99"); //��Ʒ�۸�
		PayParams.setmItemCount(10);//��ʯ���� ,10��Ԫ��
		PayParams.setmItemDescription("��Ʒ����");
//		PayParams.setmItemId("100002"); //��ƷID
		PayParams.setmItemId("com.immoralconquest.fc.50"); //��ƷID
		PayParams.setmItemName("10Ԫ��"); //��Ʒ��
		PayParams.setmItemType("Ԫ��"); //��Ʒ����
		PayParams.setmCurrency("RMB");//��������
		PayParams.setmOrderId("��Ϸ���뷽������"); //��Ϸ�������ţ������򲻴��ò������߲����ã����ֶ�Ϊ֧���ɹ��󣬷��ص�����
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
				 * ����Ϊdemo��ʾ����Ϸ����ʱ�򣬰����Լ����������
				 */
//				Toast.makeText(MainActivity.this, "���������˳�",Toast.LENGTH_LONG).show();
				finish();
				android.os.Process.killProcess(android.os.Process.myPid());
			}

			@Override
			public void onGameExit() {
				// TODO Auto-generated method stub
				Log.e(TAG, "-------onGameExit");
						AlertDialog.Builder builder = new Builder(
								MainActivity.this);
						builder.setTitle("��Ϸ�˳�����");
						builder.setPositiveButton("�˳�",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										dialog.dismiss();

										/**** �˳��߼���ȷ���ܹ���ȫ������Ϸ ****/
										finish();
										android.os.Process
												.killProcess(android.os.Process
														.myPid());
										/**** �˳��߼��������Ϸʵ����������հ�Demo ****/
									}
								});
						builder.setNegativeButton("ȡ��",
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
			Toast.makeText(MainActivity.this, "��δ��¼�����¼", 0).show();
			return;
		}
		/**
		 * �ռ��������ֶδ����ַ���
		 */
		ParamsContainer pc = new ParamsContainer();
	    pc.putString("usermark", mSession.getmUserID());
	    pc.putString("role_id", "123");
	    pc.putString("serverno", "998");
	    pc.putString("server_name", "����");
	    pc.putString("role_name", "test");
	    
	    pc.putString("role_gamegold_balance", "��Ϸ��ҽ�����"); //��Ϸ��ң����ǳ�ֵ�����ʯ����
	    pc.putString("role_gameunion_name", "��������");
	    pc.putString("role_vip_level", "1");//VIP�ȼ�
	    pc.putString("role_level", "1"); //��ɫ�ȼ�
	    pc.putString("role_creat_time", String.valueOf(System.currentTimeMillis()));//��ɫ����ʱ��
	    pc.putString("role_upgrade_time", String.valueOf(System.currentTimeMillis())); //��ɫ����ʱ��
	    
	    pc.putString("role_recharge_balance", "��Ϸ��ҳ�ֵ��Ϸ�����"); //��ֵ�����Ϸ�����(��ʯ��Ԫ�������)
	    FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_CREATE_ROLE, pc); 
	}
	
	private void LoginEvent(){
		if(mSession == null){
			Toast.makeText(MainActivity.this, "��δ��¼�����¼", 0).show();
			return;
		}
		ParamsContainer pc = new ParamsContainer();
		pc.putString("usermark", mSession.getmUserID());
		pc.putString("serverno", "998");
		FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_LOGIN, pc); 
	}
	

	private void RoleLevelUpEvent(){
		if(mSession == null){
			Toast.makeText(MainActivity.this, "��δ��¼�����¼", 0).show();
			return;
		}
		ParamsContainer pc = new ParamsContainer();
		pc.putString("usermark", mSession.getmUserID());
		pc.putString("serverno", "998");
		pc.putString("role_level", "999");
		pc.putString("role_id", "123");
		pc.putString("role_name", "test");
		pc.putString("server_name","����");
		
		pc.putString("role_gamegold_balance", "��Ϸ��ҽ�����"); //��Ϸ��ң����ǳ�ֵ�����ʯ����
	    pc.putString("role_gameunion_name", "��������");
	    pc.putString("role_vip_level", "1");//VIP�ȼ�
	    pc.putString("role_creat_time", String.valueOf(System.currentTimeMillis()));//��ɫ����ʱ��
	    pc.putString("role_upgrade_time", String.valueOf(System.currentTimeMillis())); //��ɫ����ʱ��
	    
	    pc.putString("role_recharge_balance", "��Ϸ��ҳ�ֵ��Ϸ�����"); //��ֵ�����Ϸ�����(��ʯ��Ԫ�������)
		FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_ROLE_LEVELUP, pc);
		
		
	}
	
	private void Server_RoleEvent(){
		if(mSession == null){
			Toast.makeText(MainActivity.this, "��δ��¼�����¼", 0).show();
			return;
		}
		ParamsContainer pc = new ParamsContainer();
		pc.putString("usermark", mSession.getmUserID());
		pc.putString("role_id", "123");
		pc.putString("role_level", "999");
		pc.putString("role_name", "test");
		pc.putString("role_gameunion_name", "����");
		pc.putString("role_vip_level", "VIP�ȼ�");
		pc.putString("serverno", "998");
		pc.putString("server_name", "����");
		pc.putString("role_gamegold_balance", "��Ϸ��ҽ�����"); //��Ϸ��ң����ǳ�ֵ�����ʯ����
	    pc.putString("role_creat_time", String.valueOf(System.currentTimeMillis()));//��ɫ����ʱ��
	    pc.putString("role_upgrade_time", String.valueOf(System.currentTimeMillis())); //��ɫ����ʱ��
	    
	    pc.putString("role_recharge_balance", "��Ϸ��ҳ�ֵ��Ϸ�����"); //��ֵ�����Ϸ�����(��ʯ��Ԫ�������)
		FuncellGameSdkProxy.getInstance().setDatas(MainActivity.this, FuncellDataTypes.DATA_SERVER_ROLE_INFO, pc);
		
	}
	
	/**
	 * ��չ��������
	 * @return
	 */
	private Object callFunction(){
		return FuncellGameSdkProxy.getInstance().callFunction(MainActivity.this, "showFuncellAccount");
	} 
	
	private void analytics(){
		/**
		 * ����ͳ�ƾ�Ϊ����SDKʹ�ò��֣��磬appsflyer��facebook
		 */
		
		//appsflyer���ͳ��
		/**
		 * ��¼��ͳ��
		 */
		ParamsContainer paramsContainer1 = new ParamsContainer();
		paramsContainer1.put(FuncellAnalyticsEventKey.login, "aflogin"); //��¼ eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.login, paramsContainer1);
		
		/**
		 * ��ֵ�ɹ���ͳ��
		 */
		ParamsContainer paramsContainer2 = new ParamsContainer();
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_success, "afpurchase"); //��ֵ eventName
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_revenue, "revenue");
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_content_type, "content_type");
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_content_id, "content_id");
		paramsContainer2.put(FuncellAnalyticsEventKey.purchase_currency, "currency");
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.purchase_success, paramsContainer2);
		
		/**
		 * �����������ͳ��
		 */
		ParamsContainer paramsContainer3 = new ParamsContainer();
		paramsContainer3.put(FuncellAnalyticsEventKey.tutorial_completed, "tutorial_completion"); //�������  eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.tutorial_completed, paramsContainer3);
		
		/**
		 * ��ɫ����ͳ��
		 */
		ParamsContainer paramsContainer4 = new ParamsContainer();
		paramsContainer4.put(FuncellAnalyticsEventKey.level_achieved, "level_achieved"); //��ɫ����  eventName
		paramsContainer4.put(FuncellAnalyticsEventKey.level, "level");
		paramsContainer4.put(FuncellAnalyticsEventKey.level_score, "level_score");
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.level_achieved, paramsContainer4);
		
		/**
		 * ������ɫ��ͳ��
		 */
		ParamsContainer paramsContainer5 = new ParamsContainer();
		paramsContainer5.put(FuncellAnalyticsEventKey.create_role, "create_roleEventName");//������ɫ eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.appsflyer, FuncellAnalyticsEventType.create_role, paramsContainer5);
		
		//facebook���ͳ��
		/**
		 * ��¼��ͳ��
		 */
		ParamsContainer paramsContainer6 = new ParamsContainer();
		paramsContainer6.put(FuncellAnalyticsEventKey.login, "fb_mobile_complete_registration"); //��¼ eventName
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.login, paramsContainer6);
		
		/**
		 * ��ֵ�ɹ���ͳ��
		 */
		ParamsContainer paramsContainer7 = new ParamsContainer();
		paramsContainer7.put(FuncellAnalyticsEventKey.purchase_revenue, "revenue");
		paramsContainer7.put(FuncellAnalyticsEventKey.purchase_currency, "currency");
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.purchase_success, paramsContainer7);
		
		/**
		 * �����������ͳ��
		 */
		ParamsContainer paramsContainer8 = new ParamsContainer();
		paramsContainer8.put(FuncellAnalyticsEventKey.tutorial_completed, "tutorial_completion"); 
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.tutorial_completed, paramsContainer8);
		
		/**
		 * ��ɫ����ͳ��
		 */
		ParamsContainer paramsContainer9 = new ParamsContainer();
		paramsContainer9.put(FuncellAnalyticsEventKey.level_achieved, "level_achieved");
		paramsContainer9.put(FuncellAnalyticsEventKey.level, "level"); 
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.level_achieved, paramsContainer9);
		
		/**
		 * ������ɫ��ͳ��
		 */
		ParamsContainer paramsContainer10 = new ParamsContainer();
		paramsContainer10.put(FuncellAnalyticsEventKey.create_role, "create_roleEventName"); 
		FuncellSDKAnalytics.getInstance().logEvent(FuncellAnalyticsType.facebook, FuncellAnalyticsEventType.create_role, paramsContainer10);
		
	}
	
	private void share(){
		/**
		 * ���·����Ϊ����SDKʹ�ò��֣��磬facebook��sharesdk...
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
				 * ����ȡ��
				 */
			}

			@Override
			public void onFailed(String arg0) {
				// TODO Auto-generated method stub
				/**
				 * ����ʧ��
				 */
			}

			@Override
			public void onSuccess(ParamsContainer arg0) {
				// TODO Auto-generated method stub
				/**
				 * ����ɹ�
				 */
			}
			
		});
	}
	
	private void like(){
		/**
		 * ����
		 */
		ParamsContainer paramsContainer = new ParamsContainer();
		paramsContainer.put(FuncellShareKey.likeurl, "likeurl");
		FuncellSDKShare.getInstance().callFunction(MainActivity.this, FuncellShareChannelType.facebook, "faceBookLike", paramsContainer.toString());
		
	}
	
	/**
	 * ��ʾ�ͷ�ϵͳ
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
				String callbackType = paramsContainer.getString("callbackType"); //��������ͻص�. text:�ı�����   photo:����ͼƬ����
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
