package com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperDataView;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Product;

/**
 * Created by jjodelka on 29/11/2016.
 */

public interface ProductContract {

    interface Presenter extends MvpPresenter<View> {

    }

    interface View extends ViperDataView<Product> {

        void setTitle(String productTitle);

        void setDescription(String productDescription);

        void setPhoto(String productPhotoUrl);

        void setPrice(String productPrice);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting {

    }
}
