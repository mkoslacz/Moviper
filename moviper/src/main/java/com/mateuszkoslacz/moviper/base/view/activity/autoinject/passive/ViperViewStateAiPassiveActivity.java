package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.exception.PresenterAccessFromPassiveView;
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
     * <b>DO NOT</b> use this method because of a fact that this view should be completely passive
     * (independent from the presenter type)! <br/>
     * Every call to this method will result in throwing
     * {@link PresenterAccessFromPassiveView} exception. Instead you should use getters to provide
     * event sources that will notify presenter after presenter's registration to them. To use
     * getPresenter() method you shall use non-passive Moviper view.
     *
     * @return Nothing. It always throws {@link PresenterAccessFromPassiveView} exception.
     */
    @NonNull
    @Override
    @Deprecated
    public ViperPresenter<ViewType> getPresenter() {
        throw new PresenterAccessFromPassiveView(this);
    }
}
