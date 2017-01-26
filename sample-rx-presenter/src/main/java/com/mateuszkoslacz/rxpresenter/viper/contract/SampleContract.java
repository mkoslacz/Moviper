package com.mateuszkoslacz.rxpresenter.viper.contract;

import android.app.Activity;
import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

public interface SampleContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated(Bundle savedInstanceState);
    }

    interface View extends MvpView {

        void showNumber(long number);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting<Activity> {

    }
}
