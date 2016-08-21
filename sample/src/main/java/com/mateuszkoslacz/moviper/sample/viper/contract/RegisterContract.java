package com.mateuszkoslacz.moviper.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperFragmentPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;
import com.mateuszkoslacz.moviper.sample.data.bundle.LocationPoint;
import com.mateuszkoslacz.moviper.sample.data.bundle.RegisterBundle;

/**
 * Created by mateuszkoslacz on 10.08.2016.
 * <p>
 * See {@link MainContract} to check out the freshly generated contract with usage description.
 */
public interface RegisterContract {

    interface Presenter extends MvpPresenter<View> {

        void onRegisterClicked(RegisterBundle bundle);

        void onShowLoginFragmentClicked();
    }

    interface View extends MvpView {

        void showLoadingView();

        void displayError(String msg);
    }

    interface Interactor extends MoviperInteractor<PresenterForInteractor> {

        void register(RegisterBundle bundle, LocationPoint point);
    }

    interface PresenterForInteractor extends MoviperPresenterForInteractor<Interactor> {

        void showRegisterError(String msg);

        void proceedAfterRegister();
    }

    interface Routing extends MoviperViewHelperRouting<PresenterForRouting, ViewHelper> {

        void gotoLoginFragment();

        void goToMainActivity();

        void subscribeToGetLocalization();

        // stuff caused by Android need of registering permission result listener being
        // a fragment or activity
        void onRequestLocalizationPermissionsResult(boolean granted);

        void hideSoftKeyboard();
    }

    interface PresenterForRouting extends MoviperFragmentPresenterForRouting<Routing> {

        // stuff caused by Android need of registering permission result listener being
        // a fragment or activity
        // IT'S CALLED BY AN ACTIVITY OR A FRAGMENT!
        void onRequestLocalizationPermissionsResult(boolean granted);

        /**
         * It's called a callback hell. To avoid duplicating (or even tripling if you want to
         * handle errors) move to <a href="https://github.com/ReactiveX/RxJava">rx approach</a>.
         * It will be showed in the future samples.
         *
         * @param location
         */
        void onLocalizationAquired(LocationPoint location);

        /**
         * It's called a callback hell. To avoid duplicating (or even tripling if you want to
         * handle errors) move to <a href="https://github.com/ReactiveX/RxJava">rx approach</a>.
         * It will be showed in the future samples.
         *
         * @param message
         */
        void onLocalizationAquireFailed(String message);
    }

    interface ViewHelper extends MoviperViewHelper {
    }
}
