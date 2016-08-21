package com.mateuszkoslacz.moviper.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperActivityPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;

/**
 * Created by mateuszkoslacz on 10.08.2016.
 * <p>
 * It's an example of a template generator generated Viper contract. There is no single line of code
 * added excluding this javadoc comment. All explanations that you can see here are provided in
 * generated contract for making contract projecting process easier for developers.
 */
public interface MainContract {

    interface Presenter extends MvpPresenter<View> {
        // Defines what methods the View can invoke on the Presenter.
        // In most cases there will be user interactions and View lifecycle events.

    }

    interface View extends MvpView {
        // Defines what methods the Presenter can invoke on the View
        // In most cases there will be manipulating ui and displaying data or errors.

    }

    interface Interactor extends MoviperInteractor<PresenterForInteractor> {
        // Defines what methods the Presenter can invoke on the Interactor.
        // In most cases there will be data saving and querying.

    }

    interface PresenterForInteractor extends MoviperPresenterForInteractor<Interactor> {
        // Defines what methods the Interactor could invoke on the Presenter.
        // In most cases there will be data received callbacks and error notifying.

    }

    interface Routing extends MoviperViewHelperRouting<PresenterForRouting, ViewHelper> {
        // Defines what methods the Presenter can invoke on the Routing.
        // In most cases there will be starting another activities, services and using system
        // framework, ie. scheduling alarms or sending broadcasts.
        // In the case of a fragment being the view, there also will be manipulating
        // the root Activity, ie. switching fragments.

    }

    interface PresenterForRouting extends MoviperActivityPresenterForRouting<Routing> {
        // Defines what methods the Routing can invoke on the Presenter.
        // In most cases there will be system framework interaction callbacks and error notifying.

    }

    interface ViewHelper extends MoviperViewHelper {
        // Defines what Android views the Routing can get from the Viper View.
        // There should only be Android View getter methods to provide the Routing elements
        // to be used on advanced Android transitions.

    }
}
