package com.example.mydemo.base;

import android.os.Bundle;

import com.example.mylibrary.mvp.MvpPresenter;
import com.example.mylibrary.mvp.MvpView;

/**
 * @Date: 2018/6/27
 * @Author: yinfx
 * @Description:
 */
public abstract class BaseMvpActivity<P extends MvpPresenter> extends BaseAppActivity implements MvpView {

    private P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        mPresenter = createPresenter();
        if (getPresenter() == null) {
            throw new NullPointerException("Presenter is null! Do you return null in createPresenter()?");
        }
        mPresenter.attachView(this);
    }

    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }

}
