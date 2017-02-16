package com.mateuszkoslacz.moviper.mvi.base.view.fragment.autoinject.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.mvi.base.view.fragment.autoinject.MviperAiFragment;

import butterknife.ButterKnife;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperButterKnifeFragment
        <ViewType extends MvpView,
                PresenterType extends MviPresenter<ViewType, ?>>
        extends MviperAiFragment<ViewType, PresenterType> {

    @Override
    protected void injectViews(View view) {
        ButterKnife.bind(this, view);
    }
}
