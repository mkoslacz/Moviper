package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.BaseRouting;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;
import com.mateuszkoslacz.moviper.sample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends BaseRouting<ListingContract.PresenterForRouting>
        implements ListingContract.Routing {

    public ListingRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startUserDetailsActivity(User user) {
        if (isActivityAttached()) UserDetailsActivity.start(getActivity(), user);
    }
}
