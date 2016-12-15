package com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter;

import android.view.ViewGroup;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegatesManager;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.MvpBaseViewHolder;
import com.mateuszkoslacz.moviper.base.view.MvpRecyclerViewAdapter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.DisplayableItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.HeaderItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ProductItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.delegate.HeaderAdapterDelegate;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.delegate.ProductAdapterDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductAdapter
        extends MvpRecyclerViewAdapter<MvpView, MvpPresenter<MvpView>,
        MvpBaseViewHolder> {

    private List<DisplayableItem> mDisplayableItems;
    private AdapterDelegatesManager mDelegatesManager;

    public ProductAdapter() {
        mDisplayableItems = new ArrayList<>();
        mDelegatesManager = new AdapterDelegatesManager();
        mDelegatesManager
                .addDelegate(HeaderItem.TYPE, new HeaderAdapterDelegate())
                .addDelegate(ProductItem.TYPE, new ProductAdapterDelegate());
    }

    @Override
    public MvpBaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return (MvpBaseViewHolder) mDelegatesManager.onCreateViewHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(MvpBaseViewHolder holder, int position) {
        mDelegatesManager.onBindViewHolder(mDisplayableItems, position, holder);
    }

    @Override
    public int getItemCount() {
        return mDisplayableItems != null ? mDisplayableItems.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return mDelegatesManager.getItemViewType(mDisplayableItems, position);
    }

    public void setListingItems(List<DisplayableItem> displayableItems) {
        mDisplayableItems.clear();
        mDisplayableItems.addAll(displayableItems);
        notifyDataSetChanged();
    }
}
