package com.mateuszkoslacz.moviper.base.view.activity.autoinject.butterknife;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperButterKnifeActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends ViperAiActivity<ViewType, Presenter>
        implements ViperView {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
