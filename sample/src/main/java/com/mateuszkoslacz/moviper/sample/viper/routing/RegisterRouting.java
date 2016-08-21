package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.mateuszkoslacz.moviper.base.routing.FragmentBaseViewHelperRouting;
import com.mateuszkoslacz.moviper.sample.data.bundle.LocationPoint;
import com.mateuszkoslacz.moviper.sample.util.LocationUtils;
import com.mateuszkoslacz.moviper.sample.util.LocationUtilsImpl;
import com.mateuszkoslacz.moviper.sample.util.UiUtils;
import com.mateuszkoslacz.moviper.sample.viper.contract.AuthorizationContract;
import com.mateuszkoslacz.moviper.sample.viper.contract.RegisterContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.MainActivity;


/**
 * Created by mateuszkoslacz on 09.08.2016.
 */
// TODO change behaviour to allow user registering without getting a localization
public class RegisterRouting
        extends FragmentBaseViewHelperRouting<
        RegisterContract.PresenterForRouting,
        RegisterContract.ViewHelper>
        implements
        RegisterContract.Routing,
        LocationUtils.LocationRequestsCallback {

    private LocationUtils mLocationUtils;

    public RegisterRouting(@NonNull Fragment fragment) {
        super(fragment);
    }

    @Override
    public void gotoLoginFragment() {
        if (isActivityAttached())
            ((AuthorizationContract.View) getActivity()).showLoginFragment();
    }

    @Override
    public void goToMainActivity() {
        if (isActivityAttached())
            getActivity().runOnUiThread(() -> MainActivity.start(getActivity()));
    }

    @Override
    public void subscribeToGetLocalization() {
        // TODO migrate to rx approach
        if (isActivityAttached()) {
            if (!isLocationUtilsAttached())
                mLocationUtils = new LocationUtilsImpl(getActivity(), this);
            mLocationUtils.subscribeToGetLocalization();
        }
    }

    @Override
    public void onRequestLocalizationPermissionsResult(boolean granted) {
        if (isLocationUtilsAttached())
            getLocationUtils().onRequestLocalizationPermissionsResult(granted);
    }

    @Override
    public void onLocalizationAquired(LocationPoint location) {
        if (isPresenterAttached()) getPresenter().onLocalizationAquired(location);
    }

    @Override
    public void onLocalizationAquireFailed(String message) {
        if (isPresenterAttached()) getPresenter().onLocalizationAquireFailed(message);
    }

    private LocationUtils getLocationUtils() {
        return mLocationUtils;
    }

    // it should be "are", but I decided to stick to convention
    private boolean isLocationUtilsAttached() {
        return mLocationUtils != null;
    }

    // TODO: 14.08.2016 will it be ok, ie if presenter could be detached and re-attached?
    @Override
    public void detachPresenter() {
        super.detachPresenter();
        mLocationUtils = null;
    }

    @Override
    public void hideSoftKeyboard() {
        if (isActivityAttached()) UiUtils.hideSoftKeyboard(getActivity());
    }
}
