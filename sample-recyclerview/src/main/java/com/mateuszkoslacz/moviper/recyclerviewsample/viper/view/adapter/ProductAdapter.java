package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter;

import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.HeaderListingItem;
import com.mateuszkoslacz.moviper.base.view.ViperRecyclerViewAdapter;
import com.mateuszkoslacz.moviper.base.view.viewholder.ViperViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ProductListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.delegate.HeaderAdapterDelegate;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.delegate.ProductAdapterDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductAdapter
        extends ViperRecyclerViewAdapter<ViperViewHolder> {

    private List<ListingItem> mListingItems;
    private AdapterDelegatesManager<List<ListingItem>> mDelegatesManager;

    public ProductAdapter() {
        mListingItems = new ArrayList<>();
        mDelegatesManager = new AdapterDelegatesManager<>();
        mDelegatesManager
                .addDelegate(HeaderListingItem.TYPE, new HeaderAdapterDelegate())
                .addDelegate(ProductListingItem.TYPE, new ProductAdapterDelegate());
    }

    @Override
    public ViperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return (ViperViewHolder) mDelegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(ViperViewHolder holder, int position) {
        mDelegatesManager.onBindViewHolder(mListingItems, position, holder);
        super.onBindViewHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return mListingItems != null ? mListingItems.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mDelegatesManager.getItemViewType(mListingItems, position);
    }

    public void setListingItems(List<ListingItem> listingItems) {
        mListingItems.clear();
        mListingItems.addAll(listingItems);
        notifyDataSetChanged();
    }
}
