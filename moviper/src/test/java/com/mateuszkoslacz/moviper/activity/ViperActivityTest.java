package com.mateuszkoslacz.moviper.activity;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegate;
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
    private ActivityMvpDelegate<MvpView, MvpPresenter<MvpView>> mMvpDelegate;
    private ActivityController<CustomViperActivity> mTestActivityLifecycleController =
            Robolectric.buildActivity(CustomViperActivity.class);
    private CustomViperActivity mActivity = mTestActivityLifecycleController.get();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldMvpDelegateInvokeOnCreateWhenActivityStarted() {
        mActivity.setMvpDelegate(mMvpDelegate);
        mTestActivityLifecycleController.create();
        Mockito.verify(mMvpDelegate).onCreate(Mockito.any());
    }
}
