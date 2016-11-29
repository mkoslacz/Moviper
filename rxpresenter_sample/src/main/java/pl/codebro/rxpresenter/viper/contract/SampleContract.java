package pl.codebro.rxpresenter.viper.contract;

import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.MoviperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.MoviperRxRouting;

public interface SampleContract {

    interface Presenter extends MvpPresenter<View> {

        void onViewCreated(Bundle savedInstanceState);
    }

    interface View extends MvpView {

        void showNumber(long number);
    }

    interface Interactor extends MoviperRxInteractor {

    }

    interface Routing extends MoviperRxRouting {

    }
}
