package com.mateuszkoslacz.moviper.presenterbus.presentertest;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;

/**
 * Created by bwilk on 12/20/16.
 */

public class CustomPresenter
        extends BaseRxPresenter<MvpView,
        ViperRxInteractor,
        ViperRxRouting>
        implements MvpPresenter<MvpView> {

    private BaseRxRouting mRouting;
    private BaseRxInteractor mInteractor;

    @NonNull
    @Override
    public ViperRxInteractor createInteractor() {
        return mInteractor;
    }

    @NonNull
    @Override
    public ViperRxRouting createRouting() {
        return mRouting;
    }
}
