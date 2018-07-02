package com.example.mydemo;

import android.content.Context;
import android.util.Log;

import com.example.mydemo.bean.MattersBeanInfo;
import com.example.mydemo.network.RetrofitFactory;
import com.example.mydemo.network.base.ApiRequestTrans;
import com.example.mydemo.network.base.BaseObserver;
import com.example.mydemo.network.bean.BaseBean;
import com.example.mylibrary.mvp.BaseMvpPrester;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * @Date: 2018/6/28
 * @Author: yinfx
 * @Description:
 */
public class MainPresenter extends BaseMvpPrester<MainContract.View> implements MainContract.Presenter {


    private Context mContext;

    public MainPresenter(Context context) {
        this.mContext = context;
    }


    @Override
    public void onStart() {
    }

    @Override
    public void syncMessage() {
        Map map = new HashMap();
        map.put("pageIndex", -1);
        map.put("pageSize", "5");
        RetrofitFactory.getInstance().getRequestService()
                .getProRegularList(map)
                .compose(new ApiRequestTrans())
                .subscribe(new BaseObserver<MattersBeanInfo>(mContext) {

                    @Override
                    protected void onSuccess(BaseBean<MattersBeanInfo> baseBean) throws Exception {
                        MattersBeanInfo mattersBeanInfo = baseBean.getData();
//                        tvToken.setText(mattersBeanInfo.getCount());
                        getView().showList(mattersBeanInfo.getCount());
                    }

                    @Override
                    protected void onFailure(String errMessaage, int errCode, boolean isNetWorkErr) throws Exception {
//                        tvToken.setText("errMessaage" + errMessaage);
                    }

                });
    }

    private void testNet() {
        Map map = new HashMap();
        map.put("pageIndex", 1);
        map.put("pageSize", "5");
        RetrofitFactory.getInstance().getRequestService()
                .getProRegularList(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BaseBean<MattersBeanInfo>>() {

                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BaseBean<MattersBeanInfo> objectBaseBean) {
                        MattersBeanInfo mattersBeanInfo = objectBaseBean.getData();
                        Log.d(TAG, mattersBeanInfo.toString());
//                        tvToken.setText(mattersBeanInfo.toString());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());
//                        tvToken.setText("errMessaage" + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}
