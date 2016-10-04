package com.mateuszkoslacz.moviper.base.routing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Fragment version of base Routing class.
 * (see {@link MoviperRouting} and {@link MoviperPresenterForRouting})
 */
public abstract class FragmentBaseRxRouting
        extends ActivityBaseRxRouting
        implements MoviperRxRouting {

    public FragmentBaseRxRouting(@NonNull Fragment fragment) {
        super(fragment.getActivity());
    }
}
