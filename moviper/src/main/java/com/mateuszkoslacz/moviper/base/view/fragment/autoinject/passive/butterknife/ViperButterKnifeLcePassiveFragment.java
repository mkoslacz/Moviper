package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.ViperLceAiPassiveFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

import butterknife.ButterKnife;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperButterKnifeLcePassiveFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>>
        extends ViperLceAiPassiveFragment<ContentView, Model, ViewType>
        implements ViperLceView<Model> {

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        ButterKnife.bind(this, view);
    }
}
