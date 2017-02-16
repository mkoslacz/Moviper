package com.mateuszkoslacz.moviper.mvi.base.view;

import android.support.v7.widget.RecyclerView;

import com.mateuszkoslacz.moviper.mvi.base.view.viewholder.MviperViewHolder;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperRecyclerViewAdapter<ViewHolder extends MviperViewHolder>
        extends RecyclerView.Adapter<ViewHolder> {

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindPresenter();
    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
        holder.unbindPresenter();
    }

    @Override
    public boolean onFailedToRecycleView(ViewHolder holder) {
        holder.unbindPresenter();
        return super.onFailedToRecycleView(holder);
    }
}
