package com.mateuszkoslacz.moviper.sample.util;

import com.mateuszkoslacz.moviper.sample.data.bundle.LocationPoint;

/**
 * Created by mateuszkoslacz on 14.08.2016.
 */
public interface LocationUtils {

    int PERMISSION_REQUEST_ACCES_FINE_LOCATION = 123;

    void subscribeToGetLocalization();

    // stuff caused by Android need of registering permission result listener being
    // a fragment or activity
    void onRequestLocalizationPermissionsResult(boolean granted);

    interface LocationRequestsCallback {

        void onLocalizationAquired(LocationPoint location);

        void onLocalizationAquireFailed(String message);
    }
}
