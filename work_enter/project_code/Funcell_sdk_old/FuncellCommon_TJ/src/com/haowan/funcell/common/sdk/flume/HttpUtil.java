package com.haowan.funcell.common.sdk.flume;

import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.util.Log;

import com.haowan.funcell.common.sdk.api.HttpUtils;
import com.haowan.funcell.common.sdk.api.HttpUtils.FuncellResponseCallback;
import com.haowan.funcell.common.sdk.api.volley.VolleyError;

/**
 * Created by Administrator on 2016/6/21.
 */
public class HttpUtil {

	private static final String TAG = "PlatformInterface";

	// 通过HTTP POST方式将一条Event发送到HTTP Source 没有构建event
	public static void send(Context ctx, final String URL, final Map map) {
		HttpUtils.getInstance(ctx).post(System.currentTimeMillis() + "", URL,
				map, new FuncellResponseCallback() {

					@Override
					public void onResponse(String response) {
						Log.i(TAG, "successCode: " + response);
					}

					@Override
					public void onErrorResponse(String error) {
						Log.i(TAG, "FailCode: " + error);
					}

					@Override
					public void onErrorResponse(VolleyError error) {
						// TODO Auto-generated method stub
						
					}

				});

	}

	public static String sendHttps(String strUrl, JSONArray obj) {
		try {
			// data = buf.toString().getBytes("UTF-8");

			URL url = new URL(strUrl);
			URLConnection conn = url.openConnection();// 连打通必备方式
			HttpURLConnection httpUrlConnection = (HttpURLConnection) conn;
			conn.setReadTimeout(20000);// 设置从主机读取数据超时（单位：毫秒）
			conn.setConnectTimeout(10000);// 设置连接主机超时（单位：毫秒）
			conn.setDoOutput(true);// 允许使用conn.getOutputStream().write()
			conn.setDoInput(true);// 允许使用conn.getInputStream().read();
			conn.setUseCaches(false);// Post 请求不能使用缓存
			conn.setRequestProperty("Content-Type",
					"application/json;charset=UTF-8");
			OutputStreamWriter out = new OutputStreamWriter(
					conn.getOutputStream(), "utf-8");// 写流变量
			out.write(obj.toString());
			out.close();
			String code = new Integer(httpUrlConnection.getResponseCode())
					.toString();
			Log.d(TAG, "发送请求成功: " + code);
			Log.d(TAG, "发送请求成功");
			InputStreamReader is = new InputStreamReader(conn.getInputStream(),
					"utf-8");
			StringBuffer buffer = new StringBuffer();
			int i;
			while ((i = is.read()) != -1) {
				buffer.append((char) i);
			}
			is.close();
			Log.d(TAG, "返回DATA" + buffer.toString());
			return buffer.toString();

		} catch (Exception e) {
			Log.i(TAG, "error"+e.toString());
			return null;
			
		}

	}
	
	

}
