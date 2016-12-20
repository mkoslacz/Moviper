package com.mateuszkoslacz.moviper.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperRouting;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;

import java.util.List;

public interface ListingContract {

    interface Presenter extends MvpPresenter<View> {
        // Defines what methods the View can invoke on the Presenter.
        // In most cases there will be user interactions and View lifecycle events.

        void onViewCreated();

        void onItemClicked(User item);
    }

    interface View extends MvpView {
        // Defines what methods the Presenter can invoke on the View
        // In most cases there will be manipulating ui and displaying data or errors.

        void setUserList(List<User> userList);

        void showError(Throwable throwable);

        void showLoading();

        void showContent();
    }

    interface Interactor extends ViperInteractor<PresenterForInteractor> {
        // Defines what methods the Presenter can invoke on the Interactor.
        // In most cases there will be data saving and querying.

        void getUserList();
    }

    interface PresenterForInteractor extends ViperPresenterForInteractor<Interactor> {
        // Defines what methods the Interactor could invoke on the Presenter.
        // In most cases there will be data received callbacks and error notifying.

        void onUserListFetched(List<User> userList);

        void onUserListFetchedError(Throwable throwable);
    }

    interface Routing extends ViperRouting<PresenterForRouting> {
        // Defines what methods the Presenter can invoke on the Routing.
        // In most cases there will be starting another activities, services and using system
        // framework, ie. scheduling alarms or sending broadcasts.
        // In the case of a fragment being the view, there also will be manipulating
        // the root Activity, ie. switching fragments.

        void startUserDetailsActivity(User user);
    }

    interface PresenterForRouting extends ViperPresenterForRouting<Routing> {
        // Defines what methods the Routing can invoke on the Presenter.
        // In most cases there will be system framework interaction callbacks and error notifying.

    }
}
