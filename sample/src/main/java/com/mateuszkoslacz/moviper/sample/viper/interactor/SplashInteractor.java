package com.mateuszkoslacz.moviper.sample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseInteractor;
import com.mateuszkoslacz.moviper.sample.viper.contract.SplashContract;
import com.parse.ParseUser;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 */
public class SplashInteractor
        extends BaseInteractor<SplashContract.PresenterForInteractor>
        implements SplashContract.Interactor {

    /**
     * There is an example how to suppress yellow lint remarks because of probable
     * NullPointerException (the "//noinspection ConstantConditions" part). I skipped this
     * in the rest of the sample to improve readability.
     */
    @Override
    public void subscribeToHasActiveUserSession() {
        // simulate heavy work
        // not using Android Runnable to make this separated from the platform framework
        new Timer().schedule(
                new TimerTask() {
                    @Override
                    public void run() {
                        if (isPresenterAttached())
                            //noinspection ConstantConditions because we checked isPresenterAttached()
                            getPresenter().onHasActiveUserSessionResponse(
                                    ParseUser.getCurrentUser() != null);
                    }
                },
                3000
        );
    }
}
