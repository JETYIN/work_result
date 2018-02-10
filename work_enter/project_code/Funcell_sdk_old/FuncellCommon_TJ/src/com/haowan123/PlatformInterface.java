package com.haowan123;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import android.provider.Settings;
import android.provider.Settings.Secure;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings.Secure;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.haowan.funcell.common.sdk.api.ChannelConfig;
import com.haowan.funcell.common.sdk.api.HttpUtils;
import com.haowan.funcell.common.sdk.api.HttpUtils.FuncellResponseCallback;
import com.haowan.funcell.common.sdk.api.IThirdOther;
import com.haowan.funcell.common.sdk.api.IThirdPlatform;
import com.haowan.funcell.common.sdk.api.Utils;
import com.haowan.funcell.common.sdk.api.WebActivity;
import com.haowan.funcell.common.sdk.api.volley.VolleyError;
import com.haowan.funcell.common.sdk.flume.HttpUtil;
import com.unity3d.player.UnityPlayer;

public class PlatformInterface {

	public static class STATISTICS {
		public static int mSetAreaInfo = 0x1;
		public static int mSetRoleInfo = 0x2;
		public static int mSetGameUnionName = 0x4;
		public static int mSetGameGoldBalance = 0x8;
		public static int mPDT_LEVEL_CHANGE = 0x10;
		public static int mPDT_TOTAL_CREATEROLE = 0x20;
		public static int mPDT_TOTAL_ENTERGAME = 0x40;
		public static int mPDT_WEBTOTAL = 0x80;
	}

	private static PlatForm_Current_GameInfo m_p_current_gameinfo = new PlatForm_Current_GameInfo();
	private static final String TAG = "PlatformInterface";
	public static final int ERROR_CODE_INIT_FAIL = 0;// 初始化失败
	public static final int ERROR_CODE_INIT_SUCCESS = 1;// 初始化成功
	public static final int ERROR_CODE_LOGIN_FAIL = 0;// 登陆失败
	public static final int ERROR_CODE_LOGIN_CANNCEL = 1;// 取消登录
	/**
	 * 统计地址
	 */
	private final static String TJ_URL = "http://gather-client-data.funcell123.com";
	// http://gather-client-data.funcell123.com 好玩使用
	// http://gather-client-data.raink.com.cn 雨墨使用

	private static Context sContext;

	private static IThirdPlatform sDoPlatform;

	private static IThirdOther thirdOtherInterface;

	private static String payToken, userKey, credentialType, pf, pfKey, appKey;

	private static String isNewUser = "old";

	/***************** 处理日志上传失败 *****************/
	/**
	 * 失败后上传的次数
	 */
	private static int count = 1;

	private final static int ONE = 1;

	private final static int TWO = 2;

	private final static int THREE = 3;

	private final static long Second_30 = 30 * 1000;

	private final static long Minute_3 = 3 * 60 * 1000;

	private final static long Minute_5 = 5 * 60 * 1000;

	private final static int TIME = 3;
	/***************** end *****************/
	// 日志统计内容
	private static Integer gameID;
	private static Integer platformID;
	private static String platform_type;
	private static String node;
	private static String appVersion;

	private static String CLIENT_ID = null;

	private static String eve = null;

	private static int statistic = 0;

	private static boolean bStatistic = false;

	private static String UID;

	private static JSONObject phoneJson;

	// private static String engineName = "unity"; //
	// 是否是unity,此标志对unity和cocos2d分别处理
	private static String engineName = "cocos2d"; // 是否是unity,此标志对unity和cocos2d分别处理

	public static final int DOMAIN_HOST_TYPE_DEFAULT = 0;
	public static final int DOMAIN_HOST_TYPE_TEST = 100;
	public static final int DOMAIN_HOST_TYPE_HANGUO = 1;
	public static final int DOMAIN_HOST_TYPE_YUENAN = 2;
	public static final int DOMAIN_HOST_TYPE_TAIWAN = 3;
	public static final int DOMAIN_HOST_TYPE_EFUN = 4;
	public static final int DOMAIN_HOST_TYPE_TAIWAN_EFUN = 5;
	public static final int DOMAIN_HOST_TYPE_JAN = 6;
	public static final int DOMAIN_HOST_TYPE_HANGUO_HXBNS = 7;
	public static final int DOMAIN_HOST_TYPE_XMT_HXBNS = 8;
	public static final int DOMAIN_HOST_TYPE_TAIGUO_LSM = 9;
	public static final int DOMAIN_HOST_TYPE_TAIGUO_HXBNS = 10;
	public static final int DOMAIN_HOST_TYPE_OUMEI_HXBNS = 11;
	// eve
	public static final int DOMAIN_HOST_TYPE_OUMEI_YUMO = 12;
	public static final int DOMAIN_HOST_TYPE_HANGUO_LSM = 13;
	public static final int DOMAIN_HOST_TYPE_YUENAN_LSM = 14;
	public static final int DOMAIN_HOST_TYPE_TAIWAN_LSM = 15;
	public static final int DOMAIN_HOST_TYPE_YUENAN_HXBNS = 16;
	public static final int DOMAIN_HOST_TYPE_ELUOSI_HXBNS = 17;

	// 大圣evetype
	public static final int DOMAIN_HOST_TYPE_DASHENG_HW = 18;

	public static enum MultPay {
		joycell, google, appstore, vstargame;
	}

	private static int talkingdata_status = 0 << 0, crash_status = 0 << 1, push = 0 << 2, THIRDSDK_STATUS = 0; // 通过该值判断接入了哪些三方统计SDK

	public static final String PAY_CALLBACK_SUCCESS_NO = "PAY_CALLBACK_SUCCESS_NO";// 当无充值成功回调的时候使用

	/**
	 * 发现服务地址
	 */
	// 台湾EFUN
	private static final String DOMAIN_HOST_TAIWAN_EFUN = "http://tw-efun-eve.joy-cell.com/config/";
	private static final String DOMAIN_HOST_BACK_TAIWAN_EFUN = "http://tw-efun-eve.joy-cell.com/config/";
	// 台湾
	private static final String DOMAIN_HOST_TAIWAN = "http://tw-eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_TAIWAN = "http://tw-eve.funcell123.com/config/";
	// 国内地址
	public static final String DOMAIN_HOST_DEFAULT = "http://eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_DEFAULT = "http://eve.haowan123.com/config/";
	// 测试地址
	public static final String DOMAIN_HOST_TEST = "http://eve-beta.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_TEST = "http://eve-beta.funcell123.com/config/";

	/** notice针对大圣eve **/
	private static final String DOMAIN_HOST_DASHENG_DEFAULT = "http://eve-2.funcell123.com/config/";
	private static final String DOMAIN_HOST_DASHENG_STANDBY = "http://eve-3.funcell123.com/config/";

	// 韩国地址
	private static final String DOMAIN_HOST_HANGUO = "http://xsm-korea-eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_HANGUO = "http://xsm-korea-eve.funcell123.com/config/";

	// 幻想-韩国地址
	private static final String DOMAIN_HOST_HANGUO_HXBNS = "http://korea.hxbns.eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_HANGUO_HXBNS = "http://korea.hxbns.eve.funcell123.com/config/";

	// 幻想-新马泰地址
	private static final String DOMAIN_HOST_XMT_HXBNS = "http://xmt.hxbns.eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_XMT_HXBNS = "http://xmt.hxbns.eve.funcell123.com/config/";

	// 幻想-泰国地址
	private static final String DOMAIN_HOST_TAIGUO_HXBNS = "http://thailand.hxbns.eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_TAIGUO_HXBNS = "http://thailand.hxbns.eve.funcell123.com/config/";

	// 幻想-欧美地址
	private static final String DOMAIN_HOST_OUMEI_HXBNS = "http://abroad.eve.federation.raink.com.cn/config/";
	private static final String DOMAIN_HOST_BACK_OUMEI_HXBNS = "http://abroad.eve.federation.raink.com.cn/config/";

	// 幻想-俄罗斯地址
	private static final String DOMAIN_HOST_ELUOSI_HXBNS = "http://tw-efun-eve.joy-cell.com/config/";
	private static final String DOMAIN_HOST_BACK_ELUOSI_HXBNS = "http://tw-efun-eve.joy-cell.com/config/";

	// 泰国六扇门
	private static final String DOMAIN_HOST_TAIGUO_LSM = "http://thailand.lsm.eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_BACK_TAIGUO_LSM = "http://thailand.lsm.eve.funcell123.com/config/";

	// 越南地址
	private static final String DOMAIN_HOST_YUENAN = "http://xsm-vietnam-eve.funcell123.com/config/";
	private static final String DOMAIN_HOST_EFUN = "http://xsm-singapore-eve.funcell123.com/config/";

	// 越南六扇门地址
	private static final String DOMAIN_HOST_YUENAN_LSM = "http://vietnam.lsm.eve.raink.com.cn/config/";
	private static final String DOMAIN_HOST_BACK_YUENAN_LSM = "http://vietnam.lsm.eve.raink.com.cn/config/";

	// 日本地址
	private static final String DOMAIN_HOST_JAN = "http://japan.hxbns.eve.funcell123.com/config/";

	// 韩国六扇门
	private static final String DOMAIN_HOST_HANGUO_LSM = "http://korea.lsm.eve.raink.com.cn/config/";
	private static final String DOMAIN_HOST_BACK_HANGUO_LSM = "http://korea.lsm.eve.raink.com.cn/config/";

	// 台湾六扇门
	private static final String DOMAIN_HOST_TAIWAN_LSM = "http://tw.lsm.eve.raink.com.cn/config/";
	private static final String DOMAIN_HOST_BACK_TAIWAN_LSM = "http://tw.lsm.eve.raink.com.cn/config/";

	// 越南幻想
	private static final String DOMAIN_HOST_YUENAN_HXBNS = "http://vietnam.hxbns.eve.raink.com.cn/config/";
	private static final String DOMAIN_HOST_BACK_YUENAN_HXBNS = "http://vietnam.hxbns.eve.raink.com.cn/config/";

	// 雨墨eve地址 https://mainaland-eve.raink.com.cn/config/
	private static final String DOMAIN_HOST_YUMO = "https://mainland-eve.raink.com.cn/config/";
	private static final String DOMAIN_HOST_EFUN_YUMO = "https://mainland-eve.raink.com.cn/config/";
	// private static final String DOMAIN_HOST_EFUN_YUMO =
	// "https://mainaland.eve.raink.com.cn/config/";

	private static String DOMAIN_HOST = DOMAIN_HOST_DEFAULT;
	private static String DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_DEFAULT;

	public static String getDomainHost() {
		return DOMAIN_HOST;
	}

	public static enum Area {
		China("China"), Taiwan("Taiwan"), Thailand("Thailand"), Korea("Korea"), Malaysia("Malaysia"), Europe(
				"Europe"), Russia("Russia"), Vietnam("Vietnam"), Japan("Japan");
		private final String name;

		private Area(String str) {
			name = str;
		}

		public boolean equalsName(String otherName) {
			return otherName == null ? false : name.equals(otherName);
		}

		public String toString() {
			return this.name;
		}
	}

	public static Area area = Area.China;

	public static void setDomainHost(int domainHostType) {

		if (isTest) {
			DOMAIN_HOST = DOMAIN_HOST_TEST;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_TEST;
			area = Area.China;
			return;
		}

		switch (domainHostType) {
		case DOMAIN_HOST_TYPE_DEFAULT:// china
			DOMAIN_HOST = DOMAIN_HOST_DEFAULT;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_DEFAULT;
			// area = "China";
			area = Area.China;
			break;
		case DOMAIN_HOST_TYPE_TEST:// china test
			DOMAIN_HOST = DOMAIN_HOST_TEST;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_TEST;
			// area = "China";
			area = Area.China;
			break;
		case DOMAIN_HOST_TYPE_HANGUO:// 韩国
			DOMAIN_HOST = DOMAIN_HOST_HANGUO;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_HANGUO;
			// area = "Korea";
			area = Area.Korea;
			break;
		case DOMAIN_HOST_TYPE_YUENAN:// 越南
			DOMAIN_HOST = DOMAIN_HOST_YUENAN;
			DOMAIN_HOST_BACK = DOMAIN_HOST_YUENAN;
			// area = "Vietnam";
			area = Area.Vietnam;
			break;
		case DOMAIN_HOST_TYPE_TAIWAN:// 台湾
			DOMAIN_HOST = DOMAIN_HOST_TAIWAN;
			DOMAIN_HOST_BACK = DOMAIN_HOST_TAIWAN;
			// area = "Taiwan";
			area = Area.Taiwan;
			break;
		case DOMAIN_HOST_TYPE_EFUN:// 台湾
			DOMAIN_HOST = DOMAIN_HOST_EFUN;
			DOMAIN_HOST_BACK = DOMAIN_HOST_EFUN;
			// area = "Taiwan";
			area = Area.Taiwan;
			break;
		case DOMAIN_HOST_TYPE_TAIWAN_EFUN:// 台湾
			DOMAIN_HOST = DOMAIN_HOST_TAIWAN_EFUN;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_TAIWAN_EFUN;
			// area = "Taiwan";
			area = Area.Taiwan;
			break;
		case DOMAIN_HOST_TYPE_JAN:// 日本
			DOMAIN_HOST = DOMAIN_HOST_JAN;
			DOMAIN_HOST_BACK = DOMAIN_HOST_JAN;
			// area = "Japan";
			area = Area.Japan;
			break;
		case DOMAIN_HOST_TYPE_HANGUO_HXBNS:// 韩国
			DOMAIN_HOST = DOMAIN_HOST_HANGUO_HXBNS;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_HANGUO_HXBNS;
			// area = "Korea";
			area = Area.Korea;
			break;
		case DOMAIN_HOST_TYPE_XMT_HXBNS:// 新马泰
			DOMAIN_HOST = DOMAIN_HOST_XMT_HXBNS;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_XMT_HXBNS;
			// area = "Malaysia";
			area = Area.Malaysia;
			break;
		case DOMAIN_HOST_TYPE_TAIGUO_LSM:// 泰国
			DOMAIN_HOST = DOMAIN_HOST_TAIGUO_LSM;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_TAIGUO_LSM;
			// area = "Thailand";
			area = Area.Thailand;
			break;
		case DOMAIN_HOST_TYPE_TAIGUO_HXBNS:// 泰国
			DOMAIN_HOST = DOMAIN_HOST_TAIGUO_HXBNS;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_TAIGUO_HXBNS;
			// area = "Thailand";
			area = Area.Thailand;
			break;
		case DOMAIN_HOST_TYPE_OUMEI_HXBNS:// 欧美
			DOMAIN_HOST = DOMAIN_HOST_OUMEI_HXBNS;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_OUMEI_HXBNS;
			// area = "Europe";
			area = Area.Europe;
			break;
		case DOMAIN_HOST_TYPE_OUMEI_YUMO:// 雨墨
			DOMAIN_HOST = DOMAIN_HOST_YUMO;
			DOMAIN_HOST_BACK = DOMAIN_HOST_EFUN_YUMO;
			// area = "China";
			area = Area.China;
			break;
		case DOMAIN_HOST_TYPE_HANGUO_LSM:// 韩国
			DOMAIN_HOST = DOMAIN_HOST_HANGUO_LSM;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_HANGUO_LSM;
			// area = "Korea";
			area = Area.Korea;
			break;
		case DOMAIN_HOST_TYPE_YUENAN_LSM:// 越南
			DOMAIN_HOST = DOMAIN_HOST_YUENAN_LSM;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_YUENAN_LSM;
			// area = "Vietnam";
			area = Area.Vietnam;
			break;
		case DOMAIN_HOST_TYPE_TAIWAN_LSM:// 台湾
			DOMAIN_HOST = DOMAIN_HOST_TAIWAN_LSM;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_TAIWAN_LSM;
			// area = "Taiwan";
			area = Area.Taiwan;
			break;
		case DOMAIN_HOST_TYPE_YUENAN_HXBNS:// 越南
			DOMAIN_HOST = DOMAIN_HOST_YUENAN_HXBNS;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_YUENAN_HXBNS;
			// area = "Vietnam";
			area = Area.Vietnam;
			break;
		case DOMAIN_HOST_TYPE_ELUOSI_HXBNS:// 俄罗斯
			DOMAIN_HOST = DOMAIN_HOST_ELUOSI_HXBNS;
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_ELUOSI_HXBNS;
			// area = "Russia";
			area = Area.Russia;
			break;
		case DOMAIN_HOST_TYPE_DASHENG_HW:// 大圣特殊地址
			DOMAIN_HOST = DOMAIN_HOST_DASHENG_DEFAULT;// china
			DOMAIN_HOST_BACK = DOMAIN_HOST_DASHENG_STANDBY;
			area = Area.China;
			break;
		default:
			DOMAIN_HOST = DOMAIN_HOST_DEFAULT;// china
			DOMAIN_HOST_BACK = DOMAIN_HOST_BACK_DEFAULT;
			// area = "China";
			area = Area.China;
			break;
		}
	}

	// game content view
	private static FrameLayout sFrameLayout;

	private static View sPublicView;

	private static boolean isInitSuccessed = false;
	private static boolean isLogining = false;// 判断是否在登录流程，登录流程如果初始化失败会做初始化处理，处理方式和未登录不一样。

	public static void setEngineName(String name) {
		engineName = name;
	}

	public static String getEngineName() {
		return engineName;
	}

	public static interface InitPlatformCallback {
		void initSuccess();

		void initFailure();
	}

	public static InitPlatformCallback mInitPlatformCallback;

	public static void setInitPlatformCallback(InitPlatformCallback initPlatformCallback) {
		mInitPlatformCallback = initPlatformCallback;
	}

	// java-c/c# java回调c或者回调c#,针对cocos或者unity
	private static void sendU3dMessage(String messageName, JSONObject json) {
		if (json != null)
			UnityPlayer.UnitySendMessage("SDK_Object", messageName, json.toString());
		else
			UnityPlayer.UnitySendMessage("SDK_Object", messageName, "");
	}

	private static void startGameUnity(String token, String userName, String uid, String sessionid) {
		try {
			JSONObject jdata = new JSONObject();
			jdata.put("username", userName);
			jdata.put("userID", uid);
			jdata.put("sessionID", sessionid);
			jdata.put("token", token);

			sendU3dMessage("LoginSuccess", jdata);
		} catch (Throwable e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage(), e);
		}
	}

	public static void startGameNormal(String token, String userName, String uid, String sessionid) {
		if (engineName.equals("unity")) {
			startGameUnity(token, userName, uid, sessionid);
		} else if (engineName.equals("cocos")) {
			startGame(token, userName, uid, sessionid);
		}
	}

	private static void exitGameCallbackUnity(int state) {

	}

	public static void exitGameCallbackNormal(int state) // 暂时未用到此回调
	{
		if (engineName.equals("unity")) {
			exitGameCallbackUnity(state);
		} else if (engineName.equals("cocos")) {
			exitGameCallback(state);
		}
	}

	private static void PlatformToGameLogoutUnity()// 登出函数
	{
		sendU3dMessage("PlatformToGameLogout", null);
	}

	public static void PlatformToGameLogoutNormal()// 登出函数
	{
		if (engineName.equals("unity")) {
			PlatformToGameLogoutUnity();
		} else if (engineName.equals("cocos")) {
			PlatformToGameLogout();
		}
	}

	private static void LoginCancelUnity(int errorCode)// 添加平台被取消登录调用的接口 0:失败
														// 1:取消
	{
		try {
			JSONObject jdata = new JSONObject();
			jdata.put("type", "" + errorCode);
			sendU3dMessage("LoginCancel", jdata);

		} catch (Throwable e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage(), e);
		}
	}

	public static void LoginCancelNormal(int errorCode)// 添加平台被取消登录调用的接口 0:失败
														// 1:取消
	{
		if (engineName.equals("unity")) {
			LoginCancelUnity(errorCode);
		} else if (engineName.equals("cocos")) {
			LoginCancel(errorCode);
		}

	}

	public static JSONObject getPhoneInfoJson() {
		phoneJson = new JSONObject();
		try {
			phoneJson.put("mo", Utils.getPhoneModel());// 终端机型
			phoneJson.put("sy", "anzhuo");// 系统
			phoneJson.put("ID", Utils.getAndroid_ID(sContext));// 终端唯一标识
			phoneJson.put("ve", Utils.getPhoneVersion());// 终端系统版本
			phoneJson.put("cpu", Utils.getCPU());// cpu
			phoneJson.put("me", Utils.getRAM(sContext));// 终端内存
			phoneJson.put("re", Utils.getScreenPiexl(sContext));// 分辨率
			phoneJson.put("ne", Utils.getNetType(sContext));// 联网方式
			phoneJson.put("op", Utils.setLogToBiEncoder(Utils.getMobileServiceProvider(sContext)));// 运营商
		} catch (JSONException e) {
			Log.e(TAG, "--------ERROR-----" + e.toString());
			e.printStackTrace();
		}
		return phoneJson;

	}

	// 获取登录成功获取的uid

	public static String getUID() {
		if (UID == null || UID.length() <= 0) {
			throw new IllegalStateException("登录成功才能获取UID");
		}
		return UID;
	}

	public static String getGsId()// 服务器ＩＤ值
	{
		if (m_p_current_gameinfo.m_areaID == null || m_p_current_gameinfo.m_areaID.length() == 0)
			throw new IllegalStateException("setAreaInfo必须先调用");
		return m_p_current_gameinfo.m_areaID;
	}

	public static int GetLevel()// 得到角色等级
	{
		if (m_p_current_gameinfo.m_roleLevel == -1)
			throw new IllegalStateException("DealMessage(PDT_LEVEL_CHANGE)必须先调用");
		return m_p_current_gameinfo.m_roleLevel;
	}

	public static String GetRoleID()// 游戏角色ID
	{
		if (m_p_current_gameinfo.m_roleID == null || m_p_current_gameinfo.m_roleID.length() == 0)
			throw new IllegalStateException("setRoleInfo必须先调用");
		return m_p_current_gameinfo.m_roleID;
	}

	public static long getRoleLevelupTime() {// 角色升级时间
		if (m_p_current_gameinfo.m_roleLevelupTime == -1) {
			throw new IllegalStateException("SetRoleLevelupTime必须先调用");
		}
		return m_p_current_gameinfo.m_roleLevelupTime;
	}

	public static String GetZoneName()// 区服名字
	{
		if (m_p_current_gameinfo.m_areaName == null || m_p_current_gameinfo.m_areaName.length() == 0)
			throw new IllegalStateException("setAreaInfo必须先调用");
		return m_p_current_gameinfo.m_areaName;
	}

	public static String GetRoleName()// 得到角色名字
	{
		if (m_p_current_gameinfo.m_roleName == null || m_p_current_gameinfo.m_roleName.length() == 0)
			throw new IllegalStateException("SetRoleInfo必须先调用");
		return m_p_current_gameinfo.m_roleName;
	}

	public static long GetRoleCreatTime()// 得到角色创建时间
	{
		if (m_p_current_gameinfo.m_roleCreatTime == -1)
			throw new IllegalStateException("SetRoleInfo必须先调用");
		return m_p_current_gameinfo.m_roleCreatTime;
	}

	public static String GetGameUnionName()// 得到游戏公会名
	{
		// if (m_p_current_gameinfo.m_gameUnionName == null
		// || m_p_current_gameinfo.m_gameUnionName.length() == 0)
		// throw new IllegalStateException("SetGameUnionName必须先调用");
		return m_p_current_gameinfo.m_gameUnionName;
	}

	public static int GetGameGoldBalance()// 得到游戏玩家金币余额
	{
		if (m_p_current_gameinfo.m_gameGoldBalance == -1)
			throw new IllegalStateException("SetGameGoldBalance必须先调用");
		return m_p_current_gameinfo.m_gameGoldBalance;
	}

	public static int GetRolePower() { // 获取角色战斗力值
		if (m_p_current_gameinfo.m_rolePower == -1)
			throw new IllegalStateException("SetRoleInfo必须先调用");
		return m_p_current_gameinfo.m_rolePower;
	}

	public static int GetRoleGold() { // 获取角色钻石、元宝值
		if (m_p_current_gameinfo.m_roleGold == -1)
			throw new IllegalStateException("SetRoleInfo必须先调用");
		return m_p_current_gameinfo.m_roleGold;
	}

	public static String GetRoleProfession() { // 获取角色职业
		if (m_p_current_gameinfo.m_profession == null || m_p_current_gameinfo.m_profession.length() == 0)
			throw new IllegalStateException("SetRoleInfo必须先调用");
		return m_p_current_gameinfo.m_profession;
	}

	public static void SetAreaInfo(String areaID, String areaName) {
		Log.e("PlatformInterface", "SetAreaInfo已调用!");
		m_p_current_gameinfo.m_areaID = areaID;
		m_p_current_gameinfo.m_areaName = areaName;
		statistic |= STATISTICS.mSetAreaInfo;
	}

	public static void SetRoleInfo(String roleName, String roleID) {
		Log.e("PlatformInterface", "SetRoleInfo已调用!");
		m_p_current_gameinfo.m_roleName = roleName;
		m_p_current_gameinfo.m_roleID = roleID;
		statistic |= STATISTICS.mSetRoleInfo;
	}

	public static void SetRoleLevelupTime(long levelupTime) {
		Log.e("PlatformInterface", "SetRoleLevelupTime已调用!");
		m_p_current_gameinfo.m_roleLevelupTime = levelupTime;
	}

	public static void SetRoleInfo(String roleName, String roleID, String profession, int rolePower, int roleGold) {
		Log.e("PlatformInterface", "SetRoleInfo已调用!");
		m_p_current_gameinfo.m_roleName = roleName;
		m_p_current_gameinfo.m_roleID = roleID;
		m_p_current_gameinfo.m_profession = profession;
		m_p_current_gameinfo.m_rolePower = rolePower;
		m_p_current_gameinfo.m_roleGold = roleGold;
		statistic |= STATISTICS.mSetRoleInfo;
	}

	// 添加设置vip信息
	public static void setVipLevel(int vip) {
		Log.e(TAG, "****invoke--setVipLevel,vip:" + vip);
		m_p_current_gameinfo.m_vip = vip;
	}

	public static int getVipLevel() {

		if (m_p_current_gameinfo.m_vip == -1) {
			Log.e(TAG, "****vip level is -1");
			return 1;
		}
		return m_p_current_gameinfo.m_vip;
	}

	public static void SetRoleInfo(String roleName, String roleID, String profession, int rolePower, int roleGold,
			long roleCreatTime) {
		Log.e("PlatformInterface", "SetRoleInfo已调用!");
		Log.i(TAG, roleName);
		Log.i(TAG, roleID);
		Log.i(TAG, profession);
		Log.i(TAG, rolePower + "");
		Log.i(TAG, roleGold + "");
		Log.i(TAG, roleCreatTime + "");
		m_p_current_gameinfo.m_roleName = roleName;
		m_p_current_gameinfo.m_roleID = roleID;
		m_p_current_gameinfo.m_roleCreatTime = roleCreatTime;
		m_p_current_gameinfo.m_profession = profession;
		m_p_current_gameinfo.m_rolePower = rolePower;
		m_p_current_gameinfo.m_roleGold = roleGold;
		statistic |= STATISTICS.mSetRoleInfo;

		// HttpUtil.send(arg0, arg1);
	}

	public static void SetGameUnionName(String name) {
		Log.e("PlatformInterface", "SetGameUnionName已调用!");
		m_p_current_gameinfo.m_gameUnionName = name;
		statistic |= STATISTICS.mSetGameUnionName;
	}

	public static void SetGameGoldBalance(int gold) {
		Log.e("PlatformInterface", "SetGameGoldBalance已调用!");
		m_p_current_gameinfo.m_gameGoldBalance = gold;
		statistic |= STATISTICS.mSetGameGoldBalance;
	}

	public static void onDestroy() {
		checkStastics();
	}

	private static void checkStastics() { // 统计位目前只有8位，全部统计完成则为0xff

		if (bStatistic) {
			if (statistic != 0xff) {
				Log.e("PlatformInterface", "统计接口未调用完全，请参照文档接入统计接口，否则渠道审核会通不过！statistic:" + statistic);
				if (sContext != null) {
					((Activity) sContext).runOnUiThread(new Runnable() {

						@Override
						public void run() {
							// TODO Auto-generated method stub
							AlertDialog dialog1 = new AlertDialog.Builder(sContext).setTitle("Error")
									.setMessage("统计接口未调用完全，请参照文档接入统计接口，否则渠道审核会通不过！")
									.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
										public void onClick(DialogInterface dialog, int whichButton) {
										}
									}).create();
							dialog1.show();
						}
					});
				}
				throw new IllegalStateException("统计接口未调用完全，请参照文档接入统计接口，否则渠道审核会通不过！");
			} else {
				Log.i("PlatformInterface", "统计接口已接入完全！statistic:" + statistic);
			}
		} else {
			Log.i("PlatformInterface", "checkStastics功能已关闭");
		}
	}

	private static void payCallbackUnity(String billNo, String accessToken) {
		try {
			JSONObject jdata = new JSONObject();
			jdata.put("billNo", billNo);
			jdata.put("accessToken", accessToken);
			sendU3dMessage("payCallback", jdata);

		} catch (Throwable e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage(), e);
		}
	}

	/**
	 * 语音
	 * 
	 * @param msg
	 */
	public static void translateVoiveCallbackUnity(String msg) {
		try {
			JSONObject json = new JSONObject();
			json.put("voiceMsg", msg);
			sendU3dMessage("voiceCallback", json);
		} catch (Throwable e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage(), e);
		}
	}

	public static void payCallbackNormal(String billNo, String accessToken) {
		if (engineName.equals("unity")) {
			payCallbackUnity(billNo, accessToken);
		} else if (engineName.equals("cocos")) {
			payCallback(billNo, accessToken);
		}
	}

	private static void getPayListCallbackUnity(String payListResult) {
		try {
			JSONObject jdata = new JSONObject();
			jdata.put("payListResult", payListResult);
			sendU3dMessage("getPayListCallback", jdata);

		} catch (Throwable e) {
			e.printStackTrace();
			Log.e(TAG, e.getMessage(), e);
		}
	}

	public static void getPayListCallbackNormal(String payListResult) {
		if (engineName.equals("unity")) {
			getPayListCallbackUnity(payListResult);
		} else if (engineName.equals("cocos")) {
			getPayListCallback(payListResult);
		}
	}

	/****************************************************************************
	 * JNI JAVA-C
	 ****************************************************************************/
	/**
	 * 登录成功通知游戏的回调
	 */
	private static native void startGame(String token, String userName, String uid, String sessionid);

	// 反馈是否有第三方渠道的退出界面，如果没有，需要游戏自己处理退出流程，否则走第三方渠道退出流程
	private static native void exitGameCallback(int state); // state
															// 0表示渠道无退出，需游戏自己界面退出；1表示渠道有退出界面退出，游戏自身不弹出界面。

	private static native void PlatformToGameLogout();// 登出函数

	private static native void LoginCancel(int errorCode);// 添加平台被取消登录调用的接口 0:失败
															// 1:取消

	private static native void payCallback(String billNo, String accessToken);

	private static native void getPayListCallback(String payListResult);

	// public static native void initSdkCallback(int code); // 初始化回调 0:失败 1:成功

	/****************************************************************************
	 * NDK C-JAVA
	 ****************************************************************************/

	/**
	 * 获取发现服务（json字符串）
	 * 
	 * @return
	 */
	public static String getEveData() {
		return null == eve ? "" : eve;
	}

	/**
	 * 
	 * @param path
	 * @param targetPath
	 * @return
	 */
	public static int copy(String path, String targetPath) {
		try {
			InputStream inputStream = sContext.getAssets().open(path);

			FileOutputStream outputStream = new FileOutputStream(targetPath);

			int len = 0;
			byte[] buffer = new byte[3072];

			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}

			outputStream.close();
			inputStream.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}

		return 0;
	}

	public static void setupAPK(final String path) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
		sContext.startActivity(intent);
	}

	public static void osSendMessage(String msg) {
		// 如果没有电话号码是不能发送短信的
		if (Utils.getMobileServiceProvider(sContext).compareToIgnoreCase("无") == 0)
			return;

		try {
			Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"));
			intent.putExtra("sms_body", msg);
			sContext.startActivity(intent);
		} catch (Exception e) {

		}
	}

	static PlatformConfig m_platformConfig = new PlatformConfig();
	private static boolean isTest = false;

	// readConfig将打包到渠道包中xml文件的配置信息读取出来
	private static void readConfig() {

		try {

			AssetManager assets = sContext.getAssets();
			InputStream file = assets.open("funcellconfig.xml");

			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			org.w3c.dom.Document document = builder.parse(file);
			Element root = document.getDocumentElement();
			NodeList items = root.getChildNodes();
			for (int i = 0; i < items.getLength(); i++) {
				if (items.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element item = (Element) items.item(i);
					if (item.getNodeName().equals("platform")) {// platform
						gameID = Integer.valueOf(Integer.parseInt(item.getAttribute("gameId")));
						node = item.getAttribute("datacenter");
						appVersion = item.getAttribute("appVersion");
						platformID = Integer.valueOf(Integer.parseInt(item.getAttribute("platformId")));
						platform_type = item.getAttribute("platformType");
						try {
							isTest = null != item.getAttribute("isTest") && "true".equals(item.getAttribute("isTest"))
									? true : false;

						} catch (Exception e) {
							// TODO: handle exception
						}
					} else if (item.getNodeName().equals("talkingdata")) {
						if (item.getAttribute("status").equalsIgnoreCase("enable")) {
							talkingdata_status = 1 << 0;
						}
					} else if (item.getNodeName().equals("crash")) {
						if (item.getAttribute("status").equalsIgnoreCase("enable")) {
							crash_status = 1 << 1;
						}
					} else if (item.getNodeName().equals("push")) {
						if (item.getAttribute("status").equalsIgnoreCase("enable")) {
							push = 1 << 2;
						}
					}
				}
			}
			THIRDSDK_STATUS = push | crash_status | talkingdata_status;
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	/* 初始化，将当前系统的接口参数加入进来。 */
	public static <T> boolean PlatformInit(Context context, T doPlatform, FrameLayout frameLayout) {

		PlatformInterface.sContext = context;
		PlatformInterface.sDoPlatform = (IThirdPlatform) doPlatform;
		try {
			PlatformInterface.thirdOtherInterface = (IThirdOther) doPlatform;
		} catch (ClassCastException e) {

		}
		PlatformInterface.sFrameLayout = frameLayout;

		readConfig();

		if (null == context || null == doPlatform || null == gameID || null == platformID || null == platform_type
				|| null == node || null == appVersion) {
			Log.i(TAG, "渠道配置参数不全！！！");
			// LoginCancel(ERROR_CODE_LOGIN_FAIL);
			return false;
		}

		m_platformConfig.func_ClientID = gameID + ":" + platformID + ":" + appVersion + ":" + platform_type;
		m_platformConfig.func_even_node = node;
		m_platformConfig.func_platform_name = platform_type;
		// m_platformConfig.func_pay_callback = "game/" + gameID + "/platform/"
		// + platform_type;

		setClientId(m_platformConfig.func_ClientID);

		if (true == getIsFirstOpen(sContext)) {
			/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓统计激活↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
			StringBuffer activiteLog = new StringBuffer();
			activiteLog.append(gameID + "");// 游戏id
			activiteLog.append("~@");
			activiteLog.append(area.toString());// 区域
			activiteLog.append("~@");
			activiteLog.append(getPlatFormType());// 渠道标识
			activiteLog.append("~@");
			activiteLog.append(appVersion);// 游戏版本
			countActivite("Active", activiteLog.toString().trim(), true);
			Log.e(TAG, "调用了激活接口-PlatformInit");
			/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑统计激活↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
			setIsFirstOpen(sContext, false);
		}
		platform_eveInit();
		return true;
	}

	/**
	 * 游戏暂停还是开始 true 为开始 false 为暂停
	 * 
	 * @param isPause
	 */
	public static void gamePauseOrEnter(boolean isPause) {
		StringBuffer pauseLog = new StringBuffer();
		pauseLog.append(gameID + "");// 游戏id
		pauseLog.append("~@");
		pauseLog.append(area.toString());// 区域
		pauseLog.append("~@");
		pauseLog.append(getPlatFormType());// 渠道标识
		pauseLog.append("~@");
		pauseLog.append(appVersion);// 游戏版本
		pauseLog.append("~@");
		pauseLog.append(UID);// uid
		pauseLog.append("~@");
		pauseLog.append(getGsId());// 服务器
		pauseLog.append("~@");
		pauseLog.append(GetRoleID());// 角色id
		pauseLog.append("~@");
		pauseLog.append(GetLevel());
		pauseLog.append("~@");
		pauseLog.append(Utils.getAndroid_ID(sContext));
		if (true == isPause) {
			countActivite("EnterGame", pauseLog.toString().trim(), true);
		} else {
			countActivite("QuitGame", pauseLog.toString().trim(), false);
		}
	}

	/**
	 * 游戏调用-上传日志统一接口 type 事件触发类型,body由游戏那边处理
	 **/

	public static void sendLogToBI(String sign, String body) {

		JSONObject json = new JSONObject();
		/** 包裹头信息 **/
		try {
			json.put("sign", sign);
			json.put("area", area.toString());
			json.put("gameID", gameID + "");
		} catch (JSONException e) {
			Log.e(TAG, "header json error");
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("headers", json);
		StringBuffer sb = new StringBuffer(body);

		map.put("body", sb.toString());

		// 上传日志
		uploadLog(map);
		Log.e(TAG, "sendLogToBI upload json:" + map.toString());
	}

	/**
	 * 
	 * @param type
	 *            统计类型
	 * @param area
	 *            用户所在区域
	 * @param gameId
	 *            游戏id
	 * @param log
	 *            统计内容
	 */
	private static void countActivite(String type, String log, boolean isNeedPhoneInfo) {
		JSONObject json = new JSONObject();
		try {
			json.put("area", area.toString());
			json.put("gameID", gameID + "");
			json.put("sign", type);
		} catch (JSONException e) {
			Log.i(TAG, "第一个json+： " + e);
			e.printStackTrace();
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("headers", json);
		StringBuffer sb = new StringBuffer(log);

		if (isNeedPhoneInfo) {
			sb.append("~@");
			// 生成的手机信息jsonobj
			sb.append(getPhoneInfoJson().toString());
			sb.append("~@");
			sb.append(System.currentTimeMillis() + "");
			map.put("body", sb.toString());
		} else {
			sb.append("~@");
			sb.append(System.currentTimeMillis() + "");
			map.put("body", sb.toString());
		}
		uploadLog(map);

		Log.e(TAG, map.toString());
	}

	public static Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			Log.i(TAG, "upload");
			uploadLog((Map<String, Object>) msg.obj);
		};
	};

	private static String getBIAddress() {
		if (m_platformConfig.func_data_center == null || m_platformConfig.func_data_center.equals("")) {
			return TJ_URL;
		}
		return m_platformConfig.func_data_center;
	}

	/**
	 * 上传日志
	 * 
	 * @param map
	 */
	@SuppressWarnings("deprecation")
	public static void uploadLog(final Map<String, Object> map) {
		HttpUtils.getInstance(sContext).postByJsonArray(java.net.URLEncoder.encode(System.currentTimeMillis() + ""),
				getBIAddress(), map, new FuncellResponseCallback() {

					@Override
					public void onResponse(String response) {
						Log.i(TAG, "上传成功");
					}

					@Override
					public void onErrorResponse(String error) {
						Log.i(TAG, "上传失败");
					}

					@Override
					public void onErrorResponse(VolleyError error) {
						if (error.networkResponse != null) {
							if (error.networkResponse.statusCode != 200) {
								Log.i(TAG, "上传失败，重新上传");
								if (count <= TIME) {
									uploadLog(map);
									Message msg = new Message();
									msg.obj = map;
									switch (count) {
									case ONE:
										mHandler.sendMessageDelayed(msg, Second_30);
										count++;
										break;
									case TWO:
										mHandler.sendMessageDelayed(msg, Minute_3);
										count++;
										break;
									case THREE:
										mHandler.sendMessageDelayed(msg, Minute_5);
										count++;
										break;
									}
								}
							} else {
								Log.i(TAG, "上传成功");
							}
						} else {
							if (count <= TIME) {
								uploadLog(map);
								Message msg = new Message();
								msg.obj = map;
								switch (count) {
								case ONE:
									mHandler.sendMessageDelayed(msg, Second_30);
									count++;
									break;
								case TWO:
									mHandler.sendMessageDelayed(msg, Minute_3);
									count++;
									break;
								case THREE:
									mHandler.sendMessageDelayed(msg, Minute_5);
									count++;
									break;
								}
							}
						}
					}
				});
	}

	/* 初始化，将当前系统的接口参数加入进来。 */
	public static <T> boolean PlatformInit(Context context, T doPlatform, ChannelConfig channelConfig,
			FrameLayout frameLayout) {

		PlatformInterface.sContext = context;
		PlatformInterface.sDoPlatform = (IThirdPlatform) doPlatform;
		try {
			PlatformInterface.thirdOtherInterface = (IThirdOther) doPlatform;
		} catch (ClassCastException e) {

		}
		PlatformInterface.sFrameLayout = frameLayout;

		gameID = channelConfig.getProductId();
		platformID = channelConfig.getFgi();
		platform_type = channelConfig.getPlatform_type();
		String node = channelConfig.getNode();
		String appVersion = channelConfig.getAppVersion();

		if (null == context || null == doPlatform || null == gameID || null == platformID || null == platform_type
				|| null == node || null == appVersion) {
			Log.i(TAG, "渠道配置参数不全！！！");
			// LoginCancel(ERROR_CODE_LOGIN_FAIL);
			return false;
		}

		m_platformConfig.func_ClientID = gameID + ":" + platformID + ":" + appVersion + ":" + platform_type;
		m_platformConfig.func_even_node = node;
		m_platformConfig.func_platform_name = platform_type;
		// m_platformConfig.func_pay_callback = "game/" + gameID + "/platform/"
		// + platform_type;

		setClientId(m_platformConfig.func_ClientID);

		if (true == getIsFirstOpen(sContext)) {

			/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓统计激活↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
			StringBuffer activiteLog = new StringBuffer();
			activiteLog.append(gameID + "");
			activiteLog.append("~@");
			activiteLog.append(area);
			activiteLog.append("~@");
			activiteLog.append(getPlatFormType());
			activiteLog.append("~@");
			activiteLog.append(appVersion);
			countActivite("Active", activiteLog.toString().trim(), true);
			Log.i(TAG, "调用了激活接口");
			/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑统计激活↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
			setIsFirstOpen(sContext, false);
		}

		platform_eveInit();
		return true;
	}

	static void platform_eveInit() {

		// 无网络连接不进行初始化
		if (!Utils.isNetworkAvailable(sContext)) {
			Log.i(TAG, "无网络连接...初始化失败!!!");
			// 处理网络连接失败问题
			Builder builder = new AlertDialog.Builder(sContext);
			if (DOMAIN_HOST.equals(DOMAIN_HOST_DEFAULT) || DOMAIN_HOST.equals(DOMAIN_HOST_YUMO)) { // 解决国内R文件冲突，国外R文件冲突则单独生成R文件
				builder.setTitle("网络连接错误");
				builder.setMessage("亲！请检查网络,游戏即将退出！");
			} else {
				builder.setTitle(sContext.getResources().getString(RUtils.string(sContext, "funcell_networkerror")));
				builder.setMessage(sContext.getResources().getString(RUtils.string(sContext, "funcell_checknetwork")));
			}
			builder.setPositiveButton("", new OnClickListener() {

				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stub
					if (isLogining) {
						isLogining = false;
						LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
					}
					return;
				}
			}).create().show();
			return;
		} else {

			final String url = DOMAIN_HOST + m_platformConfig.func_ClientID + "/" + m_platformConfig.func_even_node;
			Log.i(TAG, "url = " + url);
			HttpUtils.getInstance(sContext).get(null, url, new FuncellResponseCallback() {

				@Override
				public void onResponse(String response) {
					initTask(url);
				}

				@Override
				public void onErrorResponse(String error) {
					String curl = DOMAIN_HOST_BACK + m_platformConfig.func_ClientID + "/"
							+ m_platformConfig.func_even_node;
					initTask(curl);
				}

				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub

				}

			});

		}

	}

	private static void initTask(String url) {
		HttpUtils.getInstance(sContext).get(null, url, new FuncellResponseCallback() {

			@Override
			public void onResponse(String response) {
				Log.i(TAG, "init data = " + response);
				eve = response;
				if (null == eve) {
					Log.i(TAG, "init fail : eve is null");
					if (isLogining) {
						isLogining = false;
						LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
					}
					return;
				}

				JSONTokener jsonParser = new JSONTokener(eve);
				JSONObject person;
				try {
					person = (JSONObject) jsonParser.nextValue();

					m_platformConfig.func_log_url = person.optString("log");

					m_platformConfig.func_pay_url = person.getString("pay");
					m_platformConfig.func_auth_url = person.getString("auth");
					// 上传地址
					m_platformConfig.func_data_center = person.getString("datacenter_service");

					m_platformConfig.func_pay_callback = person.getString("callback") + "game/" + gameID + "/platform/"
							+ platform_type;

					if (m_platformConfig.func_auth_url != "" && m_platformConfig.func_pay_url != "") {
						isInitSuccessed = true;
						Log.e(TAG, "初始化成功!!!" + eve);
						if (null != m_platformConfig.func_log_url
								&& 0 < m_platformConfig.func_log_url.trim().length()) {
							// 初始化成功进行上传设备属性,通过消息机制处理上传http请求
							handler.sendEmptyMessage(1001);

						}

						if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
						{
							isLogining = false;
							sDoPlatform.doLogin();
						}
						if (null != mInitPlatformCallback) {
							mInitPlatformCallback.initSuccess();
						}

						if (null != mOnMiddlePlatformInitListener) {
							mOnMiddlePlatformInitListener.initThirdSdk(m_platformConfig.func_pay_url + "item"
									+ File.separator + "vnconfig?" + m_platformConfig.func_ClientID);
						}
					} else {
						Log.i(TAG, "init fail : auth|pay url is null");
						if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
						{
							isLogining = false;
							LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
						}
					}
				} catch (Exception e) {

					Log.i(TAG, "init fail : " + eve + " , e : " + e);
					e.printStackTrace();
					if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
					{
						isLogining = false;
						LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
					}
				}
			}

			@Override
			public void onErrorResponse(String error) {
				Log.i(TAG, "init error : " + error);
				if (isLogining)// 如果登录触发的初始化，初始化成功过后要调用登录
				{
					isLogining = false;
					LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
				}
			}

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});
	}

	public static PlatformConfig getM_platformConfig() {
		return m_platformConfig;
	}

	public static void setM_platformConfig(PlatformConfig m_platformConfig) {
		PlatformInterface.m_platformConfig = m_platformConfig;
	}

	static interface RefreshTokenCallback {
		void onSuccess();

		void onFail();
	}

	static void newrefresh_token_request(final RefreshTokenCallback refreshTokenCallback) {
		String url = m_platformConfig.func_auth_url + "authorize";
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("grant_type", "refresh_token");
		postData.put("refresh_token",
				null == m_platformConfig.func_refresh_token ? "" : m_platformConfig.func_refresh_token);

		HttpUtils.getInstance(sContext).post(null, url, postData, new FuncellResponseCallback() {

			@Override
			public void onResponse(String response) {
				if (response == null) {
					// refresh_token_request();
					refreshTokenCallback.onFail();
					return;
				}

				JSONTokener jsonParser = new JSONTokener(response);
				JSONObject person;
				try {
					person = (JSONObject) jsonParser.nextValue();
					m_platformConfig.func_access_token = person.getString("access_token");
					m_platformConfig.func_refresh_token = person.getString("refresh_token");
					if (m_platformConfig.func_access_token != "" && m_platformConfig.func_refresh_token != "") {
						refreshTokenCallback.onSuccess();
					} else {
						refreshTokenCallback.onFail();
					}

				} catch (JSONException e) {
					e.printStackTrace();
					refreshTokenCallback.onFail();
				}
			}

			@Override
			public void onErrorResponse(String error) {
				refreshTokenCallback.onFail();
			}

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});

	}

	static void refresh_token_request(final RefreshTokenCallback refreshTokenCallback) {
		String url = m_platformConfig.func_auth_url + "authorize";
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("grant_type", "refresh_token");
		postData.put("refresh_token",
				null == m_platformConfig.func_refresh_token ? "" : m_platformConfig.func_refresh_token);

		HttpUtils.getInstance(sContext).post("refresh_token_request", url, postData, new FuncellResponseCallback() {

			@Override
			public void onResponse(String response) {
				// TODO Auto-generated method stub
				if (response == null) {
					refreshTokenCallback.onFail();
					return;
				}

				JSONTokener jsonParser = new JSONTokener(response);
				JSONObject person;
				try {
					person = (JSONObject) jsonParser.nextValue();
					m_platformConfig.func_access_token = person.getString("access_token");
					m_platformConfig.func_refresh_token = person.getString("refresh_token");
					if (m_platformConfig.func_access_token != "" && m_platformConfig.func_refresh_token != "") {
						refreshTokenCallback.onSuccess();
					} else {
						refreshTokenCallback.onFail();
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					refreshTokenCallback.onFail();
				}
			}

			@Override
			public void onErrorResponse(String error) {
				// TODO Auto-generated method stub
				refreshTokenCallback.onFail();
			}

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});
	}

	/** 将渠道中登录成功信息回调，上传登录信息到funcell服务器 **/
	public static boolean LoginSuccess(String token, String userName, String uid, final String sessionid,
			String mToken) {
		// ThirdStats.tdgaOnBegin(TALKING_TASK_ID_P_LOGIN);
		String url = m_platformConfig.func_auth_url + "authorize";
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("grant_type", "password");
		postData.put("client_id", m_platformConfig.func_ClientID);
		postData.put("username", m_platformConfig.func_platform_name + ":" + userName);
		String TokenString = Base64.encodeToString(mToken.getBytes(), Base64.DEFAULT);
		postData.put("password", null == TokenString ? "" : TokenString);
		postData.put("scope", "auth");
		postData.put("device_id", null == Utils.getAndroid_ID(sContext) ? "" : Utils.getAndroid_ID(sContext));

		Log.e(TAG, "login url  = " + url + " & data = " + postData);

		HttpUtils.getInstance(sContext).post(null, url, postData, new FuncellResponseCallback() {

			@Override
			public void onResponse(String response) {
				Log.e(TAG, "login response = " + response);
				if (response == null) {
					LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
					// ThirdStats.tdgaOnFailed(TALKING_TASK_ID_P_LOGIN,
					// "login response is null");
					return;
				}

				JSONTokener jsonParser = new JSONTokener(response);
				JSONObject person = null;
				try {
					person = (JSONObject) jsonParser.nextValue();
					String err_code = person.getString("error_code");
					if (err_code != null)// 登录失败了
					{

						Log.e("platformInterface", "登录失败...");
						// Utils.alert(person.getString("message"),
						// sContext);
						LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
						// ThirdStats.tdgaOnFailed(
						// TALKING_TASK_ID_P_LOGIN,
						// "login fail : " + err_code);
						return;
					}
				} catch (Exception e) {
					Log.e("platformInterface", "返回了正常的数据");

					if (person == null) {
						// Utils.alert("登录验证失败，请重新登录！", sContext);
						Log.e("platformInterface", "登录验证失败，请重新登录！");
						LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
						// ThirdStats.tdgaOnFailed(
						// TALKING_TASK_ID_P_LOGIN,
						// "login fail : " + response);
						return;
					}
				}

				// 解析登录成功的数据
				try {
					m_platformConfig.func_access_token = person.getString("access_token");
					m_platformConfig.func_refresh_token = person.getString("refresh_token");
					m_platformConfig.func_platform_uid = person.getString("platform_uid");
					m_platformConfig.func_fed_id = person.getString("fed_id");
					if (person.has("new_user")) {
						isNewUser = person.getString("new_user");
					}
					UID = m_platformConfig.func_fed_id;

					Log.e(TAG, "uid= " + UID);
					/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓统计登录↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
					StringBuffer registerLog = new StringBuffer();
					registerLog.append(gameID + "");
					registerLog.append("~@");
					registerLog.append(area.toString());
					registerLog.append("~@");
					registerLog.append(getPlatFormType());
					registerLog.append("~@");
					registerLog.append(appVersion);
					registerLog.append("~@");
					registerLog.append(UID);
					Log.e(TAG, "-----------  isNewUser " + isNewUser);
					if (!TextUtils.isEmpty(isNewUser) && isNewUser.equals("new")) {
						countActivite("AccountRegister", registerLog.toString().trim(), true);
						Log.e(TAG, "调用了注册统计接口");
					}
					countActivite("AccountLogin", registerLog.toString().trim(), true);
					Log.e(TAG, "调用了统计账号登录接口");

					/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑计激活↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
				} catch (Exception e) {
					// ThirdStats.tdgaOnFailed(TALKING_TASK_ID_P_LOGIN,
					// "login fail : " + e);
					LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);

					return;
				}

				currentTime = getCurrentTime();
				if (m_platformConfig.func_platform_uid.length() > 0) {
					Log.e("PlatformInterface", "login success...........");

					Log.e(TAG, "func_access_token = " + m_platformConfig.func_access_token + " , func_fed_id = "
							+ m_platformConfig.func_fed_id);
					startGameNormal(m_platformConfig.func_access_token, m_platformConfig.func_platform_uid,
							m_platformConfig.func_fed_id, sessionid + "");// 开始游戏

					// PlatformInterface.getOrderList();

					doAntiAddictionQuery();
				}

				if (person != null) {
					try {
						m_platformConfig.chan_ext_data = null == person.getString("ext_data") ? null
								: person.getString("ext_data");
					} catch (JSONException e) {

					}
				}

				if (null != mOnLoginSuccessedListener) {
					mOnLoginSuccessedListener.LoginCallBack(m_platformConfig); // 登录成功后设置的回调,(熊猫玩SDK需要此回调来获取token信息)
				}

			}

			@Override
			public void onErrorResponse(String error) {
				Log.e(TAG, "login error = " + error);

			}

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});

		Utils.dimssProgress(sContext);

		return true;
	}

	/**
	 * 加了sdk版本的
	 * 
	 * @param token
	 * @param userName
	 * @param uid
	 * @param sessionid
	 * @param mToken
	 * @param version
	 * @return
	 */
	public static boolean LoginSuccess(String token, String userName, String uid, final String sessionid, String mToken,
			String version) {
		// ThirdStats.tdgaOnBegin(TALKING_TASK_ID_P_LOGIN);
		String url = m_platformConfig.func_auth_url + "authorize";
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("grant_type", "password");
		postData.put("client_id", m_platformConfig.func_ClientID);
		postData.put("username", m_platformConfig.func_platform_name + ":" + userName);
		postData.put("sdkver", version);
		String TokenString = Base64.encodeToString(mToken.getBytes(), Base64.DEFAULT);
		postData.put("password", null == TokenString ? "" : TokenString);
		postData.put("scope", "auth");
		postData.put("device_id", null == Utils.getAndroid_ID(sContext) ? "" : Utils.getAndroid_ID(sContext));

		Log.e(TAG, "login url  = " + url + " & data = " + postData);

		HttpUtils.getInstance(sContext).post(null, url, postData, new FuncellResponseCallback() {

			@Override
			public void onResponse(String response) {
				Log.e(TAG, "login response = " + response);
				if (response == null) {
					LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
					// ThirdStats.tdgaOnFailed(TALKING_TASK_ID_P_LOGIN,
					// "login response is null");
					return;
				}

				JSONTokener jsonParser = new JSONTokener(response);
				JSONObject person = null;
				try {
					person = (JSONObject) jsonParser.nextValue();
					String err_code = person.getString("error_code");
					if (err_code != null)// 登录失败了
					{

						Log.e("platformInterface", "登录失败...");
						// Utils.alert(person.getString("message"),
						// sContext);
						LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
						// ThirdStats.tdgaOnFailed(
						// TALKING_TASK_ID_P_LOGIN,
						// "login fail : " + err_code);
						return;
					}
				} catch (Exception e) {
					Log.e("platformInterface", "返回了正常的数据");

					if (person == null) {
						// Utils.alert("登录验证失败，请重新登录！", sContext);
						Log.e("platformInterface", "登录验证失败，请重新登录！");
						LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);
						// ThirdStats.tdgaOnFailed(
						// TALKING_TASK_ID_P_LOGIN,
						// "login fail : " + response);
						return;
					}
				}

				// 解析登录成功的数据
				try {
					m_platformConfig.func_access_token = person.getString("access_token");
					m_platformConfig.func_refresh_token = person.getString("refresh_token");
					m_platformConfig.func_platform_uid = person.getString("platform_uid");
					m_platformConfig.func_fed_id = person.getString("fed_id");
					if (person.has("new_user")) {
						isNewUser = person.getString("new_user");
					}
					UID = m_platformConfig.func_fed_id;
					Log.e(TAG, "uid= " + UID);
					/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓统计登录↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */
					StringBuffer registerLog = new StringBuffer();
					registerLog.append(gameID + "");
					registerLog.append("~@");
					registerLog.append(area.toString());
					registerLog.append("~@");
					registerLog.append(getPlatFormType());
					registerLog.append("~@");
					registerLog.append(appVersion);
					registerLog.append("~@");
					registerLog.append(UID);
					Log.e(TAG, "-----------  isNewUser " + isNewUser);
					if (!TextUtils.isEmpty(isNewUser) && isNewUser.equals("new")) {
						countActivite("AccountRegister", registerLog.toString().trim(), true);
						Log.e(TAG, "调用了注册统计接口");
					}
					countActivite("AccountLogin", registerLog.toString().trim(), true);
					Log.e(TAG, "调用了统计账号登录接口");

					/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑计激活↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */
				} catch (Exception e) {
					// ThirdStats.tdgaOnFailed(TALKING_TASK_ID_P_LOGIN,
					// "login fail : " + e);
					LoginCancelNormal(ERROR_CODE_LOGIN_FAIL);

					return;
				}

				currentTime = getCurrentTime();
				if (m_platformConfig.func_platform_uid.length() > 0) {
					Log.e("PlatformInterface", "login success...........");

					Log.e(TAG, "func_access_token = " + m_platformConfig.func_access_token + " , func_fed_id = "
							+ m_platformConfig.func_fed_id);
					startGameNormal(m_platformConfig.func_access_token, m_platformConfig.func_platform_uid,
							m_platformConfig.func_fed_id, sessionid + "");// 开始游戏

					// PlatformInterface.getOrderList();

					doAntiAddictionQuery();
				}

				if (person != null) {
					try {
						m_platformConfig.chan_ext_data = null == person.getString("ext_data") ? null
								: person.getString("ext_data");
					} catch (JSONException e) {

					}
				}

				if (null != mOnLoginSuccessedListener) {
					mOnLoginSuccessedListener.LoginCallBack(m_platformConfig); // 登录成功后设置的回调,(熊猫玩SDK需要此回调来获取token信息)
				}

			}

			@Override
			public void onErrorResponse(String error) {
				Log.e(TAG, "login error = " + error);

			}

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});

		Utils.dimssProgress(sContext);

		return true;
	}

	public static void showLogo() {
		sDoPlatform.showLogo();
	}

	public static void startCopyFiles() {
		sDoPlatform.startCopyFiles();
	}

	//
	public static int ExitGame() {
		checkStastics();
		try {
			gamePauseOrEnter(false);// 退出游戏统计
		} finally {
			return PlatformInterface.sDoPlatform.exitGame();
		}
	}

	/**
	 * 得到当前平台的编号
	 * 
	 * @return
	 */
	public static int GetPlatformID() {
		if (platformID != null && platformID != 0)
			return platformID;
		return sDoPlatform.getPlatFormId();
	}

	/**
	 * 得到当前平台的名字
	 * 
	 * @return
	 */
	public static String getPlatformName() {
		if (m_platformConfig.func_platform_name != null && m_platformConfig.func_platform_name.length() != 0)
			return m_platformConfig.func_platform_name;
		else
			return sDoPlatform.getPlatFormName();
	}

	/**
	 * notice 获取已接入三方SDK（talkingdata，bugly，push...）
	 * 
	 * @return
	 */
	public static String getThirdSdkPackageNames() {
		String talkingdata = "com.haowan.funcell.sdk.takingdata.api.ThirdStats";
		String bugly = "com.haowan.funcell.sdk.crash.api.ThirdCrash";
		String push = "com.haowan.funcell.sdk.push.api.ThirdPush";
		String result = "";
		switch (THIRDSDK_STATUS) {
		case 1 << 0: // talkingdata 1
			result = talkingdata;
			break;
		case 1 << 1: // bugly 2
			result = bugly;
			break;
		case 1 << 2: // push推送 4
			result = push;
			break;
		case 1 << 1 | 1 << 0: // bugly| talkingdata
			result = bugly + ":" + talkingdata;
			break;
		case 1 << 2 | 1 << 1: // push | bugly
			result = push + ":" + bugly;
			break;
		case 1 << 2 | 1 << 0: // push | talkingdata
			result = push + ":" + talkingdata;
			break;
		case 1 << 2 | 1 << 1 | 1 << 0: // push | bugly | talkingdata
			result = push + ":" + bugly + ":" + talkingdata;
			break;
		default:
			break;
		}
		return result;
	}

	public static void initThirdSdk() { // 针对unity和有些渠道初始化冲突，添加一个init渠道的方法，让游戏自己选择合适的时机调用

		Log.i("PlatformInterface", "initThirdSdk");

		if (getEngineName().equals("cocos"))
			return;

		if (getPlatformName().equals("uc")) { // uc有冲突，需要特殊处理
			sDoPlatform.doInit();
		}
	}

	/**
	 * 登录调用的接口处理
	 * 
	 * @return
	 */
	public static int doSdkLogin() {
		Log.e(TAG, "开始登录...");

		if (isLogining) {
			Log.e("PlatformInterface", "正在初始化");
			return -1;
		}

		if (!isInitSuccessed) {
			// Utils.alert("初始化失败,请稍后重试！！！", sContext);
			Log.e("PlatformInterface", "初始化未成功就登录，初始化重试");
			isLogining = true; // 记录platform_eveInit是在登录环境触发的
			platform_eveInit();
			return 0;
		}

		Log.e("PlatformInterface", "正常登录");
		isLogining = false;
		sDoPlatform.doLogin();
		return sDoPlatform.getPlatFormId();
	}

	// public static int doSdkLogin(OnLoginSuccessedListener
	// onLoginSuccessedListener) {
	// Log.i(TAG, "开始登录...");
	// mOnLoginSuccessedListener=onLoginSuccessedListener;
	// if (!isInitSuccessed) {
	// Utils.alert("初始化失败,请稍后重试！！！", sContext);
	// platform_eveInit();
	// return 0;
	// }
	// sDoPlatform.doLogin();
	// return sDoPlatform.getPlatFormId();
	// }

	/**
	 * 游戏中会有小退出游戏的情况， 要退出就需要注销掉当前登录用户的登录记录操作
	 */
	public static void GameToPlatformLogout() {
		sDoPlatform.GameToPlatformLogout();
	}

	/**
	 * 第三方的操作接口， 根据类型去处理不同的类型操作
	 * 
	 * @param type
	 *            定义的操作类型值;1:用户中心、2:论坛、3：反馈页面、4：统计、5：创建角色、6：进入游戏、7：等级变化、8：激活统计(
	 *            下载并启动)、9:其他
	 * @param mess
	 *            参数信息列表
	 */
	public static void DealMessage(int type, String mess) {

		Log.i("PlatformInterface", "DealMessage type" + type);
		switch (type) {
		case 1:
			Log.e(TAG, "docenter");
			sDoPlatform.doCenter(type, mess);
			break;
		case 2:
			Log.e(TAG, "doBBS");
			sDoPlatform.doBBS();

			break;
		case 3:
			Log.e(TAG, "doFeedback");
			sDoPlatform.doFeedback();

			break;
		case 4:
			// sDoPlatform.TotalUI(type, mess);
			Log.e(TAG, "doSdkStatistics");
			sDoPlatform.doSdkStatistics();
			statistic |= STATISTICS.mPDT_WEBTOTAL;
			break;
		case 5:// 建角色
			Log.e(TAG, "doSdkNotifyZone");
			sDoPlatform.doSdkNotifyZone();
			statistic |= STATISTICS.mPDT_TOTAL_CREATEROLE;
			// ***************** 建角色统计 ****************
			StringBuffer createLog = new StringBuffer();
			createLog.append(gameID + "");
			createLog.append("~@");
			createLog.append(area.toString());
			createLog.append("~@");
			createLog.append(getPlatFormType());
			createLog.append("~@");
			createLog.append(appVersion);
			createLog.append("~@");
			createLog.append(UID);
			createLog.append("~@");
			createLog.append(getGsId());
			createLog.append("~@");
			createLog.append(GetRoleID());
			createLog.append("~@");
			createLog.append(Utils.getAndroid_ID(sContext));
			countActivite("RoleCreate", createLog.toString().trim(), false);
			Log.i(TAG, "调用了统计创建角色接口");
			/******************* end *****************/
			break;
		case 6:// 进游戏
			Log.e(TAG, "doIntoGameStaticstics");

			sDoPlatform.doIntoGameStaticstics();
			statistic |= STATISTICS.mPDT_TOTAL_ENTERGAME;
			/***************** 进入游戏统计统计 ****************/

			StringBuffer enterLog = new StringBuffer();
			enterLog.append(gameID + "");
			enterLog.append("~@");
			enterLog.append(area.toString());
			enterLog.append("~@");
			enterLog.append(getPlatFormType());
			enterLog.append("~@");
			enterLog.append(appVersion);
			enterLog.append("~@");
			enterLog.append(UID);
			enterLog.append("~@");
			enterLog.append(getGsId());
			enterLog.append("~@");
			enterLog.append(GetRoleID());
			enterLog.append("~@");
			enterLog.append(GetLevel());
			enterLog.append("~@");
			enterLog.append(Utils.getAndroid_ID(sContext));
			// enterLog.append(Utils.getImei(sContext));
			countActivite("EnterGame", enterLog.toString().trim(), false);

			Log.i(TAG, "调用了统计进入游戏接口");
			/******************* end *****************/
			break;
		case 7:
			Log.e(TAG, "doLevelChange:" + mess);

			if (null == mess) {
				break;
			}

			statistic |= STATISTICS.mPDT_LEVEL_CHANGE;
			/** notice **/
			// SetRoleLevelupTime(System.currentTimeMillis()/1000);
			if (mess.startsWith("#")) {// 初始化等级
				m_p_current_gameinfo.m_roleLevel = Integer.parseInt(mess.substring(1));

				return;
			}

			if (mess.length() != 0) {// 等级变化
				m_p_current_gameinfo.m_roleLevel = Integer.parseInt(mess);
			}

			sDoPlatform.doLevelChange();

			break;
		case 8:
			Log.e(TAG, "doActivateStaticstics");
			sDoPlatform.doActivateStaticstics();
			break;
		case 9:
			sDoPlatform.doSdkOther(type, mess);
			Log.e(TAG, "doSdkOther");
			break;
		case 10:
			sDoPlatform.doSdkOther(type, mess);
			Log.e(TAG, "doSdkOther");
			break;
		case 11:
			sDoPlatform.doSdkOther(type, mess);
			Log.e(TAG, "doSdkOther");
			break;
		case 12:
			sDoPlatform.doSdkOther(type, mess);
			Log.e(TAG, "doSdkOther");
			break;
		case 13:
			sDoPlatform.doSdkOther(type, mess);
			Log.e(TAG, "doSdkOther");
			break;

		default:
			sDoPlatform.doSdkOther(type, mess);
			Log.e(TAG, "doSdkOther");
			break;
		}

	}

	/**
	 * 提示下载更新时候需要处理的显示平台的包的地址位置函数接口
	 */
	public static void OpenDownloadUrl() {
		Utils.openUrl(sContext, sDoPlatform.getDownloadUrl());
	}

	public static void doSdkPay(final String PayType, final String itemID, final String itemName, final int itemCount,
			final float moneyAmount, final short lsID, final String extData) {
		doSdkPay(PayType, itemID, itemName, itemCount, moneyAmount, lsID, extData, null);
	}

	/**
	 * 充值接口
	 * 
	 * @param PayType
	 *            [充值类型]
	 * @param itemID
	 *            [物品ID]
	 * @param itemName
	 *            [物品名称]
	 * @param itemCount
	 *            [物品数量]
	 * @param moneyAmount
	 *            [物品总价,单位:元]
	 * @param lsID
	 *            [保留参数，暂时未用到]
	 * @param extData
	 *            [游戏自定义参数]
	 * @param multPay
	 *            [多渠道支付标识；由平台分配]
	 */
	public static void doSdkPay(final String PayType, final String itemID, final String itemName, final int itemCount,
			final float moneyAmount, final short lsID, final String extData, final String multPay) {
		Log.e(TAG, "支付开始");
		if (DOMAIN_HOST.equals(DOMAIN_HOST_DEFAULT) || DOMAIN_HOST.equals(DOMAIN_HOST_YUMO)) { // 解决国内R文件冲突，国外R文件冲突则单独生成R文件
			Utils.startProgress("开始进行支付了", sContext);
		} else {
			Utils.startProgress(sContext.getResources().getString(RUtils.string(sContext, "funcell_startpay")),
					sContext);
		}

		String url = m_platformConfig.func_pay_url + "charge";
		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("category", null == PayType ? "" : PayType);
		postData.put("access_token", m_platformConfig.func_access_token + "");
		postData.put("item", null == itemID ? "" : itemID);
		postData.put("amount", itemCount + "");// 数量
		postData.put("server_id", null == getGsId() ? "" : getGsId());
		postData.put("character_id", null == GetRoleID() ? "" : GetRoleID());
		postData.put("ext_data", null == extData || 0 == extData.trim().length() ? ""
				: Base64.encodeToString(extData.getBytes(), Base64.DEFAULT));

		Log.e(TAG, "url = " + url + " , postData = " + postData);
		HttpUtils.getInstance(sContext).post(String.valueOf(System.currentTimeMillis()), url, postData,
				new FuncellResponseCallback() {

					@Override
					public void onResponse(String response) {
						if (TextUtils.isEmpty(response)) {
							Utils.dimssProgress(sContext);
							if (DOMAIN_HOST.equals(DOMAIN_HOST_DEFAULT) || DOMAIN_HOST.equals(DOMAIN_HOST_YUMO)) { // 解决国内R文件冲突，国外R文件冲突则单独生成R文件
								Utils.alert("提交参数失败了， 请重新提交处理哦！", sContext);
							} else {
								Utils.alert(sContext.getResources()
										.getString(RUtils.string(sContext, "funcell_submitfail")), sContext);
							}
							// GameLogout();
							return;
							// 弹出提示
						}
						String order = "";
						JSONTokener jsonParser = new JSONTokener(response);
						JSONObject person = null;
						try {
							person = (JSONObject) jsonParser.nextValue();
							Log.e(TAG, "person = " + person);
							final String err_code = person.getString("error_code");
							if (err_code != null && err_code.trim().length() > 0)// 认证失败了
							{
								Log.e("platform", "需要重新刷新ＴＯＫＥＮ来处理支付开始");
								newrefresh_token_request(new RefreshTokenCallback() {

									@Override
									public void onSuccess() {
										doSdkPay(PayType, itemID, itemName, itemCount, moneyAmount, lsID, extData,
												multPay);
									}

									@Override
									public void onFail() {
										Utils.dimssProgress(sContext);
										if (DOMAIN_HOST.equals(DOMAIN_HOST_DEFAULT)
												|| DOMAIN_HOST.equals(DOMAIN_HOST_YUMO)) { // 解决国内R文件冲突，国外R文件冲突则单独生成R文件
											Utils.alert("获取订单号失败，请联系客服！", sContext);
										} else {
											Utils.alert(sContext.getResources().getString(
													RUtils.string(sContext, "funcell_getorderfail")), sContext);
										}
									}
								});

								Log.e("PlatformInterface", "获取订单号失败" + err_code);
								return;
							}
						} catch (JSONException e) {
							// TODO Auto-generated catch block
							if (person == null) {
								e.printStackTrace();
								Log.e("PlatformInterface", "读取订单号信息出错了＝＝＝＝＝＝");
								Utils.dimssProgress(sContext);
								if (DOMAIN_HOST.equals(DOMAIN_HOST_DEFAULT) || DOMAIN_HOST.equals(DOMAIN_HOST_YUMO)) { // 解决国内R文件冲突，国外R文件冲突则单独生成R文件
									Utils.alert("提交参数失败了， 请重新提交处理哦！", sContext);
								} else {
									Utils.alert(sContext.getResources()
											.getString(RUtils.string(sContext, "funcell_submitfail")), sContext);
								}

								return;
							}
						}

						String pOrder = null;
						String pSign = null;

						String pSubmitTime = null;

						/**
						 * 步步高交易流水号
						 */
						String transNo = null;
						/**
						 * 步步高签名方法
						 */
						String accesskey = null;

						try {
							order = person.getString("f_orderid");

						} catch (JSONException e) {
							e.printStackTrace();
							Log.e("PlatformInterface", "读取订单号信息出错了＝＝orderid error＝＝＝＝");
							Utils.dimssProgress(sContext);
							if (DOMAIN_HOST.equals(DOMAIN_HOST_DEFAULT) || DOMAIN_HOST.equals(DOMAIN_HOST_YUMO)) { // 解决国内R文件冲突，国外R文件冲突则单独生成R文件
								Utils.alert("提交参数失败了， 请重新提交处理哦！", sContext);
							} else {
								Utils.alert(sContext.getResources()
										.getString(RUtils.string(sContext, "funcell_submitfail")), sContext);
							}

							return;
						}
						try {
							pOrder = person.getString("platform_order");// 渠道订单号
							pSign = person.getString("platform_sign");// 渠道签名--步步高

						} catch (Exception e) {

						}

						try {
							transNo = person.getString("platform_orderNumber");
							accesskey = person.getString("platform_accessKey");
							// pSign = person.getString("platform_sign");//
							// 渠道签名--步步高
						} catch (Exception e) {

						}

						try {
							pSubmitTime = person.getString("platform_submit_time");// 金立支付
						} catch (Exception e) {

						}
						currentTime = getCurrentTime();

						Log.e(TAG, "moneyAmount = " + moneyAmount + " , pOrder = " + pOrder + " , pSign = " + pSign
								+ " , userName = " + GetRoleName() + " , roleId = " + GetRoleID());

						String roleId = GetRoleID();

						Bundle bundle = new Bundle();
						bundle.putString(IThirdPlatform.STRING_USER_NAME, GetRoleName());
						bundle.putFloat(IThirdPlatform.INT_MONEY, moneyAmount);
						bundle.putShort(IThirdPlatform.SHORT_LS_ID, lsID);
						bundle.putString(IThirdPlatform.SHORT_GS_ID, getGsId());
						bundle.putString(IThirdPlatform.LONG_Role_ID, roleId);
						bundle.putString(IThirdPlatform.ORDER_STRING, order);
						bundle.putString(IThirdPlatform.PAY_ITEM_STRING, itemID);
						bundle.putString(IThirdPlatform.PAY_ITEM_NMAE, itemName);
						bundle.putInt(IThirdPlatform.PAY_ITEM_NUM, itemCount);
						bundle.putString(IThirdPlatform.PAY_PLATFORM_ORDER, pOrder);
						bundle.putString(IThirdPlatform.PAY_PLATFORM_SIGN, pSign);
						bundle.putString(IThirdPlatform.PAY_PLATFORM_SUBMIT_TIME, pSubmitTime);
						bundle.putString(IThirdPlatform.STRING_EXT_DATA, m_platformConfig.chan_ext_data);
						bundle.putString(IThirdPlatform.PAY_CALLBACK_URL, m_platformConfig.func_pay_callback);
						bundle.putString(IThirdPlatform.PAY_PLATFORM_UID, m_platformConfig.func_platform_uid);
						bundle.putString(IThirdPlatform.STRING_ACCESS_TOKEN, m_platformConfig.func_access_token);
						bundle.putString(IThirdPlatform.PAY_PLATFORM_MULT_PAY_KEY, multPay);
						bundle.putString("platform_orderNumber", transNo);
						bundle.putString("platform_accessKey", accesskey);

						Utils.dimssProgress(sContext);
						sDoPlatform.doPay(bundle);
					}

					@Override
					public void onErrorResponse(String error) {
						Log.e(TAG, "pay get order error is " + error);
						Utils.dimssProgress(sContext);
					}

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub

					}
				});

	}

	/**
	 * 界面统计平台的调用接口处理
	 * 
	 * @param uidefineName
	 *            ＵＩ的别名
	 */
	public static void FlurryTotal(String uidefineName) {
		sDoPlatform.TotalUI(uidefineName);
	}

	/**
	 * 用外部浏览器打开一个网页的接口调用
	 * 
	 * @param Url
	 *            访问的指定网站地址
	 */
	public static void openUrl(String Url) {
		Utils.openUrl(sContext, Url);
	}

	/**
	 * 从剪贴版获得内容
	 */
	public static String getClipboard() {
		ClipboardManager clipboard = (ClipboardManager) PlatformInterface.sContext
				.getSystemService(Context.CLIPBOARD_SERVICE);
		CharSequence csq = clipboard.getText();
		if (csq != null)
			return csq.toString();
		else
			return "";

	}

	/**
	 * 设置文本到android的剪贴版
	 * 
	 * @param value
	 */
	public static void setClipboard(String value) {
		ClipboardManager clipboard = (ClipboardManager) PlatformInterface.sContext
				.getSystemService(Context.CLIPBOARD_SERVICE);
		clipboard.setText(value);
	}

	/**
	 * 增加显示一个网页函数用于显示内嵌网页内容的显示操作
	 * 
	 * @param openWeb_url
	 *            设置显示的网页地址
	 * @param openWeb_x
	 *            设置显示的X坐标
	 * @param openWeb_y
	 *            设置显示的Y坐标
	 * @param openWeb_width
	 *            设置显示的宽度
	 * @param openWeb_heihgt
	 *            设置显示的高度
	 */
	public static void openWebView(final String openWeb_url, final int openWeb_x, final int openWeb_y,
			final int openWeb_width, final int openWeb_heihgt) {
		((Activity) sContext).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				WebView webView = new WebView(sContext);
				webView.setVisibility(View.GONE);
				webView.setWebViewClient(new WebViewClient() {
					@Override
					public void onPageFinished(WebView view, String url) {
						super.onPageFinished(view, url);
					}
				});
				WebSettings settings = webView.getSettings();
				settings.setRenderPriority(RenderPriority.HIGH);
				settings.setJavaScriptEnabled(true);

				if (VERSION.SDK_INT < 11) {
					RelativeLayout rl = new RelativeLayout(sContext);
					FrameLayout.LayoutParams rlp = new FrameLayout.LayoutParams(openWeb_x + openWeb_width,
							openWeb_y + openWeb_heihgt, Gravity.BOTTOM);

					RelativeLayout.LayoutParams rlpw = new RelativeLayout.LayoutParams(openWeb_width, openWeb_heihgt);
					rlpw.alignWithParent = true;
					rlpw.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
					rlpw.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
					rl.setBackgroundColor(Color.TRANSPARENT);

					Display display = ((Activity) sContext).getWindowManager().getDefaultDisplay();
					DisplayMetrics metrics = new DisplayMetrics();
					display.getMetrics(metrics);

					rlpw.bottomMargin = metrics.heightPixels - openWeb_heihgt - openWeb_y;

					rl.addView(webView, rlpw);
					sFrameLayout.addView(rl, rlp);
					sPublicView = rl;
				} else {
					sPublicView = webView;
					FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(openWeb_width, openWeb_heihgt);
					params.leftMargin = openWeb_x;
					params.topMargin = openWeb_y;
					sFrameLayout.addView(sPublicView, params);
				}

				webView.setVisibility(View.VISIBLE);
				webView.loadUrl(openWeb_url);
			}
		});
	}

	/**
	 * 内嵌网页的关闭接口
	 */
	public static void closeWebView() {
		((Activity) sContext).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				if (sPublicView == null || sFrameLayout == null)
					return;
				sPublicView.setVisibility(View.GONE);
				sFrameLayout.removeView(sPublicView);
				sPublicView = null;
			}
		});
	}

	/**
	 * 根据传递的参数猎取设备的各种参数值
	 * 
	 * @param type
	 *            设备的参数类型
	 * @return
	 */
	public static String getMachineInfoByType(int type) {
		String ret = "";
		try {
			switch (type) {
			case Utils.IMEI:
				ret = Utils.getAndroid_ID(sContext);
				break;
			case Utils.NET_TYPE:
				ret = Utils.getNetType(sContext);
				break;
			case Utils.SDCARD_SUM:
				ret = Utils.getSdcardSum(sContext);
				break;
			// case 4:
			// ret = getDefaultSDcardFreeSize();
			// break;
			case Utils.CPU:
				ret = Utils.getCPU();
				break;
			case Utils.MEM:
				ret = Utils.getMEM();
				break;
			case Utils.SCREEN_PIEXL:
				ret = Utils.getScreenPiexl(sContext);
				break;
			case Utils.SYSTEM_VERSION:
				ret = Utils.getSystemVersion();
				break;
			case Utils.MOBILE_TYPE:
				ret = Utils.getMobileType();
				break;
			case Utils.MOBILE_SERVICE_PROVIDER:
				ret = Utils.getMobileServiceProvider(sContext);
				break;
			case Utils.SYSTEM_TYPE:
				ret = Utils.getSystemType();
				break;
			default:
				Log.e("---", "getMachineInfoByType  error");
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ret;
	}

	/**
	 * 
	 * @return
	 */
	public static int getConnectedType() {
		if (sContext != null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) sContext
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
			if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
				return mNetworkInfo.getType();
			}
		}
		return -1;
	}

	/**
	 * 根据传递的地址打开一个内嵌的网页显示
	 * 
	 * @param url
	 *            传入ＵＲＬ地址
	 */
	public static void openWebViewActivity(String url) {
		Intent intent = new Intent();
		intent.setClass(sContext, WebActivity.class);
		intent.putExtra("data", url);
		sContext.startActivity(intent);
	}

	/**
	 * 从网上获得支付的ＪＳＯＮ串信息
	 * 
	 */

	static long readtime = 0;

	public static String getPayList(boolean isStrange, final String category) {

		boolean isRead = false;

		long over = System.currentTimeMillis() - readtime;

		if (over > 3600000) {
			isRead = true;
		}

		if (m_platformConfig.func_pay_json == null || m_platformConfig.func_pay_json.length() < 1) {
			isRead = true;
		}

		if (isStrange) {
			isRead = true;
		}

		// 检查支付字串是否已经设置成功了
		if (isRead) {
			readtime = System.currentTimeMillis();
			// TODO Auto-generated method stub
			String url = m_platformConfig.func_pay_url + "item";
			HashMap<String, String> postData = new HashMap<String, String>();
			postData.put("category", category);
			postData.put("access_token",
					null == m_platformConfig.func_access_token ? "" : m_platformConfig.func_access_token);
			// String meve = CPHttpResponse.doSendHttpPostResponse(url,
			// postData);

			Log.e(TAG, "pay list url = " + url + " , postData = " + postData);

			HttpUtils.getInstance(sContext).post("getPayList", url, postData, new FuncellResponseCallback() {

				@Override
				public void onResponse(String response) {
					if (null == response || response.trim().length() == 0 || !response.startsWith("[")) {
						Log.e(TAG, "获取充值列表失败了  " + response);
						getPayListCallbackNormal("" + response);
						return;
					}

					// if (!eve.startsWith("[")) {
					// // Utils.alert("获取充值列表失败了，请通知技术", sContext);
					// Log.i(TAG, "获取充值列表失败了 " + eve);
					// eve = "";
					// // getPayListCallback(null);//通知游戏获取失败，需要重新获取
					// }
					m_platformConfig.func_pay_json = response;

					Log.e(TAG, "pay list  = " + response);

					Log.e(TAG, "获取充值列表成功!!! ");
					getPayListCallbackNormal(response);
				}

				@Override
				public void onErrorResponse(String error) {
					Log.e(TAG, "pay list error : " + error);
					getPayListCallbackNormal("");
				}

				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub

				}
			});

		}

		return null;
	}

	/**
	 * 获取未处理的充值订单列单
	 */
	public static void getOrderList() {
		((Activity) sContext).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				doTask(false, null, null, null);

			}
		});
	}

	/**
	 * 获取未处理的充值订单列单
	 */
	public static void getOrderList(final String serverId, final String roleId) {
		((Activity) sContext).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				String sid = null == serverId || 0 == serverId.length() ? null : serverId;
				String rid = null == roleId || 0 == roleId.length() ? null : roleId;

				if (Utils.isFastDoubleClick(1000)) {
					return;
				}

				if (null == userKey) {
					if (null != serverId) {
						String[] split = serverId.split("_");
						sid = split[0];

					}

					doTask(false, null, sid, rid);
				} else {

					if (null == serverId || 0 == serverId.trim().length()) {
						Log.i(TAG, "应用宝补单未进行，请传入serverid|itemid后在试");
						return;
					}

					// String[] split = serverId.split("_");
					// if (2 > split.length) {
					// Log.i(TAG, "应用宝补单未进行，请传入serverid|itemid后在试");
					// return;
					// }
					doYYBPayTask(false, null, sid, rid);

				}

			}

		});
	}

	public static void getOrderListFromSDK(final String billNo) {
		((Activity) sContext).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				doTask(true, billNo, null, null);

			}
		});
	}

	/** 渠道支付成功回调后，需要调用此方法去查询该账单是否支付成功 **/
	public static void getOrderListWithNoCallBack(final String billNo) {
		((Activity) sContext).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				doTask(false, billNo, null, null);

			}
		});
	}

	/**
	 * 充值成功反馈
	 * 
	 * @param billNo
	 */
	public static void payFeedback(final String billNo) {
		((Activity) sContext).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				doPayFeedbackTask(billNo);
			}
		});
	}

	public static void setLoginSuccessedListener(OnLoginSuccessedListener listener) {
		mOnLoginSuccessedListener = listener;
	}

	public interface OnLoginSuccessedListener {

		void LoginCallBack(PlatformConfig result);
	}

	private static OnLoginSuccessedListener mOnLoginSuccessedListener = null;

	public interface OnHideGmaeLogoCallback {
		void hideLogo();
	}

	private static ScheduledExecutorService executorService = null;

	public static synchronized ScheduledExecutorService getSingleExecutorService() {
		if (null == executorService) {
			executorService = Executors.newScheduledThreadPool(2);
		}

		return executorService;
	}

	public static Map<String, ScheduledFuture<?>> payResultMap = Collections
			.synchronizedMap(new HashMap<String, ScheduledFuture<?>>());

	public static Map<String, ScheduledFuture<?>> yybPayResultMap = Collections
			.synchronizedMap(new HashMap<String, ScheduledFuture<?>>());

	public static ScheduledFuture<?> stopScheduledFuture = null;

	public static void doTask(boolean isFromSDK, String billNo, String serverId, String roleId) {

		// if (Utils.isFastDoubleClick(1 * 1000)) {
		// Log.i(TAG, "5s内2次调用");
		// return;
		// }

		if (null == billNo) {
			billNo = "all";
		}

		ScheduledExecutorService singleExecutorService = getSingleExecutorService();

		ScheduledFuture<?> payFuture;

		if (!payResultMap.isEmpty()
				&& (null == billNo || "all".equals(billNo) || PAY_CALLBACK_SUCCESS_NO.equals(billNo))) {
			Log.i(TAG, "payResultList is not null");
			ScheduledFuture<?> future = payResultMap.get(billNo);
			try {
				if (null != future && !future.isDone()) {
					Log.i(TAG, "future is cancel");
					future.cancel(true);

				}

			} catch (CancellationException e) {
				// TODO: handle exception
			} finally {
				payResultMap.remove(billNo);
				// singleExecutorService.shutdown();
			}

		}

		if (!payResultMap.isEmpty() && payResultMap.containsKey(billNo)) {
			return;
		}

		long initialDelay = 0;
		long delay = 5;

		if (isFromSDK) {
			initialDelay = 3;
			delay = 1;
		}

		Log.i(TAG, "m_platformConfig.func_access_token = " + m_platformConfig.func_access_token);
		payFuture = singleExecutorService.scheduleWithFixedDelay(
				new PayTaskRunable(m_platformConfig.func_access_token, isFromSDK, billNo, serverId, roleId),
				initialDelay, delay, TimeUnit.SECONDS);

		payResultMap.put(billNo, payFuture);
		Log.i(TAG, "future is add successed...");
	}

	private static class PayTaskRunable implements Runnable {
		private long startTime;
		private String accessToken;
		private boolean isFromSDK;
		private final long intervalTime = 6 * 60 * 1000;
		private final int pollCount = 5;
		private final int maxPollCount = 6;
		private int currentPollCount = 0;
		private long delayTime = 0;
		private String mBillNo;
		private String mServerId;
		private String mRoleId;

		public PayTaskRunable(String accessToken, boolean isFromSDK, String billNo, String serverId, String roleId) {
			this.accessToken = accessToken;
			this.isFromSDK = isFromSDK;
			this.startTime = System.currentTimeMillis();
			this.mBillNo = billNo;
			this.mServerId = serverId;
			this.mRoleId = roleId;
		}

		@Override
		public void run() {
			Log.i(TAG, "into pay task...");

			long currentTimeMillis = System.currentTimeMillis();
			if (currentTimeMillis - startTime > intervalTime) {// 当前时间超过最大间隔时间，就结束当前任务

				closeTask(mBillNo);
				return;
			}

			switch (currentPollCount) {
			case 1:
				delayTime = 3;

				break;
			case 2:
				delayTime = 10;
				break;
			case 3:
				delayTime = 20;
				break;
			case 4:
				delayTime = 30;
				break;
			case 5:
				delayTime = 60;
				break;
			case 6:
				delayTime = 180;
				break;

			default:
				break;
			}

			currentPollCount++;

			Log.i(TAG, "unfinished delayTime = " + delayTime);
			try {
				TimeUnit.SECONDS.sleep(delayTime);
			} catch (InterruptedException e) {
				closeTask(mBillNo);
			}

			// try {
			// TimeUnit.SECONDS.sleep(5);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }

			Log.i(TAG, "currentTimeMillis = " + currentTimeMillis);

			// String url = "http://192.168.6.24/payment/confirm";
			String url = m_platformConfig.func_pay_url + "confirm";
			HashMap<String, String> postData = new HashMap<String, String>();
			Log.i(TAG, "order accessToken = " + accessToken);
			postData.put("access_token", null == accessToken ? "" : accessToken);
			postData.put("action", "unfinished");
			postData.put("server_id", null == mServerId ? "" : mServerId);
			postData.put("character_id", null == mRoleId ? "" : mRoleId);

			JSONArray billNoJsonArray = new JSONArray();
			if (null != mBillNo && !"all".equals(mBillNo) && !PAY_CALLBACK_SUCCESS_NO.equals(mBillNo)) {
				billNoJsonArray.put(mBillNo);

				postData.put("f_orders", null == billNoJsonArray.toString() ? "" : billNoJsonArray.toString());
			}
			Log.i(TAG, "url = " + url + " , postData = " + postData);
			// String orderListJsonData = CPHttpResponse.doSendHttpPostResponse(
			// url, postData);

			HttpUtils.getInstance(sContext).post(System.currentTimeMillis() + "", url, postData,
					new FuncellResponseCallback() {

						@Override
						public void onResponse(String response) {
							Log.i(TAG, "unfinished orderListJsonData = " + response);

							if (null != response && !"[]".equals(response) && response.startsWith("[")
									&& response.endsWith("]")) {
								Log.i(TAG, "unfinished orderListJsonData is not null");

								Message msg = new Message();
								msg.obj = response;
								msg.what = 1;
								handler.sendMessageDelayed(msg, 2000);

								closeTask(mBillNo);
								return;
							}
							if (null == mBillNo || "all".equals(mBillNo)) {
								closeTask(mBillNo);
								return;
							}
							// switch (currentPollCount) {
							// case 1:
							// delayTime = 3;
							//
							// break;
							// case 2:
							// delayTime = 10;
							// break;
							// case 3:
							// delayTime = 20;
							// break;
							// case 4:
							// delayTime = 30;
							// break;
							// case 5:
							// delayTime = 60;
							// break;
							// case 6:
							// delayTime = 180;
							// break;
							//
							// default:
							// break;
							// }
							if (maxPollCount < currentPollCount) {// 当前次数超过maxPollCount次，就通知游戏购买失败
								closeTask(mBillNo);
								return;
							}

							if (pollCount == currentPollCount && isFromSDK) {// 当前次数超过pollCount次，就通知游戏购买失败
								doPayCallback("");
								if (DOMAIN_HOST.equals(DOMAIN_HOST_DEFAULT) || DOMAIN_HOST.equals(DOMAIN_HOST_YUMO)) { // 解决国内R文件冲突，国外R文件冲突则单独生成R文件
									Utils.alert("亲，网络延迟可能造成到账时间延迟，请先试玩游戏，感谢支持!", sContext);
								} else {
									Utils.alert(sContext.getResources()
											.getString(RUtils.string(sContext, "funcell_delaypay")), sContext);
								}

								Log.i(TAG, "unfinished pay task handing....");
							}

						}

						@Override
						public void onErrorResponse(String error) {
							Log.i(TAG, "unfinished error is " + error);
						}

						@Override
						public void onErrorResponse(VolleyError error) {
							// TODO Auto-generated method stub

						}
					});

		}

	}

	private static void closeTask(String billNo) {
		if (!payResultMap.isEmpty()) {
			try {
				if (!payResultMap.get(billNo).isDone()) {
					payResultMap.get(billNo).cancel(true);
				}
			} catch (CancellationException e) {
				// TODO: handle exception
			} finally {
				payResultMap.remove(billNo);
				Log.i(TAG, "pay task over.....");

				// if (null != executorService) {
				// executorService.shutdown();
				//
				// }
			}
		}
	}

	private static void closeYYBTask(String billNo) {
		if (!yybPayResultMap.isEmpty()) {
			try {
				if (!yybPayResultMap.get(billNo).isDone()) {
					yybPayResultMap.get(billNo).cancel(true);
				}
			} catch (CancellationException e) {
				// TODO: handle exception
			} finally {
				yybPayResultMap.remove(billNo);
				Log.i(TAG, "yyb pay task over.....");

				// if (null != executorService) {
				// executorService.shutdown();
				//
				// }
			}
		}
	}

	public static void doYYBPayTask(boolean isFromSDK, HashMap<String, String> dataMap, String serverId,
			String roleId) {

		yybSubmitPayTask(isFromSDK, dataMap, serverId, roleId);

	}

	private static String BillNo, server_id;// 应用宝获取的订单号

	private static void yybSubmitPayTask(final boolean isFromSDK, final HashMap<String, String> dataMap,
			final String serverId, final String roleId) {
		new Thread(new Runnable() {

			@Override
			public void run() {

				String category = "cash";
				String item = "default";// default
				String amount = "1";
				server_id = "";
				final String character_id = null == roleId ? "" : roleId;
				String ext_data = "";

				if (null != serverId) {
					String[] split = serverId.split("_");
					server_id = split[0];
					if (split.length > 1) {
						item = split[1];

					}
				}

				// String billNo = null == dataMap ? null :
				// dataMap.get("orderid");
				BillNo = null == dataMap ? null : dataMap.get("orderid");
				if (null == BillNo || 0 == BillNo.trim().length()) {
					// TODO生成订单
					String url = m_platformConfig.func_pay_url + "charge";
					HashMap<String, String> postData = new HashMap<String, String>();
					postData.put("category", category);
					postData.put("access_token", m_platformConfig.func_access_token + "");
					postData.put("item", item + "");
					postData.put("amount", amount + "");// 数量
					postData.put("server_id", server_id + "");
					postData.put("character_id", character_id + "");
					postData.put("ext_data", null == ext_data || 0 == ext_data.trim().length() ? ""
							: Base64.encodeToString(ext_data.getBytes(), Base64.DEFAULT));

					Log.e(TAG, "url = " + url + " , postData = " + postData);
					HttpUtils.getInstance(sContext).post(String.valueOf(System.currentTimeMillis()), url, postData,
							new FuncellResponseCallback() {

								@Override
								public void onResponse(String response) {
									// TODO Auto-generated method stub
									if (response == null) {
										Log.i(TAG, "获取订单失败");
										return;
										// 弹出提示
									}
									JSONTokener jsonParser = new JSONTokener(response);
									JSONObject person = null;
									try {
										person = (JSONObject) jsonParser.nextValue();
										Log.i(TAG, "person = " + person);
										String err_code = person.getString("error_code");
										if (err_code != null && err_code.trim().length() > 0)// 认证失败了
										{
											Log.e("PlatformInterface", "获取订单号失败" + err_code);
											return;
										}
									} catch (JSONException e) {
										// TODO Auto-generated catch block
										if (person == null) {
											e.printStackTrace();
											Log.e("PlatformInterface", "读取订单号地址信息出错了＝＝＝＝＝＝");
											return;
										}
									}

									try {
										// billNo =
										// person.getString("f_orderid");
										BillNo = person.getString("f_orderid");
										YYBPayTask(isFromSDK, server_id, character_id);

									} catch (JSONException e) {
										e.printStackTrace();
										Log.e("PlatformInterface", "读取订单号地址信息出错了＝＝");
										return;
									}

								}

								@Override
								public void onErrorResponse(String error) {
									// TODO Auto-generated method stub
									Log.i(TAG, "unfinished error is " + error);
								}

								@Override
								public void onErrorResponse(VolleyError error) {
									// TODO Auto-generated method stub

								}

							});
					return;
				}

				ScheduledExecutorService singleExecutorService = getSingleExecutorService();

				ScheduledFuture<?> payFuture;

				// if (!yybPayResultMap.isEmpty() && isFromSDK
				// && yybPayResultMap.containsKey(billNo)) {
				// Log.i(TAG, "yyb future is exist...");
				// return;
				// }
				if (!yybPayResultMap.isEmpty() && isFromSDK && yybPayResultMap.containsKey(BillNo)) {
					Log.i(TAG, "yyb future is exist...");
					return;
				}

				long initialDelay = 0;
				long delay = 30;

				if (isFromSDK) {
					initialDelay = 3;
					delay = 1;
				}

				HashMap<String, String> mDataMap = new HashMap<String, String>();
				mDataMap.put("access_token", m_platformConfig.func_access_token);
				mDataMap.put("client_id", m_platformConfig.func_ClientID);

				if (isFromSDK) {
					mDataMap.put("orderid", dataMap.get("orderid"));
					mDataMap.put("credential_type", dataMap.get("credential_type"));
					mDataMap.put("result_code", dataMap.get("result_code") + "");
					mDataMap.put("result_msg", dataMap.get("result_msg"));
					mDataMap.put("pay_channel", dataMap.get("pay_channel"));
					mDataMap.put("pay_state", dataMap.get("pay_state"));
					mDataMap.put("provide_state", dataMap.get("provide_state"));
					mDataMap.put("save_num", dataMap.get("save_num"));
					mDataMap.put("extend_info", dataMap.get("extend_info"));
					mDataMap.put("openid", dataMap.get("openid"));
					mDataMap.put("openkey", dataMap.get("openkey"));
					mDataMap.put("pay_token", dataMap.get("pay_token"));
					mDataMap.put("pf", dataMap.get("pf"));
					mDataMap.put("pfkey", dataMap.get("pfkey"));
					mDataMap.put("zoneid", dataMap.get("zoneid"));
					mDataMap.put("sign", getYYBPaySin(mDataMap, dataMap.get("sign")));
				}

				Log.i(TAG, "m_platformConfig.func_access_token = " + m_platformConfig.func_access_token);
				payFuture = singleExecutorService
						.scheduleWithFixedDelay(new YYBPayTaskRunable(m_platformConfig.func_access_token, mDataMap,
								isFromSDK, server_id, character_id), initialDelay, delay, TimeUnit.SECONDS);

				// yybPayResultMap.put(billNo, payFuture);
				yybPayResultMap.put(BillNo, payFuture);
				Log.i(TAG, "yyb future is add successed...");
			}
		}).start();
	}

	private static void YYBPayTask(boolean isFromSDK, String server_id, String character_id) {
		HashMap<String, String> mDataMap = new HashMap<String, String>();
		mDataMap.put("access_token", m_platformConfig.func_access_token);
		mDataMap.put("client_id", m_platformConfig.func_ClientID);

		ScheduledExecutorService singleExecutorService = getSingleExecutorService();

		ScheduledFuture<?> payFuture;

		if (!yybPayResultMap.isEmpty() && isFromSDK && yybPayResultMap.containsKey(BillNo)) {
			Log.i(TAG, "yyb future is exist...");
			return;
		}

		long initialDelay = 0;
		long delay = 30;

		mDataMap.put("orderid", BillNo);
		mDataMap.put("credential_type", credentialType);
		mDataMap.put("result_code", "");
		mDataMap.put("result_msg", "");
		mDataMap.put("pay_channel", "");
		mDataMap.put("pay_state", "");
		mDataMap.put("provide_state", "");
		mDataMap.put("save_num", "");
		mDataMap.put("extend_info", "");
		mDataMap.put("openid", m_platformConfig.func_platform_uid);
		mDataMap.put("openkey", userKey);
		mDataMap.put("pay_token", payToken);
		mDataMap.put("pf", pf);
		mDataMap.put("pfkey", pfKey);
		String zoneid = "1";
		mDataMap.put("zoneid", zoneid);
		mDataMap.put("sign", getYYBPaySin(mDataMap, appKey));

		Log.i(TAG, "m_platformConfig.func_access_token = " + m_platformConfig.func_access_token);
		payFuture = singleExecutorService.scheduleWithFixedDelay(
				new YYBPayTaskRunable(m_platformConfig.func_access_token, mDataMap, isFromSDK, server_id, character_id),
				initialDelay, delay, TimeUnit.SECONDS);

		yybPayResultMap.put(BillNo, payFuture);
		Log.i(TAG, "yyb future is add successed...");
	}

	private static class YYBPayTaskRunable implements Runnable {
		private String accessToken;
		private HashMap<String, String> mDataMap;

		private long startTime;
		private boolean isFromSDK;
		private final long intervalTime = 6 * 60 * 1000;
		private final int pollCount = 5;
		private final int maxPollCount = 6;
		private int currentPollCount = 0;
		private long delayTime = 0;
		private String mServerId, mRoleId;

		public YYBPayTaskRunable(String accessToken, HashMap<String, String> dataMap, boolean isFromSDK,
				String serverId, String roleId) {
			this.accessToken = accessToken;
			this.mDataMap = dataMap;
			startTime = System.currentTimeMillis();
			this.isFromSDK = isFromSDK;
			this.mServerId = serverId;
			this.mRoleId = roleId;

		}

		@Override
		public void run() {
			final String billNo = mDataMap.get("orderid");

			currentPollCount++;
			long currentTimeMillis = System.currentTimeMillis();
			if (currentTimeMillis - startTime > intervalTime) {// 当前时间超过最大间隔时间，就结束当前任务

				closeYYBTask(billNo);
				return;
			}
			String url = m_platformConfig.func_pay_callback;

			Log.i(TAG, "mDataMap = " + mDataMap.toString());

			HttpUtils.getInstance(sContext).post(String.valueOf(System.currentTimeMillis()), url, mDataMap,
					new FuncellResponseCallback() {

						@Override
						public void onResponse(String response) {
							// TODO Auto-generated method stub
							if (null == response) {
								return;
							}
							if ("success".equals(response)) {// 应用宝充值回调成功
								payCallbackNormal(billNo, accessToken);
								closeYYBTask(billNo);
								return;
							} else {// 应用宝充值回调失败
								Log.i(TAG, "yyb充值回调失败");
							}
						}

						@Override
						public void onErrorResponse(String error) {
							// TODO Auto-generated method stub

						}

						@Override
						public void onErrorResponse(VolleyError error) {
							// TODO Auto-generated method stub

						}
					});

			// String returnData = CPHttpResponse.doSendHttpPostResponse(url,
			// mDataMap);
			// Log.i(TAG, "yyb pay get order = " + returnData);
			// if (null != returnData) {
			// if ("success".equals(returnData)) {// 应用宝充值回调成功
			// payCallbackNormal(billNo, accessToken);
			// closeYYBTask(billNo);
			// return;
			// } else {// 应用宝充值回调失败
			// Log.i(TAG, "yyb充值回调失败");
			// }
			// }
			if (!isFromSDK) {
				doTask(false, null, mServerId, mRoleId);
				closeYYBTask(billNo);
				return;
			}

			switch (currentPollCount) {
			case 1:
				delayTime = 3;

				break;
			case 2:
				delayTime = 10;
				break;
			case 3:
				delayTime = 20;
				break;
			case 4:
				delayTime = 30;
				break;
			case 5:
				delayTime = 60;
				break;
			case 6:
				delayTime = 180;
				break;

			default:
				break;
			}
			if (maxPollCount < currentPollCount) {// 当前次数超过maxPollCount次，就通知游戏购买失败
				closeYYBTask(billNo);
				return;
			}

			if (pollCount == currentPollCount && isFromSDK) {// 当前次数超过pollCount次，就通知游戏购买失败
				doPayCallback("");
				closeYYBTask(billNo);
				// Utils.alert("亲，网络延迟可能造成到账时间延迟，请先试玩游戏，感谢支持!", sContext);
				Log.i(TAG, "pay task handing....");
			}

			Log.i(TAG, "delayTime = " + delayTime);
			try {
				TimeUnit.SECONDS.sleep(delayTime);
			} catch (InterruptedException e) {
				closeYYBTask(billNo);
			}
		}

	}

	private static String getYYBPaySin(HashMap<String, String> dataMap, String appKey) {

		StringBuilder sign = new StringBuilder();

		sign.append("access_token=").append(dataMap.get("access_token")).append("&");
		sign.append("client_id=").append(dataMap.get("client_id")).append("&");
		sign.append("credential_type=").append(dataMap.get("credential_type")).append("&");
		sign.append("extend_info=").append(dataMap.get("extend_info")).append("&");
		sign.append("openid=").append(dataMap.get("openid")).append("&");
		sign.append("openkey=").append(dataMap.get("openkey")).append("&");
		sign.append("orderid=").append(dataMap.get("orderid")).append("&");
		sign.append("pay_channel=").append(dataMap.get("pay_channel")).append("&");
		sign.append("pay_state=").append(dataMap.get("pay_state")).append("&");
		sign.append("pay_token=").append(dataMap.get("pay_token")).append("&");
		sign.append("pf=").append(dataMap.get("pf")).append("&");
		sign.append("pfkey=").append(dataMap.get("pfkey")).append("&");
		sign.append("provide_state=").append(dataMap.get("provide_state")).append("&");
		sign.append("result_code=").append(dataMap.get("result_code")).append("&");
		sign.append("result_msg=").append(dataMap.get("result_msg")).append("&");
		sign.append("save_num=").append(dataMap.get("save_num")).append("&");
		sign.append("zoneid=").append(dataMap.get("zoneid")).append("#");
		sign.append(appKey);

		Log.i(TAG, "sign str = " + sign.toString());

		// return CPHttpResponse.MD5(sign.toString());
		return Utils.stringTo32LowerCaseMD5(sign.toString());
	}

	/** 此接口只在渠道返回支付失败时调用，成功时不再调用 **/
	public static void doPayCallback(final String billNo) {
		// ((Activity) sContext).runOnUiThread(new Runnable() {
		//
		// @Override
		// public void run() {
		// TODO Auto-generated method stub
		if (billNo != null && billNo.length() > 3)
			Log.i(TAG, "pay call back success!!!");
		payCallbackNormal(billNo, m_platformConfig.func_access_token);
		// }
		// });

	}

	private static void doPayFeedbackTask(String billNo) {

		String url = m_platformConfig.func_pay_url + "confirm";

		JSONArray billNoJsonArray = new JSONArray();
		billNoJsonArray.put(billNo);

		Log.i(TAG, "billNoJsonArray = " + billNoJsonArray.toString());

		HashMap<String, String> postData = new HashMap<String, String>();
		postData.put("access_token",
				null == m_platformConfig.func_access_token ? "" : m_platformConfig.func_access_token);
		postData.put("action", "confirm");
		postData.put("f_orders", null == billNoJsonArray.toString() ? "" : billNoJsonArray.toString());

		HttpUtils.getInstance(sContext).post(null, url, postData, new FuncellResponseCallback() {

			@Override
			public void onResponse(String response) {
				Log.i(TAG, "pay confirm response data is = " + response);

				if (null != response) {

					try {
						JSONObject jsonObject = new JSONObject(response);

						String errorCode = jsonObject.getString("error_code");
						Log.i(TAG, "pay confim response errorCode is " + errorCode);
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}

			}

			@Override
			public void onErrorResponse(String error) {
				Log.i(TAG, "pay confim error : " + error);
			}

			@Override
			public void onErrorResponse(VolleyError error) {
				// TODO Auto-generated method stub

			}
		});

	}

	/**
	 * 激活统计
	 * 
	 * 
	 */

	// token
	// 如果是处于登录状态，其值为平台给的accesstoken；否则不传。
	// token2
	// 如果未处于登录状态，则传该参数，否则不传。其值为：
	// {client_id:值,device_id:设备id}
	// 将该json进行base64编码。
	// eventId
	// 事件id。如登录事件定义为22
	// time
	// 事件时间unixtime
	// param
	// 事件参数，可为json也可为字符串
	public static void doActiveLogCollect(String url, JSONObject paramJSONObject) {

		HashMap<String, String> postData = new HashMap<String, String>();
		JSONObject dataJSONObject = new JSONObject();

		JSONObject dataItemJSONObject = new JSONObject();

		JSONObject token2JSONObject = new JSONObject();

		try {
			token2JSONObject.put("client_id", m_platformConfig.func_ClientID + "");
			token2JSONObject.put("device_id", null == Utils.getAndroid_ID(sContext) ? m_platformConfig.func_ClientID
					: Utils.getAndroid_ID(sContext));

			String str = "{\"client_id\":\"" + m_platformConfig.func_ClientID + "\",\"device_id\":\""
					+ (null == Utils.getAndroid_ID(sContext) ? m_platformConfig.func_ClientID
							: Utils.getAndroid_ID(sContext))
					+ "\"}";
			String token2 = Base64.encodeToString(str.getBytes(), Base64.DEFAULT);
			token2 = token2.replaceAll("\n", "");
			dataItemJSONObject.put("token2", token2);// {client_id:值,device_id:设备id}

			dataItemJSONObject.put("eventId", "U1001");// 事件ID
			dataItemJSONObject.put("time", Utils.getTimestamp());// 时间戳
			dataItemJSONObject.put("param", paramJSONObject);// json字符串

			JSONArray dataJSONArray = new JSONArray();
			dataJSONArray.put(dataItemJSONObject);

			dataJSONObject.put("data", dataJSONArray);

			String eventdata = dataJSONObject.toString();

			postData.put("eventdata", eventdata);

			Log.i(TAG, postData.toString());

			HttpUtils.getInstance(sContext).post(null, url, postData, new FuncellResponseCallback() {

				@Override
				public void onResponse(String response) {
					if (null != response) {

						try {
							JSONObject jsonObject = new JSONObject(response);

							String errorCode = jsonObject.getString("code");
							Log.i(TAG, "Active Log errorCode is " + errorCode);
						} catch (JSONException e) {
							e.printStackTrace();
						}
					}
				}

				@Override
				public void onErrorResponse(String error) {
					Log.i(TAG, "Active Log error is " + error);
				}

				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub

				}
			});
		} catch (JSONException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public static void setYYBPayTokenAndUserKey(String mPayToken, String mUserKey, String mCredentialType, String mpf,
			String mpfKey, String mAppKey) {
		payToken = mPayToken;
		userKey = mUserKey;
		credentialType = mCredentialType;
		pf = mpf;
		pfKey = mpfKey;
		appKey = mAppKey;
	}

	public static void doAntiAddictionQuery() {
		sDoPlatform.doAntiAddictionQuery(m_platformConfig.func_platform_uid, m_platformConfig.func_access_token);
	}

	public static String getClientId() {
		return CLIENT_ID;
	}

	private static void setClientId(String clientId) {
		CLIENT_ID = clientId;
	}

	public static String getAccessToken() // 只能游戏在主线程调用，内部不能调用
	{
		if (System.currentTimeMillis() - currentTime > ACCESS_TOKEN_EXPIRE_TIME) {
			refresh_token_request(new RefreshTokenCallback() {

				@Override
				public void onSuccess() {
					// TODO Auto-generated method stub

				}

				@Override
				public void onFail() {
					// TODO Auto-generated method stub

				}
			});
		}
		currentTime = System.currentTimeMillis();

		return m_platformConfig.func_access_token;
	}

	private static final long ACCESS_TOKEN_EXPIRE_TIME = 3 * 60 * 60;

	private static long currentTime;

	private static long getCurrentTime() {
		return System.currentTimeMillis();
	}

	// 长明专用
	public static native void setPercent(int percent);

	public static native void setFailTag(int tag);

	public static native void setMemoryInfo(int memFreeInSys, int memUsedBySelf);

	public static native void setRepair(int repairFlag);

	public interface OnMiddlePlatformInitListener {
		void initThirdSdk(String argu);
	}

	public static OnMiddlePlatformInitListener mOnMiddlePlatformInitListener;

	public static void setOnMiddlePlatformInitListener(OnMiddlePlatformInitListener onMiddlePlatformInitListener) {
		mOnMiddlePlatformInitListener = onMiddlePlatformInitListener;
	}

	public static void onPause() {

	}

	public static void onResume() {

	}

	// facebook Invitation
	public static void FuncellFacebookInvitation() {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.doFacebookInvitation();
			Log.i(TAG, " Funcell Facebook Invitation .......");
		}
	}

	// facebook share
	public static void FuncellFacebookShare(String title, String subtitle, String description, String imageurl,
			String contenturl) {
		sDoPlatform.doFacebookShare(title, subtitle, description, imageurl, contenturl);
	}

	// facebook share callback
	public static native void FuncellFacebookShareResult(boolean isSuccess, String message);

	static Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			if (1 == msg.what) {
				String billnoArray = msg.obj.toString();
				JSONArray jsonArray;
				try {
					jsonArray = new JSONArray(billnoArray);

					int length = jsonArray.length();
					for (int i = 0; i < length; i++) {
						String billno = jsonArray.getString(i);
						payCallbackNormal(billno, m_platformConfig.func_access_token);
						Log.i(TAG, "pay : to game billno is " + billno);
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (1001 == msg.what) {
				// TODO 封装日志数据json paraData
				JSONObject paramJSONObject = new JSONObject();

				String client = m_platformConfig.func_ClientID;
				String model = Utils.getPhoneModel();
				String version = Utils.getPhoneVersion();
				String device = null == Utils.getAndroid_ID(sContext) ? m_platformConfig.func_ClientID
						: Utils.getAndroid_ID(sContext);
				String width = Utils.getPhoneWidht((Activity) sContext);
				String height = Utils.getPhoneHeight((Activity) sContext);
				String ip = Utils.getCurrentIp((Activity) sContext);
				/*
				 * sdk init时上传设备硬件信息不上传时间戳 String unixtimestamp =
				 * Utils.getTimestamp();
				 */
				String ram = Utils.getAvailMemory(sContext) / (1024 * 1024) + "/"
						+ Utils.getTotalMemory() / (1024 * 1024);
				String rom = Utils.getAvailableInternalMemorySize() / (1024 * 1024) + "/"
						+ Utils.getTotalInternalMemorySize() / (1024 * 1024);
				String sdcard = Utils.getAvailableExternalMemorySize() / (1024 * 1024) + "/"
						+ Utils.getTotalExternalMemorySize() / (1024 * 1024);

				try {
					paramJSONObject.put("ram", ram);

					paramJSONObject.put("rom", Utils.setLogToBiEncoder(rom));
					paramJSONObject.put("sdcard", Utils.setLogToBiEncoder(sdcard));
					paramJSONObject.put("game", gameID + "");
					paramJSONObject.put("client", Utils.setLogToBiEncoder(client) + "");
					paramJSONObject.put("fgi", platformID + "");
					paramJSONObject.put("platform", Utils.setLogToBiEncoder(getPlatFormType()) + "");
					paramJSONObject.put("model", Utils.setLogToBiEncoder(model) + "");
					paramJSONObject.put("version", Utils.setLogToBiEncoder(version) + "");
					paramJSONObject.put("device", Utils.setLogToBiEncoder(device) + "");
					paramJSONObject.put("height", Utils.setLogToBiEncoder(height) + "");
					paramJSONObject.put("width", Utils.setLogToBiEncoder(width) + "");
					paramJSONObject.put("ip", TextUtils.isEmpty(ip) ? "" : Utils.setLogToBiEncoder(ip) + "");
					// paramJSONObject.put("unixtimestamp", unixtimestamp + "");

					Log.i(TAG, paramJSONObject.toString());

					doActiveLogCollect(m_platformConfig.func_log_url, paramJSONObject);

				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

		}

	};

	public static void showGoogleGameCenterDialog() {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.showGoogleGameCenterDialog();
			Log.i(TAG, " showGoogleGameCenterDialog() .......");
		}
	}

	public static void submitGoogleGameLeaderBoardScore(int score, String googleGameLeaderboardID) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.submitGoogleGameLeaderBoardScore(score, googleGameLeaderboardID);
			Log.i(TAG, " submitGoogleGameLeaderBoardScore(" + score + " , " + googleGameLeaderboardID + ") .......");
		}
	}

	public static void unlockGoogleGameAchievements(String achievementsID) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.unlockGoogleGameAchievements(achievementsID);
			Log.i(TAG, " unlockGoogleGameAchievements(" + achievementsID + ") .......");
		}
	}

	/*****************************************************************************
	 * 第三方统计
	 *****************************************************************************/
	/**
	 * 赠予虚拟币 【用途和用法】
	 * 遊戲中除了可通過充值來獲得虛擬幣外，可能會在任務獎勵、登錄獎勵、成就獎勵等環節免費發放給玩家虛擬幣，來培養他們使用虛擬幣的習慣
	 * 。開發者可通過此方法跟蹤全部免費贈予虛擬幣的數據。 在成功向玩家贈予虛擬幣時調用onReward方法來傳入相關數據。
	 * 只獲得過贈予虛擬幣的玩家不會被記為付費玩家。贈予的虛擬幣會計入到所有的虛擬幣產出中，也計入到留存虛擬幣中。
	 * 
	 * 
	 * 
	 * @param virtualCurrencyAmount
	 *            虛擬幣金額
	 * @param reason
	 *            贈送虛擬幣原因/類型
	 *            [贈送虛擬幣原因/類型。格式：32個字符內的中文、空格、英文、數字。不要帶有任何開發中的轉義字符，如斜槓
	 *            。注意：最多支持100種不同原因。]
	 */
	public static void onReward(double virtualCurrencyAmount, String reason) {
		// 示例
		// 玩家在完成了新手引導後，成功獲得了免費贈送的5個鑽石：
		// GameXDDAgent.onReward(5, "新手獎勵");

		if (null != thirdOtherInterface) {
			thirdOtherInterface.onReward(virtualCurrencyAmount, reason);
			Log.i(TAG, " onReward(" + virtualCurrencyAmount + ", " + reason + ") ");
		}
	}

	/**
	 * 跟蹤遊戲消費點 記錄付費點 【用途和用法】 跟蹤遊戲中全部使用到虛擬幣的消費點，如購買虛擬道具、VIP服務、復活等 跟蹤某物品或服務的耗盡
	 * 在任意消費點發生時盡快調用onPurchase，在某個道具/服務被用掉（消失）時盡快調用onUse
	 * 消費點特指有價值的虛擬幣的消費過程，如果遊戲中存在普通遊戲金幣可購買的虛擬物品，不建議在此處統計。
	 * 
	 * 
	 * @param item
	 *            某個消費點的編號[某個消費點的編號,最多32個字符]
	 * @param itemNumber
	 *            消費數量
	 * @param priceInVirtualCurrency
	 *            虛擬幣單價 該方法在任意消費點發生時盡快調用
	 */
	public static void onPurchase(String item, int itemNumber, double priceInVirtualCurrency) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.onPurchase(item, itemNumber, priceInVirtualCurrency);
			Log.i(TAG, " onPurchase(" + item + " , " + itemNumber + " , " + priceInVirtualCurrency + ") ");
		}
	}

	/**
	 * 跟蹤遊戲消費點 消耗物品或服务等
	 * 
	 * @param item
	 *            某個消費點的編號[某個消費點的編號,最多32個字符]
	 * @param itemNumber
	 *            消費數量 在某個道具/服務被用掉（消失）調用
	 */
	public static void onUse(String item, int itemNumber) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.onUse(item, itemNumber);
			Log.i(TAG, " onUse(" + item + " , " + itemNumber + ") ");
		}
	}

	/**
	 * 任務,關卡或副本 接受/进入 【用途和用法】 跟蹤玩家任務/關卡/副本的情況。
	 * 同一個missionId如果在未結束前，重復進行了onBegin調用，則重新開始計時，上一次的調用被丟棄
	 * 如果多個不同的MissionID同時在進行（都調用了開始，但並未完成或失敗），他們都會同時進行計時，而不是只有一個計時其他暫停計時。
	 * 
	 * @param missionId
	 *            任務,關卡或副本的編號 [任務,關卡或副本的編號,最多32個字符,此處可填寫ID,別名,可在報表編輯]
	 */
	public static void onBegin(String missionId) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.onBegin(missionId);
			Log.i(TAG, " onBegin(" + missionId + ") ");
		}
	}

	/**
	 * 任務,關卡或副本 完成
	 * 
	 * @param missionId
	 *            任務,關卡或副本的編號 [任務,關卡或副本的編號,最多32個字符,此處可填寫ID,別名,可在報表編輯]
	 */
	public static void onCompleted(String missionId) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.onCompleted(missionId);
			Log.i(TAG, " onCompleted(" + missionId + ") ");
		}
	}

	/**
	 * 任務,關卡或副本 失败
	 * 
	 * @param missionId
	 *            任務,關卡或副本的編號 [任務,關卡或副本的編號,最多32個字符,此處可填寫ID,別名,可在報表編輯]
	 * @param cause
	 *            失敗原因 [失敗原因,最多16個字符,共支持100個原因]
	 */
	public static void onFailed(String missionId, String cause) {
		if (null != thirdOtherInterface) {
			Log.i(TAG, " onFailed(" + missionId + " , " + cause + ") ");
			thirdOtherInterface.onFailed(missionId, cause);
		}
	}

	/**
	 * 自定義跟蹤事件 【用途和用法】 用於統計任何您期望去跟蹤的數據，如：點擊某功能按鈕、填寫某個輸入框、觸發了某個廣告等。
	 * 可以自行定義eventId，在遊戲中需要跟蹤的位置進行調用，注意eventId中僅限使用中英文字符、數字和下划線，不要加空格或其他的轉義字符。
	 * 除了可以統計某自定義eventId的觸發次數外
	 * ，還可以通過key-value參數來對當時觸發事件時的屬性進行描述。如定義eventId為玩家死亡事件
	 * ，可添加死亡時關卡、死亡時等級、死亡時攜帶金幣等屬性，通過key-value進行發送。 每款遊戲可定義最多10000個不同eventId。
	 * 注意:當前自定義統計可根據我方產品需要統計的點來進行定義,向我方獲取統計表
	 * eventId、JsonEventData的key和String類型的value，分別最多支持32個字符。
	 * 
	 * @param eventId
	 * @param eventData
	 */
	public static void onEvent(String eventId, final String jsonEventData) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.onEvent(eventId, jsonEventData);
			Log.i(TAG, " onEvent(" + eventId + " , " + jsonEventData + ") ");
		}
	}

	/**
	 * Efun-新马----事件追踪（过完新手调用）
	 */
	public void efunTrackingFinshGuideEvent() {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.efunTrackingFinshGuideEvent();
			Log.i(TAG, " efunTrackingFinshGuideEvent() ");
		}
	}

	/**
	 * 
	 */
	public static void cleanMemory(Context context) {
		// Utils.cleanMemory(context);
	}

	/**
	 * 快用是否有用户中心
	 * 
	 */
	public static boolean IsSupportUserCenter() {
		boolean flag = true;
		if (null != thirdOtherInterface) {
			flag = thirdOtherInterface.IsSupportUserCenter();
		}
		return flag;
	}

	/**
	 * vstargame越南游戏CDN资源加载监控
	 */
	public static void onGameResLoading(String resName, String resVersion, long totalSize, long currentSize,
			float speed) {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.onGameResLoading(resName, resVersion, totalSize, currentSize, speed);
		}
	}

	public static void setIsFirstOpen(Context context, boolean isFirst) {
		SharedPreferences sp = context.getSharedPreferences("funcell", Context.MODE_PRIVATE);
		Editor editor = sp.edit();
		editor.putBoolean("isFirst", isFirst);
		editor.commit();
	}

	public static boolean getIsFirstOpen(Context context) {
		SharedPreferences sp = context.getSharedPreferences("funcell", Context.MODE_PRIVATE);
		return sp.getBoolean("isFirst", true);
	}

	public static void showMap() {
		if (null != thirdOtherInterface) {
			thirdOtherInterface.onShow();
		}
	}

	public static String getMsdkData() {
		if (null != thirdOtherInterface) {
			Log.i(TAG, "run getMsdkData");
			return thirdOtherInterface.getMsdkData();
		} else {
			return null;
		}
	}

	public static void uploadMsdkLog(String log) {
		if (null != thirdOtherInterface) {
			Log.i(TAG, "run uploadMsdkLog");
			thirdOtherInterface.uploadMsdkLog(log);
		}
	}

	public static String getChildChannel() {
		Log.i(TAG, "run getChildChannel begin");
		if (null == thirdOtherInterface) {
			return null;
		}

		Log.i(TAG, "run getChildChannel end");
		return thirdOtherInterface.doGetChildChannel();
	};

	// kaopu
	public static String getKaoPuOpenId() {
		if (null == thirdOtherInterface) {
			return null;
		}
		return thirdOtherInterface.doGetOpenId();
	}

	public static String getKaopuToken() {
		if (null == thirdOtherInterface) {
			return null;
		}
		return thirdOtherInterface.doGetToken();
	}

	public static String getKaoPuNextChannel() {
		if (null == thirdOtherInterface) {
			return null;
		}
		return thirdOtherInterface.doGetNextChannel();
	}

	/** 平台是否有子渠道--BI上传 **/

	private static String getPlatFormType() {
		if (TextUtils.isEmpty(getChildChannel())) {

			return platform_type;
		}
		return platform_type + "_" + getChildChannel();

	}

	/**
	 * 靠谱渠道判断是否是android平台
	 * 
	 * @return
	 */
	public static boolean getNowTypeIsAndroid() {

		if (null == thirdOtherInterface) {
			return true;
		}

		return thirdOtherInterface.getNowTypeIsAndroid();
	}

	public static int getAddictionInfo() {
		if (null == thirdOtherInterface) {
			return 0;
		}

		return thirdOtherInterface.getAddictionInfo();
	}
}
