package com.mateuszkoslacz.moviper.base.view.fragment.autoinject;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.fragment.mvp.MvpAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperAiFragment
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpAiFragment<ViewType, Presenter>
        implements ViperView {

    @NonNull
    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    public Bundle getArgs() {
        return getArguments();
    }

}
