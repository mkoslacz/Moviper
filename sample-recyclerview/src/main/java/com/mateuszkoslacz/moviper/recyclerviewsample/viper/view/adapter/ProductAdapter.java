package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter;

import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.ViperRecyclerViewAdapter;
import com.mateuszkoslacz.moviper.base.view.ViperViewHolder;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ListingItem;
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
    private AdapterDelegatesManager mDelegatesManager;

    public ProductAdapter() {
        mListingItems = new ArrayList<>();
        mDelegatesManager = new AdapterDelegatesManager();
        mDelegatesManager
                .addDelegate(ListingItem.TYPE_HEADER, new HeaderAdapterDelegate())
                .addDelegate(ListingItem.TYPE_PRODUCT, new ProductAdapterDelegate());
    }

    @Override
    public ViperViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return (ViperViewHolder) mDelegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(ViperViewHolder holder, int position) {
        mDelegatesManager.onBindViewHolder(mListingItems, position, holder);
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
