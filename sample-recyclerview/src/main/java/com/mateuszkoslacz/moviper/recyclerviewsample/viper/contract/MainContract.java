package com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
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

    interface View extends MvpView {

        void setData(List<ListingItem> listingItems);
    }

    interface Interactor extends ViperRxInteractor {

        List<Product> getProducts();
    }

    interface Routing extends ViperRxRouting {

    }
}
