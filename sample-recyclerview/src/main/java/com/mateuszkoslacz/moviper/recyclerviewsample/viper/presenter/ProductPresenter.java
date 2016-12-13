package com.mateuszkoslacz.moviper.recyclerviewsample.viper.presenter;

import android.support.annotation.NonNull;
import android.view.View;

import com.mateuszkoslacz.moviper.base.presenter.ViperViewHolderBaseRxPresenter;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract.ProductContract;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.interactor.ProductInteractor;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.routing.ProductRouting;

/**
 * Created by jjodelka on 29/11/2016.
 */

public class ProductPresenter
        extends ViperViewHolderBaseRxPresenter<
                    ProductContract.View,
                    ProductContract.Interactor,
                    ProductContract.Routing>
        implements ProductContract.Presenter {

    public ProductPresenter(@NonNull View view) {
        super(view);
    }

    @Override
    public void attachView(ProductContract.View view) {
        super.attachView(view);
        if (isViewAttached()) {
            Product product = getView().getDataObject();
            getView().setTitle(product.getTitle());
            getView().setDescription(product.getDescription());
            getView().setPrice(product.getPrice());
            getView().setPhoto(product.getPhotoUrl());
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
        return new ProductRouting(view);
    }
}

