package com.mateuszkoslacz.moviper.sample.viper.routing;

import com.mateuszkoslacz.moviper.base.routing.BaseRouting;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;
import com.mateuszkoslacz.moviper.sample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends BaseRouting<ListingContract.PresenterForRouting>
        implements ListingContract.Routing {

    @Override
    public void startUserDetailsActivity(User user) {
        if (isActivityAttached()) UserDetailsActivity.start(getActivity(), user);
    }
}
