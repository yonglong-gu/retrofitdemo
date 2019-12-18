package com.example.retrofitdemo.base;

import android.content.Context;

import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;

public class BGARefreshUtil {

    public static BGANormalRefreshViewHolder getNormalRefreshLayout(Context context , boolean isLoadingMore){
        BGANormalRefreshViewHolder refreshViewHolder = new BGANormalRefreshViewHolder(context , isLoadingMore);
        refreshViewHolder.setPullDownRefreshText("下拉刷新");
        refreshViewHolder.setRefreshingText("加载中");
        refreshViewHolder.setReleaseRefreshText("释放刷新");
        refreshViewHolder.setLoadingMoreText("加载更多...");
        return refreshViewHolder;
    }
}
