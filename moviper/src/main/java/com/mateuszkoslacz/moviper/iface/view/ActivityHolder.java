package com.mateuszkoslacz.moviper.iface.view;

import android.app.Activity;
import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 15.12.2016.
 * <p/>
 * It's used for providing Activity to the routing. Used in pair with {@link MvpView} in Moviper
 * views.
 */

public interface ActivityHolder {

    Activity getActivity();

    Bundle getArgs();
}
