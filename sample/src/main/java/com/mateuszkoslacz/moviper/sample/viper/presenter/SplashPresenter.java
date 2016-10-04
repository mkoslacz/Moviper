package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.contract.SplashContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.SplashInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.SplashRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 */
public class SplashPresenter
        extends ViperActivityBasePresenter<SplashContract.View,
        SplashContract.Interactor,
        SplashContract.Routing>
        implements
        SplashContract.Presenter,
        SplashContract.PresenterForInteractor,
        SplashContract.PresenterForRouting {


    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // initializers
    ///////////////////////////////////////////////////////////////////////////

    public SplashPresenter(Activity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public SplashContract.Interactor createInteractor() {
        return new SplashInteractor();
    }

    @NonNull
    @Override
    public SplashContract.Routing createRouting(@NonNull Activity activity) {
        return new SplashRouting(activity);
    }


    ///////////////////////////////////////////////////////////////////////////
    // logic
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onViewLoaded() {
        getInteractor().subscribeToHasActiveUserSession();
    }

    @Override
    public void onHasActiveUserSessionResponse(boolean hasActiveUserSession) {
        if (hasActiveUserSession) getRouting().goToMainView();
        else getRouting().goToAuthorizationView();
    }
}
