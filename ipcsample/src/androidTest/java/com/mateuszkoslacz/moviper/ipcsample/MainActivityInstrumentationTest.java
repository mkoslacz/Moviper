package com.mateuszkoslacz.moviper.ipcsample;

import android.graphics.drawable.ColorDrawable;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mateuszkoslacz.moviper.base.presenter.WipeBaseRxPresenter;
import com.mateuszkoslacz.moviper.ipcsample.constants.Constants;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.activity.MainActivity;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

import org.junit.Before;
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

    private MainActivity mActivity;

    @Rule
    public ActivityTestRule<MainActivity>
            mActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class) {
        @Override
        protected void afterActivityFinished() {
            /*
                We need to unregister presenters manually because of threading issues.
                Ex: Sometimes the fragment's presenter inside the first test is not unregistered
                when we call another test and the same presenter is trying go be registered again.
             */
            super.afterActivityFinished();
            Moviper.getInstance().getPresenters(WipeBaseRxPresenter.class)
                    .subscribe(Moviper.getInstance()::unregister);
        }
    };

    @Before
    public void setUp() {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void shouldButtonClickChangeFragmentColorFoundById() {
        ColorDrawable firstFragmentColor = getFragmentBackgroundDrawable(R.id.fragment_first);
        assertEquals(firstFragmentColor.getColor(), Constants.COLOR_BLUE);
        ColorDrawable thirdFragmentColor = getFragmentBackgroundDrawable(R.id.fragment_third);
        assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_RED);
        onView(allOf(withId(R.id.button_third),
                withParent(withParent(withParent(withId(R.id.fragment_first))))))
                .perform(click());
        assertEquals(thirdFragmentColor.getColor(), Constants.COLOR_BLUE);
    }

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
        return ((ColorDrawable) mActivity.getSupportFragmentManager()
                .findFragmentById(fragmentId).getView().getBackground());
    }
}
