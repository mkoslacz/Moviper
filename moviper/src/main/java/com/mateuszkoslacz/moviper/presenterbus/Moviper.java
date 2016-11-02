package com.mateuszkoslacz.moviper.presenterbus;

import com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException;
import com.mateuszkoslacz.moviper.base.exception.PresenterInstancesAccessNotEnabled;
import com.mateuszkoslacz.moviper.base.exception.PresentersAccessUtilNotEnabled;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */
public class Moviper {

    private static final String TAG = "Moviper";

    private static final Moviper instance = new Moviper();

    private Config mConfig = new Config();

    // for every presenter complete lifecycle we do two writes (save and remove), and
    // n reads where n is the size of the presenters list.
    // for every external call we do n reads where n is the size of the presenters list.
    // that makes
    // TODO: 28.10.2016 reconsider no-checking if presenter exists
    // TODO: 28.10.2016 create config for
    // - enabling bus (and add runtime exception on getPresenters if not enabled)
    // - enabling named instance presenters (and add runtime exception on getPresenterInstance if not enabled)
    private List<MoviperPresenter> mPresenters = new CopyOnWriteArrayList<>();

    private PublishSubject<MoviperBundle> registerSynchronizer = PublishSubject.create();

    private Moviper() {
        registerSynchronizer
                .subscribeOn(Schedulers.computation())
                .subscribe(this::routeMoviperBundle);
    }

    public static Moviper getInstance() {
        return instance;
    }

    public void setConfig(Config config) {
        mConfig = config;
    }

    public void register(MoviperPresenter presenter) {
        if (mConfig.isPresenterAccessUtilEnabled()) {
            registerSynchronizer.onNext(new MoviperBundle(presenter, true));
        }
    }

    public void unregister(MoviperPresenter presenter) {
        if (mConfig.isPresenterAccessUtilEnabled()) {
            registerSynchronizer.onNext(new MoviperBundle(presenter, false));
        }
    }

    private void routeMoviperBundle(MoviperBundle bundle) {
        if (bundle.isRegister()) {
            if (mConfig.isInstancePresentersEnabled() && mPresenters.contains(bundle.getPresenter()))
                throw new PresenterAlreadyRegisteredException(bundle.getPresenter());
            registerSync(bundle.getPresenter());
        } else {
            unregisterSync(bundle.getPresenter());
        }
    }

    public <PresenterType extends MoviperPresenter> Observable<PresenterType> getPresenters(
            final Class<PresenterType> presenterTypeClass) {
        if (!mConfig.isPresenterAccessUtilEnabled()) throw new PresentersAccessUtilNotEnabled();
        return Observable.from(mPresenters)
                .filter(presenterTypeClass::isInstance)
                .map(presenterTypeClass::cast)
                .subscribeOn(Schedulers.computation()); // TODO: reconsider moving to computation scheduler
    }

    public <PresenterType extends MoviperPresenter> Observable<PresenterType> getPresenterInstance(
            final Class<PresenterType> presenterTypeClass, String name) {
        if (!mConfig.isInstancePresentersEnabled()) throw new PresenterInstancesAccessNotEnabled();
        return Observable.from(mPresenters)
                .filter(moviperPresenter -> moviperPresenter.getName().equals(name))
                .filter(presenterTypeClass::isInstance)
                .map(presenterTypeClass::cast)
                .first()
                .subscribeOn(Schedulers.computation());
    }

    private void registerSync(MoviperPresenter presenter) {
        mPresenters.add(presenter);
    }

    private void unregisterSync(MoviperPresenter presenter) {
        mPresenters.remove(presenter);
    }

    private class MoviperBundle {

        private MoviperPresenter mPresenter;

        private boolean mRegister;

        public MoviperBundle(MoviperPresenter presenter, boolean register) {
            mPresenter = presenter;
            mRegister = register;
        }

        public MoviperPresenter getPresenter() {
            return mPresenter;
        }

        public boolean isRegister() {
            return mRegister;
        }
    }

}
