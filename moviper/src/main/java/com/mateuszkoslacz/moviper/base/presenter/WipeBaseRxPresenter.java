package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;

/**
 * Created by mateuszkoslacz on 08.08.2016. based on original lucas.urbas idea from 29/08/15.
 * <p>
 * Wipe - Wiew/View, Interactor, Presenter, Entities
 * <p>
 * This is a universal base presenter class for mentioned set of concepts.
 * (see {@link MvpBasePresenter})
 * <p>
 * You can use any Mosby View with this class (activity views:
 * {@link com.hannesdorfmann.mosby.mvp.MvpActivity},
 * {@link com.hannesdorfmann.mosby.mvp.lce.MvpLceActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateActivity},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateActivity},
 * and fragment ones:
 * {@link com.hannesdorfmann.mosby.mvp.MvpFragment},
 * {@link com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.MvpViewStateFragment},
 * {@link com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment})
 */
//TODO migrate to MvpNullObjectPresenter base class?
public abstract class WipeBaseRxPresenter
        <ViewType extends MvpView, // I prefer readability rather than conventions
                InteractorType extends MoviperRxInteractor>
        extends MoviperBaseRxPresenter<ViewType>
        implements MoviperPresenter<ViewType>,
        MoviperPresenterForInteractor<InteractorType> {

    protected Bundle args;
    @NonNull
    private InteractorType interactor;

    public WipeBaseRxPresenter() {
        this(null);
    }

    public WipeBaseRxPresenter(Bundle args) {
        super();
        this.args = args;
        this.interactor = createInteractor();
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        interactor.onPresenterDetached();
    }

    @Override
    @Deprecated
    public boolean isInteractorAttached() {
        return interactor != null;
    }

    @NonNull
    @Override
    public InteractorType getInteractor() {
        return interactor;
    }
}
