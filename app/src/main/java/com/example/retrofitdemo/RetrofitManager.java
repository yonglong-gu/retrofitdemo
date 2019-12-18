package com.example.retrofitdemo;

import android.text.TextUtils;

import com.example.retrofitdemo.base.BaseParamInterceptor;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitManager retrofitManager;
    private Retrofit retrofit;
    private static OkHttpClient okHttpClient;
    private String baseUrl = "http://gank.io/api/data/";
//    private String baseUrl = "http://192.168.1.232:9321/api/user/captcha/";

    private RetrofitManager() {
        if (TextUtils.isEmpty(baseUrl)) {
            new Throwable("BaseUrl is Empty").printStackTrace();
        }
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    public static synchronized RetrofitManager getInstance() {
        if (null == retrofitManager) {
            synchronized (RetrofitManager.class) {
                if (null == retrofitManager)
                    retrofitManager = new RetrofitManager();
            }
        }
        return retrofitManager;
    }

    static {
        initOkHttpClient();
    }

    private static OkHttpClient initOkHttpClient() {
        if (null == okHttpClient) {
            synchronized (OkHttpClient.class) {
                if (null == okHttpClient) {
                    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                    okHttpClient = new OkHttpClient.Builder()
                            .addInterceptor(new BaseParamInterceptor())
                            .addNetworkInterceptor(httpLoggingInterceptor)//拦截器日志
                            .connectTimeout(30, TimeUnit.SECONDS)
                            .writeTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return okHttpClient;
    }

    public <T> T getApi(Class<T> clazz) {
        return retrofit.create(clazz);
    }
}
