package com.example.retrofitdemo.base;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.retrofitdemo.R;

public class DefaultLoadingView extends Dialog implements ILoadingView {
    private View mContentView;
    public DefaultLoadingView(@NonNull Context context) {
        super(context, R.style.DefaultDialogStyle_Loading);
        mContentView = LayoutInflater.from(context).inflate(R.layout.dialog_default_loading, null);
        setContentView(mContentView);
    }

    @Override
    public void showLoading() {
        if (!isShowing()) {
            show();
        }
    }

    @Override
    public void hideLoading() {
        dismiss();
    }
}
