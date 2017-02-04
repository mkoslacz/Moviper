package com.mateuszkoslacz.moviper.ipcsample;

import android.graphics.drawable.ColorDrawable;
import android.support.test.runner.AndroidJUnit4;

import com.mateuszkoslacz.moviper.ipcsample.constants.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.activity.MainActivity;
import com.mateuszkoslacz.moviper.tests.rules.MoviperActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by bwilk on 12/5/16.
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {

    @Rule
    public MoviperActivityTestRule<MainActivity>
            mActivityTestRule = new MoviperActivityTestRule<>(MainActivity.class);

//    // TODO: 06.01.2017 why de fuk this is failing ONLY when all tests are run together
//    // and device HAS ANIMATIONS CONFIGURED like on the espresso docs?
//    // if it's run as a single test it passes, if it's run in a bunch of tests on a
//    // NOT espresso configured device it works. (at least on my workstation)
//    @Test
//    public void shouldButtonClickChangeFragmentColorFoundById() {
//        ColorDrawable firstFragmentColor = getFragmentBackgroundDrawable(R.id.fragment_first);
//        assertEquals(firstFragmentColor.getColor(), Constants.COLOR_BLUE);
//        ColorDrawable thirdFragmentColor = getFragmentBackgroundDrawable(R.id.fragment_third);
//        assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_RED);
//        onView(allOf(withId(R.id.button_third),
//                withParent(withParent(withParent(withId(R.id.fragment_first))))))
//                .perform(click());
//        assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_BLUE);
//    }

    @Test
    public void shouldButtonClickChangeFragmentColorFoundByContent() {
        ColorDrawable firstFragmentColor = getFragmentBackgroundDrawable(R.id.fragment_first);
        assertEquals(firstFragmentColor.getColor(), Constants.COLOR_BLUE);
        ColorDrawable thirdFragmentColor = getFragmentBackgroundDrawable(R.id.fragment_third);
        assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_RED);
        onView(allOf(withId(R.id.button_third),
                withParent(withParent(hasDescendant(withText(Constants.NAME_BLUE))))))
                .perform(click());
        assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_BLUE);
    }

    private ColorDrawable getFragmentBackgroundDrawable(int fragmentId) {
        return ((ColorDrawable) mActivityTestRule.getActivity().getSupportFragmentManager()
                .findFragmentById(fragmentId).getView().getBackground());
    }
}
