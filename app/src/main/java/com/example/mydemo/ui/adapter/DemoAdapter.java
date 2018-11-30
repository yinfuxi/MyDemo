package com.example.mydemo.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mydemo.R;
import com.example.mydemo.base.VH;
import com.example.mydemo.bean.DemoBean;

import java.util.List;

/**
 * @Author yinfx
 * @Date 2018/11/9
 * @Description
 */
public class DemoAdapter extends RecyclerView.Adapter<VH> {

    private List list;

    public void setData(List data) {
        list = data;
        notifyDataSetChanged();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0){
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demo1, parent, false));
        } else {
            return new ViewHolder2(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_demo2, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        try {
            holder.bindData(list.get(position));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (list.get(position) instanceof DemoBean.ListBean) {
            return 1;
        } else {
            return 0;
        }
    }

    private class ViewHolder extends VH implements View.OnClickListener {

        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = $(R.id.title);
        }

        @Override
        public void onClick(View v) {
        }

        @Override
        public void bindData(Object o) {
            itemView.setTag(o);
            String titiles = (String) o;
            title.setText(titiles);

        }
    }

    private class ViewHolder2 extends VH implements View.OnClickListener {

        TextView title;
        TextView title2;

        public ViewHolder2(View itemView) {
            super(itemView);
            title = $(R.id.tv_1);
            title2 = $(R.id.tv_2);
        }

        @Override
        public void onClick(View v) {
        }

        @Override
        public void bindData(Object o) {
            itemView.setTag(o);
            DemoBean.ListBean listBean = (DemoBean.ListBean) o;
            itemView.setTag(o);
            title.setText(listBean.getId());
            title2.setText(listBean.getTitle());

        }
    }

}
