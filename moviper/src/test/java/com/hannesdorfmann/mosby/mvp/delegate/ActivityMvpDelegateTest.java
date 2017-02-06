package com.hannesdorfmann.mosby3.mvp.delegate;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.BuildConfig;
import com.mateuszkoslacz.moviper.presenterbus.presentertest.CustomPresenter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by bwilk on 12/21/16.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ActivityMvpDelegateTest {

    private CustomPresenter mPresenter;
    private CustomMvpDelegateCallback mDelegateCallback;
    private MvpInternalDelegate<MvpView, MvpPresenter<MvpView>> mInternalDelegate;
    private CustomActivityMvpDelegate mMainDelegate;

    @Before
    public void setUp() {
        mPresenter = Mockito.mock(CustomPresenter.class);
        mDelegateCallback = new CustomMvpDelegateCallback(mPresenter);
        mInternalDelegate = new MvpInternalDelegate<>(mDelegateCallback);
        mMainDelegate = new CustomActivityMvpDelegate(mDelegateCallback);
    }

    @Test
    public void shouldPresenterAttachViewWhenDelegateCallsOnCreate() {
        mMainDelegate.setInternalDelegate(mInternalDelegate);
        mMainDelegate.onCreate(Mockito.any());
        Mockito.verify(mPresenter).attachView(Mockito.any());
    }
}
