package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;

import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.UserDetailsActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.never;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;

/**
 * Created by mateuszkoslacz on 21.11.2016.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserDetailsActivity.class)
public class ListingRoutingTest {

    @Mock
    protected Activity mActivity;

    protected ListingRouting mRouting;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void startUserDetailsActivity() throws Exception {
        mRouting = new ListingRouting(mActivity);
        mockStatic(UserDetailsActivity.class);
        User user = new User();
        mRouting.startUserDetailsActivity(user);
        verifyStatic();
        UserDetailsActivity.start(mActivity, user);
    }

    @Test
    public void startUserDetailsActivityWhenActivityDetached() throws Exception {
        mRouting = new ListingRouting(null);
        mockStatic(UserDetailsActivity.class);
        User user = new User();
        mRouting.startUserDetailsActivity(user);
        verifyStatic(never());
        UserDetailsActivity.start(any(), any());
    }
}