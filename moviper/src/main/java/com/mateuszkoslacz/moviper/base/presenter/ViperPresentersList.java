package com.mateuszkoslacz.moviper.base.presenter;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by mateuszkoslacz on 10.01.2017.
 *
 * It allows you to use multiple presenters in one view. It can be used with any of the passive
 * views.
 */

public class ViperPresentersList<ViewType extends MvpView> implements ViperPresenter<ViewType> {

    @NonNull
    private List<ViperPresenter<ViewType>> mPresenters;

    public ViperPresentersList(ViperPresenter<ViewType>... presenters) {
        LinkedList<ViperPresenter<ViewType>> presentersList = new LinkedList<>();
        for (ViperPresenter<ViewType> presenter : presenters) {
            presentersList.add(presenter);
        }
        mPresenters = presentersList;
    }

    @Override
    public void attachView(ViewType view) {
        for (ViperPresenter<ViewType> presenter : mPresenters) {
            presenter.attachView(view);
        }
    }

    @Override
    public void detachView(boolean retainInstance) {
        for (ViperPresenter<ViewType> presenter : mPresenters) {
            presenter.detachView(retainInstance);
        }
    }

    @Override
    public String getName() {
        return "ViperPresentersList - won't be registered";
    }
}
