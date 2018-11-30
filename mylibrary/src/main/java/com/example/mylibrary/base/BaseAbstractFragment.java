package com.example.mylibrary.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mylibrary.utils.LogUtils;

import java.lang.reflect.Field;

/**
 * @Author yinfx
 * @Date 2018/10/8
 * @Description
 */
public abstract class BaseAbstractFragment extends Fragment {

    protected final String TAG = this.getClass().getSimpleName();

    protected Context mContext;
    protected Activity mActivity;

    protected View mContentView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initContext();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (null == mContentView) {
            mContentView = inflater.inflate(getLayoutResId(), container, false);
            initView(mContentView);
            initEvent();
            processLogic();
        }
        ViewGroup parent = (ViewGroup) mContentView.getParent();
        if (parent != null) {
            parent.removeView(mContentView);
        }
        return mContentView;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        try {//ChildFragmentManager出现No activity
            Field childFragmentManager = Fragment.class.getDeclaredField("mChildFragmentManager");
            childFragmentManager.setAccessible(true);
            childFragmentManager.set(this, null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        initContext();
    }

    /**
     * 布局文件资源ID
     */
    protected abstract int getLayoutResId();

    /**
     * 负责有关handler等对象,界面ui组件的初始化
     */
    protected abstract void initView(View mContentView);

    /**
     * 负责有关界面ui组件事件的初始化
     */
    protected abstract void initEvent();

    /**
     * 处理业务逻辑
     */
    protected abstract void processLogic();

    protected void initContext() {
        try {
            this.mActivity = getActivity();
            this.mContext = getActivity().getApplicationContext();
        } catch (Exception e) {
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        LogUtils.d(TAG, "@@onPause----");
    }

    @Override
    public void onResume() {
        super.onResume();
        LogUtils.d(TAG, "@@onResume----");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        LogUtils.d(TAG, "@@onDestroy----");
    }


}
