package com.mateuszkoslacz.moviper.base.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
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
public abstract class WipeBasePresenter
        <ViewType extends MvpView, // I prefer readability rather than conventions
                InteractorType extends MoviperInteractor>
        extends MoviperBasePresenter<ViewType>
        implements MoviperPresenter<ViewType>,
        MoviperPresenterForInteractor<InteractorType> {

    @NonNull
    private InteractorType interactor;

    public WipeBasePresenter() {
        this(null);
    }

    public WipeBasePresenter(Bundle args) {
        super(args);
        this.interactor = createInteractor();
    }

    @Override
    @Deprecated
    public boolean isInteractorAttached() {
        return interactor != null;
    }

    @Override
    public void attachView(ViewType view) {
        super.attachView(view);
        //noinspection unchecked
        interactor.attachPresenter(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
        interactor.detachPresenter();
    }

    @NonNull
    @Override
    public InteractorType getInteractor() {
        return interactor;
    }
}
