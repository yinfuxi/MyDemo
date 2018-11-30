package com.example.mydemo.ui.presenter;

import com.example.mylibrary.mvp.MvpPresenter;
import com.example.mylibrary.mvp.MvpView;

/**
 * @Author yinfx
 * @Date 2018/10/26
 * @Description
 */
public interface HomeContract {

    interface View extends MvpView{

    }

    interface Presernter extends MvpPresenter<View>{

    }

}
