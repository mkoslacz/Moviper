package com.mateuszkoslacz.moviper.rxsample.viper.presenter;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;
import com.mateuszkoslacz.moviper.rxsample.data.model.User;
import com.mateuszkoslacz.moviper.rxsample.viewadapter.UserAdapter;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.interactor.ListingInteractor;
import com.mateuszkoslacz.moviper.rxsample.viper.routing.ListingRouting;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListingPresenter
        extends ViperActivityBaseRxPresenter
        <ListingContract.View,
                ListingContract.Interactor,
                ListingContract.Routing>
        implements
        ListingContract.Presenter {

    public ListingPresenter(Activity activity) {
        super(activity);
    }

    @Override
    public void onViewCreated() {
        if (isViewAttached())
            getView().showLoading();

        getInteractor().getUserList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> {
                            if (isViewAttached()) {
                                getView().setUserList(user);
                                getView().showContent();
                            }
                        },
                        throwable -> {
                            Log.d("onUsers()", throwable.getMessage());
                            if (isViewAttached())
                                getView().showError();
                        }
                );
    }

    @Override
    public void onItemClicked(User user, UserAdapter.UserViewHolder userViewHolder) {
        getRouting().startUserDetailsActivity(user, userViewHolder);
    }

    /*
    --------------------------------------------------------------------------
     */

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
