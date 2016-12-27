package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.content.Intent;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.UserDetailsPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.server.ActivityStarter;
import com.mateuszkoslacz.moviper.rxsample.viper.server.MoviperPresentersDispatcher;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends BaseRxRouting
        implements ListingContract.Routing {

    @Override
    public void startUserDetailsActivity(User user) {
        if (isActivityAttached()) {
            Intent startingIntent = UserDetailsActivity.getStartingIntent(getActivity(), user);
            MoviperPresentersDispatcher.getInstance().startActivity(
                    ActivityStarter.newBuilder()
                            .withContext(getActivity())
                            .withIntent(startingIntent)
                            .withPresenter(new UserDetailsPresenter(startingIntent.getExtras()))
                            .build());
        }
    }
}
