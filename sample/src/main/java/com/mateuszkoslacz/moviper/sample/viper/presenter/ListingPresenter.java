package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.BasePresenter;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;
import com.mateuszkoslacz.moviper.sample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.sample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.sample.viper.routing.ListingRouting;

import java.util.List;

public class ListingPresenter
        extends BasePresenter<ListingContract.View,
                                ListingContract.Interactor,
                                ListingContract.Routing>
        implements ListingContract.Presenter,
        ListingContract.PresenterForInteractor,
        ListingContract.PresenterForRouting {

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
    public void onUserListFetched(List<User> userList) {
        if (isViewAttached()) {
            getView().setUserList(userList);
            getView().showContent();
        }
    }

    @Override
    public void onUserListFetchedError(Throwable throwable) {
        if (isViewAttached()) getView().showError(throwable);
    }

    @NonNull
    @Override
    public ListingContract.Routing createRouting() {
        return new ListingRouting();
    }

    @NonNull
    @Override
    public ListingContract.Interactor createInteractor() {
        return new ListingInteractor();
    }
}
