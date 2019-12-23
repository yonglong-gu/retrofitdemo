package com.example.retrofitdemo.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.retrofitdemo.R;
import com.example.retrofitdemo.base.BaseMvpActivity;
import com.example.retrofitdemo.base.BaseMvpPresenter;
import com.example.retrofitdemo.qrcode.QrCodeActivity;
import com.example.retrofitdemo.retrofitlist.ImgListActivity;

public class MainActivity extends BaseMvpActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_retrofit).setOnClickListener(this);
        findViewById(R.id.btn_qrCode).setOnClickListener(this);
    }

    @Override
    protected BaseMvpPresenter initPresenter() {
        return null;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_retrofit) {
            Intent intent = ImgListActivity.buildIntent(this);
            startActivity(intent);
        } else if (id == R.id.btn_qrCode) {
            Intent intent = QrCodeActivity.buildIntent(this);
            startActivity(intent);
        }
    }
}
