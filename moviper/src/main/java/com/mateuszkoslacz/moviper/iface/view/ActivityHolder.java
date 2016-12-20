package com.mateuszkoslacz.moviper.iface.view;

import android.app.Activity;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 15.12.2016.
 * </p>
 * Interface used in pair with {@link MvpView}. It's used for providing Activity to the routing.
 */

public interface ActivityHolder {

    Activity getActivity();
}
