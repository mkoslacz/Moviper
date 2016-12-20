package com.mateuszkoslacz.moviper.base.view.fragment;

import com.hannesdorfmann.mosby.mvp.MvpFragment;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

/**
 * Created by tomasznajda on 14.12.2016.
 */

public abstract class ViperFragment
        <ViewType extends ViperView,
                Presenter extends MvpPresenter<ViewType>>
        extends MvpFragment<ViewType, Presenter>
        implements ViperView {

}
