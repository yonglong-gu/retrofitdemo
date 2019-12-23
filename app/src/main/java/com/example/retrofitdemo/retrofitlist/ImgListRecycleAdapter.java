package com.example.retrofitdemo.retrofitlist;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.ResponseBean;
import com.example.retrofitdemo.base.BaseRecyclerViewAdapter;
import com.example.retrofitdemo.base.BaseRecyclerViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

public class ImgListRecycleAdapter extends BaseRecyclerViewAdapter<ResponseBean> {
    protected Context context;

    public ImgListRecycleAdapter(Context context, int itemLayoutId) {
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
