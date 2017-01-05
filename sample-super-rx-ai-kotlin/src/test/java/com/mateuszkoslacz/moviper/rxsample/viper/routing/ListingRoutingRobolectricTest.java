package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.content.Intent;

import com.mateuszkoslacz.moviper.rxsample.BuildConfig;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.UserDetailsPresenter;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;
import com.mateuszkoslacz.moviper.server.ActivityStarter;
import com.mateuszkoslacz.moviper.server.MoviperPresentersDispatcher;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertTrue;
import static org.robolectric.Robolectric.setupActivity;

/**
 * Created by mateuszkoslacz on 21.11.2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
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
        MoviperPresentersDispatcher.setInstance(null);
        User user = new User();
        user.setLogin("testUser");
        mRouting.startUserDetailsActivity(user);
        Intent starter = new Intent(mListingActivity, UserDetailsActivity.class);
        starter.putExtra(UserDetailsActivity.Companion.getUSER_EXTRA(), user.getLogin());
        assertTrue(Shadows.shadowOf(mListingActivity).getNextStartedActivity().filterEquals(starter));
    }

    @Test
    public void startUserDetailsActivityUnitTest() throws Exception {
        MoviperPresentersDispatcher mPresentersDispatcher = Mockito.mock(MoviperPresentersDispatcher.class);
        MoviperPresentersDispatcher.setInstance(mPresentersDispatcher);

        User user = new User();
        user.setLogin("testUser");

        mRouting.startUserDetailsActivity(user);

        Intent starter = new Intent(mListingActivity, UserDetailsActivity.class);
        starter.putExtra(UserDetailsActivity.Companion.getUSER_EXTRA(), user.getLogin());

        ActivityStarter activityStarter = ActivityStarter.newBuilder()
                .withIntent(starter)
                .withContext(mListingActivity)
                .withPresenter(new UserDetailsPresenter(starter.getExtras()))
                .build();

        Mockito.verify(mPresentersDispatcher).startActivity(activityStarter);
    }
}