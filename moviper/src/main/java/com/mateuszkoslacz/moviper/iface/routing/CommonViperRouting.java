package com.mateuszkoslacz.moviper.iface.routing;

import android.app.Activity;
import android.support.annotation.Nullable;

/**
 * Created by tomaszajda on 16.12.2016.
 */

public interface CommonViperRouting {

    /**
     * Remember to call {@link #isActivityAttached()} before getting the Activity to avoid {@link
     * NullPointerException}s.
     *
     * @return attached Activity instance or null if it's detached (View got destroyed)
     */
    @Nullable
    Activity getActivity();

    boolean isActivityAttached();

    void detach(boolean retainInstance);
}
