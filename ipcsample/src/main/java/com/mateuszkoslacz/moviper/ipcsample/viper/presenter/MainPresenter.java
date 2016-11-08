package com.mateuszkoslacz.moviper.ipcsample.viper.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.interactor.MainInteractor;
import com.mateuszkoslacz.moviper.ipcsample.viper.routing.MainRouting;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ViperFragment;

import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.COLOR_BLUE;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.COLOR_GREEN;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.COLOR_NAME_BLUE;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.COLOR_NAME_GREEN;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.COLOR_NAME_RED;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.COLOR_RED;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.FRAGMENT_NAME_FIRST;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.FRAGMENT_NAME_SECOND;
import static com.mateuszkoslacz.moviper.ipcsample.util.Constants.FRAGMENT_NAME_THIRD;

public class MainPresenter
        extends ViperActivityBaseRxPresenter
        <MainContract.View,
                MainContract.Interactor,
                MainContract.Routing>
        implements
        MainContract.Presenter {

    public MainPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            createAndConfigureFirstFragment();
            createAndConfigureSecondFragment();
            createAndConfigureThirdFragment();
        }
    }

    private void createAndConfigureFirstFragment() {
        ViperFragment viperFragment = new ViperFragment();
        viperFragment.setArguments(prepareBundleToViperFragment(FRAGMENT_NAME_FIRST,
                COLOR_NAME_BLUE, COLOR_BLUE));
        getRouting().bindFragmentToView(getView().getViewIdFragmentFirst(), viperFragment);
    }

    private void createAndConfigureSecondFragment() {
        ViperFragment viperFragment = new ViperFragment();
        viperFragment.setArguments(prepareBundleToViperFragment(FRAGMENT_NAME_SECOND,
                COLOR_NAME_GREEN, COLOR_GREEN));
        getRouting().bindFragmentToView(getView().getViewIdFragmentSecond(), viperFragment);
    }

    private void createAndConfigureThirdFragment() {
        ViperFragment viperFragment = new ViperFragment();
        viperFragment.setArguments(prepareBundleToViperFragment(FRAGMENT_NAME_THIRD,
                COLOR_NAME_RED, COLOR_RED));
        getRouting().bindFragmentToView(getView().getViewIdFragmentThird(), viperFragment);
    }

    private Bundle prepareBundleToViperFragment(String fragmentName, String colorName, String color) {
        Bundle bundle = new Bundle();
        bundle.putString(ViperPresenter.FRAGMENT_PRESENTER_NAME, fragmentName);
        bundle.putString(ViperPresenter.FRAGMENT_COLOR_NAME, colorName);
        bundle.putString(ViperPresenter.FRAGMENT_BACKGROUND_COLOR, color);
        return bundle;
    }

    @NonNull
    @Override
    public MainContract.Routing createRouting(@NonNull Activity activity) {
        return new MainRouting(activity);
    }

    @NonNull
    @Override
    public MainContract.Interactor createInteractor() {
        return new MainInteractor();
    }
}
