package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.delegate;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;
import com.mateuszkoslacz.moviper.recyclerviewsample.R;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ProductListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.viewholder.ProductViewHolder;

import java.util.List;

/**
 * Created by jjodelka on 29/11/2016.
 */
public class ProductAdapterDelegate extends AdapterDelegate<List<ListingItem>> {

    @Override
    protected boolean isForViewType(@NonNull List<ListingItem> items, int position) {
        return items.get(position).getType() == ListingItem.TYPE_PRODUCT;
    }

    @NonNull
    @Override
    protected RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        return new ProductViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.vh_product, parent, false));
    }

    @Override
    protected void onBindViewHolder(@NonNull List<ListingItem> items, int position,
                                    @NonNull RecyclerView.ViewHolder holder,
                                    @NonNull List<Object> payloads) {
        ProductViewHolder productViewHolder = (ProductViewHolder) holder;
        productViewHolder.setProduct(((ProductListingItem) items.get(position)).getProduct());
        productViewHolder.bindPresenter();
    }
}
