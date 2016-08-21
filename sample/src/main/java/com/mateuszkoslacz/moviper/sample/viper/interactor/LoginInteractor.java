package com.mateuszkoslacz.moviper.sample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseInteractor;
import com.mateuszkoslacz.moviper.sample.viper.contract.LoginContract;
import com.parse.ParseUser;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 */
public class LoginInteractor
        extends BaseInteractor<LoginContract.PresenterForInteractor>
        implements LoginContract.Interactor {

    @Override
    public void login(String username, String password) {
        ParseUser.logInInBackground(username, password, (user, e) -> {
            if (isPresenterAttached()) {
                if (e == null) getPresenter().proceedAfterLogin();
                else getPresenter().showLoginError(e);
            }
        });
    }
}
