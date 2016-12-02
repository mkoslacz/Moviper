package com.mateuszkoslacz.moviper.ipcsample;

import android.os.Bundle;

import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.ColorWidgetPresenter;
import com.mateuszkoslacz.moviper.ipcsample.viper.view.fragment.ColorWidgetFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.support.v4.SupportFragmentTestUtil;

import static org.mockito.Mockito.verify;

/**
 * Created by bwilk on 12/2/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ColorFragmentTest {

    @Mock
    ColorWidgetPresenter presenter;

    @InjectMocks
    ColorWidgetFragment fragment = new ColorWidgetFragment();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        fragment.setArguments(new Bundle());
    }

    @Test
    public void testFragment() {
        SupportFragmentTestUtil.startVisibleFragment(fragment);
        verify(presenter).onViewCreated();
    }
}
