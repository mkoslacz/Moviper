package com.mateuszkoslacz.moviper.ipcsample;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import com.mateuszkoslacz.moviper.ipcsample.constants.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.ColorWidgetPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by bwilk on 12/5/16.
 */
@RunWith(AndroidJUnit4.class)
public class ColorWidgetFragmentInstrumentationTest {

    private static Bundle mArguments;

    @Rule
    public FragmentTestRule<ColorWidgetFragment>
            mFragmentTestRule = new FragmentTestRule<>(ColorWidgetFragment.class);

    /*
        Here we can perform isolated fragment tests.
        However, in this sample, our fragment doesn't change its state while performing
        actions on its views.
     */

    @BeforeClass
    public static void setUp() {
        mArguments = new Bundle();
        mArguments.putString(ColorWidgetPresenter.FRAGMENT_COLOR_NAME, Constants.NAME_BLUE);
        mArguments.putInt(ColorWidgetPresenter.FRAGMENT_BACKGROUND_COLOR, Constants.COLOR_BLUE);
    }

    @Test
    public void shouldFragmentBeLoadedSuccessfully() {
        mFragmentTestRule.setArguments(mArguments);
        mFragmentTestRule.launchActivity(null);
        onView(withId(R.id.button_first)).check(matches(isDisplayed()));
    }

    @Test
    public void shouldFragmentBeDestroyedSuccessfully() {
        mFragmentTestRule.setArguments(mArguments);
        mFragmentTestRule.launchActivity(null);
        onView(withId(R.id.button_first)).check(matches(isDisplayed()));
        mFragmentTestRule.removeFragment();
        onView(withId(R.id.button_first)).check(doesNotExist());
    }
}
