package com.xmfplus.platform.core.http;

import android.content.Context;

import com.xmfplus.framework.http.HttpFactory;

import java.util.ArrayList;
import java.util.HashMap;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

public class HttpHelper {


    private final HashMap<String, HttpHelper> instances = new HashMap<>();

    private final Retrofit retrofit;

    private static final class Holder {
        private static final HttpHelper INSTANCE = new HttpHelper();
    }

    public static HttpHelper getInstance() {
        return Holder.INSTANCE;
    }

    private HttpHelper() {
        OkHttpClient okHttpClient = HttpFactory.buildOkHttpClient(new ArrayList<>(), builder -> {

        });
        retrofit = HttpFactory.buildRetrofit("", okHttpClient);
    }


    public <T> T createService(Class<T> serviceClass) {
        return retrofit.create(serviceClass);
    }


}
