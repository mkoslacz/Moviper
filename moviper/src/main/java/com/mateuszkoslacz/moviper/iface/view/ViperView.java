package com.mateuszkoslacz.moviper.iface.view;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by tomasznajda on 13.12.2016.
 */

public interface ViperView extends MvpView {

    @NonNull
    Activity getActivity();
}
