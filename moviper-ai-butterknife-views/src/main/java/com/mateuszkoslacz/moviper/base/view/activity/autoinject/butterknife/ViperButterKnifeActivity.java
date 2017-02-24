package com.mateuszkoslacz.moviper.base.view.activity.autoinject.butterknife;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends ViperAiActivity<ViewType, Presenter>
        implements MvpView, ActivityHolder {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
