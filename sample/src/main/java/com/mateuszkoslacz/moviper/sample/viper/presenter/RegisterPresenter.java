package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.presenter.ViperFragmentBasePresenter;
import com.mateuszkoslacz.moviper.sample.data.bundle.LocationPoint;
import com.mateuszkoslacz.moviper.sample.data.bundle.RegisterBundle;
import com.mateuszkoslacz.moviper.sample.viper.contract.RegisterContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.RegisterInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.RegisterRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 */
public class RegisterPresenter
        extends ViperFragmentBasePresenter<RegisterContract.View,
        RegisterContract.Interactor,
        RegisterContract.Routing>
        implements RegisterContract.Presenter,
        RegisterContract.PresenterForInteractor,
        RegisterContract.PresenterForRouting {

    private RegisterBundle cachedRegisterBundle;


    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // initializers
    ///////////////////////////////////////////////////////////////////////////

    public RegisterPresenter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public RegisterContract.Routing createRouting(@NonNull Fragment fragment) {
        return new RegisterRouting(fragment);
    }

    @NonNull
    @Override
    public RegisterContract.Interactor createInteractor() {
        return new RegisterInteractor();
    }


    ///////////////////////////////////////////////////////////////////////////
    // logic
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onRegisterClicked(RegisterBundle bundle) {
        if (isRoutingAttached()) getRouting().hideSoftKeyboard();
        if (!bundle.isComplete()) { // it's not needed with Parse, just for illustration purposes
            if (isViewAttached()) getView().displayError("Provide login, email and password!");
        } else {
            if (isViewAttached()) getView().showLoadingView();
            cachedRegisterBundle = bundle;
            if (isRoutingAttached()) getRouting().subscribeToGetLocalization();
        }
    }

    @Override
    public void onShowLoginFragmentClicked() {
        if (isRoutingAttached()) getRouting().gotoLoginFragment();
    }

    @Override
    public void showRegisterError(String msg) {
        if (isViewAttached()) getView().displayError(msg);
    }

    @Override
    public void proceedAfterRegister() {
        if (isRoutingAttached()) getRouting().goToMainActivity();
    }

    @Override
    public void onRequestLocalizationPermissionsResult(boolean granted) {
        if (isRoutingAttached()) getRouting().onRequestLocalizationPermissionsResult(granted);
    }

    @Override
    public void onLocalizationAquired(LocationPoint location) {
        if (isInteractorAttached()) getInteractor().register(cachedRegisterBundle, location);
    }

    @Override
    public void onLocalizationAquireFailed(String message) {
        if (isViewAttached()) getView().displayError(message);
    }

}
