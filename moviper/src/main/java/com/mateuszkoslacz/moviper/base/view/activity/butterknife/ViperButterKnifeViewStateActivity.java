package com.mateuszkoslacz.moviper.base.view.activity.butterknife;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperViewStateAiActivity;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperButterKnifeViewStateActivity
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends ViperViewStateAiActivity<ViewType, Presenter, ViewStateType>
        implements ViperView {

    @Override
    protected void injectViews() {
        super.injectViews();
        ButterKnife.bind(this);
    }
}
