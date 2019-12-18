package com.example.retrofitdemo;

import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitdemo.base.BGARefreshUtil;
import com.example.retrofitdemo.base.BaseMvpActivity;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.List;

import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

public class MainActivity extends BaseMvpActivity<MyPresenter> {
    private BGARefreshLayout bg;
    private RecyclerView recycle;
    private MyRecycleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fresco.initialize(this);
        recycle = findViewById(R.id.recycle);
        bg = findViewById(R.id.bg);

        mAdapter = new MyRecycleAdapter(this, R.layout.item);
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

    @Override
    protected MyPresenter initPresenter() {
        return new MyPresenter(this);
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
