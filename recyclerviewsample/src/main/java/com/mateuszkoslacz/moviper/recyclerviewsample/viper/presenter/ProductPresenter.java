package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.ProductContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.ProductInteractor;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductPresenter
        extends ViperActivityBaseRxPresenter<ProductContract.View,
            ProductContract.Interactor,
            ProductContract.Routing>
        implements ProductContract.Presenter {

    public ProductPresenter(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void requestFillingView() {
        if (isViewAttached()) {
            Product product = getView().getProduct();
            getView().setProductTitle(product.getTitle());
            getView().setProductDescription(product.getDescription());
            getView().setProductPrice(product.getPrice());
            getView().setProductPhoto(product.getPhotoUrl());
        }
    }

    @NonNull
    @Override
    public ProductContract.Interactor createInteractor() {
        return new ProductInteractor();
    }

    @NonNull
    @Override
    public ProductContract.Routing createRouting(@NonNull Activity activity) {
        return null;
        // TODO: 29/11/2016  
    }

}

