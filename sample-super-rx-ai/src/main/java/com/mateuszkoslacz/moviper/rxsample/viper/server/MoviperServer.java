package com.mateuszkoslacz.moviper.rxsample.viper.server;

import android.util.SparseArray;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

import java.util.Random;

/**
 * Created by bwilk on 12/22/16.
 */
public class MoviperServer {

    public static final String VIEW_ID_EXTRA = "VIEW_ID_EXTRA";
    private static MoviperServer instance;
    private SparseArray<ViperPresenter<MvpView>> presentersRepository = new SparseArray<>();

    public static MoviperServer getInstance() {
        if (instance == null) {
            instance = new MoviperServer();
        }
        return instance;
    }

    private MoviperServer() {
    }

    public <ViewType extends MvpView> ViperPresenter<ViewType> getPresenterForView(int viewId) {
        return (ViperPresenter<ViewType>) presentersRepository.get(viewId);
    }

    public <ViewType extends MvpView> void startActivity(Config<ViewType> config) {
        int viewId = new Random().nextInt();
        config.intent.putExtra(VIEW_ID_EXTRA, viewId);
        presentersRepository.put(viewId, (ViperPresenter<MvpView>) config.presenter);
        config.context.startActivity(config.intent);
    }
}
