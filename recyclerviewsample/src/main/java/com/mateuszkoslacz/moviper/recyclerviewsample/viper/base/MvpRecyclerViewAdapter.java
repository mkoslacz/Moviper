package com.mateuszkoslacz.moviper.recyclerviewsample.viper.base;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by norbertbanaszek on 24.10.2016.
 */

public abstract class MvpRecyclerViewAdapter<V extends MvpView,
                P extends MvpPresenter<V>,
                VH extends MvpViewHolder<V, P>>
        extends RecyclerView.Adapter<VH> {

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        holder.bindPresenter();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public void onViewRecycled(VH holder) {
        super.onViewRecycled(holder);
        holder.unbindPresenter();
    }

    @Override
    public boolean onFailedToRecycleView(VH holder) {
        holder.unbindPresenter();
        return super.onFailedToRecycleView(holder);
    }

    @Override
    public int getItemViewType(int position) {

        return super.getItemViewType(position);
    }
}
