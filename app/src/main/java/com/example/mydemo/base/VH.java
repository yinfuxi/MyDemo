package com.example.mydemo.base;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class VH extends RecyclerView.ViewHolder {

    public VH(View itemView) {
        super(itemView);
    }

    protected <T extends View> T $(@IdRes int resId) {
        return (T) itemView.findViewById(resId);
    }

    public abstract void bindData(Object o);

    public interface OnItemClickListener {

        void onClick(View v, Object arg);

    }

    public static class SpaceViewHolder extends VH {

        public SpaceViewHolder(View itemView) {
            super(itemView);
        }

        @Override
        public void bindData(Object o) {
        }

    }

}
