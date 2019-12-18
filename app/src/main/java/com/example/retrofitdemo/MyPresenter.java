package com.example.retrofitdemo;

import com.example.retrofitdemo.base.BaseMvpPresenter;

import java.util.List;

public class MyPresenter extends BaseMvpPresenter<MainActivity, MyModel> {
    public MyPresenter(MainActivity mView) {
        super(mView);
    }

    @Override
    protected MyModel initModel() {
        return new MyModel();
    }

    public void getList() {
        mView.showLoadingView();
        mModel.getList(new DefaultObserver<List<ResponseBean>>() {
            @Override
            public void onNext(List<ResponseBean> responseBean) {
                mView.hideLoadingView();
                mView.hideRefreshView();
                mView.refreshData(responseBean);
            }
        });
    }
}
