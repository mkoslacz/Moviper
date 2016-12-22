package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive;

import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperLceAiActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by bwilk on 12/22/16.
 */

public abstract class ViperLceAiPassiveActivity
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>>
        extends ViperLceAiActivity<ContentView, Model, ViewType, ViperPresenter<ViewType>>
        implements ViperLceView<Model> {

    /**
     * This method should not be used because of fact that this view should be
     * completely passive (independent from presenter type).
     */
    @NonNull
    @Override
    @Deprecated
    public ViperPresenter<ViewType> getPresenter() {
        return super.getPresenter();
    }
}
