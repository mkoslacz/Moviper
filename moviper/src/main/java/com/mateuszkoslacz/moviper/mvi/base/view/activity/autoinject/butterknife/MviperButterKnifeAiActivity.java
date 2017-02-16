package com.mateuszkoslacz.moviper.mvi.base.view.activity.autoinject.butterknife;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.mvi.base.view.activity.autoinject.MviperAiActivity;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 16.02.2017.
 */

public abstract class MviperButterKnifeAiActivity
        <ViewType extends MvpView,
                PresenterType extends MviPresenter<ViewType, ?>>
        extends MviperAiActivity<ViewType, PresenterType> {

    @Override
    protected void injectViews() {
        ButterKnife.bind(this);
    }
}
