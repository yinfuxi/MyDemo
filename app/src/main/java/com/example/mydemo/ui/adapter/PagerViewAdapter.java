package com.example.mydemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @Author yinfx
 * @Date 2018/10/8
 * @Description 通用ViewPager适配器
 */
public class PagerViewAdapter extends FragmentPagerAdapter {

    private List<Fragment> list;
    private String[] titles;

    public PagerViewAdapter(String[] titles, List<Fragment> l, FragmentManager fm) {
        super(fm);
        this.list = l;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return list == null ? null : list.get(position);
    }

    @Override
    public long getItemId(int position) {
        int id = position;
        try {
            id = list.get(position).hashCode();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return id;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
