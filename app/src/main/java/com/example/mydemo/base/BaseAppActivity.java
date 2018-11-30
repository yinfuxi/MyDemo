package com.example.mydemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.mylibrary.base.BaseAbstractActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Date: 2018/6/27
 * @Author: yinfx
 * @Description: activity基类
 */
public abstract class BaseAppActivity extends BaseAbstractActivity {

    private Unbinder unbinder;

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        unbinder = ButterKnife.bind(this);
    }

    @Override
    protected void initEvent() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder!=null){
            unbinder.unbind();
        }
    }
}
