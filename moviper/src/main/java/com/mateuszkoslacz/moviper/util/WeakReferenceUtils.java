package com.mateuszkoslacz.moviper.util;

import android.support.annotation.Nullable;

import java.lang.ref.WeakReference;

/**
 * Created by mateuszkoslacz on 21.08.2016.
 */
public class WeakReferenceUtils {

    @Nullable
    public static <T> T get(@Nullable WeakReference<T> weakReferenceToGetFrom) {
        return weakReferenceToGetFrom == null ? null : weakReferenceToGetFrom.get();
    }

    public static void detach(@Nullable WeakReference weakReferenceToClear) {
        if (weakReferenceToClear != null) {
            weakReferenceToClear.clear();
            weakReferenceToClear = null;
        }
    }

    public static boolean isAttached(@Nullable WeakReference weakReferenceToCheck) {
        return weakReferenceToCheck != null && weakReferenceToCheck.get() != null;
    }
}
