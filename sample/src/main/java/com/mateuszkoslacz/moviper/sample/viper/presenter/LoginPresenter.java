package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.presenter.ViperFragmentBasePresenter;
import com.mateuszkoslacz.moviper.sample.util.StringUtils;
import com.mateuszkoslacz.moviper.sample.viper.contract.LoginContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.LoginInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.LoginRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 */
public class LoginPresenter
        extends ViperFragmentBasePresenter<LoginContract.View,
        LoginContract.Interactor,
        LoginContract.Routing>
        implements
        LoginContract.Presenter,
        LoginContract.PresenterForInteractor,
        LoginContract.PresenterForRouting {


    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // initializers
    ///////////////////////////////////////////////////////////////////////////

    public LoginPresenter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public LoginContract.Interactor createInteractor() {
        return new LoginInteractor();
    }

    @NonNull
    @Override
    public LoginContract.Routing createRouting(@NonNull Fragment fragment) {
        return new LoginRouting(fragment);
    }


    ///////////////////////////////////////////////////////////////////////////
    // logic
    ///////////////////////////////////////////////////////////////////////////

    /**
     * I'm not using Android string resources here to detach the Presenter from system Framework,
     * but actually the View should know what exactly to display and the Presenter should have no
     * strings at all. It will be changed in future. For more info see
     * <a href="https://stackoverflow.com/questions/25794106/">here</a>
     *
     * @param username
     * @param password
     */
    @Override
    public void onLoginClicked(String username, String password) {
        getRouting().hideSoftKeyboard();
        if (StringUtils.isNullOrEmpty(username) || StringUtils.isNullOrEmpty(password)) {
            if (isViewAttached())
                getView().showError(new Exception("Provide login and password!"), false);
        } else {
            if (isViewAttached()) getView().showLoading(false);
            getInteractor().login(username, password);
        }
    }

    @Override
    public void onShowRegisterFragmentClicked() {
        getRouting().gotoRegisterFragment();
    }

    @Override
    public void showLoginError(Throwable e) {
        if (isViewAttached()) getView().showError(e, false);
    }

    @Override
    public void proceedAfterLogin() {
        getRouting().goToMainActivity();
    }


}
