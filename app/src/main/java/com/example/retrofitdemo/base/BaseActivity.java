package com.example.retrofitdemo.base;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.trello.rxlifecycle3.components.support.RxFragmentActivity;

public abstract class BaseActivity extends RxFragmentActivity implements IBaseView{

    protected ILoadingView mLoadingView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mLoadingView = new DefaultLoadingView(this);
    }

    public ILoadingView getLoadingView() {
        return mLoadingView;
    }

}
