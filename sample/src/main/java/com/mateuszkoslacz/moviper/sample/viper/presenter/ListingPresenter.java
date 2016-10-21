package com.mateuszkoslacz.moviper.sample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBasePresenter;
import com.mateuszkoslacz.moviper.sample.model.User;
import com.mateuszkoslacz.moviper.sample.viewadapter.UserAdapter;
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

    @Override
    public void onViewCreated() {
        if (isViewAttached()) {
            getView().showLoading();
            getInteractor().getUserList();
        }
    }

    @Override
    public void onItemClicked(User item, UserAdapter.UserViewHolder userViewHolder) {
        getRouting().startUserDetailsActivity(item, userViewHolder);
    }

    @Override
    public void onUserFetched(List<User> userList) {
        if (isViewAttached()) {
            getView().setUserList(userList);
            getView().showContent();
        }
    }

    @Override
    public void onUserFetchedError() {
        if (isViewAttached())
            getView().showError();
    }
}
