package com.example.retrofitdemo;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MyModel {

    public void getList(Observer observer) {
        NetApiUtils.getApi().getMyBase()
                .map(new HttpResultFunction<List<ResponseBean>>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
                        /*new DefaultObserver<List<ResponseBean>>() {
                    @Override
                    public void onNext(List<ResponseBean> responseBeans) {
//                        mLoadingView.hideLoading();
//                        mAdapter.refresh(responseBeans);
//                        hideRefreshView();
//                        for (ResponseBean bean: responseBeans) {
//                            Log.i("oye", "----" + bean.toString());
//                        }
                    }
//                }*/
    }
}
