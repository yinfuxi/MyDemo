package com.example.mydemo.base;

import android.view.View;

import com.example.mylibrary.base.BaseAbstractFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @Author yinfx
 * @Date 2018/10/26
 * @Description
 */
public class BaseAppFragment extends BaseAbstractFragment {

    private Unbinder unbinder;

    @Override
    protected int getLayoutResId() {
        return 0;
    }

    @Override
    protected void initView(View mContentView) {
        unbinder = ButterKnife.bind(this, mContentView);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void processLogic() {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
        }
    }
}
