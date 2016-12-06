package com.mateuszkoslacz.moviper.ipcsample;

import android.support.test.runner.AndroidJUnit4;

import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bwilk on 12/2/16.
 */

@RunWith(AndroidJUnit4.class)
public class ColorWidgetFragmentTest {

    @Rule
    public FragmentTestRule<ColorWidgetFragment> mFragmentTestRule = new FragmentTestRule<>(ColorWidgetFragment.class);

    @Test
    public void testFragment() {
        mFragmentTestRule.launchActivity(null);
        onView(withId(R.id.button_first)).check(matches(isDisplayed()));
        mFragmentTestRule.getFragmentManager()
                .beginTransaction().remove(mFragmentTestRule.getFragment()).commit();
        onView(withId(R.id.button_first)).check(doesNotExist());
    }
}
