package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.transition.ChangeBounds;
import android.transition.Slide;
import android.view.Gravity;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.AuthorizationContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.AuthorizationPresenter;
import com.mateuszkoslacz.moviper.sample.viper.view.fragment.LoginFragment;
import com.mateuszkoslacz.moviper.sample.viper.view.fragment.RegisterFragment;
import com.mateuszkoslacz.moviper.sample.viper.view.fragment.iface.AuthorizationFragment;

public class AuthorizationActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<AuthorizationContract.View, AuthorizationContract.Presenter>
        implements AuthorizationContract.View {

    LoginFragment mLoginFragment;
    RegisterFragment mRegisterFragment;

    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // initializers
    ///////////////////////////////////////////////////////////////////////////

    public static void startWithTransiton(Activity activity, android.view.View logo) {
        Intent intent = new Intent(activity, AuthorizationActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                        activity,
                        logo,
                        activity.getString(R.string.logoTransition));
        activity.startActivity(intent, options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        mLoginFragment = (LoginFragment) addTransitions(new LoginFragment(), Gravity.LEFT);
        mRegisterFragment = (RegisterFragment) addTransitions(new RegisterFragment(), Gravity.RIGHT);
        presenter.onUiCreated();
    }


    ///////////////////////////////////////////////////////////////////////////
    // creating presenter
    ///////////////////////////////////////////////////////////////////////////

    @NonNull
    @Override
    public AuthorizationContract.Presenter createPresenter() {
        return new AuthorizationPresenter();
    }


    ///////////////////////////////////////////////////////////////////////////
    // view interface methods
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void showRegisterFragment() {
        switchFragments(mRegisterFragment, mLoginFragment);
    }

    @Override
    public void showLoginFragment() {
        switchFragments(mLoginFragment, mRegisterFragment);
    }


    ///////////////////////////////////////////////////////////////////////////
    // internal methods
    ///////////////////////////////////////////////////////////////////////////

    private void switchFragments(@NonNull Fragment fragmentToShow,
                                 @Nullable Fragment fragmentToHide) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        showFragment(fragmentTransaction, fragmentToShow);
        hideFragment(fragmentTransaction, fragmentToHide);
        fragmentTransaction.commit();
    }

    private void showFragment(@NonNull FragmentTransaction fragmentTransaction,
                              @NonNull Fragment fragmentToShow) {
        if (fragmentToShow.isAdded()) {
            //TODO it's not animating using supportFragmentManager
            fragmentTransaction.show(fragmentToShow);
        } else {
            fragmentTransaction.add(R.id.activity_authorization_login_register_fragment_container,
                    fragmentToShow,
                    fragmentToShow.getClass().getName());
        }
    }

    private void hideFragment(@NonNull FragmentTransaction fragmentTransaction,
                              @Nullable Fragment fragmentToHide) {
        if (fragmentToHide != null && fragmentToHide.isAdded()) {
            fragmentTransaction.hide(fragmentToHide);
            fragmentTransaction.addSharedElement(
                    ((AuthorizationFragment) fragmentToHide).getSharedLoginEditText(),
                    getString(R.string.loginTransition));
            fragmentTransaction.addSharedElement(
                    ((AuthorizationFragment) fragmentToHide).getSharedPasswordEditText(),
                    getString(R.string.passwordTransition));
        }
    }

    // TODO: 21.08.2016 I have no idea why it does work only for a first time, it works everytime
    // when using non-support fragments
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private Fragment addTransitions(@NonNull Fragment fragment, int slideEdge) {
        fragment.setSharedElementEnterTransition(new ChangeBounds());
        fragment.setEnterTransition(new Slide(slideEdge));
        fragment.setReenterTransition(new Slide(slideEdge));
        fragment.setExitTransition(new Slide(slideEdge));
        fragment.setReturnTransition(new Slide(slideEdge));
        fragment.setSharedElementReturnTransition(new ChangeBounds());
        return fragment;
    }
}
