package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.ViperViewStateAiFragment;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperViewStateAiPassiveFragment
        <ViewType extends MvpView,
                ViewStateType extends ViewState<ViewType>>
        extends ViperViewStateAiFragment<ViewType, ViperPresenter<ViewType>, ViewStateType>
        implements ViperView {

    /**
     * <b>DO NOT</b> use this method because of a fact that this view should be completely passive
     * (independent from the presenter type)! <br>
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
