package com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.view.adapter.agregate.ListingItem;

import java.util.List;

/**
 * Created by jjodelka on 29/11/2016.
 */

public interface MainContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();
    }

    interface View extends ViperView {

        void setData(List<ListingItem> listingItems);
    }

    interface Interactor extends MoviperRxInteractor {
        List<Product> getProducts();
    }

    interface Routing extends MoviperRxRouting {

    }
}
