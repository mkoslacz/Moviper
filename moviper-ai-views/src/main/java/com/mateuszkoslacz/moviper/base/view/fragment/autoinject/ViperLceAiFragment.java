package com.mateuszkoslacz.moviper.base.view.fragment.autoinject;

import android.os.Bundle;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.fragment.mvp.MvpLceAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperLceAiFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpLceAiFragment<ContentView, Model, ViewType, Presenter>
        implements MvpLceView<Model>, ViperView {

    @Override
    public Bundle getArgs() {
        return getArguments();
    }

}
