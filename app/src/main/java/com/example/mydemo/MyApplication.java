package com.example.mydemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.example.mylibrary.utils.LogUtils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import jiguang.chat.application.JGApplication;


public class MyApplication extends JGApplication {

    private static final String TAG = "MyApplication";
    private static MyApplication mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        LogUtils.d(TAG, "----------");
        //初始化友盟推送
        initUMPush();
        LogUtils.init();
    }

    public static MyApplication getInstance() {
        return mContext;
    }

    /**
     * 测试友盟推送
     */
    private void initUMPush() {
        UMConfigure.setLogEnabled(true);
//        UMConfigure.init(this, "5ad5a4d7b27b0a701b0000ad", "Umeng", UMConfigure.DEVICE_TYPE_PHONE,
//                "1f08961a6a92c7a0570ad9770ca0682f");
        //统计应用启动数据
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "1f08961a6a92c7a0570ad9770ca0682f");

//        MiPushRegistar.register(this, "", "");

        PushAgent mPushAgent = PushAgent.getInstance(this);
        //注册推送服务 每次调用register都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                Log.i(TAG, "device token: " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.i(TAG, "register failed: " + s + " " + s1);
            }
        });
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}