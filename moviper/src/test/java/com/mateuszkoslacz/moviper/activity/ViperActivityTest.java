package com.mateuszkoslacz.moviper.activity;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.delegate.ActivityMvpDelegate;
import com.mateuszkoslacz.moviper.BuildConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.util.ActivityController;

/**
 * Created by bwilk on 12/20/16.
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ViperActivityTest {

    @Mock
    private ActivityMvpDelegate<MvpView, MvpPresenter<MvpView>> mvpDelegate;
    private ActivityController<CustomViperActivity> testActivityLifecycleController =
            Robolectric.buildActivity(CustomViperActivity.class);
    private CustomViperActivity activity = testActivityLifecycleController.get();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldMvpDelegateInvokeOnCreateWhenActivityStarted() {
        activity.setMvpDelegate(mvpDelegate);
        testActivityLifecycleController.create();
        Mockito.verify(mvpDelegate).onCreate(Mockito.any());
    }
}
