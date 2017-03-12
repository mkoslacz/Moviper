package com.mateuszkoslacz.sample.viper.contract;

import android.content.Context;

import com.mateuszkoslacz.moviper.iface.interactor.ViperRxInteractor;
import com.mateuszkoslacz.moviper.iface.routing.ViperRxRouting;
import com.mateuszkoslacz.sample.viper.entity.User;

import java.util.List;

import io.reactivex.Observable;

public interface IndependentContract {

    interface Interactor extends ViperRxInteractor {

        Observable<List<User>> getUserList();
    }

    interface Routing extends ViperRxRouting<Context> {

        void showUserToast(User user);

        void showErrorToast(Throwable throwable);
    }
}
