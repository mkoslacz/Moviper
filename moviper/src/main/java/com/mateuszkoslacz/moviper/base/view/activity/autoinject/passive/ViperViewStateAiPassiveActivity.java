package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperViewStateAiActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by bwilk on 12/22/16.
 */

public abstract class ViperViewStateAiPassiveActivity
        <ViewType extends MvpView,
                ViewStateType extends ViewState<ViewType>>
        extends ViperViewStateAiActivity<ViewType, ViperPresenter<ViewType>, ViewStateType>
        implements MvpView, ActivityHolder {

    /**
     * <b>DO NOT</b> use this method because of a fact that this view should be completely passive
     * (independent from the presenter type)! <br/>
     * Instead you should use getters to provide
     * event sources that will notify presenter after presenter's registration to them. To use
     * getPresenter() method you shall use non-passive Moviper view.
     *
     * @return raw {@link ViperPresenter}, so you can't call any custom methods on it anyway
     */
    @NonNull
    @Override
    @Deprecated
    public ViperPresenter<ViewType> getPresenter() {
        return super.getPresenter();
    }
}
