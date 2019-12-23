package com.example.retrofitdemo.retrofitlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.ResponseBean;
import com.example.retrofitdemo.base.BGARefreshUtil;
import com.example.retrofitdemo.base.BaseMvpActivity;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class ImgListActivity extends BaseMvpActivity<ImgListPresenter> {
    @Override
    protected ImgListPresenter initPresenter() {
        return new ImgListPresenter(this);
    }

    private BGARefreshLayout bg;
    private RecyclerView recycle;
    private ImgListRecycleAdapter mAdapter;

    public static Intent buildIntent(Context context){
        Intent intent = new Intent(context , ImgListActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img_list);

        setTitleView(findViewById(R.id.toolbar));
        recycle = findViewById(R.id.recycle);
        bg = findViewById(R.id.bg);

        mAdapter = new ImgListRecycleAdapter(this, R.layout.item);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        recycle.setAdapter(mAdapter);

        bg.setRefreshViewHolder(BGARefreshUtil.getNormalRefreshLayout(this, true));
        bg.setDelegate(new BGARefreshLayout.BGARefreshLayoutDelegate() {

            @Override
            public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
                if (null != mPresenter)
                    mPresenter.getList();
            }

            @Override
            public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
                return false;
            }
        });

        bg.beginRefreshing();
    }

    public void refreshData(List<ResponseBean> list) {
        if (null != mAdapter)
            mAdapter.refresh(list);
    }

    public void hideRefreshView() {
        if (null != bg) {
            bg.endRefreshing();
        }
    }

    public void hideLoadMoreView() {
        if (null != bg) {
            bg.endLoadingMore();
        }
    }
}
