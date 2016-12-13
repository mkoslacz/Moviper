package com.mateuszkoslacz.moviper.rxsample;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;
import com.mateuszkoslacz.moviper.rxsample.utils.RecyclerViewMatcher;
import com.mateuszkoslacz.moviper.rxsample.utils.data.rdp.repository.TestRepository;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;
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
import static org.hamcrest.Matchers.not;

@RunWith(AndroidJUnit4.class)
public class ListingActivityTest {

    @Rule
    public ActivityTestRule<ListingActivity>
            mActivityTestRule = new ActivityTestRule<>(ListingActivity.class);

    @Test
    public void testDataFetchingWithSuccess() {
        shouldLoadingViewBeDisplayed();
        ((TestRepository<User>) DIProvider.getRepositoryComponent().provideUserRepository())
                .triggerContentReturn();
        shouldContentViewBeDisplayed();
    }

    @Test
    public void testDataFetchingWithError() {
        shouldLoadingViewBeDisplayed();
        ((TestRepository<User>) DIProvider.getRepositoryComponent().provideUserRepository())
                .triggerError(new IllegalStateException());
        shouldErrorViewBeDisplayed();
    }

    @Test
    public void testDataLoadingToRecyclerView() {
        shouldLoadingViewBeDisplayed();
        ((TestRepository<User>) DIProvider.getRepositoryComponent().provideUserRepository())
                .triggerContentReturn();
        shouldContentViewBeDisplayed();
        onView(withRecyclerView(R.id.recycler_view).atPosition(3))
                .check(matches(hasDescendant(withText("user4"))));
    }

    public void shouldErrorViewBeDisplayed() {
        onView(withId(R.id.loadingView)).check(matches(not(isDisplayed())));
        onView(withId(R.id.errorView)).check(matches(isDisplayed()));
        onView(withId(R.id.recycler_view)).check(matches(not(isDisplayed())));
    }

    public void shouldLoadingViewBeDisplayed() {
        onView(withId(R.id.loadingView)).check(matches(isDisplayed()));
        onView(withId(R.id.errorView)).check(matches(not(isDisplayed())));
        onView(withId(R.id.recycler_view)).check(matches(not(isDisplayed())));
    }

    public void shouldContentViewBeDisplayed() {
        onView(withId(R.id.loadingView)).check(matches(not(isDisplayed())));
        onView(withId(R.id.errorView)).check(matches(not(isDisplayed())));
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()));
    }

    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }
}
