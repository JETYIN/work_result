package com.funcell.platform.android.http;

import com.funcell.platform.android.annotation.FuncellNotProguard;

@FuncellNotProguard
public interface FuncellRetrofitCallback {
	public void onResponse(String response);
	public void onFailure(String throwable);
}
