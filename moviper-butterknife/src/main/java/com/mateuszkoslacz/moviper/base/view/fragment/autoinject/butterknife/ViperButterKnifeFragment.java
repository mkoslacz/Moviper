package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.ViperAiFragment;
import com.mateuszkoslacz.moviper.iface.view.ContextHolder;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeFragment
        <ViewType extends MvpView,
                Presenter extends MvpPresenter<ViewType>>
        extends ViperAiFragment<ViewType, Presenter>
        implements ViperView {

    private Unbinder unbinder;

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        unbinder = ButterKnife.bind(this, view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
