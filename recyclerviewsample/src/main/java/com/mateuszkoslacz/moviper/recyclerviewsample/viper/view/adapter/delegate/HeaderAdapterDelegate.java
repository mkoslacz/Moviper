package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.delegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.HeaderItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.IListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder.HeaderViewHolder;

import java.util.List;

/**
 * Created by jjodelka on 29/11/2016.
 */
public class HeaderAdapterDelegate extends AdapterDelegate<List<IListingItem>> {

    @Override
    protected boolean isForViewType(@NonNull List<IListingItem> items, int position) {
        return items.get(position).getType() == IListingItem.TYPE_HEADER;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new HeaderViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.vh_header, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<IListingItem> items, int position,
                                    @NonNull RecyclerView.ViewHolder holder,
                                    @NonNull List<Object> payloads) {
        HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
        headerViewHolder.setCategory(((HeaderItem) items.get(position)).getTitle());
        headerViewHolder.bindPresenter();
    }
}