package com.example.retrofitdemo.retrofitlist;

import com.example.retrofitdemo.DefaultObserver;
import com.example.retrofitdemo.ResponseBean;
import com.example.retrofitdemo.base.BaseMvpPresenter;

import java.util.List;

public class ImgListPresenter extends BaseMvpPresenter<ImgListActivity, ImgListModel> {
    public ImgListPresenter(ImgListActivity mView) {
        super(mView);
    }

    @Override
    protected ImgListModel initModel() {
        return new ImgListModel();
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
