package com.mateuszkoslacz.rxpresenter.viper.contract;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

public interface SampleContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated(Bundle savedInstanceState);
    }

    interface View extends ViperView {

        void showNumber(long number);
    }

    interface Interactor extends ViperRxInteractor {

    }

    interface Routing extends ViperRxRouting {

    }
}
