package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.butterknife;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifePassiveActivity
        <ViewType extends MvpView>
        extends ViperAiPassiveActivity<ViewType>
        implements MvpView, ActivityHolder {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
