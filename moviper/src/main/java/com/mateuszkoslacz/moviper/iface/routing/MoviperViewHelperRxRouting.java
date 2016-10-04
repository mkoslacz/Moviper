package com.mateuszkoslacz.moviper.iface.routing;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p>
 * It's a Routing ({@link MoviperRouting}) that also provides a ViewHelper
 * (see {@link MoviperViewHelper}), which is responsible for providing
 * Android Views (ImageView, TextView etc.) to allow performing Android Transitions with shared Views.
 * <p>
 */
public interface MoviperViewHelperRxRouting
        <ViewHelperType extends MoviperViewHelper>  // I prefer readability rather than conventions
        extends MoviperRxRouting {

    /**
     * Remember to call {@link #isViewHelperAttached()} before getting the ViewHelper to avoid
     * {@link NullPointerException}s.
     *
     * @return attached {@link MoviperViewHelper} or null if it's detached (View got destroyed)
     */
    @Nullable
    ViewHelperType getViewHelper();

    boolean isViewHelperAttached();
}
