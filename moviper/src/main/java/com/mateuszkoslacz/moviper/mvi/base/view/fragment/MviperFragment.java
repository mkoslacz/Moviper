package com.mateuszkoslacz.moviper.mvi.base.view.fragment;

import android.os.Bundle;

import com.hannesdorfmann.mosby3.mvi.MviFragment;
import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperFragment
        <ViewType extends MvpView,
                Presenter extends MviPresenter<ViewType, ?>>
        extends MviFragment<ViewType, Presenter>
        implements ViperView {

    @Override
    public Bundle getArgs() {
        return getArguments();
    }
}
