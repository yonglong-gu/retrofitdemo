package com.example.retrofitdemo;

public class NetApiUtils {

    public static NetApi getApi() {
        return RetrofitManager.getInstance().getApi(NetApi.class);
    }
}
