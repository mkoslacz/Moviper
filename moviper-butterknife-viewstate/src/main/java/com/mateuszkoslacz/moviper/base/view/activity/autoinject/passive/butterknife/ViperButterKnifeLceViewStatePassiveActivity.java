package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperLceViewStateAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLceViewStatePassiveActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                ViewStateType extends LceViewState<Model, ViewType>>
        extends ViperLceViewStateAiPassiveActivity<ContentView, Model, ViewType, ViewStateType>
        implements ViperLceView<Model> {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
