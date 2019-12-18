package com.example.retrofitdemo.base;

import java.io.IOException;

import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class BaseParamInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originRequest = chain.request();
        Headers.Builder headersBuilder = originRequest.headers().newBuilder();

        headersBuilder.add("Authorization", "Bearer " + "");
        headersBuilder.add("User_Authorization", "Bearer " + "");
        headersBuilder.add("locale", "");
        headersBuilder.add("Connection", "keep-alive");
        headersBuilder.add("User-Agent", "Android");
        headersBuilder.add("system", "Android");
        headersBuilder.add("version", "");
        return chain.proceed(originRequest);
    }
}
