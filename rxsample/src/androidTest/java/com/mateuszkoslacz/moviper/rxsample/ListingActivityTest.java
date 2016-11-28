package com.mateuszkoslacz.moviper.rxsample;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;
import com.mateuszkoslacz.moviper.rxsample.utils.RecyclerViewMatcher;
import com.mateuszkoslacz.moviper.rxsample.utils.di.UserTestRepository;
import com.mateuszkoslacz.moviper.rxsample.viper.view.activity.ListingActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ListingActivityTest {

    @Rule
    public ActivityTestRule<ListingActivity> mActivityTestRule = new ActivityTestRule<>(ListingActivity.class);

    @Test
    public void testDataFetching() {
        onView(withId(R.id.loadingView)).check(matches(isDisplayed()));
        Log.d("UserTestRepository", "inside test");
        ((UserTestRepository) DIProvider.getRepositoryComponent().provideUserRepository()).triggerContentReturn();
    }

    @Test
    public void loadUsersList() {
        onView(withRecyclerView(R.id.recycler_view).atPosition(3))
                .check(matches(hasDescendant(withText("user4"))));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
}
