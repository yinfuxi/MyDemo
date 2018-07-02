package com.example.mylibrary.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.mylibrary.framework.AppManager;

/**
 * @Date: 2018/6/27
 * @Author: yinfx
 * @Description: 框架通用的activity基类
 */
public abstract class BaseAbstractActivity extends AppCompatActivity{

    protected final String TAG = this.getClass().getSimpleName();
    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        AppManager.getAppManager().addActivity(this);
        mContext = getApplicationContext();
        if (getLayoutResId() > 0) {
            setContentView(getLayoutResId());
        }
        initView(savedInstanceState);
        initEvent();

    }

    /**
     * 布局文件资源ID
     */
    protected abstract int getLayoutResId();

    /**
     * 负责有关handler等对象,界面ui组件的初始化
     */
    protected void initView(Bundle savedInstanceState){}

    /**
     * 负责有关界面ui组件事件的初始化
     */
    protected abstract void initEvent();
}
