/*
 * File Name: LogUtils.java
 * History:
 * Created by mwqi on 2014-4-4
 */
package com.example.mylibrary.utils;


import android.support.annotation.Nullable;

import com.example.mylibrary.BuildConfig;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * 日志输出工具类，方便以后更换
 */
public class LogUtils {

    /**
     * 初始化logger日志
     */
    public static void init() {
        Logger.addLogAdapter(new AndroidLogAdapter() {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    public static void v(String message) {
        Logger.v(message);
    }

    public static void v(String tag, String message) {
        Logger.t(tag).v(message);
    }

    public static void d(Object object) {
        Logger.d(object);
    }

    public static void d(String tag, Object object) {
        Logger.t(tag).d(object);
    }

    public static void i(String message) {
        Logger.i(message);
    }

    public static void i(String tag, String message) {
        Logger.t(tag).i(message);
    }

    public static void w(String message) {
        Logger.w(message);
    }

    public static void w(String tag, String message) {
        Logger.t(tag).w(message);
    }

    public static void e(String message) {
        Logger.e(message);
    }

    public static void e(String tag, String message) {
        Logger.t(tag).e(message);
    }

    public static void e(Exception e, String message) {
        Logger.e(e, message);
    }


    public static void josn(String tag, String josn) {
        Logger.t(tag).json(josn);
    }

    public static void json(Exception e, String josn) {
        Logger.json(josn);
    }
}
