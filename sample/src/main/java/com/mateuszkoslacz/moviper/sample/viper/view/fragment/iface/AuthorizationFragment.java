package com.mateuszkoslacz.moviper.sample.viper.view.fragment.iface;

import android.view.View;

/**
 * Created by mateuszkoslacz on 31.07.2016.
 * <p>
 * Interface for getting views from Fragments for their base Activity's ViewHelper to allow the
 * Routing perform transitions between fragments.
 */
public interface AuthorizationFragment {

    View getSharedLoginEditText();

    View getSharedPasswordEditText();
}
