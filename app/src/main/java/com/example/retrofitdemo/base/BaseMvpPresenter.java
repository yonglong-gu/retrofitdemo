package com.example.retrofitdemo.base;

public abstract class BaseMvpPresenter<T extends IBaseView, K> {
    protected T mView;
    protected K mModel;

    public BaseMvpPresenter(T mView) {
        this.mView = mView;
        mModel = initModel();
    }

    protected abstract K initModel();

    public void destroy() {
        mView = null;
        mModel = null;
    }

    protected boolean isNullView() {
        return mView == null;
    }

    protected boolean isNullModel() {
        return mModel == null;
    }
}
