package com.xmfplus.framework.http;

import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttp;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpFactory {

    public static OkHttpClient buildOkHttpClient(List<Interceptor> interceptors, BuildOkHttpCallback callback) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                builder.addInterceptor(interceptor);
            }
        }
        if (callback != null) {
            callback.build(builder);
        }
        return builder
                .build();
    }


    public static Retrofit buildRetrofit(String baseUrl, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();


        builder.client(okHttpClient)
                .baseUrl(baseUrl)
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

        return builder.build();
    }




    public interface BuildOkHttpCallback {


        void build(OkHttpClient.Builder builder);

    }
}
