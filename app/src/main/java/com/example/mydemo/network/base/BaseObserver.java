package com.example.mydemo.network.base;


import android.accounts.NetworkErrorException;
import android.content.Context;
import android.widget.Toast;

import com.example.mydemo.network.bean.BaseBean;

import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.concurrent.TimeoutException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by user on 2018/4/23.
 */

public abstract class BaseObserver<T> implements Observer<BaseBean<T>> {

    protected Context mContext;
    public static final int ERRCOIDE = -999;

    public BaseObserver(Context mContext) {
        this.mContext = mContext;
    }

    public BaseObserver() {
    }

    @Override
    public void onSubscribe(Disposable d) {
        onRequestStart();
    }

    @Override
    public void onNext(BaseBean<T> tBaseBean) {
        onRequestEnd();
        if (tBaseBean.isSuccess()) {//与后台约定的成功返回码
            try {
                onSuccess(tBaseBean);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                onFailure(tBaseBean.getUserMsg(), tBaseBean.getResCode(), false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(Throwable e) {
        onRequestEnd();
        if (e instanceof ConnectException
                || e instanceof TimeoutException
                || e instanceof NetworkErrorException
                || e instanceof UnknownHostException) {
            try {
                onFailure(e.getMessage(), ERRCOIDE, true);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } else {
            try {
                onFailure(e.getMessage(), ERRCOIDE, false);
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }

    }

    @Override
    public void onComplete() {

    }

    /**
     * 返回成功
     *
     * @param tBaseBean
     * @throws Exception
     */
    protected abstract void onSuccess(BaseBean<T> tBaseBean) throws Exception;

    /**
     * 返回失败
     *
     * @param errMessaage  错误消息
     * @param errCode      错误码
     * @param isNetWorkErr 是否是网络错误
     * @throws Exception
     */
    protected abstract void onFailure(String errMessaage, int errCode, boolean isNetWorkErr) throws Exception;

    /**
     * 开始请求
     */
    protected void onRequestStart() {
        Toast.makeText(mContext,"开始请求",Toast.LENGTH_SHORT).show();
    }

    /**
     * 结束请求
     */
    protected void onRequestEnd() {
        Toast.makeText(mContext,"开始结束",Toast.LENGTH_SHORT).show();
    }

}
