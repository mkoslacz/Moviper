package com.mateuszkoslacz.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

import rx.Observable;

public interface MainContract {

    interface View extends MvpView {

        void enableStart();

        void enableStop();

        Observable<Void> onStartClicks();

        Observable<Void> onStopClicks();
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting {

        void startIndependentViper();

        void stopIndependentViper();
    }
}
