package com.mateuszkoslacz.moviper.mvi.base.view.fragment.autoinject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.mvi.base.view.fragment.MviperFragment;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperAiFragment
        <ViewType extends MvpView,
                PresenterType extends MviPresenter<ViewType, ?>>
        extends MviperFragment<ViewType, PresenterType> {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(getLayoutId(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        injectViews(view);
    }

    abstract protected int getLayoutId();

    abstract protected void injectViews(View view);
}
