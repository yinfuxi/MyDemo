package com.example.mylibrary.mvp;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * @Date: 2018/6/27
 * @Author: yinfx
 * @Description:
 */
public abstract class BaseMvpPrester<V extends MvpView> implements MvpPresenter<V> {

    //View接口类型的软引用
    private WeakReference<V> mViewRef;

    protected final String TAG = getClass().getSimpleName();

    @Override
    public void attachView(V view) {
        //建立关系
        mViewRef = new WeakReference<V>(view);
        if (getView() == null) {
            throw new NullPointerException("view cannot be null");
        }
    }

    @Override
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }

    protected V getView() {
        return mViewRef.get();
    }

}
