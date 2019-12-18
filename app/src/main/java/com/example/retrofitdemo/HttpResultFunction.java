package com.example.retrofitdemo;


import android.util.Log;

import io.reactivex.functions.Function;

public class HttpResultFunction<T> implements Function<HttpResult<T>, T> {

    public HttpResultFunction() {
    }

    @Override
    public T apply(HttpResult<T> httpResult) {
        if (!httpResult.isError()) {
            return httpResult.getResults();
        }
        return null;
    }
}
