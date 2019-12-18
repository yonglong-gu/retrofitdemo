package com.example.retrofitdemo.base;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

public class BaseRecyclerViewHolder extends RecyclerView.ViewHolder {
    protected View mRootView;

    public BaseRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        mRootView = itemView;
    }

    public View getView(int viewId) {
        if (null == mRootView) return null;
        return mRootView.findViewById(viewId);
    }

    public void setText(int viewId, String value) {
        if (viewId != 0 && !TextUtils.isEmpty(value)) {
            ((TextView)getView(viewId)).setText(value);
        }
    }

    public void setText(int viewId, int resourceId) {
        if (viewId != 0) {
            ((TextView)getView(viewId)).setText(resourceId);
        }
    }
}
