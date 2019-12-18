package com.example.retrofitdemo;

import android.util.Log;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class DefaultObserver<T> implements Observer<T> {
    @Override
    public void onSubscribe(Disposable d) {
        Log.i("okhttp", "onSubscribe---");
    }

    @Override
    public void onError(Throwable e) {
        Log.i("okhttp", "onError---" + e.getMessage());
    }

    @Override
    public void onComplete() {
        Log.i("okhttp", "onComplete---");
    }
}
