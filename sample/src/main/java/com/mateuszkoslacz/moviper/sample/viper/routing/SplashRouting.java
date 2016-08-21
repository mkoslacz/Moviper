package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.viper.contract.SplashContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.AuthorizationActivity;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.MainActivity;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 */
public class SplashRouting
        extends ActivityBaseViewHelperRouting<
        SplashContract.PresenterForRouting,
        SplashContract.ViewHelper>
        implements SplashContract.Routing {


    public SplashRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void goToMainView() {
        //TODO add transition from splash to main
        if (isActivityAttached() && isViewHelperAttached())
            getActivity().runOnUiThread(() ->
                    MainActivity.startWithTransition(getActivity(), getViewHelper().getLogo()));
    }

    @Override
    public void goToAuthorizationView() {
        if (isActivityAttached() && isViewHelperAttached())
            getActivity().runOnUiThread(() ->
                    AuthorizationActivity.startWithTransiton(
                            getActivity(), getViewHelper().getLogo()));
    }
}
