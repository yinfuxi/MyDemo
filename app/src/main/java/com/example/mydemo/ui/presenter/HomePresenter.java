package com.example.mydemo.ui.presenter;

import android.content.Context;

import com.example.mylibrary.mvp.BaseMvpPrester;

/**
 * @Author yinfx
 * @Date 2018/10/26
 * @Description
 */
public class HomePresenter extends BaseMvpPrester<HomeContract.View> implements HomeContract.Presernter{

    private Context mContext;

    public HomePresenter(Context context) {
        this.mContext = context;
    }

    @Override
    public void onStart() {

    }
}
