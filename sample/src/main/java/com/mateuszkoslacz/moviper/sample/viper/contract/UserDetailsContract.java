package com.mateuszkoslacz.moviper.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperActivityPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;
import com.mateuszkoslacz.moviper.sample.model.User;

public interface UserDetailsContract {

    interface Presenter extends MvpPresenter<View> {
        // Defines what methods the View can invoke on the Presenter.
        // In most cases there will be user interactions and View lifecycle events.

        void onViewCreated();

        void onAvatarClicked(String avatarUrl);
    }

    interface View extends MvpView, MvpLceView<User> {
        // Defines what methods the Presenter can invoke on the View
        // In most cases there will be manipulating ui and displaying data or errors.

        void bindDataToViews(User user);

        void setLoginAndAvatarForUser(User user);
    }

    interface Interactor extends MoviperInteractor<PresenterForInteractor> {
        // Defines what methods the Presenter can invoke on the Interactor.
        // In most cases there will be data saving and querying.

        void getUserForUsername(String user);
    }

    interface PresenterForInteractor extends MoviperPresenterForInteractor<Interactor> {
        // Defines what methods the Interactor could invoke on the Presenter.
        // In most cases there will be data received callbacks and error notifying.

        void onUserFetched(User user);

        void onUserFetchedError(Throwable throwable);
    }

    interface Routing extends MoviperViewHelperRouting<PresenterForRouting, ViewHelper> {
        // Defines what methods the Presenter can invoke on the Routing.
        // In most cases there will be starting another activities, services and using system
        // framework, ie. scheduling alarms or sending broadcasts.
        // In the case of a fragment being the view, there also will be manipulating
        // the root Activity, ie. switching fragments.

        void startFullscreenPhotoActivity(String avatarUrl);
    }

    interface PresenterForRouting extends MoviperActivityPresenterForRouting<Routing> {
        // Defines what methods the Routing can invoke on the Presenter.
        // In most cases there will be system framework interaction callbacks and error notifying.

    }

    interface ViewHelper extends MoviperViewHelper {
        // Defines what Android views the Routing can get from the Viper View.
        // There should only be Android View getter methods to provide the Routing elements
        // to be used on advanced Android transitions.

        android.view.View getAvatarImageView();
    }

}
