package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.ViperLceAiPassiveFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLcePassiveFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>>
        extends ViperLceAiPassiveFragment<ContentView, Model, ViewType>
        implements ViperLceView<Model> {

    private Unbinder unbinder;

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
