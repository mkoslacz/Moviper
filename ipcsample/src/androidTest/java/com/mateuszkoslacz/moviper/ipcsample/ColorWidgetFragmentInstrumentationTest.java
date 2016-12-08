package com.mateuszkoslacz.moviper.ipcsample;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static junit.framework.Assert.assertEquals;

/**
 * Created by bwilk on 12/5/16.
 */
@RunWith(AndroidJUnit4.class)
public class ColorWidgetFragmentInstrumentationTest {

    @Rule
    public FragmentTestRule<ColorWidgetFragment>
            mFragmentTestRule = new FragmentTestRule<>(ColorWidgetFragment.class);

    /*
        Here we can perform isolated fragment tests.
        However, in this sample, our fragment doesn't change it's state while performing
        any actions on his views.
     */

    @Test
    public void shouldFragmentBeLoadedSuccessfully() {
        mFragmentTestRule.launchActivity(null);
        onView(withId(R.id.button_first)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldFragmentBeDestroyedSuccessfully() {
        mFragmentTestRule.launchActivity(null);
        onView(withId(R.id.button_first)).check(matches(isDisplayed()));
        mFragmentTestRule.removeFragment();
        onView(withId(R.id.button_first)).check(doesNotExist());
    }

    @After
    public void cleanUp() {
        mFragmentTestRule.removeFragment();
    }
}
