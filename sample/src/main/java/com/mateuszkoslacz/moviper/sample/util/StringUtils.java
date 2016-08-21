package com.mateuszkoslacz.moviper.sample.util;

/**
 * Created by mateuszkoslacz on 12.08.2016.
 * <p>
 * Created instead of Android TextUtils class to have presentation-layer Java-only
 */
public class StringUtils {

    public static boolean isNullOrEmpty(String string) {
        return string == null || string.trim().isEmpty();
    }
}
