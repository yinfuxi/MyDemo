package com.example.mydemo.ui.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.mydemo.R;
import com.example.mydemo.base.BaseMvpFragment;
import com.example.mydemo.bean.DemoBean;
import com.example.mydemo.ui.adapter.DemoAdapter;
import com.example.mydemo.ui.presenter.HomeContract;
import com.example.mydemo.ui.presenter.HomePresenter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * @Author yinfx
 * @Date 2018/10/8
 * @Description
 */
public class HomeFragment extends BaseMvpFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    DemoAdapter adapter;


    public static HomeFragment newInstance() {
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(mContext);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.fgmt_home;
    }

    @Override
    protected void initView(View mContentView) {
        super.initView(mContentView);
        adapter = new DemoAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(adapter);


        String json = "[\n" +
                "  {\n" +
                "    \"time\": \"2018-11-11\",\n" +
                "    \"list\": [\n" +
                "      {\n" +
                "        \"id\": \"1037\",\n" +
                "        \"title\": \"土耳其原装进口雍家玉米油\",\n" +
                "        \"pics\": [\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085d67f794.jpg\",\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085e2617a8.jpg\",\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085ea0b48d.jpg\"\n" +
                "        ],\n" +
                "        \"price\": \"98.00\",\n" +
                "        \"stock\": \"200\",\n" +
                "        \"sells\": \"0\",\n" +
                "        \"state\": \"1\",\n" +
                "        \"hits\": \"12\",\n" +
                "        \"addtime\": \"1541664959\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"time\": \"2018-11-10\",\n" +
                "    \"list\": [\n" +
                "      {\n" +
                "        \"id\": \"1037\",\n" +
                "        \"title\": \"土耳其原装进口雍家玉米油\",\n" +
                "        \"pics\": [\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085d67f794.jpg\",\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085e2617a8.jpg\",\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085ea0b48d.jpg\"\n" +
                "        ],\n" +
                "        \"price\": \"98.00\",\n" +
                "        \"stock\": \"200\",\n" +
                "        \"sells\": \"0\",\n" +
                "        \"state\": \"1\",\n" +
                "        \"hits\": \"12\",\n" +
                "        \"addtime\": \"1541664959\"\n" +
                "      },\n" +
                "      {\n" +
                "        \"id\": \"1037\",\n" +
                "        \"title\": \"土耳其原装进口雍家玉米油\",\n" +
                "        \"pics\": [\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085d67f794.jpg\",\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085e2617a8.jpg\",\n" +
                "          \"http://112.13.199.14:202/uploads/products/201806/5b3085ea0b48d.jpg\"\n" +
                "        ],\n" +
                "        \"price\": \"98.00\",\n" +
                "        \"stock\": \"200\",\n" +
                "        \"sells\": \"0\",\n" +
                "        \"state\": \"1\",\n" +
                "        \"hits\": \"12\",\n" +
                "        \"addtime\": \"1541664959\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]";

        Type founderListType = new TypeToken<ArrayList<DemoBean>>() {
        }.getType();
        List<DemoBean> listTemp = new Gson().fromJson(json, founderListType);

        List list = new ArrayList();
        for (DemoBean bean:listTemp){
            list.add(bean.getTime());
            list.addAll(bean.getList());
        }

        adapter.setData(list);
    }
}
