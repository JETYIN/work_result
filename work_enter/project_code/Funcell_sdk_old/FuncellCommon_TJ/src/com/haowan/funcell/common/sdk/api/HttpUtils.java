package com.haowan.funcell.common.sdk.api;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.util.Log;

import com.haowan.funcell.common.sdk.api.volley.AuthFailureError;
import com.haowan.funcell.common.sdk.api.volley.DefaultRetryPolicy;
import com.haowan.funcell.common.sdk.api.volley.Request;
import com.haowan.funcell.common.sdk.api.volley.Request.Method;
import com.haowan.funcell.common.sdk.api.volley.RequestQueue;
import com.haowan.funcell.common.sdk.api.volley.Response;
import com.haowan.funcell.common.sdk.api.volley.Response.ErrorListener;
import com.haowan.funcell.common.sdk.api.volley.Response.Listener;
import com.haowan.funcell.common.sdk.api.volley.VolleyError;
import com.haowan.funcell.common.sdk.api.volley.toolbox.ImageRequest;
import com.haowan.funcell.common.sdk.api.volley.toolbox.JsonArrayRequest;
import com.haowan.funcell.common.sdk.api.volley.toolbox.JsonObjectRequest;
import com.haowan.funcell.common.sdk.api.volley.toolbox.StringRequest;
import com.haowan.funcell.common.sdk.api.volley.toolbox.Volley;

public class HttpUtils {
	private static RequestQueue requestQueue = null;
	private static Context mContext = null;
	private static final String HTTP_TASK_TAG = "my_http_task_tag";
	private static final int INITIAL_TIMEOUT = 5 * 1000; // Specifies Socket
															// Timeout in millis
															// per every retry
															// attempt.
	private static final int MAX_NUM_RETRIES = 1; // Number of times retry is
													// attempted.
	private static final float BACK_OFF_MULTIPLIER = 1.0f;// A multiplier which
															// is used to
															// determine
															// exponential time
															// set to socket for
															// every retry
															// attempt.

	public HttpUtils() {

	}

	private static class HttpUtilsHolder {
		static HttpUtils instance = new HttpUtils();
	}

	public static HttpUtils getInstance(Context context) {
		mContext = context;

		if (null == requestQueue) {
			requestQueue = Volley.newRequestQueue(mContext, null, -1, true, -1);
		}

		return HttpUtilsHolder.instance;
	}

	public interface FuncellResponseCallback {
		void onResponse(String response);

		void onErrorResponse(String error);

		void onErrorResponse(VolleyError error);
	}

	public void get(String tag, String url,
			final FuncellResponseCallback responseCallback) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;

		requestQueue.cancelAll(mTag);

		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				responseCallback.onResponse(response);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				responseCallback.onErrorResponse(error.getMessage());
			}
		});

		request.setShouldCache(false);
		request.setTag(mTag);
		request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(request);

	}

	public void post(String tag, String url, final Map<String, String> para,
			final FuncellResponseCallback responseCallback) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;

		requestQueue.cancelAll(mTag);

		StringRequest request = new StringRequest(Method.POST, url,
				new Listener<String>() {

					@Override
					public void onResponse(String response) {
						responseCallback.onResponse(response);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						responseCallback.onErrorResponse(error.getMessage());
					}
				}) {

			@Override
			protected Map<String, String> getParams() throws AuthFailureError {
				return para;
			}

		};
		request.setShouldCache(false);
		request.setTag(mTag);
		request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(request);

	}

	/**
	 * 新增的方法
	 * 
	 * @param tag
	 * @param url
	 * @param para
	 * @param responseCallback
	 */
	public void postByJson(String tag, String url,
			final Map<String, String> para,
			final FuncellResponseCallback responseCallback) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;
		requestQueue.cancelAll(mTag);
		JSONObject params = new JSONObject(para);
		JSONArray a = new JSONArray();
		JsonObjectRequest request = new JsonObjectRequest(Method.POST, url,
				params, new Response.Listener<JSONObject>() {
					@Override
					public void onResponse(JSONObject response) {
						Log.e("Error", "response:" + response);
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Log.e("Error", "error:" + error);
					}
				});

		request.setShouldCache(false);
		request.setTag(mTag);
		request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(request);
	}
	 
	public <T> void postByJsonArray(String tag, String url,
			final Map<String, T> para,
			final FuncellResponseCallback responseCallback) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;
		requestQueue.cancelAll(mTag);
		JSONObject params = new JSONObject(para);
		JSONArray arrayParams = new JSONArray().put(params);
		Log.i("MSG", "arrayParams------------" + arrayParams.toString());
		JsonArrayRequest request = new JsonArrayRequest(Method.POST, url,
				arrayParams, new Response.Listener<JSONArray>() {
					@Override
					public void onResponse(JSONArray response) {
						Log.e("HttpUtils", "response:" + response);
					}
				}, new Response.ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						if (error != null) {
							responseCallback.onErrorResponse(error);
						}
						LogUtil.i("errorMessage", error);
					}
				});
		request.setShouldCache(false);
		request.setTag(mTag);
		request.setRetryPolicy(new DefaultRetryPolicy(15*1000,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(request);
	}
	
	
	public void cancelAllRequest() {

		requestQueue.cancelAll(new RequestQueue.RequestFilter() {

			@Override
			public boolean apply(Request<?> request) {

				return true;
			}

		});
	}

	public void cancelRequestByTag(String tag) {

		requestQueue.cancelAll(tag);
	}

	public interface FuncellImageResponseCallback {
		void onResponse(Bitmap response);

		void onErrorResponse(String error);
	}

	public void getImage(String tag, String url,
			final FuncellImageResponseCallback responseCallback) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;

		requestQueue.cancelAll(mTag);
		ImageRequest imageRequest = new ImageRequest(url,
				new Response.Listener<Bitmap>() {

					@Override
					public void onResponse(Bitmap response) {
						// TODO Auto-generated method stub
						responseCallback.onResponse(response);
					}
				}, 0, 0, Config.RGB_565, new Response.ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						responseCallback.onErrorResponse(error.getMessage());
					}
				});
		imageRequest.setShouldCache(false);
		imageRequest.setTag(mTag);
		imageRequest.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(imageRequest);
	}

}
