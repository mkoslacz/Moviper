package com.mateuszkoslacz.moviper.rxsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

public interface FullscreenPhotoContract {

    interface Presenter extends MvpPresenter<View> {
        // Defines what methods the View can invoke on the Presenter.
        // In most cases there will be user interactions and View lifecycle events.

        String getPhotoUrlIntentFromUserDetailsActivity();
    }

    interface View extends MvpView {
        // Defines what methods the Presenter can invoke on the View
        // In most cases there will be manipulating ui and displaying data or errors.
        // In Super Rx version it also provides getters for Observables emmiting user click events.

    }

    interface Interactor extends MoviperRxInteractor {
        // Defines what methods the Presenter can invoke on the Interactor.
        // In most cases there will be data saving and querying.
        // It's just a marker interface.

    }

    interface Routing extends MoviperRxRouting {
        // Defines what methods the Presenter can invoke on the Routing.
        // In most cases there will be starting another activities, services and using system
        // framework, ie. scheduling alarms or sending broadcasts.
        // In the case of a fragment being the view, there also will be manipulating
        // the root Activity, ie. switching fragments.

        String getPhotoUrlIntentFromUserDetailsActivity();
    }
}
