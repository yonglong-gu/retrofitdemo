package com.example.retrofitdemo;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.retrofitdemo.base.BaseRecyclerViewAdapter;
import com.example.retrofitdemo.base.BaseRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

public class MyRecycleAdapter extends BaseRecyclerViewAdapter<ResponseBean> {
    protected Context context;

    public MyRecycleAdapter(Context context, int itemLayoutId) {
        super(context, itemLayoutId);
    }


    @Override
    protected void bindView(BaseRecyclerViewHolder holder, ResponseBean item, int position) {
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) holder.getView(R.id.item_simple);
        if (!TextUtils.isEmpty(item.url)) {
            simpleDraweeView.setImageURI(item.url);
        }
        holder.setText(R.id.tv_title, "时间：" + item.desc);
    }
}
