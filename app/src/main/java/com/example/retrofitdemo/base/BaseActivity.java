package com.example.retrofitdemo.base;

import android.os.Bundle;
import android.view.View;

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

    /**
     * 设置 MyToolBar 标题 及点击事件
     *
     * @param toolbar MyToolBar
     * @param title   标题
     * @param <T>     继承自 MyToolBar
     */
    protected <T extends MyToolbar> void setTitleView(T toolbar, String title) {
        setTitleView(toolbar);
        toolbar.setTitle(title);
    }

    /**
     * 设置 MyToolBar 点击事件
     *
     * @param toolbar MyToolBar
     * @param <T>     继承自 MyToolBar
     */
    protected <T extends MyToolbar> void setTitleView(T toolbar) {
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();//设置为返回键功能
            }
        });
    }

}
