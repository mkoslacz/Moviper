package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.ViperAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeFragment
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends ViperAiFragment<ViewType, Presenter>
        implements MvpView, ActivityHolder {

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        ButterKnife.bind(this, view);
    }
}
