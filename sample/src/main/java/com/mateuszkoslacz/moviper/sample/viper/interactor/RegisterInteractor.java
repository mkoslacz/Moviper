package com.mateuszkoslacz.moviper.sample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseInteractor;
import com.mateuszkoslacz.moviper.sample.data.bundle.LocationPoint;
import com.mateuszkoslacz.moviper.sample.data.bundle.RegisterBundle;
import com.mateuszkoslacz.moviper.sample.data.parse.User;
import com.mateuszkoslacz.moviper.sample.util.mapper.LocationPointToParseGeoPointMapper;
import com.mateuszkoslacz.moviper.sample.viper.contract.RegisterContract;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 */
public class RegisterInteractor
        extends BaseInteractor<RegisterContract.PresenterForInteractor>
        implements RegisterContract.Interactor {

    @Override
    public void register(RegisterBundle bundle, LocationPoint localization) {
        User.Builder builder = new User.Builder();
        builder.withLogin(bundle.getLogin());
        builder.withEmail(bundle.getEmail());
        builder.withPassword(bundle.getPassword());
        if (!localization.isUnknown())
            builder.withLocalization(
                    new LocationPointToParseGeoPointMapper().map(localization));
        User newUser = builder.build();
        newUser.signUpInBackground(e -> {
            if (isPresenterAttached()) {
                if (e != null) getPresenter().showRegisterError(e.getLocalizedMessage());
                else getPresenter().proceedAfterRegister();
            }
        });
    }
}
