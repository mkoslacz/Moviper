package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.viewadapter.UserAdapter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends ActivityBaseRxRouting
        implements ListingContract.Routing {

    public final static String USER_EXTRA = "USER_EXTRA";

    public ListingRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startUserDetailsActivity(User user, UserAdapter.UserViewHolder userViewHolder) {
        Intent intent = new Intent(getActivity(), UserDetailsActivity.class);
        intent.putExtra(USER_EXTRA, user);

        if (isActivityAttached()) {
            getActivity().startActivity(intent);
        }
    }
}