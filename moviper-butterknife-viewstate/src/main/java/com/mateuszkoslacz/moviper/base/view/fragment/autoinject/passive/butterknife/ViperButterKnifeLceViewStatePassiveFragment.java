package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.lce.MvpLceView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.hannesdorfmann.mosby3.mvp.viewstate.lce.LceViewState;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.ViperLceViewStateAiPassiveFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLceViewStatePassiveFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                ViewStateType extends LceViewState<Model, ViewType>>
        extends ViperLceViewStateAiPassiveFragment<ContentView, Model, ViewType, ViewStateType>
        implements ViperLceView<Model> {

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        ButterKnife.bind(this, view);
    }
}
