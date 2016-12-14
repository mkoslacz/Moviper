package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.MainRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.HeaderListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ProductListingItem;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter
        extends ViperBaseRxPresenter<MainContract.View,
                        MainContract.Interactor,
                        MainContract.Routing>
        implements MainContract.Presenter {

    @Override
    public void onViewCreated() {
        List<ListingItem> listingItems = new ArrayList<>();
        for (Product product : getInteractor().getProducts()) {
            listingItems.add(new ProductListingItem(product));
        }
        listingItems.add(5, new HeaderListingItem(new Category("Laptop")));
        listingItems.add(3, new HeaderListingItem(new Category("Tablets")));
        listingItems.add(0, new HeaderListingItem(new Category("Smartphones")));

        if (isViewAttached()) {
            getView().setData(listingItems);
        }
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting() {
        return new MainRouting();
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }
}
