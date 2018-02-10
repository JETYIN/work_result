package com.funcell.platform.android.game.proxy.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.security.MessageDigest;

import com.funcell.platform.android.game.proxy.FuncellPlatformInterface;
import com.funcell.platform.android.permissions.FuncellPermissionsManager;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.provider.Settings.Secure;
import android.support.annotation.NonNull;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;

public class FuncellTools {
	private static String TAG = "FuncellTools";
	public static final String DIRECTORY_NAME = "FuncellSdk";
	private static final boolean isDebug = true;
	private static Intent mIntent = null;
	private static String adverId = "";

	public static Intent getmIntent() {
		return mIntent;
	}

	public static void setmIntent(Intent intent) {
		mIntent = intent;
	}

	public static int dip2px(Context context, float dpValue) {
		float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5F);
	}

	public boolean isMainThread() {
		boolean isMainThread = Looper.myLooper() == Looper.getMainLooper();
		return isMainThread;
	}

	/**
	 * 检测是否有网络
	 * 
	 * @param act
	 * @return
	 */
	public static boolean isNetworkAvailable(Context context) {
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = cm.getActiveNetworkInfo();
		if (info != null && info.getState() == NetworkInfo.State.CONNECTED) {
			return true;
		}
		return false;
	}

	/**
	 * 回去电话号码
	 * 
	 * @param context
	 * @return
	 */
	public static String getPhoneNum(Context context) {
		String number = "";
		if (!FuncellPermissionsManager.hasPermissions(context, Manifest.permission.READ_PHONE_STATE)) {
			Log.e(TAG, "----getPhoneNum:no permision read phone");
			return number;
		}
		try {

			TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			number = telephonyManager.getLine1Number();
			Log.e(TAG, "****phone:" + number);
		} catch (Exception e) {
			Log.e(TAG, "----get PhoneNum exception");
			e.printStackTrace();
		}
		return null == number ? "" : number;
	}

	/**
	 * 获取imei
	 * 
	 * @param context
	 * @return
	 */
	public static String getImei(Context context) {
		String imei = "";
		if (!FuncellPermissionsManager.hasPermissions(context, Manifest.permission.READ_PHONE_STATE)) {
			Log.e(TAG, "----getImei:no permision read phone");
			return imei;
		}
		try {
			imei = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
			Log.e(TAG, "****imei:" + imei);
		} catch (Exception e) {
			// TODO: handle exception
			Log.e(TAG, "----get imei exception");
			e.printStackTrace();
		}

		return null == imei ? "" : imei;
	}

	/**
	 * 获取googleId
	 * 
	 * @param paramContext
	 * @return
	 */
	public static String getAdvertisingId() {

		return adverId;
	}

	/**
	 * 先线程执行获取googleId
	 * 
	 * @param context
	 */

	public static void initGoogleId(final Context context) {
		if (isGoogleAvailable()) {
			Log.e(TAG, "****current include google jar");
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					adverId = GoogleUtils.getGoogleId(context);

				}
			}).start();
		}
	}

	/**
	 * class.forName如果包含有google jar包进行获取googleId、需要在manifest中配置google play 版本
	 * 
	 * @return
	 */
	private static boolean isGoogleAvailable() {
		Log.e(TAG, "****invoke--isGoogleAvailable");
		boolean isAvailable = false;
		try {
			isAvailable = null != Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			Log.e(TAG, "------isGoogleAvailable exception");
			e.printStackTrace();
		}
		return isAvailable;

	}

	public static String getCPU() {
		String ret = "";
		ret = android.os.Build.CPU_ABI;
		return ret;
	}

	public static String getRAM(Context mCon) {
		String str1 = "/proc/meminfo";// 系统内存信息文件
		String str2;
		String[] arrayOfString;
		long initial_memory = 0;

		try {
			FileReader localFileReader = new FileReader(str1);
			BufferedReader localBufferedReader = new BufferedReader(localFileReader, 8192);
			str2 = localBufferedReader.readLine();// 读取meminfo第一行，系统总内存大小

			arrayOfString = str2.split("\\s+");
			for (String num : arrayOfString) {
				Log.i(str2, num + "\t");
			}

			initial_memory = Integer.valueOf(arrayOfString[1]).intValue();
			localBufferedReader.close();

		} catch (IOException e) {
		}
		return initial_memory / (Double) 1024.00 + "";// Byte转换为KB或者MB，内存大小规格化
	}

	public static String getScreenPiexl(Context context) {
		String ret = "";

		DisplayMetrics metric = new DisplayMetrics();
		if (metric != null) {
			((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
			ret = "" + metric.widthPixels + "X" + metric.heightPixels;
		}
		return ret;
	}

	public static String getMobileServiceProvider(Context context) {
		String ret = "";
		String IMSI = "";
		String ProvidersName = null;
		TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

		// 返回唯一的用户ID;就是这张卡的编号神马的
		try {
			IMSI = telephonyManager.getSubscriberId();
			if (IMSI != null) {
				// IMSI号前面3位460是国家，紧接着后面2位00 02是中国移动，01是中国联通，03是中国电信。
				if (IMSI.startsWith("46000") || IMSI.startsWith("46002")) {
					ProvidersName = "中国移动";
				} else if (IMSI.startsWith("46001")) {
					ProvidersName = "中国联通";
				} else if (IMSI.startsWith("46003")) {
					ProvidersName = "中国电信";
				} else {
					ProvidersName = "其他";
				}
			} else {
				ProvidersName = "无";
			}
		} catch (Exception ex) {
			Log.e("error", ex.getMessage());
			ProvidersName = "无";
		}
		ret = ProvidersName;
		return ret;
	}

	public static String readChannelCodeFromSDCard(String fileName) {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
			File sdCardDir = Environment.getExternalStorageDirectory();
			File file = new File(sdCardDir + File.separator + DIRECTORY_NAME, fileName);
			if (!file.exists()) {
				System.err.println("channel file is not exists................");
				return null;
			}
			FileInputStream inputStream = null;
			try {
				inputStream = new FileInputStream(file);
				byte[] b = new byte[inputStream.available()];
				inputStream.read(b);
				return new String(b);
			} catch (Exception e) {

			} finally {
				if (null != inputStream) {
					try {
						inputStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

		return null;
	}

	public static void logError(String tag, String msg) {
		if (isDebug) {
			Log.e(tag, msg);
		}
	}

	public static String getMetaDataByKey(Context context, String key) {
		ApplicationInfo appi;
		Bundle infobundle = null;
		try {
			appi = context.getPackageManager().getApplicationInfo(context.getPackageName(),
					PackageManager.GET_META_DATA);
			infobundle = appi.metaData;
		} catch (NameNotFoundException e) {
			logError("HWSDK", "渠道code未配置");
			e.printStackTrace();
		}

		return null == infobundle ? null : infobundle.get(key).toString();
	}

	public static boolean writeChannelCodeToSDCard(String fileName, String channelCode) {
		if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {

			File sdCardDir = Environment.getExternalStorageDirectory();// 获取SDCard目录,2.2的时候为:/mnt/sdcard
																		// 2.1的时候为：/sdcard，所以使用静态方法得到路径会好一点。
			File dirFile = new File(sdCardDir + File.separator + DIRECTORY_NAME);
			File file = new File(sdCardDir + File.separator + DIRECTORY_NAME + File.separator + fileName);
			if (dirFile.exists()) {
				if (file.exists()) {
					return true;
				}
			} else {
				dirFile.mkdir();

			}

			FileOutputStream outStream = null;
			try {
				outStream = new FileOutputStream(file);
				outStream.write(channelCode.getBytes());
				return true;
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (null != outStream) {
					try {
						outStream.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		}

		return false;
	}

	public static String getChannelCode(Context context) {

		String packageName = context.getPackageName();

		String funcellChanel = readChannelCodeFromSDCard(packageName);

		if (null != funcellChanel && 0 < funcellChanel.trim().length()) {
			return funcellChanel;
		}

		// read manifest.xml中滴meda-data
		funcellChanel = getMetaDataByKey(context, "FUNCELL_CHANNEL_TEST");
		if (null == funcellChanel || 0 == funcellChanel.trim().length()) {
			logError("FuncellSDK", "FUNCELL_CHANNEL_TEST未配置");
		}

		writeChannelCodeToSDCard(packageName, funcellChanel);

		return funcellChanel;
	}

	public static String stringToBase64(String source) {
		return Base64.encodeToString(source.getBytes(), Base64.NO_WRAP);
	}

	public final static String stringTo32LowerCaseMD5(String s) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		try {
			byte[] strTemp = s.getBytes();
			// 使用MD5创建MessageDigest对象
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(strTemp);
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte b = md[i];
				// System.out.println((int)b);
				// 将没个数(int)b进行双字节加密
				str[k++] = hexDigits[b >> 4 & 0xf];
				str[k++] = hexDigits[b & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			return null;
		}
	}

	public static String getNetType(Context context) {
		String ret = "";
		ConnectivityManager mConnectivityManager = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
		if (mNetworkInfo != null && mNetworkInfo.isAvailable()) {
			int type = mNetworkInfo.getType();
			if (ConnectivityManager.TYPE_WIFI == type) {
				ret = "wifi";
			} else if (ConnectivityManager.TYPE_MOBILE == type) {
				ret = "3g";
				int subtype = mNetworkInfo.getSubtype();
				switch (subtype) {
				case TelephonyManager.NETWORK_TYPE_GPRS:
				case TelephonyManager.NETWORK_TYPE_EDGE:
				case TelephonyManager.NETWORK_TYPE_CDMA:
				case TelephonyManager.NETWORK_TYPE_1xRTT:
				case TelephonyManager.NETWORK_TYPE_IDEN:
					ret = "2g";
					break;

				case TelephonyManager.NETWORK_TYPE_UMTS:
				case TelephonyManager.NETWORK_TYPE_EVDO_0:
				case TelephonyManager.NETWORK_TYPE_EVDO_A:
				case TelephonyManager.NETWORK_TYPE_HSDPA:
				case TelephonyManager.NETWORK_TYPE_HSUPA:
				case TelephonyManager.NETWORK_TYPE_HSPA:
				case TelephonyManager.NETWORK_TYPE_EVDO_B:
				case TelephonyManager.NETWORK_TYPE_EHRPD:
				case TelephonyManager.NETWORK_TYPE_HSPAP:
					ret = "3g";
					break;

				case TelephonyManager.NETWORK_TYPE_LTE:
					ret = "4g";
					break;

				default:
					ret = "未知";
					break;
				}

			} else {
				ret = "未知";
			}
		}
		return ret;
	}

	public static String getPhoneVersion() {
		return "android_" + Build.BRAND + "_" + Build.VERSION.RELEASE;
	}

	public static String getPhoneModel() {
		return Build.MODEL;
	}

	static ProgressDialog sProgressDialog;

	public static void startProgress(final String msg, final Context context) {
		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				try {
					dimssProgress(context);

					// sProgressDialog = ProgressDialog.show(
					// context,
					// context.getResources().getString(
					// RUtils.string(context, "funcell_tip")),
					// msg, true);
					// sProgressDialog.setProgressStyle(ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
					// sProgressDialog.setCancelable(false);

					sProgressDialog = new ProgressDialog(context, ProgressDialog.THEME_DEVICE_DEFAULT_LIGHT);
					sProgressDialog.setCancelable(false);
					sProgressDialog.setTitle(context.getResources().getString(RUtils.string(context, "funcell_tip")));
					sProgressDialog.setMessage(msg);
					sProgressDialog.show();
				} catch (Exception ex) {
					Log.v("ddd", ex.getMessage());
				}
			}
		});
	}

	public static void dimssProgress(final Context context) {
		((Activity) context).runOnUiThread(new Runnable() {

			@Override
			public void run() {
				try {
					if (sProgressDialog != null && sProgressDialog.isShowing()) {
						sProgressDialog.dismiss();
					}
				} catch (Exception ex) {
					Log.v("ddd", ex.getMessage());
				}
			}
		});
	}

	public static void alert(final String mess, final Context context) {
		((Activity) context).runOnUiThread(new Runnable() {
			@Override
			public void run() {
				AlertDialog.Builder builder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);

				builder.setTitle(context.getResources().getString(RUtils.string(context, "funcell_tip")));

				// builder.setIcon(context.getResources().getDrawable(R.drawable.icon));
				builder.setMessage(mess);
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						dialog.dismiss();
					}
				});
				builder.create().show();
			}
		});
	}

	/**
	 * 获取当前时间（以秒为单位的时间戳）
	 * 
	 * @return
	 */
	public static String getTimestamp() {
		long time = System.currentTimeMillis();
		String timestamp = String.valueOf(time);
		if (timestamp.length() >= 10) {
			timestamp = timestamp.substring(0, 10);
		}
		return timestamp;
	}

	/**
	 * 
	 * @param context
	 * @return
	 */
	public static String getAndroidId(Context context) {
		String aid = "";
		try {
			aid = Secure.getString(context.getContentResolver(), Secure.ANDROID_ID);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return aid;
	}

	public static int getAppVersionCode(Context context) {
		int versionCode = -1;
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			Log.d(TAG, "versionName:" + info.versionCode);
			versionCode = info.versionCode;
		} catch (NameNotFoundException e) {
			Log.e(TAG, "", e);
		}
		return versionCode;
	}

	public static String getAppVersionName(Context context) {
		String versionName = "-1.0";
		try {
			PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
			Log.d(TAG, "versionName:" + info.versionName);
			versionName = info.versionName;
		} catch (NameNotFoundException e) {
			Log.e(TAG, "", e);
		}
		return versionName;
	}

	public enum DevEngineType {
		Unity3D("com.unity3d.player.UnityPlayerActivity"), Cocos2dx("org.cocos2dx.lib.Cocos2dxActivity"), AdobeAir(
				"com.adobe.fre.FREContext"), Java(null);

		private final String name;

		private DevEngineType(String str) {
			name = str;
		}

		public boolean equalsName(String otherName) {
			return otherName == null ? false : name.equals(otherName);
		}

		public String toString() {
			return this.name;
		}
	}

	public static DevEngineType DevEngine() {
		// Class clazz = null;
		// try {
		// clazz = Class.forName("com.unity3d.player.UnityPlayerActivity");
		// if (clazz != null) {
		// Log.i(TAG,"DevEngine is Unity3D");
		// return DevEngineType.Unity3D;
		// }
		// } catch (ClassNotFoundException localClassNotFoundException) {
		// try {
		// clazz = Class.forName("com.adobe.fre.FREContext");
		// if (clazz != null) {
		// Log.i(TAG,"DevEngine is AdobeAir");
		// return DevEngineType.AdobeAir;
		// }
		// } catch (ClassNotFoundException localClassNotFoundException1) {
		// try {
		// clazz = Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
		// if (clazz != null) {
		// Log.i(TAG,"DevEngine is Cocos2d-x");
		// return DevEngineType.Cocos2dx;
		// }
		// } catch (ClassNotFoundException localClassNotFoundException2) {
		// if (clazz == null) {
		// Log.i(TAG,"DevEngine is Java");
		// return DevEngineType.Java;
		// }
		// }
		// }
		// }

		Class clazz = null;
		try {
			clazz = Class.forName("org.cocos2dx.lib.Cocos2dxActivity");
			if (clazz != null) {
				Log.i(TAG, "DevEngine is Cocos2d-x");
				return DevEngineType.Cocos2dx;
			}
		} catch (ClassNotFoundException localClassNotFoundException) {
			try {
				clazz = Class.forName("com.adobe.fre.FREContext");
				if (clazz != null) {
					Log.i(TAG, "DevEngine is AdobeAir");
					return DevEngineType.AdobeAir;
				}
			} catch (ClassNotFoundException localClassNotFoundException1) {
				try {
					clazz = Class.forName("com.unity3d.player.UnityPlayerActivity");
					if (clazz != null) {
						Log.i(TAG, "DevEngine is Unity3D");
						return DevEngineType.Unity3D;
					}
				} catch (ClassNotFoundException localClassNotFoundException2) {
					if (clazz == null) {
						Log.i(TAG, "DevEngine is Java");
						return DevEngineType.Java;
					}
				}
			}
		}

		return DevEngineType.Java;
	}

	public static int dp2Pixel(Context context, int dp) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dp * scale + 0.5f);
	}

	public static boolean getGenericInterfacesType(@NonNull Object instance, @NonNull Class<?> cls) {
		if (instance == null || cls == null) {
			return false;
		}
		Type type = ((ParameterizedType) instance.getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
		if (type == cls) {
			return true;
		}
		return false;
	}

	public static boolean copyFile(final InputStream inputStream, String dest) {
		FileOutputStream oputStream = null;
		try {
			File destFile = new File(dest);
			File parentDir = destFile.getParentFile();
			if (!parentDir.isDirectory() || !parentDir.exists()) {
				destFile.getParentFile().mkdirs();
			}
			oputStream = new FileOutputStream(destFile);
			byte[] bb = new byte[48 * 1024];
			int len = 0;
			while ((len = inputStream.read(bb)) != -1) {
				oputStream.write(bb, 0, len);
			}
			oputStream.flush();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (oputStream != null) {
				try {
					oputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
