package com.mateuszkoslacz.moviper.base.view.activity.autoinject.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperLceAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLceActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>>
        extends ViperLceAiActivity<ContentView, Model, ViewType, Presenter>
        implements ViperLceView<Model> {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
