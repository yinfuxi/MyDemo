package com.example.mydemo;

import com.example.mylibrary.mvp.MvpPresenter;
import com.example.mylibrary.mvp.MvpView;

/**
 * @Date: 2018/6/28
 * @Author: yinfx
 * @Description:
 */
public interface MainContract {

    interface View extends MvpView {

        void showList(String message);

    }

    interface Presenter extends MvpPresenter<View>{

        void syncMessage();
    }

}
