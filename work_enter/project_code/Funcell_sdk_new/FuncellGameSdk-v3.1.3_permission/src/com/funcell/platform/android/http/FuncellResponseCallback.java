package com.funcell.platform.android.http;

import com.funcell.platform.android.http.volley.VolleyError;


public interface FuncellResponseCallback {
	public void onResponse(String response);

	public void onErrorResponse(String error);
	
	public void onErrorResponse(VolleyError error);
}
