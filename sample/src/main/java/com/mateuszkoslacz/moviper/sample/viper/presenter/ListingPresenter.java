package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;
import com.mateuszkoslacz.moviper.sample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.ListingRouting;

import java.util.List;

public class ListingPresenter
        extends ViperActivityBasePresenter
        <ListingContract.View,
                ListingContract.Interactor,
                ListingContract.Routing>
        implements
        ListingContract.Presenter,
        ListingContract.PresenterForInteractor,
        ListingContract.PresenterForRouting {

    public ListingPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            getView().showLoading();
            getInteractor().getUserList();
        }
    }

    @Override
    public void onItemClicked(User item) {
        getRouting().startUserDetailsActivity(item);
    }

    @Override
    public void onUserFetched(List<User> userList) {
        if (isViewAttached()) {
            getView().setUserList(userList);
            getView().showContent();
        }
    }

    @Override
    public void onUserFetchedError(Throwable throwable) {
        if (isViewAttached()) getView().showError(throwable);
    }

    @NonNull
    @Override
    public ListingContract.Routing createRouting(@NonNull Activity activity) {
        return new ListingRouting(activity);
    }

    @NonNull
    @Override
    public ListingContract.Interactor createInteractor() {
        return new ListingInteractor();
    }
}
