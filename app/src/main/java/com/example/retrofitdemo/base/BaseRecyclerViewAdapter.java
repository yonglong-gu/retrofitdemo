package com.example.retrofitdemo.base;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    protected List<T> mDates = new ArrayList<>();
    private Context mContext;
    private LayoutInflater layoutInflater;
    private int mItemLayoutId;
    private OnItemClickListener mListener;

    public BaseRecyclerViewAdapter(Context context, int itemLayoutId) {
        this.mContext = context;
        this.mItemLayoutId = itemLayoutId;
        layoutInflater = LayoutInflater.from(mContext);
    }

    public T getItem(int position) {
        if (null != mDates && !mDates.isEmpty() && position < getItemCount()) {
            return mDates.get(position);
        }
        return null;
    }

    @NonNull
    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new BaseRecyclerViewHolder(layoutInflater.inflate(mItemLayoutId, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull BaseRecyclerViewHolder holder, final int position) {
        bindView(holder, getItem(position), position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (null != mListener) {
                    mListener.itemClick(getItem(position), position);
                }
            }
        });
    }

    protected abstract void bindView(BaseRecyclerViewHolder holder, T item, int position);

    @Override
    public int getItemCount() {
        return null == mDates ? 0 : mDates.size();
    }

    /**
     * 刷新数据
     */
    public void refresh(List<T> dates) {
        this.mDates.clear();
        if (null != dates && !dates.isEmpty()) {
            this.mDates.addAll(dates);
        }
        notifyDataSetChanged();
    }

    /**
     * 添加数据
     */
    public void addDate(List<T> dates) {
        if (null != dates) {
            this.mDates.addAll(dates);
            notifyDataSetChanged();
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public interface OnItemClickListener<T> {
        void itemClick(T object, int position);
    }
}
