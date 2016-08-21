package com.mateuszkoslacz.moviper.sample.util;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.mateuszkoslacz.moviper.sample.data.bundle.LocationPoint;

/**
 * Created by mateuszkoslacz on 14.08.2016.
 */
public class LocationUtilsImpl
        implements
        LocationUtils,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {

    private Activity mActivity;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequestsCallback mCallback;

    public LocationUtilsImpl(Activity mActivity, LocationRequestsCallback mCallback) {
        this.mActivity = mActivity;
        this.mCallback = mCallback;
    }

    @Override
    public void subscribeToGetLocalization() {
        // TODO migrate to rx approach
        if (isActivityAttached()) {
            if (mGoogleApiClient == null) {
                mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                        .addConnectionCallbacks(this)
                        .addOnConnectionFailedListener(this)
                        .addApi(LocationServices.API)
                        .build();
            }
            mGoogleApiClient.connect();
        }
        // will call onConnected, onConnectionSuspended, or onConnectionFailed
    }

    @Override
    public void onRequestLocalizationPermissionsResult(boolean granted) {
        if (isCallbackAttached()) {
            if (granted) getCallback().onLocalizationAquired(getLastLocation());
            else getCallback().onLocalizationAquireFailed("We need the localization permission!");
        }
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        if (weHavePermissionToLocationAcces()) {
            if (isCallbackAttached()) getCallback().onLocalizationAquired(getLastLocation());
//            mGoogleApiClient.disconnect(); // TODO: 15.08.2016 should we uncomment this?
        } else {
            if (weShouldShowWhyWeNeedUserLocation()) {
                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            }
            // else // wrap it onto else block if you are showing the explanation
            requestLocationPermission();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        //whatever
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        if (isCallbackAttached())
            getCallback().onLocalizationAquireFailed(
                    StringUtils.isNullOrEmpty(connectionResult.getErrorMessage()) ?
                            String.format("Google Play Services Error: %d. Make sure that you have " +
                                            "Google Play Services installed and up-to-date.",
                                    connectionResult.getErrorCode()) :
                            connectionResult.getErrorMessage());
    }

    private boolean weHavePermissionToLocationAcces() {
        return ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestLocationPermission() {
        //TODO for now we use activity to handle permission, in future use maybe
        // https://github.com/bignerdranch/permission-manager to move the logic to routing
        ActivityCompat.requestPermissions(getActivity(),
                new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_REQUEST_ACCES_FINE_LOCATION);
    }

    private boolean weShouldShowWhyWeNeedUserLocation() {
        return ActivityCompat.shouldShowRequestPermissionRationale(
                getActivity(), Manifest.permission.ACCESS_FINE_LOCATION);
    }

    @NonNull
    private LocationPoint getLastLocation() {
        //noinspection MissingPermission to be checked in upper level
        Location lastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
        LocationPoint location;
        if (lastLocation != null) {
            location = new LocationPoint(lastLocation.getLatitude(), lastLocation.getLongitude());
        } else {
            location = new LocationPoint();
        }
        return location;
    }

    public LocationRequestsCallback getCallback() {
        return mCallback;
    }

    private boolean isCallbackAttached() {
        return mCallback != null;
    }

    private Activity getActivity() {
        return mActivity;
    }

    private boolean isActivityAttached() {
        return mActivity != null;
    }

}
