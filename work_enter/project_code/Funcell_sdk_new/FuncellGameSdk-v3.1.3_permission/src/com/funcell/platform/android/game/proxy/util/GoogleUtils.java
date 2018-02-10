package com.funcell.platform.android.game.proxy.util;

import com.funcell.platform.android.permissions.FuncellPermissionsManager;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;

import android.Manifest;
import android.content.Context;
import android.util.Log;

public class GoogleUtils {

	private static String TAG = "FuncellTools";

	/**
	 * 不需要权限,需要设置mate-data并且设置version
	 * 
	 * @param context
	 * @return
	 */
	public static String getGoogleId(Context context) {

		String adverId = "";
		try {
			adverId = AdvertisingIdClient.getAdvertisingIdInfo(context).getId();
			Log.e(TAG, "****adverId:" + adverId);
		} catch (Exception e) {

			Log.e(TAG, "----get google id exception");
			e.printStackTrace();
		}
		return adverId;
	}
}
