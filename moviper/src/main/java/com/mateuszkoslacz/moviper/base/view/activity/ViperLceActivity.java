package com.mateuszkoslacz.moviper.base.view.activity;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperLceActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpLceActivity<ContentView, Model, ViewType, Presenter>
        implements ViperLceView<Model> {

    @NonNull
    @Override
    public Activity getActivity() {
        return this;
    }
}
