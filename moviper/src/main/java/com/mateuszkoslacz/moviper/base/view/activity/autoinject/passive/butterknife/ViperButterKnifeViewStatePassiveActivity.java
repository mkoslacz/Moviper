package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.butterknife;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.ViperViewStateAiPassiveActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeViewStatePassiveActivity
        <ViewType extends MvpView,
                ViewStateType extends ViewState<ViewType>>
        extends ViperViewStateAiPassiveActivity<ViewType, ViewStateType>
        implements ViperView {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
