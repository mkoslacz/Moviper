package com.mateuszkoslacz.moviper.activity;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegate;
import com.mateuszkoslacz.moviper.base.view.activity.ViperActivity;

/**
 * Created by bwilk on 12/20/16.
 */

public class CustomViperActivity extends ViperActivity<MvpView, MvpPresenter<MvpView>> {

    private ActivityMvpDelegate<MvpView, MvpPresenter<MvpView>> mMvpDelegate;

    @NonNull
    @Override
    public MvpPresenter<MvpView> createPresenter() {
        return null;
    }

    @NonNull
    @Override
    protected ActivityMvpDelegate<MvpView, MvpPresenter<MvpView>> getMvpDelegate() {
        return mMvpDelegate;
    }

    public void setMvpDelegate(ActivityMvpDelegate<MvpView, MvpPresenter<MvpView>> delegate) {
        mMvpDelegate = delegate;
    }
}
