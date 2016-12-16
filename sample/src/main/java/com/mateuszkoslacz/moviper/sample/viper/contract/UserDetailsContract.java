package com.mateuszkoslacz.moviper.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.mateuszkoslacz.moviper.iface.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.ViperPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.ViperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.view.ViperLceView;
import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper;
import com.mateuszkoslacz.moviper.sample.viper.entity.User;

public interface UserDetailsContract {

    interface Presenter extends MvpPresenter<View> {
        // Defines what methods the View can invoke on the Presenter.
        // In most cases there will be user interactions and View lifecycle events.

        void onViewCreated();

        void onAvatarClicked(String avatarUrl);
    }

    interface View extends ViperLceView<User> {
        // Defines what methods the Presenter can invoke on the View
        // In most cases there will be manipulating ui and displaying data or errors.

        void bindDataToViews(User user);
    }

    interface Interactor extends ViperInteractor<PresenterForInteractor> {
        // Defines what methods the Presenter can invoke on the Interactor.
        // In most cases there will be data saving and querying.

        void getUserForUsername(String user);
    }

    interface PresenterForInteractor extends ViperPresenterForInteractor<Interactor> {
        // Defines what methods the Interactor could invoke on the Presenter.
        // In most cases there will be data received callbacks and error notifying.

        void onUserFetched(User user);

        void onUserFetchedError(Throwable throwable);
    }

    interface Routing extends ViperViewHelperRouting<PresenterForRouting, ViewHelper> {
        // Defines what methods the Presenter can invoke on the Routing.
        // In most cases there will be starting another activities, services and using system
        // framework, ie. scheduling alarms or sending broadcasts.
        // In the case of a fragment being the view, there also will be manipulating
        // the root Activity, ie. switching fragments.

        void startFullscreenPhotoActivity(String avatarUrl);
    }

    interface PresenterForRouting extends ViperPresenterForRouting<Routing> {
        // Defines what methods the Routing can invoke on the Presenter.
        // In most cases there will be system framework interaction callbacks and error notifying.

    }

    interface ViewHelper extends ViperViewHelper {
        // Defines what Android views the Routing can get from the Viper View.
        // There should only be Android View getter methods to provide the Routing elements
        // to be used on advanced Android transitions.

        android.view.View getAvatarImageView();
    }

}
