package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.ViperAiPassiveFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifePassiveFragment
        <ViewType extends MvpView>
        extends ViperAiPassiveFragment<ViewType>
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
