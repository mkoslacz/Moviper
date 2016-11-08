package com.mateuszkoslacz.moviper.ipcsample.viper.contract;

import android.support.v4.app.Fragment;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

public interface MainContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated();
    }

    interface View extends MvpView {

        int getViewIdFragmentFirst();

        int getViewIdFragmentSecond();

        int getViewIdFragmentThird();
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperRxRouting {

        void bindFragmentToView(int viewId, Fragment fragment);
    }
}
