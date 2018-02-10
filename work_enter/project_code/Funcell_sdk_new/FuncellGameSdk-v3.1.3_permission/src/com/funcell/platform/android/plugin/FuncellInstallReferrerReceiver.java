package com.funcell.platform.android.plugin;

import com.funcell.platform.android.plugin.wrapper.AnalyticsWrapper;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class FuncellInstallReferrerReceiver extends BroadcastReceiver {

	public static final String TAG = "FuncellInstallReferrerReceiver";

	@Override
	public void onReceive(Context context, Intent intent) {
		Log.e(TAG,"FuncellInstallReferrerReceiver invoke");
		AnalyticsWrapper.getInstance().OnReceive(context, intent);
	}

}
