package com.mateuszkoslacz.moviper.base.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperLceAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLcePassiveActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>>
        extends ViperLceAiPassiveActivity<ContentView, Model, ViewType>
        implements ViperLceView<Model> {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
