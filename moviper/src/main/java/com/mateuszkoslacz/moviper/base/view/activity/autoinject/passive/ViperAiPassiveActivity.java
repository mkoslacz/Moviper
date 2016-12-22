package com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.ViperAiActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by bwilk on 12/22/16.
 */

public abstract class ViperAiPassiveActivity<V extends MvpView>
        extends ViperAiActivity<V, ViperPresenter<V>>
        implements ViperView {

    /**
     * This method should not be used because of fact that this view should be
     * completely passive (independent from presenter type).
     */
    @NonNull
    @Override
    @Deprecated
    public ViperPresenter<V> getPresenter() {
        return super.getPresenter();
    }
}
