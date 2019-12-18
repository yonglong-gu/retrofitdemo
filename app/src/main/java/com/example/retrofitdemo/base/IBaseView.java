package com.example.retrofitdemo.base;

public interface IBaseView {

    void showLoadingView();

    void hideLoadingView();

    void showToast(String msg);

    void showToast(int resourceId);

    void showError(Throwable e);

    void exitActivity();
}
