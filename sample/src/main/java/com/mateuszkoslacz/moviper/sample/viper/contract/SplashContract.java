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
 * See {@link MainContract} to check out the freshly generated contract with usage description.
 */
public interface SplashContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewLoaded();
    }

    interface View extends MvpView {

    }

    interface Interactor extends MoviperInteractor<PresenterForInteractor> {

        void subscribeToHasActiveUserSession();
    }

    interface PresenterForInteractor extends MoviperPresenterForInteractor<Interactor> {

        /**
         * It's called a callback hell. To avoid duplicating (or even tripling if you want to
         * handle errors) move to <a href="https://github.com/ReactiveX/RxJava">rx approach</a>.
         * It will be showed in the future samples.
         *
         * @param hasActiveUserSession
         */
        void onHasActiveUserSessionResponse(boolean hasActiveUserSession);

    }

    interface Routing extends MoviperViewHelperRouting<PresenterForRouting, ViewHelper> {

        void goToMainView();

        void goToAuthorizationView();
    }

    interface PresenterForRouting extends MoviperActivityPresenterForRouting<Routing> {

    }

    interface ViewHelper extends MoviperViewHelper {

        android.view.View getLogo();
    }
}
