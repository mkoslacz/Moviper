package com.mateuszkoslacz.moviper.recyclerviewsample.viper.contract;

import android.app.Activity;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;
import com.mateuszkoslacz.moviper.recyclerviewsample.viper.entity.Category;

/**
 * Created by jjodelka on 29/11/2016.
 */

public interface HeaderContract {

    interface Presenter extends MvpPresenter<View> {

    }

    interface View extends MvpDataView<Category> {

        void setTitle(String title);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting<Activity> {

    }
}

