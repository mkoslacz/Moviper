package com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.butterknife;

import android.view.View;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.viewstate.ViewState;
import com.mateuszkoslacz.moviper.base.view.fragment.autoinject.passive.ViperViewStateAiPassiveFragment;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import butterknife.ButterKnife;

/**
 * Created by mateuszkoslacz on 14.12.2016.
 */

public abstract class ViperButterKnifeViewStatePassiveFragment
        <ViewType extends MvpView,
                ViewStateType extends ViewState<ViewType>>
        extends ViperViewStateAiPassiveFragment<ViewType, ViewStateType>
        implements ViperView {

    @Override
    protected void injectViews(View view) {
        super.injectViews(view);
        ButterKnife.bind(this, view);
    }
}
