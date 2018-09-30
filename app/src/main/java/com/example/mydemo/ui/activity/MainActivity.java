package com.example.mydemo.ui.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.mydemo.R;
import com.example.mydemo.base.BaseMvpActivity;
import com.example.mydemo.ui.presenter.MainContract;
import com.example.mydemo.ui.presenter.MainPresenter;
import com.example.mydemo.widget.PieChartView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import butterknife.BindView;

/**
 * @Author yinfx
 * @Date 2018/9/27
 * @Description 首页
 */
public class MainActivity extends BaseMvpActivity<MainPresenter> implements MainContract.View {

    @BindView(R.id.tv_token)
    TextView tvToken;
    @BindView(R.id.btn_test)
    Button btnTest;
    @BindView(R.id.piechart_view)
    PieChartView pieChartView;


    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        testPieChartView();
        btnTest.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                getPresenter().syncMessage();
            }
        });
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(mContext);
    }

    private void testPieChartView() {
        Map<String, Integer> kindsMap = new LinkedHashMap<String, Integer>();//存放事物的品种与其对应的数量
        ArrayList<Integer> colors = new ArrayList<>();//存放颜色
        kindsMap.put("苹果", 10);
        kindsMap.put("梨子", 30);
        kindsMap.put("香蕉", 10);
        kindsMap.put("葡萄", 30);
        kindsMap.put("哈密瓜", 10);
        kindsMap.put("猕猴桃", 30);
        kindsMap.put("草莓", 10);
        kindsMap.put("橙子", 30);
        kindsMap.put("火龙果", 10);
        kindsMap.put("椰子", 20);
        for (int i = 0; i <= kindsMap.size() + 1; i++) {
            int r = (new Random().nextInt(100) + 10) * i;
            int g = (new Random().nextInt(100) + 10) * 3 * i;
            int b = (new Random().nextInt(100) + 10) * 2 * i;
            int color = Color.rgb(r, g, b);
            if (Math.abs(r - g) > 10 && Math.abs(r - b) > 10 && Math.abs(b - g) > 10) {
                colors.add(color);
            }
        }


        pieChartView.setKindsMap(kindsMap);
        pieChartView.setColors(colors);
    }


    @Override
    public void showList(String message) {
        tvToken.setText(message);
    }
}