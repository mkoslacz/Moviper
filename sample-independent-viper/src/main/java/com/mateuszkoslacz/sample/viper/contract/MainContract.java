package com.mateuszkoslacz.sample.viper.contract;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

import io.reactivex.Observable;

public interface MainContract {

    interface View extends MvpView {

        void enableStart();

        void enableStop();

        Observable<Object> onStartClicks();

        Observable<Object> onStopClicks();
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting {

        void startIndependentViper();

        void stopIndependentViper();
    }
}
