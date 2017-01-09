package com.mateuszkoslacz.moviper.iface.routing;

import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper;

/**
 * Created by mateuszkoslacz on 08.08.2016.
 * <p/>
 * It's a Routing ({@link ViperRouting}) that also provides a ViewHelper (see {@link
 * ViperViewHelper}), which is responsible for providing Android Views (ImageView, TextView etc.) to
 * allow performing Android Transitions with shared Views.
 */
public interface ViperViewHelperRxRouting<ViewHelperType extends ViperViewHelper>
        extends ViperRxRouting {

    /**
     * Remember to call {@link #isViewHelperAttached()} before getting the ViewHelper to avoid
     * {@link NullPointerException}s.
     *
     * @return attached {@link ViperViewHelper} or null if it's detached (View got destroyed)
     */
    @Nullable
    ViewHelperType getViewHelper();

    /**
     * Checks if a ViewHelper is attached to this routing.
     */
    boolean isViewHelperAttached();
}
