package com.haowan123.funcell.sdk.apiinterface;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Configuration;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.haowan123.funcell.sdk.ui.FunLoginActivity;
import com.haowan123.funcell.sdk.ui.FunSdkUiActivity;
import com.haowan123.funcell.sdk.util.FunFloatingTool;
import com.haowan123.funcell.sdk.util.FunLogStatsUtils;
import com.haowan123.funcell.sdk.util.FunLogStatsUtils.AtsLogTaskInfo;
import com.haowan123.funcell.sdk.util.FunLogStatsUtils.LogTaskInfo;
import com.reyun.sdk.TrackingIO;
import com.haowan123.funcell.sdk.util.HWFileUtils;
import com.haowan123.funcell.sdk.util.HWPreferences;
import com.haowan123.funcell.sdk.util.HWUtils;
import com.haowan123.funcell.sdk.util.FloatView;

/**
 * 瑞邦渠道，兼容ats和热云在lib之中
 * 
 * @author id4lin
 * 
 */
public class FunCellPlatformSdkApi {
	public String mAppId;
	public String mAppKey;
	private String reyunKey, channel;
	private boolean isAllowGuestLogin = false;
	private boolean isWindowMode = false;
	private boolean isLogin = false;
	private Activity mContext;
	private static FunCellPlatformSdkApi instance = null;
	// 是否是切换账号
	private boolean isSwitchUser;
	private String TAG = "FunCellPlatformSdkApi";

	public void setIsSwitchUser(boolean is) {
		isSwitchUser = is;
	}

	public boolean getIsSwitchUser() {
		return isSwitchUser;
	}

	/**
	 * 内部类，用于实现lzay机制
	 */
	private static class SingletonHolder {
		/** 单例变量 */
		private static FunCellPlatformSdkApi instance = new FunCellPlatformSdkApi();
	}

	/**
	 * 私有化的构造方法，保证外部的类不能通过构造器来实例化。
	 */
	private FunCellPlatformSdkApi() {

	}

	/**
	 * 获取单例对象 WwsPlatformSdkApi
	 * 
	 * @return WwsPlatformSdkApi
	 */
	public static FunCellPlatformSdkApi getInstance() {
		if (FunCellPlatformSdkApi.instance == null) {
			instance = new FunCellPlatformSdkApi();
		}
		return instance;
	}

	/**
	 * 初始化
	 * 
	 * @param context
	 * @param appId
	 *            [由平台方分配]
	 * @param appKey
	 *            [由平台方分配]
	 */
	public void init(final Activity context, final String appId, final String appKey, final InitCallBack initCallBack) {
		// TODO appCode设置、激活统计等
		if (null == context || null == appId || 0 == appId.trim().length() || null == appKey
				|| 0 == appKey.trim().length() || null == initCallBack) {
			HWUtils.logError("HWSDKLOG", "FuncellSDK init--> parameter error");
			return;
		}

		this.mContext = context;
		this.mAppId = appId;
		this.mAppKey = appKey;
		// 创建悬浮窗对象
		// 创建文件
		HWFileUtils.createHwAccountFile();
		// 读取
		readConfig();

		HWUtils.beginTime = HWUtils.getTimestamp();
		((Activity) context).runOnUiThread(new Runnable() {

			public void run() {

				initCallBack.initSuccess();

				LogTaskInfo logTaskInfo = new LogTaskInfo();
				logTaskInfo.setEventCode(LogTaskInfo.EVENT_CODE_DEVICE_ACTIVE);

				FunLogStatsUtils.submit(new FunLogStatsUtils.LogTaskRunnable(context, logTaskInfo));

				// cps--初始化有ats即为cps

				AtsLogTaskInfo atsLogTaskInfo = new AtsLogTaskInfo();
				atsLogTaskInfo.setMethod(AtsLogTaskInfo.ATS_METHOD_CPS);

				FunLogStatsUtils.submit(new FunLogStatsUtils.AtsLogTaskRunnable(context, atsLogTaskInfo));

				// 热云激活
				activeReyun(context);
			}
		});

	}

	public void readConfig() {

		try {

			AssetManager assets = mContext.getAssets();
			InputStream file = assets.open("funcellconfig.xml");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(file);
			Element root = document.getDocumentElement();
			NodeList items = root.getChildNodes();
			for (int i = 0; i < items.getLength(); i++) {
				if (items.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element item = (Element) items.item(i);
					if (item.getNodeName().equals("channel")) {// channel
						reyunKey = item.getAttribute("appKey");
						channel = item.getAttribute("channel_type");

					}
				}
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/**
	 * 热云激活
	 */
	private void activeReyun(Activity act) {
		HWUtils.logError(TAG, "****reyunKey:" + reyunKey + ",channel:" + channel);
		TrackingIO.initWithKeyAndChannelId(act, reyunKey, channel);// 激活

	}

	/**
	 * 登录接口
	 * 
	 * @param loginCallBack
	 */
	public void login(final LoginCallBack loginCallBack) {
		if (null == mContext) {

			HWUtils.logError("HWSDKLOG", "FuncellSDK login--> parameter error");
			return;
		}
		mContext.runOnUiThread(new Runnable() {

			public void run() {
				FunLoginActivity.setOnLoginCallBack(loginCallBack);
				Intent intent = new Intent(mContext, FunLoginActivity.class);
				mContext.startActivity(intent);

			}
		});
	}

	/**
	 * 登出接口
	 */
	public void logout(LogoutCallBack loginOutCallBack) {
		FunSdkUiActivity.setLogoutCallBack(loginOutCallBack);
	}

	/**
	 * 充值接口
	 * 
	 * @param context
	 * @param payInfo
	 *            [订单信息]
	 * @param rechargeCallBack
	 *            [充值回调]
	 */
	public void recharge(final FunPayInfo payInfo, final RechargeCallBack rechargeCallBack) {
		if (null == mContext) {

			HWUtils.logError("HWSDKLOG", "FuncellSDK pay--> parameter error");
			return;
		}
		mContext.runOnUiThread(new Runnable() {

			public void run() {

				FunSdkUiActivity.setRechargeCallBack(rechargeCallBack);
				Intent intent = new Intent(mContext, FunSdkUiActivity.class);
				intent.putExtra("funPayInfo", payInfo);
				intent.putExtra("fun_action", "pay");
				mContext.startActivity(intent);
			}
		});
	}

	/**
	 * 用户中心接口
	 */
	public void openUserCenter(Context context) {
		// Intent intent = new Intent(context,WwsSdkUiActivity.class);
		// intent.putExtra("fun_action", "usercenter");
		// context.startActivity(intent);
	}

	/**
	 * 显示浮动工具条
	 */
	public void showFuncellToolBar() {
		HWUtils.logError("HWSDKLOG", "****into--showFuncellToolBar");
		if (null == mContext || !isLogin) {
			return;
		}

		HWUtils.logError("HWSDKLOG", "****showFuncellToolBar");
		// mFloatView.show();

		/*
		 * mContext.runOnUiThread(new Runnable() {
		 * 
		 * public void run() { // TODO Auto-generated method stub
		 * FunFloatingTool.initFloatToolBar(mContext);
		 * 
		 * } });
		 */
	}

	/**
	 * 隐藏浮动工具条
	 */
	public void hideFuncellToolBar() {
		if (null == mContext) {
			return;
		}

		// mFloatView.hide();

		/*
		 * mContext.runOnUiThread(new Runnable() {
		 * 
		 * public void run() { FunFloatingTool.close(mContext);
		 * 
		 * } });
		 */
	}

	public boolean isAllowGuestLogin() {
		return isAllowGuestLogin;
	}

	/**
	 * 设置是否开启游客模式[开启:true,不开启:false],默认为不开启模式
	 * 
	 * @param isAllowGuestLogin
	 */
	public void setAllowGuestLogin(boolean isAllowGuestLogin) {
		this.isAllowGuestLogin = isAllowGuestLogin;
	}

	public boolean isWindowMode() {
		return isWindowMode;
	}

	/**
	 * 设置登录页面展示是否是窗口模式[true:窗口模式,false:全屏模式]
	 * 
	 * @param isWindowMode
	 */
	public void setWindowMode(boolean isWindowMode) {
		this.isWindowMode = isWindowMode;
	}

	public boolean isLogin() {
		return isLogin;
	}

	public void setLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public void onPause() {
		hideFuncellToolBar();
	}

	//
	/**
	 * 退出时关闭热云
	 */

	private void exitReyun() {
		TrackingIO.exitSdk();
	}

	public void onDestroy() {
		exitReyun();
		hideFuncellToolBar();
	}

	public void onResume() {
		showFuncellToolBar();
	}

	public void onConfigurationChanged(Configuration newConfig) {

	}

	/**
	 * cps,单接必须调用此方法
	 * 
	 * @param level
	 */
	public void funLevelUp(String level) {
		// cps levelup
		AtsLogTaskInfo atsLogTaskInfo = new AtsLogTaskInfo();
		atsLogTaskInfo.setMethod(AtsLogTaskInfo.ATS_METHOD_LEVEL_UP);
		atsLogTaskInfo.setLevel(level);

		String userAccount = HWPreferences.getData(mContext, "hw_account");
		atsLogTaskInfo.setIdentity(userAccount);

		FunLogStatsUtils.submit(new FunLogStatsUtils.AtsLogTaskRunnable(mContext, atsLogTaskInfo));

		HWUtils.logError("HWSDKLOG", "call funLevelUp over");
	}

	public void realNameAuthentication() {
		if (null == mContext) {

			HWUtils.logError("HWSDKLOG", "FuncellSDK real name authentication--> parameter error");
			return;
		}
		mContext.runOnUiThread(new Runnable() {

			public void run() {
				Intent intent = new Intent(mContext, FunSdkUiActivity.class);
				intent.putExtra("fun_action", "adult");
				mContext.startActivity(intent);
			}
		});
	}
}
