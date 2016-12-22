package com.mateuszkoslacz.moviper.presenterbus;

import android.app.Application;
import android.support.annotation.VisibleForTesting;

import com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException;
import com.mateuszkoslacz.moviper.base.exception.PresenterInstancesAccessNotEnabled;
import com.mateuszkoslacz.moviper.base.exception.PresentersAccessUtilNotEnabled;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

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
    private List<ViperPresenter> mPresenters = new CopyOnWriteArrayList<>();

    private PublishSubject<MoviperBundle> registerSynchronizer = PublishSubject.create();

    private Moviper() {
        registerSynchronizer
                .subscribeOn(Schedulers.computation())
                .subscribe(this::routeMoviperBundle);
    }

    public static Moviper getInstance() {
        return instance;
    }

    /**
     * Use it in {@link Application#onCreate()} to setup IPC and IPC Instance Presenter Access to
     * let you make use of {@link #getPresenters(Class)} and {@link #getPresenterInstance(Class,
     * String)}.
     */
    public void setConfig(Config config) {
        mConfig = config;
    }

    public void register(ViperPresenter presenter) {
        if (mConfig.isPresenterAccessUtilEnabled()) {
            registerSynchronizer.onNext(new MoviperBundle(presenter, true));
        }
    }

    public void unregister(ViperPresenter presenter) {
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

    /**
     * * Make sure that you have enabled IPC Instance Presenter Access by using {@link
     * #setConfig(Config)} with {@link Config.Builder#withPresenterAccessUtilEnabled(boolean)} set
     * to true to avoid {@link PresenterInstancesAccessNotEnabled}
     *
     * @param presenterTypeClass class of presenters you want to get
     * @return {@link Observable} that emmits all (from zero to n) registered presenters of given
     * class. It operates on the {@link Schedulers#computation()}.
     */
    public <PresenterType extends ViperPresenter> Observable<PresenterType> getPresenters(
            final Class<PresenterType> presenterTypeClass) {
        if (!mConfig.isPresenterAccessUtilEnabled()) throw new PresentersAccessUtilNotEnabled();
        return Observable.from(mPresenters)
                .filter(presenterTypeClass::isInstance)
                .map(presenterTypeClass::cast)
                .subscribeOn(Schedulers.computation()); // TODO: reconsider moving to computation scheduler
    }

    /**
     * Make sure that you have fulfilled the requirements of ue the general IPC ({@link
     * #getPresenters(Class)}.
     * <p/>
     * Make sure that you have enabled IPC Instance Presenter Access by using {@link
     * #setConfig(Config)} with {@link Config.Builder#withInstancePresentersEnabled(boolean)} set to
     * true to avoid {@link PresenterInstancesAccessNotEnabled}
     * <p/>
     * If you create two presenters with the same name (not assuring that this method will return an
     * unique name for each presenter) with the IPC Instance Presenters Access enabled, a {@link
     * com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException} is thrown.
     *
     * @param presenterTypeClass class of presenter you want to get
     * @param name               name of a presenter you want to get here. You shall set it up by
     *                           returning proper name in {@link ViperPresenter#getName()}.
     * @return {@link Observable} that emits (or not) Presenter instance of given name and class.
     */
    public <PresenterType extends ViperPresenter> Observable<PresenterType> getPresenterInstance(
            final Class<PresenterType> presenterTypeClass, String name) {
        if (!mConfig.isInstancePresentersEnabled()) throw new PresenterInstancesAccessNotEnabled();
        return Observable.from(mPresenters)
                .filter(moviperPresenter -> moviperPresenter.getName().equals(name))
                .filter(presenterTypeClass::isInstance)
                .map(presenterTypeClass::cast)
                .first()
                .subscribeOn(Schedulers.computation());
    }

    private void registerSync(ViperPresenter presenter) {
        mPresenters.add(presenter);
    }

    private void unregisterSync(ViperPresenter presenter) {
        mPresenters.remove(presenter);
    }

    @VisibleForTesting
    public void unregisterAll() {
        mPresenters.clear();
    }

    private class MoviperBundle {

        private ViperPresenter mPresenter;

        private boolean mRegister;

        public MoviperBundle(ViperPresenter presenter, boolean register) {
            mPresenter = presenter;
            mRegister = register;
        }

        public ViperPresenter getPresenter() {
            return mPresenter;
        }

        public boolean isRegister() {
            return mRegister;
        }
    }

}
