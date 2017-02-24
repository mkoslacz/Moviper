package com.mateuszkoslacz.moviper.base.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperFragment
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpFragment<ViewType, Presenter>
        implements MvpView, ActivityHolder {

    @NonNull
    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public Bundle getArgs() {
        return getArguments();
    }

}
