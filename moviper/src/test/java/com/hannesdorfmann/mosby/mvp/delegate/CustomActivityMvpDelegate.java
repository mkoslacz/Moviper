package com.hannesdorfmann.mosby.mvp.delegate;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by bwilk on 12/21/16.
 */

public class CustomActivityMvpDelegate extends ActivityMvpDelegateImpl<MvpView, MvpPresenter<MvpView>> {

    private MvpInternalDelegate<MvpView, MvpPresenter<MvpView>> mInternalDelegate;

    public CustomActivityMvpDelegate(ActivityMvpDelegateCallback<MvpView,
            MvpPresenter<MvpView>> delegateCallback) {
        super(delegateCallback);
    }

    @Override
    protected MvpInternalDelegate<MvpView, MvpPresenter<MvpView>> getInternalDelegate() {
        return mInternalDelegate;
    }

    public void setInternalDelegate(MvpInternalDelegate<MvpView,
            MvpPresenter<MvpView>> internalDelegate) {
        this.mInternalDelegate = internalDelegate;
    }
}
