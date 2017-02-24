package com.mateuszkoslacz.moviper.base.view.fragment.autoinject;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.fragment.mvp.MvpAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperAiFragment
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpAiFragment<ViewType, Presenter>
        implements MvpView, ActivityHolder {

    @Override
    public Bundle getArgs() {
        return getArguments();
    }

}
