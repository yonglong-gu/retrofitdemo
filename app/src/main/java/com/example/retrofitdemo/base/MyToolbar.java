package com.example.retrofitdemo.base;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;

import androidx.appcompat.widget.Toolbar;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.utils.DensityUtils;

public class MyToolbar extends Toolbar {
    private int mFirstContentLeft = 0;
    public MyToolbar(Context context) {
        super(context);
    }

    public MyToolbar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyToolbar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setTitle(CharSequence title) {
        int textSize = (int) getContext().getResources().getDimension(R.dimen.custom_toolbar_title_size);
        Paint mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.WHITE);
        mTextPaint.setTextSize(textSize);
        mTextPaint.setFakeBoldText(true);

        float textWidth = mTextPaint.measureText(title.toString());
        int needInsectLeft = (int) ((DensityUtils.deviceWidthPX(getContext()) - textWidth)) / 2;
        int contentInsectLeft = getContentInsetLeft();
        if (contentInsectLeft < needInsectLeft - mFirstContentLeft/2){
//            mFirstContentLeft = getContentInsetLeft();
            //默认赋值为16dp
            mFirstContentLeft = DensityUtils.dip2px(getContext(), 16);
        }
        setContentInsetsAbsolute(needInsectLeft - mFirstContentLeft / 2 , 0);
        super.setTitle(title);
    }
}
