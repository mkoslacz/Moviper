package com.mateuszkoslacz.moviper.base.presenter;

import com.hannesdorfmann.mosby.mvp.MvpView;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by tnajda on 22.11.2016.
 */

public class MoviperBaseRxPresenter<V extends MvpView>
        extends MoviperBasePresenter<V> {

    private CompositeSubscription compositeSubscription;

    public MoviperBaseRxPresenter() {
        super();
        compositeSubscription = new CompositeSubscription();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        if(!retainInstance)
            unsubscribe();
    }

    protected void addSubscription(Subscription subscription) {
        if(compositeSubscription != null) {
            compositeSubscription.add(subscription);
        }
    }

    private void unsubscribe() {
        if(compositeSubscription != null)
            compositeSubscription.clear();
    }
}
