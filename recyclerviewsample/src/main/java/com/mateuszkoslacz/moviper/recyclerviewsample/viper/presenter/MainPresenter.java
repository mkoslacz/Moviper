package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.MainRouting;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.HeaderItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.IListingItem;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ProductItem;

import java.util.ArrayList;
import java.util.List;

public class MainPresenter extends ViperActivityBaseRxPresenter<
            MainContract.View,
            MainContract.Interactor,
            MainContract.Routing>
        implements MainContract.Presenter {

    public MainPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void onViewCreated() {
        List<IListingItem> listingItems = new ArrayList<>();
        for (Product product : getInteractor().getProducts()) {
            listingItems.add(new ProductItem(product));
        }
        listingItems.add(5, new HeaderItem("Laptops"));
        listingItems.add(3, new HeaderItem("Tablets"));
        listingItems.add(0, new HeaderItem("Smartphones"));

        if (isViewAttached()) {
            getView().setData(listingItems);
        }
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting(@NonNull Activity activity) {
        return new MainRouting(activity);
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }
}
