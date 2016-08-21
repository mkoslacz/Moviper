package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.SplashContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.SplashPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 25.07.2016.
 */
public class SplashActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<SplashContract.View, SplashContract.Presenter>
        implements SplashContract.View, SplashContract.ViewHelper {

    @BindView(R.id.logo)
    View logo;


    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // initializer
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        getPresenter().onViewLoaded();
    }


    // I DO NOT encourage block comments in non-sample code! Organize your code
    // in the self-explaining way and block comments will become redundant.
    ///////////////////////////////////////////////////////////////////////////
    // creating presenter
    ///////////////////////////////////////////////////////////////////////////

    @NonNull
    @Override
    public SplashContract.Presenter createPresenter() {
        return new SplashPresenter(this);
    }


    ///////////////////////////////////////////////////////////////////////////
    // ViewHelper interface method
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public View getLogo() {
        return logo;
    }
}
