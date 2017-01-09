package com.mateuszkoslacz.moviper.ipcsample;

import android.os.Bundle;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.ColorWidgetPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.mockito.Mockito.verify;
import static org.junit.Assert.assertEquals;



/**
 * Created by bwilk on 12/5/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ColorWidgetFragmentUnitTest {

    @Mock
    ColorWidgetPresenter mPresenter;

    @InjectMocks
    ColorWidgetFragment mFragment = new ColorWidgetFragment();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mFragment.setArguments(new Bundle());
    }

    @Test
    public void testFragment() {
        Assert.assertNotNull(mPresenter);
        SupportFragmentTestUtil.startVisibleFragment(mFragment);
        mFragment.setName("testName");
        assertEquals("testName", ((TextView) mFragment.getView().findViewById(R.id.color_name)).getText().toString());
    }
}
