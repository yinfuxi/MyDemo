package com.example.mydemo.base;

import android.view.View;

import com.example.mylibrary.mvp.MvpPresenter;
import com.example.mylibrary.mvp.MvpView;

/**
 * @Author yinfx
 * @Date 2018/10/26
 * @Description
 */
public abstract class BaseMvpFragment<P extends MvpPresenter> extends BaseAppFragment implements MvpView {

    private P mPresenter;

    protected abstract P createPresenter();

    @Override
    protected void initView(View mContentView) {
        super.initView(mContentView);
        mPresenter = createPresenter();
        if (getPresenter() == null) {
            throw new IllegalArgumentException("You must inject the dependencies before retrieving the presenter");
        }
        mPresenter.attachView(this);
    }


    protected P getPresenter() {
        return mPresenter;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
            mPresenter = null;
        }
    }
}
