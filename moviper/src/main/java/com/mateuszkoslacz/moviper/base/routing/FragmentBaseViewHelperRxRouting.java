package com.mateuszkoslacz.moviper.base.routing;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * Fragment version of base Routing class with ViewHelper. (see {@link MoviperViewHelperRouting},
 * {@link MoviperViewHelper} and {@link MoviperPresenterForRouting})
 */
public abstract class FragmentBaseViewHelperRxRouting
        <ViewHelperType extends MoviperViewHelper>   // I prefer readability rather than conventions
        extends ActivityBaseViewHelperRxRouting<ViewHelperType>
        implements MoviperViewHelperRxRouting<ViewHelperType> {

    @NonNull
    private WeakReference<Fragment> fragment;

    public FragmentBaseViewHelperRxRouting(@NonNull Fragment fragment) {
        super(fragment.getActivity());
        this.fragment = new WeakReference<>(fragment);
    }

    @Override
    public boolean isViewHelperAttached() {
        return WeakReferenceUtils.isAttached(fragment);
    }

    @Nullable
    @Override
    public ViewHelperType getViewHelper() {
        //noinspection unchecked
        return ((ViewHelperType) WeakReferenceUtils.get(fragment));
    }
}
