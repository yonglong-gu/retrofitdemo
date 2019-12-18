package com.example.retrofitdemo.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.Nullable;

public abstract class BaseMvpActivity<T extends BaseMvpPresenter> extends BaseActivity implements IBaseView{
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = initPresenter();
    }

    protected abstract T initPresenter();

    @Override
    public void showLoadingView() {
        if (null != mLoadingView) {
            mLoadingView.showLoading();
        }
    }

    @Override
    public void hideLoadingView() {
        if (null != mLoadingView) {
            mLoadingView.hideLoading();
        }
    }

    @Override
    public void showToast(String msg) {
        if (!TextUtils.isEmpty(msg)) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showToast(int resourceId) {
        if (resourceId != 0) {
            Toast.makeText(this, getString(resourceId), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showError(Throwable e) {

    }

    @Override
    public void exitActivity() {
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != mPresenter) {
            mPresenter.destroy();
        }
    }
}
