package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;
import android.content.Intent;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.UserDetailsPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;
import com.mateuszkoslacz.moviper.presentersdispatcher.ActivityStarter;
import com.mateuszkoslacz.moviper.presentersdispatcher.MoviperPresentersDispatcher;

public class ListingRouting
        extends BaseRxRouting<Activity>
        implements ListingContract.Routing {

    @Override
    public void startUserDetailsActivity(User user) {
        if (isContextAttached()) {
            Intent startingIntent = UserDetailsActivity.getStartingIntent(getRelatedContext(), user);
            MoviperPresentersDispatcher.getInstance().startActivity(
                    ActivityStarter.newBuilder()
                            .withContext(getRelatedContext())
                            .withIntent(startingIntent)
                            .withPresenter(new UserDetailsPresenter(startingIntent.getExtras()))
                            .build());
        }
    }
}
