package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.rxsample.BuildConfig;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.ListingPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by mateuszkoslacz on 22.11.2016.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ListingActivityTest {

    @Mock
    private ListingPresenter mListingPresenter;
    private ListingActivity mListingActivity;

    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private TextView mErrorTextView;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ActivityController<ListingActivity> listingActivityLifecycleController =
                Robolectric.buildActivity(ListingActivity.class);
        mListingActivity = listingActivityLifecycleController.get();
        mListingActivity.setPresenter(mListingPresenter);
        listingActivityLifecycleController.create().start().resume().visible().get();

        mErrorTextView = (TextView) mListingActivity.findViewById(R.id.errorView);
        mProgressBar = (ProgressBar) mListingActivity.findViewById(R.id.loadingView);
        mRecyclerView = (RecyclerView) mListingActivity.findViewById(R.id.recycler_view);
    }

    @Test
    public void onViewCreated() throws Exception {
        Mockito.verify(mListingPresenter).onViewCreated();
    }

    @Test
    public void testActivity() throws Exception {
        User user = new User();
        mListingActivity.onUserClick(user);
        Mockito.verify(mListingPresenter).onItemClicked(user);
    }

    @Test
    public void testKeyElementsExists() throws Exception {
        assertNotNull("Error textview could not be found", mErrorTextView);
        assertNotNull("Progressbar could not be found", mProgressBar);
        assertNotNull("content could not be found", mRecyclerView);
    }

    @Test
    public void testShowError() throws Exception {
        mListingActivity.showError(new Exception("Test message"));
        assertFalse("Loading indicator is visible", mProgressBar.isShown());
        assertFalse("content is visible", mRecyclerView.isShown());
        assertTrue("Error textview is not visible", mErrorTextView.isShown());
        assertEquals("Error textview hasn't got proper message",
                "Test message", mErrorTextView.getText().toString());
    }

    @Test
    public void testShowLoading() throws Exception {
        mListingActivity.showLoading();
        assertTrue("Loading indicator is not visible", mProgressBar.isShown());
        assertFalse("content is visible", mRecyclerView.isShown());
        assertFalse("Error textview is visible", mErrorTextView.isShown());
    }

    @Test
    public void testShowContent() throws Exception {
        mListingActivity.showContent();
        assertFalse("Loading indicator is visible", mProgressBar.isShown());
        assertTrue("content is not visible", mRecyclerView.isShown());
        assertFalse("Error textview is visible", mErrorTextView.isShown());
    }

    @Test
    public void testSetContent() throws Exception {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setLogin("first");
        user2.setLogin("second");
        user3.setLogin("third");
        mListingActivity.setUserList(Arrays.asList(user1, user2, user3));
        mListingActivity.showContent();
        TextView userLoginTextView = (TextView) mRecyclerView.findViewHolderForAdapterPosition(0)
                .itemView.findViewById(R.id.login);
        assertEquals("user item doesn't display correct user login",
                "first", userLoginTextView.getText().toString());
    }

    @Test
    public void testContentClicks() throws Exception {
        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        user1.setLogin("first");
        user2.setLogin("second");
        user3.setLogin("third");
        mListingActivity.setUserList(Arrays.asList(user1, user2, user3));
        mListingActivity.showContent();
        mRecyclerView.findViewHolderForAdapterPosition(0).itemView.performClick();

        // workaround robolectric recyclerView issue
        mRecyclerView.measure(0, 0);
        mRecyclerView.layout(0, 0, 100, 1000);

        Mockito.verify(mListingPresenter).onItemClicked(user1);
    }
}