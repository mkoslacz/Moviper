package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive;

import android.support.annotation.NonNull;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.base.exception.PresenterAccessFromPassiveView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.ViperLceAiFragment;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperLceAiPassiveFragment
        <ContentView extends View,
                Model,
                ViewType extends MvpLceView<Model>>
        extends ViperLceAiFragment<ContentView, Model, ViewType, ViperPresenter<ViewType>>
        implements ViperLceView<Model> {

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
