package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperLceViewStateAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLceViewStateActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                ViewStateType extends ViewState<ViewType>>
        extends ViperLceViewStateAiPassiveActivity<ContentView, Model, ViewType, ViewStateType>
        implements ViperLceView<Model> {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
