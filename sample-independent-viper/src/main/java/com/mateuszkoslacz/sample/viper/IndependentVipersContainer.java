package com.mateuszkoslacz.sample.viper;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.view.ViperView;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class IndependentVipersContainer {

    private static IndependentVipersContainer instance;

    private HashMap<String, ViperPresenter> selfPresenters = new HashMap();

    public static IndependentVipersContainer get() {
        if (instance == null) instance = new IndependentVipersContainer();
        return instance;
    }

    public void startViper(String uniqueName,
                           ViperPresenter viperPresenter,
                           Context context) {
        startViper(uniqueName, viperPresenter, context, null);
    }

    public void startViper(String uniqueName,
                           ViperPresenter viperPresenter,
                           Context context, Bundle args) {
        if (selfPresenters.containsKey(uniqueName)) throw new IllegalArgumentException(
                "Presenter with unique name '" + uniqueName + "' already exist");

            selfPresenters.put(uniqueName, viperPresenter);
        viperPresenter.attachView(createViperView(context, args));
    }

    public void stopViper(String uniqueName) {
        ViperPresenter presenter = selfPresenters.get(uniqueName);
        if (presenter == null) throw new NoSuchElementException(
                "There is no presenter with unique name: " + uniqueName);

        presenter.detachView(false);
        selfPresenters.remove(uniqueName);
    }

    private ViperView createViperView(final Context context, final Bundle args) {
        return new ViperView() {
            @NonNull
            @Override
            public Context getContext() {
                return context;
            }

            @Override
            public Bundle getArgs() {
                return args;
            }
        };
    }
}
