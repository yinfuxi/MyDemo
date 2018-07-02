package com.example.mydemo.network.base;


import com.example.mydemo.network.bean.BaseBean;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by user on 2018/4/19.
 * <p>
 * 封装的ObservableTransformer
 */
public class ApiRequestTrans implements ObservableTransformer<BaseBean, BaseBean> {

    @Override
    public ObservableSource<BaseBean> apply(Observable<BaseBean> upstream) {
        return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
