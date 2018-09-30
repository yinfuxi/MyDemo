package com.example.mydemo.base;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.example.mylibrary.base.BaseAbstractActivity;

import butterknife.ButterKnife;

/**
 * @Date: 2018/6/27
 * @Author: yinfx
 * @Description: activity基类
 */
public abstract class BaseAppActivity extends BaseAbstractActivity {

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    protected void initEvent() {
    }


}
