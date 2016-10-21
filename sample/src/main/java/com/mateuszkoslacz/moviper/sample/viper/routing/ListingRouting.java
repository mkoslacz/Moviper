package com.mateuszkoslacz.moviper.sample.viper.routing;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRouting;
import com.mateuszkoslacz.moviper.sample.model.User;
import com.mateuszkoslacz.moviper.sample.viewadapter.UserAdapter;
import com.mateuszkoslacz.moviper.sample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.sample.viper.view.activity.UserDetailsActivity;

public class ListingRouting
        extends ActivityBaseRouting<
        ListingContract.PresenterForRouting>
        implements ListingContract.Routing {

    public final static String USER_EXTRA = "USER_EXTRA";

    public ListingRouting(@NonNull Activity activity) {
        super(activity);
    }

    @Override
    public void startUserDetailsActivity(User userList, UserAdapter.UserViewHolder userViewHolder) {
        Intent intent = new Intent(getActivity(), UserDetailsActivity.class);
        intent.putExtra(USER_EXTRA, userList);

        if (isActivityAttached())
            getActivity().startActivity(intent);
    }
}
