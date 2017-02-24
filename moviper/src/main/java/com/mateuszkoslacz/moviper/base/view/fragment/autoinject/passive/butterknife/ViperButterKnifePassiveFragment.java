package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.ViperAiPassiveFragment;
import com.mateuszkoslacz.moviper.iface.view.ActivityHolder;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifePassiveFragment
        <ViewType extends MvpView>
        extends ViperAiPassiveFragment<ViewType>
        implements MvpView, ActivityHolder {

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        ButterKnife.bind(this, view);
    }
}
