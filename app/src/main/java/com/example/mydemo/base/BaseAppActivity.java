package com.example.mydemo.base;

import android.os.Bundle;
import android.util.Log;

import com.example.mylibrary.base.BaseAbstractActivity;

import butterknife.ButterKnife;

/**
 * @Date: 2018/6/27
 * @Author: yinfx
 * @Description: activity基类
 */
public abstract class BaseAppActivity extends BaseAbstractActivity{

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void initEvent() {
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "@@onStart----");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "@@onResume----");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "@@onPause----");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "@@onStop----");
    }
}
