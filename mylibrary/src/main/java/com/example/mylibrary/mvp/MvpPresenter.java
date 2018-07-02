package com.example.mylibrary.mvp;

import android.content.Context;

/**
 * @Date: 2018/6/27
 * @Author: yinfx
 * @Description:
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * 绑定view
     * @param view
     */
    void attachView(V view);

    /**
     * 解除销毁view
     */
    void detachView();

    void onStart();

}
