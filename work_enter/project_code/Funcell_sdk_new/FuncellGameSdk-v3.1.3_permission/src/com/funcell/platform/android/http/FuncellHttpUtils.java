package com.funcell.platform.android.http;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import android.util.Log;

import com.funcell.platform.android.http.volley.AuthFailureError;
import com.funcell.platform.android.http.volley.DefaultRetryPolicy;
import com.funcell.platform.android.http.volley.Request;
import com.funcell.platform.android.http.volley.Request.Method;
import com.funcell.platform.android.http.volley.RequestQueue;
import com.funcell.platform.android.http.volley.Response;
import com.funcell.platform.android.http.volley.Response.ErrorListener;
import com.funcell.platform.android.http.volley.Response.Listener;
import com.funcell.platform.android.http.volley.VolleyError;
import com.funcell.platform.android.http.volley.toolbox.ImageRequest;
import com.funcell.platform.android.http.volley.toolbox.JsonArrayRequest;
import com.funcell.platform.android.http.volley.toolbox.StringRequest;
import com.funcell.platform.android.http.volley.toolbox.Volley;

/**
 * @deprecated in SDK3.1.0£¬{@link #FuncellRetrofitUtils} Replace FuncellHttpUtils
 */
public class FuncellHttpUtils {
	private static RequestQueue requestQueue = null;
	private static Context mContext = null;
	private static final String HTTP_TASK_TAG = "my_http_task_tag";
	private static final int INITIAL_TIMEOUT = 30 * 1000; //Specifies Socket Timeout in millis per every retry attempt.
	private static final int MAX_NUM_RETRIES = 1;        //Number of times retry is attempted.
	private static final float BACK_OFF_MULTIPLIER = 1.0f;//A multiplier which is used to determine exponential time set to socket for every retry attempt. 

	private static final int DEFAULT = 0;
	public FuncellHttpUtils() {

	}

	private static class HttpUtilsHolder {
		static FuncellHttpUtils instance = new FuncellHttpUtils();
	}

	public static FuncellHttpUtils getInstance(Context context) {
		mContext = context;

		if (null == requestQueue) {
			requestQueue = Volley.newRequestQueue(mContext,null,-1,true,-1);
		}

		return HttpUtilsHolder.instance;
	}

//	public interface FuncellResponseCallback {
//		void onResponse(String response);
//
//		void onErrorResponse(String error);
//	}

	public void get(String tag, String url,
			final FuncellResponseCallback responseCallback,final boolean... callbackVolleyErrorFlag) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;

//		requestQueue.cancelAll(mTag);

		StringRequest request = new StringRequest(url, new Listener<String>() {

			@Override
			public void onResponse(String response) {
				responseCallback.onResponse(response);
			}
		}, new ErrorListener() {

			@Override
			public void onErrorResponse(VolleyError error) {
				if(callbackVolleyErrorFlag.length > 0 && callbackVolleyErrorFlag[0]){
					responseCallback.onErrorResponse(error);
				}else {
					responseCallback.onErrorResponse(error.getMessage());
				}
			}
		});
		
		request.setShouldCache(false);
//		request.setTag(mTag);
		request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(request);

	}
	
	
	
	public void post(String tag, String url, final Map<String, String> para,
			final FuncellResponseCallback responseCallback) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;

//		requestQueue.cancelAll(mTag);

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
//		request.setTag(mTag);
		request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(request);

	}
	
	public <T> void postByJsonArray(String tag, String url, final Map<String, T> para,
			final FuncellResponseCallback responseCallback) {
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG : tag;
//		requestQueue.cancelAll(mTag);
		JSONObject params = new JSONObject(para);
		JSONArray arrayParams = new JSONArray().put(params);
		JsonArrayRequest request = new JsonArrayRequest(Method.POST,url,arrayParams, new Response.Listener<JSONArray>() {  
		        @Override  
		        public void onResponse(JSONArray response) {
		        	Log.e("HttpUtils","response:"+response);
		        }  
		    }, new Response.ErrorListener() {
		        @Override  
		        public void onErrorResponse(VolleyError error) {
		        	Log.e("HttpUtils","error:"+error);
		        	if (error != null) {
						responseCallback.onErrorResponse(error);
					}
//					LogUtil.i("errorMessage", error);
		        }  
		    }); 
		 request.setShouldCache(false);
//		 request.setTag(mTag);
		 request.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				 DEFAULT, BACK_OFF_MULTIPLIER));
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
	
	public void getImage(String tag, String url,final FuncellImageResponseCallback responseCallback){
		String mTag = null == tag || TextUtils.isEmpty(tag) ? HTTP_TASK_TAG
				: tag;

//		requestQueue.cancelAll(mTag);
		ImageRequest imageRequest = new ImageRequest(url,new Response.Listener<Bitmap>(){

			@Override
			public void onResponse(Bitmap response) {
				// TODO Auto-generated method stub
				responseCallback.onResponse(response);
			}},0,0,Config.RGB_565,new Response.ErrorListener(){

				@Override
				public void onErrorResponse(VolleyError error) {
					// TODO Auto-generated method stub
					responseCallback.onErrorResponse(error.getMessage());
				}
			} );
		imageRequest.setShouldCache(false);
//		imageRequest.setTag(mTag);
		imageRequest.setRetryPolicy(new DefaultRetryPolicy(INITIAL_TIMEOUT,
				MAX_NUM_RETRIES, BACK_OFF_MULTIPLIER));
		requestQueue.add(imageRequest);
	}

}
