package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.base.presenter.ViperMoviperViewHolderBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.ProductContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.ProductInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.ProductRouting;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductPresenterMoviper
        extends ViperMoviperViewHolderBaseRxPresenter<
            ProductContract.View,
            ProductContract.Interactor,
            ProductContract.Routing>
        implements ProductContract.Presenter {

    public ProductPresenterMoviper(@NonNull View view) {
        super(view);
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
    public ProductContract.Routing createRouting(@NonNull View view) {
        return new ProductRouting((Activity) view.getContext());
    }
}

