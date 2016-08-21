package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.routing.FragmentBaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.util.UiUtils;
import com.mateuszkoslacz.moviper.sample.viper.contract.AuthorizationContract;
import com.mateuszkoslacz.moviper.sample.viper.contract.LoginContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.MainActivity;

/**
 * Created by mateuszkoslacz on 09.08.2016.
 */
public class LoginRouting
        extends FragmentBaseViewHelperRouting<
        LoginContract.PresenterForRouting,
        LoginContract.ViewHelper>
        implements LoginContract.Routing {

    public LoginRouting(Fragment fragment) {
        super(fragment);
    }

    @Override
    public void gotoRegisterFragment() {
        if (isActivityAttached())
            ((AuthorizationContract.View) getActivity()).showRegisterFragment();
    }

    @Override
    public void goToMainActivity() {
        if (isActivityAttached()) {
            getActivity().runOnUiThread(() ->
                    MainActivity.startWithTransition(getActivity(), getViewHelper().getLoadingLogo()));
        }
    }

    @Override
    public void hideSoftKeyboard() {
        if (isActivityAttached()) UiUtils.hideSoftKeyboard(getActivity());
    }
}
