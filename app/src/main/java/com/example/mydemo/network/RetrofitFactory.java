package com.example.mydemo.network;


import com.example.mydemo.MyApplication;
import com.example.mydemo.network.config.HttpConstant;
import com.example.mydemo.network.config.RequestService;
import com.example.mylibrary.BuildConfig;
import com.example.mydemo.network.interceptor.CommonInterceptor;
import com.example.mylibrary.utils.ApkVersionUtils;
import com.example.mylibrary.utils.DeviceUtils;

import java.net.Proxy;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2018/4/19.
 * <p>
 * API初始化工厂
 */

public class RetrofitFactory {

    public static final String TAG = "RetrofitFactory";
    public static final int HTTP_TIME = 10;//连接超时时间（秒）

    private static RetrofitFactory mInstance;
    private static Retrofit retrofit;
    private static RequestService mRequestService;

    private RetrofitFactory() {
        init();
    }

    public static RetrofitFactory getInstance() {
        if (mInstance == null) {
            synchronized (RetrofitFactory.class) {
                if (mInstance == null) {
                    mInstance = new RetrofitFactory();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化配置
     */
    private void init() {
        //公用拦截器，添加post公共请求参数  Constants.PACKAGE 和 Constants.CFROM
        CommonInterceptor commonInterceptor = new CommonInterceptor.Builder()
                .addHeaderParam("deviceId", DeviceUtils.getUniqueId(MyApplication.getInstance()) + "")//添加头部信息
                .addHeaderParam("token", "")
                .addHeaderParam("phone", "")
                .addHeaderParam("channel", BuildConfig.FLAVOR + "")
                .addHeaderParam("versionCode", ApkVersionUtils.getVersionCode(MyApplication.getInstance()) + "")
//                .addParam("from", "android") //添加公共参数到 post 请求体
//                .addQueryParam("version","1")  // 添加公共版本号，加在 URL 后面
//                .addHeaheadPaLine("X-Ping: Pong")  // 示例： 添加公共消息头
//                .addParamsMap(map) // 可以添加 Map 格式的参数
                .build();

        //初始化okhttp
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder()
                .proxy(Proxy.NO_PROXY)
                .addInterceptor(commonInterceptor)//添加拦截器(公共参数)
                .connectTimeout(HTTP_TIME, TimeUnit.SECONDS)//设置连接超时时间
                .readTimeout(HTTP_TIME, TimeUnit.SECONDS)//设置读取超时时间
                .writeTimeout(HTTP_TIME, TimeUnit.SECONDS);//设置写入超时时间

        // 初始化Retrofit
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConstant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//添加gson转换器
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//添加rxjava转换器
                .client(httpClient.build())//设置okhttpclient
                .build();
    }


    public RequestService getRequestService() {
        if (mRequestService == null && retrofit != null) {
            mRequestService = retrofit.create(RequestService.class);
        }
        return mRequestService;
    }

}
