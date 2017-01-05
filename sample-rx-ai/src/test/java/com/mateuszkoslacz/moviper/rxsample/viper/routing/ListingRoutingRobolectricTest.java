package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.content.Intent;

import com.mateuszkoslacz.moviper.rxsample.BuildConfig;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity.USER_EXTRA;
import static org.junit.Assert.assertTrue;
import static org.robolectric.Robolectric.setupActivity;

/**
 * Created by mateuszkoslacz on 21.11.2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ListingRoutingRobolectricTest {

    protected ListingRouting mRouting;
    private ListingActivity mListingActivity;

    @Before
    public void setUp() {
        mListingActivity = setupActivity(ListingActivity.class);
        mRouting = new ListingRouting();
        mRouting.attach(mListingActivity);
    }

    @Test
    public void startUserDetailsActivityIntentTest() throws Exception {
        User user = new User();
        user.setLogin("testUser");
        mRouting.startUserDetailsActivity(user);
        Intent starter = new Intent(mListingActivity, UserDetailsActivity.class);
        starter.putExtra(USER_EXTRA, user.getLogin());
        assertTrue(Shadows.shadowOf(mListingActivity).getNextStartedActivity().filterEquals(starter));
    }
}