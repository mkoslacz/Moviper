package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.support.annotation.NonNull;
import android.app.Activity;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;

public class ListingPresenter
        extends ViperActivityBaseRxPresenter
        <ListingContract.View,
                ListingContract.Interactor,
                ListingContract.Routing>
        implements
        ListingContract.Presenter {

    public ListingPresenter(Activity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public ListingContract.Routing createRouting(@NonNull Activity activity) {
        return new ListingRouting(activity);
    }

    @NonNull
    @Override
    public ListingContract.Interactor createInteractor() {
        return new ListingInteractor();
    }
}
