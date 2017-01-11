package com.hannesdorfmann.mosby.mvp.delegate;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by bwilk on 12/21/16.
 */

public class CustomMvpDelegateCallback implements ActivityMvpDelegateCallback<MvpView, MvpPresenter<MvpView>> {

    private MvpPresenter<MvpView> mPresenter;

    public CustomMvpDelegateCallback(MvpPresenter<MvpView> mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public Object onRetainNonMosbyCustomNonConfigurationInstance() {
        return null;
    }

    @Override
    public Object getLastCustomNonConfigurationInstance() {
        return null;
    }

    @Override
    public Object getNonMosbyLastCustomNonConfigurationInstance() {
        return null;
    }

    @NonNull
    @Override
    public MvpPresenter<MvpView> createPresenter() {
        return mPresenter;
    }

    @Override
    public MvpPresenter<MvpView> getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(MvpPresenter<MvpView> presenter) {

    }

    @Override
    public MvpView getMvpView() {
        return null;
    }

    @Override
    public boolean isRetainInstance() {
        return false;
    }

    @Override
    public void setRetainInstance(boolean retainingInstance) {

    }

    @Override
    public boolean shouldInstanceBeRetained() {
        return false;
    }

}
