package com.mateuszkoslacz.moviper.base.view.fragment.autoinject;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.fragment.mvp.MvpViewStateAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperViewStateAiFragment
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>,
                ViewStateType extends ViewState<ViewType>>
        extends MvpViewStateAiFragment<ViewType, Presenter>
        implements MvpView, ActivityHolder {

    @Override
    public ViewStateType getViewState() {
        return (ViewStateType) super.getViewState();
    }

    @Override
    public Bundle getArgs() {
        return getArguments();
    }
}
