package com.mateuszkoslacz.moviper.rxsample.viper.contract;

import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperViewHelperRxRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.ViperViewHelper;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import rx.Observable;
import rx.subjects.Subject;

public interface UserDetailsContract {

    interface View extends MvpLceView<User> {
        // Defines what methods the Presenter can invoke on the View
        // In most cases there will be manipulating ui and displaying data or errors.
        // In Super Rx version it also provides getters for Observables emmiting user click events.

        void bindDataToViews(User user);
        Subject<String, String> getAvatarClicks();
    }

    interface Interactor extends ViperRxInteractor {
        // Defines what methods the Presenter can invoke on the Interactor.
        // In most cases there will be data saving and querying.
        // It's just a marker interface.

        Observable<User> getUserForUsername(String user);
    }

    interface Routing extends ViperViewHelperRxRouting<ViewHelper> {
        // Defines what methods the Presenter can invoke on the Routing.
        // In most cases there will be starting another activities, services and using system
        // framework, ie. scheduling alarms or sending broadcasts.
        // In the case of a fragment being the view, there also will be manipulating
        // the root Activity, ie. switching fragments.

        void startFullscreenPhotoActivity(String photoUrl);
    }

    interface ViewHelper extends ViperViewHelper {
        // Defines what Android views the Routing can get from the Viper View.
        // There should only be Android View getter methods to provide the Routing elements
        // to be used on advanced Android transitions.

        android.view.View getAvatarImageView();
    }
}
