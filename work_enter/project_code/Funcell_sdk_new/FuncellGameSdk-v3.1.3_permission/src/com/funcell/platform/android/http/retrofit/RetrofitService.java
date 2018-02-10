package com.funcell.platform.android.http.retrofit;

import java.util.Map;

import com.funcell.platform.android.annotation.FuncellNotProguard;
import com.funcell.platform.android.http.okhttp3.RequestBody;
import com.funcell.platform.android.http.okhttp3.ResponseBody;
import com.funcell.platform.android.http.retrofit2.Call;
import com.funcell.platform.android.http.retrofit2.http.Body;
import com.funcell.platform.android.http.retrofit2.http.FieldMap;
import com.funcell.platform.android.http.retrofit2.http.FormUrlEncoded;
import com.funcell.platform.android.http.retrofit2.http.GET;
import com.funcell.platform.android.http.retrofit2.http.POST;
import com.funcell.platform.android.http.retrofit2.http.Url;

@FuncellNotProguard
public interface RetrofitService {
	@GET
	Call<ResponseBody> get(@Url String url);
	@GET
	Call<ResponseBody> get(@Url String url,@Body RequestBody requestBody);
	@POST
	Call<ResponseBody> post(@Url String url);
	@POST
	@FormUrlEncoded
	Call<ResponseBody> post(@Url String url,@FieldMap Map<String, Object> maps);
	@POST
	Call<ResponseBody> post(@Url String url,@Body RequestBody requestBody);
}
