package com.mateuszkoslacz.moviper.base.view.activity;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpActivity<ViewType, Presenter>
        implements ViperView {

    @NonNull
    @Override
    public Activity getActivity() {
        return this;
    }

}
