package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperViewStateAiActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by bwilk on 12/22/16.
 */

public abstract class ViperViewStateAiPassiveActivity
    <ViewType extends MvpView,
            ViewStateType extends ViewState<ViewType>>
    extends ViperViewStateAiActivity<ViewType, ViperPresenter<ViewType>, ViewStateType>
    implements ViperView {


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
