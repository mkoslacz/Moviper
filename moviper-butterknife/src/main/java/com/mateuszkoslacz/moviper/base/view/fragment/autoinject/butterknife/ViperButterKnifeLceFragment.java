package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.ViperLceAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeLceFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>>
        extends ViperLceAiFragment<ContentView, Model, ViewType, Presenter>
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
