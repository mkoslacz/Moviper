package com.mateuszkoslacz.moviper.base.routing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRouting;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Fragment version of base Routing class.
 * (see {@link MoviperRouting} and {@link MoviperPresenterForRouting})
 */
public abstract class FragmentBaseRouting
        <PresenterType extends MoviperPresenterForRouting>  // I prefer readability rather than conventions
        extends ActivityBaseRouting<PresenterType>
        implements MoviperRouting<PresenterType> {

    public FragmentBaseRouting(@NonNull Fragment fragment) {
        super(fragment.getActivity());
    }
}
