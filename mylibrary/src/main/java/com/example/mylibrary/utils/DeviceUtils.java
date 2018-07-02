package com.example.mylibrary.utils;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;

/**
 * Created by user on 2018/4/19.
 * <p>
 * 获取设备唯一标示
 */

public class DeviceUtils {

    /**
     * 获取手机IMEI号
     * <p>
     * 需要动态权限: android.permission.READ_PHONE_STATE
     */
    public static String getIMEI(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String imei = telephonyManager.getDeviceId();
        return imei == null ? "" : imei;
    }

    /**
     * 获取设备id (AndroidId 和 Serial Number)
     * 可以不用申请权限，比较靠谱
     */
    public static String getUniqueId(Context context) {
        String androidID = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        String id = androidID + Build.SERIAL;
        return id == null ? "" : id;
    }
}
