package com.haowan.funcell.common.sdk.api;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

public interface IThirdPlatform {
	/*
	 * 变量类型_变量名 
	 * 
	 */
	final public static String STRING_USER_NAME = "USER_NAME";//用户名
	final public static String STRING_ACCESS_TOKEN = "ACCESS_TOKEN";
	final public static String STRING_REFRESH_TOKEN = "REFRESH_TOKEN";
	final public static String INT_MONEY = "MONEY";
	final public static String SHORT_LS_ID = "LS_ID";
	final public static String SHORT_GS_ID = "GS_ID";
	final public static String LONG_Role_ID = "ROLE_ID";
	final public static String ORDER_STRING = "ORDER_STRING";
	final public static String PAY_ITEM_NUM = "PAY_ITEM_NUM";
	final public static String PAY_ITEM_STRING = "PAY_ITEM_STRING";//ITME ID
	final public static String PAY_ITEM_NMAE = "PAY_ITEM_NAME";
	final public static String STRING_EXT_DATA = "STRING_EXT_DATA";
	final public static String PAY_CALLBACK_URL = "PAY_CALLBACK_URL";
	final public static String PAY_PLATFORM_UID = "PAY_PLATFORM_UID";
	final public static String PAY_PLATFORM_ORDER = "PAY_PLATFORM_ORDER";//步步高支付、金立支付
	final public static String PAY_PLATFORM_SIGN = "PAY_PLATFORM_SIGN";//步步高支付
	final public static String PAY_PLATFORM_SUBMIT_TIME = "PAY_PLATFORM_SUBMIT_TIME";//金立支付
	final public static String PAY_PLATFORM_MULT_PAY_KEY = "PAY_PLATFORM_MULT_PAY_KEY";//多渠道支付key
	
	final public static int EXIT_TO_GAME_HAVE_UI_YES=1;//1：渠道有退出界面
	final public static int EXIT_TO_GAME_HAVE_UI_NO=0;//0:渠道无退出界面；
	
	public void doInit();
	
	public void doLogin();
	
	public void doPay(Bundle bundle);
	
	public void doCenter(int type, String mess);
	
	public int exitGame();//0:渠道无退出界面；1：渠道有退出界面
	
	public void doRegister();
	
	/**
	 * 注销
	 */
	public void GameToPlatformLogout();
	
	public void doBBS();
	
	public void doFeedback();
	
	public String getPlatFormName();
	
	public int getPlatFormId();
	
	public String getDownloadUrl();
	
	//统计界面的名字
	public void TotalUI( String uiname);
	
	public void showLogo();
	
	public void startCopyFiles();
	
	/**
	 * 防沉迷查询
	 * @param uid
	 * @param accessToken
	 */
	public void doAntiAddictionQuery(String uid,String accessToken);
	
	public void doSdkStatistics();
	
	public void doSdkNotifyZone();
	
	public void doLevelChange();
	
	public void doActivateStaticstics();
	
	public void doIntoGameStaticstics();
	
	public void doSdkOther(int type,String mess);
	
	
	public void onStart();

	
	public void onRestart();

	public void onResume();

	public void onPause();

	public void onStop();

	public void onBackPressed();

	public void onDestroy();
	
	/**
	 * 登录|充值回调
	 * @param requestCode
	 * @param resultCode
	 * @param data[回调data]
	 */
	public void onActivityResult(int requestCode, int resultCode, Intent data);
	
	public void onConfigurationChanged(Configuration newConfig);
    
    public void onSaveInstanceState(Bundle outState);
    
    public void onNewIntent(Intent intent);
    
    public void onRequestPermissionsResult(int requestCode,String[] permissions, int[] grantResults);
    
    public void doFacebookShare(String title, String subtitle,
			String description, String imageurl, String contenturl);
}
