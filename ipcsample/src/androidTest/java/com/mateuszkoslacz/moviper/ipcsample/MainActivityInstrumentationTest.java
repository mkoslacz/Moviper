package com.mateuszkoslacz.moviper.ipcsample;

import android.graphics.drawable.ColorDrawable;
import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mateuszkoslacz.moviper.base.presenter.WipeBaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.constants.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.activity.MainActivity;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

import junit.framework.Assert;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withParent;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by bwilk on 12/5/16.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentationTest {

    MainActivity activity;

    @Rule
    public ActivityTestRule<MainActivity>
            mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        activity = mActivityTestRule.getActivity();
    }

    @Test
    public void shouldButtonClickChangeFragmentColor() {
        ColorWidgetFragment firstFragment = ((ColorWidgetFragment)
                activity.getSupportFragmentManager().findFragmentById(R.id.fragment_first));
        ColorDrawable firstFragmentColor = ((ColorDrawable) firstFragment.getView().getBackground());

        Assert.assertEquals(firstFragmentColor.getColor(), Constants.COLOR_BLUE);


        ColorWidgetFragment thirdFragment = ((ColorWidgetFragment)
                activity.getSupportFragmentManager().findFragmentById(R.id.fragment_third));
        ColorDrawable thirdFragmentColor = ((ColorDrawable) thirdFragment.getView().getBackground());

        Assert.assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_RED);

        Espresso.onView(CoreMatchers.allOf(withId(R.id.button_third),
                withParent(withParent(withParent(withId(R.id.fragment_first)))))).perform(ViewActions.click());

        Assert.assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_BLUE);
    }

    //example with finding parent which contains proper text
    @Test
    public void shouldButtonClickChangeFragmentColor2() {
        ColorWidgetFragment firstFragment = ((ColorWidgetFragment)
                activity.getSupportFragmentManager().findFragmentById(R.id.fragment_first));
        ColorDrawable firstFragmentColor = ((ColorDrawable) firstFragment.getView().getBackground());

        Assert.assertEquals(firstFragmentColor.getColor(), Constants.COLOR_BLUE);


        ColorWidgetFragment thirdFragment = ((ColorWidgetFragment)
                activity.getSupportFragmentManager().findFragmentById(R.id.fragment_third));
        ColorDrawable thirdFragmentColor = ((ColorDrawable) thirdFragment.getView().getBackground());

        Assert.assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_RED);


        Espresso.onView(CoreMatchers.allOf(withId(R.id.button_third),
                withParent(withParent(hasDescendant(withText(Constants.NAME_BLUE)))))).perform(ViewActions.click());

        Assert.assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_BLUE);
    }

    @After
    public void cleanUp() {
        Moviper.getInstance().getPresenters(WipeBaseRxPresenter.class)
                .subscribe(Moviper.getInstance()::unregister);
    }
}
