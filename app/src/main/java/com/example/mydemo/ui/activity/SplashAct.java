package com.example.mydemo.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.example.mydemo.R;
import com.example.mydemo.base.BaseAppActivity;
import com.example.mydemo.ui.adapter.PagerViewAdapter;
import com.example.mydemo.ui.fragment.HomeFragment;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import jiguang.chat.activity.fragment.ConversationListFragment;
import jiguang.chat.utils.JIMHelp;

/**
 * @Author yinfx
 * @Date 2018/9/27
 * @Description
 */
public class SplashAct extends BaseAppActivity {


    @BindView(R.id.bnve)
    BottomNavigationViewEx bnve;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private final String[] title = {"", "", "", "", ""};
    private List<Fragment> fragmentList;

    @Override
    protected int getLayoutResId() {
        return R.layout.act_splash;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);

        initJGIM();

        fragmentList = new ArrayList<>();
        fragmentList.add(new ConversationListFragment());
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(HomeFragment.newInstance());
        fragmentList.add(HomeFragment.newInstance());
        initBottom();
    }

    private void initJGIM() {
        JIMHelp.getInstance().init(getApplicationContext(),"uid123","123456");
    }


    private void initBottom() {
        viewpager.setOffscreenPageLimit(3);
        viewpager.setAdapter(new PagerViewAdapter(title, fragmentList, getSupportFragmentManager()));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                bnve.getMenu().getItem(position).setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //禁止所有动画
        bnve.enableAnimation(false);
        bnve.setLabelVisibilityMode(1);
        bnve.setItemHorizontalTranslationEnabled(false);
        //使用自己的选中图标时一定设置这句
        bnve.setItemIconTintList(null);

        bnve.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.tab_home:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.tab_recommend:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.tab_message:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.tab_news:
                        viewpager.setCurrentItem(3);
                        break;
                    case R.id.tab_mine:
                        viewpager.setCurrentItem(4);
                        break;

                }
                return false;
            }
        });
    }

}
