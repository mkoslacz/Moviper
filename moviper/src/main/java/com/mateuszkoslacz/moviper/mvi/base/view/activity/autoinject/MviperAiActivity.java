package com.mateuszkoslacz.moviper.mvi.base.view.activity.autoinject;

import android.os.Bundle;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.mvi.base.view.activity.MviperActivity;

/**
 * Created by mateuszkoslacz on 15.02.2017.
 */

public abstract class MviperAiActivity
        <ViewType extends MvpView,
                PresenterType extends MviPresenter<ViewType, ?>>
        extends MviperActivity<ViewType, PresenterType> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        injectViews();
    }

    abstract protected int getLayoutId();

    abstract protected void injectViews();
}
