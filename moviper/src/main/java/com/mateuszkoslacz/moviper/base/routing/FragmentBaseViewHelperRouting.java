package com.mateuszkoslacz.moviper.base.routing;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperPresenterForRouting;
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
public abstract class FragmentBaseViewHelperRouting
        <PresenterType extends MoviperPresenterForRouting,  // I prefer readability rather than conventions
                ViewHelperType extends MoviperViewHelper>
        extends ActivityBaseViewHelperRouting<PresenterType, ViewHelperType>
        implements MoviperViewHelperRouting<PresenterType, ViewHelperType> {

    @Nullable
    private WeakReference<Fragment> fragment;

    public FragmentBaseViewHelperRouting(@NonNull Fragment fragment) {
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

    @Override
    public void detachPresenter() {
        super.detachPresenter();
        WeakReferenceUtils.detach(fragment);
    }
}
