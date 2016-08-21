package com.mateuszkoslacz.moviper.sample.viper.contract;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.MoviperPresenterForInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.routing.MoviperFragmentPresenterForRouting;
import com.mateuszkoslacz.moviper.iface.routing.MoviperViewHelperRouting;
import com.mateuszkoslacz.moviper.iface.viewhelper.MoviperViewHelper;

/**
 * Created by mateuszkoslacz on 10.08.2016.
 * <p>
 * See {@link MainContract} to check out the freshly generated contract with usage description.
 */
public interface LoginContract {

    interface Presenter extends MvpPresenter<View> {

        void onLoginClicked(String username, String password);

        void onShowRegisterFragmentClicked();
    }

    interface View extends MvpLceView<Object> {

        // all lce methods provided by Mosby MvpLceView

    }

    interface Interactor extends MoviperInteractor<PresenterForInteractor> {

        void login(String username, String password);
    }

    interface PresenterForInteractor extends MoviperPresenterForInteractor<Interactor> {

        /**
         * It's called a callback hell. To avoid duplicating (or even tripling if you want to
         * handle errors) move to <a href="https://github.com/ReactiveX/RxJava">rx approach</a>.
         * It will be showed in the future samples.
         *
         * @param e
         */
        void showLoginError(Throwable e);

        /**
         * It's called a callback hell. To avoid duplicating (or even tripling if you want to
         * handle errors) move to <a href="https://github.com/ReactiveX/RxJava">rx approach</a>.
         * It will be showed in the future samples.
         */
        void proceedAfterLogin();
    }

    interface Routing extends MoviperViewHelperRouting<PresenterForRouting, ViewHelper> {

        void gotoRegisterFragment();

        void goToMainActivity();

        void hideSoftKeyboard();
    }

    interface PresenterForRouting extends MoviperFragmentPresenterForRouting<Routing> {

    }

    interface ViewHelper extends MoviperViewHelper {

        android.view.View getLoadingLogo();
    }


}
