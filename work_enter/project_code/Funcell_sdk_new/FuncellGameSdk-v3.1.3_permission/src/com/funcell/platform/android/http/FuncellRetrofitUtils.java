package com.funcell.platform.android.http;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.json.JSONArray;
import org.json.JSONObject;

import android.text.TextUtils;
import android.util.Log;

import com.funcell.platform.android.annotation.FuncellNotProguard;
import com.funcell.platform.android.http.retrofit.RetrofitService;
import com.funcell.platform.android.http.okhttp3.Interceptor;
import com.funcell.platform.android.http.okhttp3.MediaType;
import com.funcell.platform.android.http.okhttp3.OkHttpClient;
import com.funcell.platform.android.http.okhttp3.Request;
import com.funcell.platform.android.http.okhttp3.RequestBody;
import com.funcell.platform.android.http.okhttp3.ResponseBody;
import com.funcell.platform.android.http.okhttp3.logging.HttpLoggingInterceptor;
import com.funcell.platform.android.http.retrofit2.Call;
import com.funcell.platform.android.http.retrofit2.Callback;
import com.funcell.platform.android.http.retrofit2.Response;
import com.funcell.platform.android.http.retrofit2.Retrofit;

@FuncellNotProguard
public class FuncellRetrofitUtils {
	private String TAG = "FuncellRetrofitUtils";
	private static FuncellRetrofitUtils mInstance;
	private int mDefaultTimeOut = 30;
	/**
	 * BaseUrl 只为占坑，用于Retrofit框架内部检查使用
	 * ---请勿修改---
	 */
	private String mBaseUrl="http://sdk.funcell123.com/";
	
	
	public static FuncellRetrofitUtils getInstance() {
		if (mInstance == null) {
			synchronized (FuncellRetrofitUtils.class) {
				if (mInstance == null) {
					mInstance = new FuncellRetrofitUtils();
				}
			}
		}
		return mInstance;
	}
	
	OkHttpClient genericClient() {
        /**
         * print http log
         */
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(_mHeaderInterceptor)
                .connectTimeout(mDefaultTimeOut, TimeUnit.SECONDS)
                .readTimeout(mDefaultTimeOut, TimeUnit.SECONDS)
                .writeTimeout(mDefaultTimeOut, TimeUnit.SECONDS)
                .build();
        return httpClient;
    }
	
	OkHttpClient genericClient(String timeout) {
        /**
         * print http log
         */
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient httpClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(false)
                .addInterceptor(interceptor)
                .addNetworkInterceptor(_mHeaderInterceptor)
                .connectTimeout(TextUtils.isEmpty(timeout) ? mDefaultTimeOut : Integer.valueOf(timeout), TimeUnit.SECONDS)
                .readTimeout(TextUtils.isEmpty(timeout) ? mDefaultTimeOut : Integer.valueOf(timeout), TimeUnit.SECONDS)
                .writeTimeout(TextUtils.isEmpty(timeout) ? mDefaultTimeOut : Integer.valueOf(timeout), TimeUnit.SECONDS)
                .build();
        return httpClient;
    }
	
	Interceptor _mHeaderInterceptor = new Interceptor() {

		@Override
		public com.funcell.platform.android.http.okhttp3.Response intercept(Chain chain) throws IOException {
			// TODO Auto-generated method stub
			Request request = chain.request().newBuilder().header("Charset", "utf-8").build();
            return chain.proceed(request);
		}
	};
	
	public void get(String url,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient()).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.get(url);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}
	
	public void get(String url,String timeOut, final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient(timeOut)).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.get(url);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}
	
	public void get(String url,RequestBody body,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient()).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.get(url, body);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}
	
	public void get(String url,String timeOut,RequestBody body,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient(timeOut)).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.get(url, body);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}
	
	public void post(String url,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient()).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}
	
	public void post(String url,String timeOut,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient(timeOut)).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}
	
	public void post(String url,Map<String, Object> map,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient()).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url, map);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
			
		});
	}
	
	public void post(String url,Map<String, Object> map,String timeOut,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient(timeOut)).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url, map);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
			
		});
	}
	
	public void post(String url,RequestBody body,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient()).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url, body);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
			
		});
	}
	
	public void post(String url,RequestBody body,String timeOut,final FuncellRetrofitCallback callback){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient(timeOut)).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url, body);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> call, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> call,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				}catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
			
		});
	}
	
	
	public void post2Bi(String url,Map<String, Object> map,final FuncellRetrofitCallback callback){
		JSONObject params = new JSONObject(map);
		JSONArray arrayParams = new JSONArray().put(params);
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), arrayParams.toString());
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient()).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url, requestBody);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> arg0, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> arg0,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}
	
	public void post2Bi(String url,Map<String, Object> map,String timeOut,final FuncellRetrofitCallback callback){
		JSONObject params = new JSONObject(map);
		JSONArray arrayParams = new JSONArray().put(params);
		RequestBody requestBody = RequestBody.create(MediaType.parse("application/json"), arrayParams.toString());
		Retrofit retrofit = new Retrofit.Builder().baseUrl(mBaseUrl).callFactory(genericClient(timeOut)).build();
		RetrofitService service = retrofit.create(RetrofitService.class);
		Call<ResponseBody> call = service.post(url, requestBody);
		call.enqueue(new Callback<ResponseBody>(){

			@Override
			public void onFailure(Call<ResponseBody> arg0, Throwable throwable) {
				// TODO Auto-generated method stub
				try {
					callback.onFailure(throwable.toString());
				}catch (Exception e) {
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}

			@Override
			public void onResponse(Call<ResponseBody> arg0,
					Response<ResponseBody> response) {
				// TODO Auto-generated method stub
				try {
					callback.onResponse(response.body().string());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					callback.onFailure(e!=null ? e.toString() : "");
				}
			}
		});
	}

}
