package com.mateuszkoslacz.moviper.presenterbus;

import com.mateuszkoslacz.moviper.base.exception.PresenterAlreadyRegisteredException;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;

import java.util.LinkedList;
import java.util.List;

import rx.Emitter;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */
public class Moviper {

    private static final Moviper instance = new Moviper();

    List<MoviperPresenter> mPresenters = new LinkedList<>();

    private Moviper() {
    }

    public static Moviper getInstance() {
        return instance;
    }

    public void register(MoviperPresenter presenter) {
        presenterWithGivenNameExists(presenter)
                .doOnNext(presenterAlreadyExists -> {
                    if (presenterAlreadyExists)
                        throw new PresenterAlreadyRegisteredException(presenter);
                })
                .doOnCompleted(() -> registerSync(presenter))
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public void unregister(MoviperPresenter presenter) {
        Observable.defer(
                () -> {
                    unregisterSync(presenter);
                    return Observable.empty();
                })
                .subscribeOn(Schedulers.io())
                .subscribe();
    }

    public <PresenterType extends MoviperPresenter> Observable<PresenterType> getPresenters(
            final Class<PresenterType> presenterTypeClass) {
        return Observable.from(mPresenters)
                .filter(presenterTypeClass::isInstance)
                .map(presenterTypeClass::cast)
                .subscribeOn(Schedulers.io()); // TODO: reconsider moving to computation scheduler
    }

    public <PresenterType extends MoviperPresenter> Observable<PresenterType> getPresenterInstance(
            final Class<PresenterType> presenterTypeClass, String name) {
        return Observable.from(mPresenters)
                .filter(moviperPresenter -> moviperPresenter.getName().equals(name))
                .filter(presenterTypeClass::isInstance)
                .map(presenterTypeClass::cast)
                .first()
                .subscribeOn(Schedulers.io());
    }

    private void registerSync(MoviperPresenter presenter) {
        mPresenters.add(presenter);
    }

    private void unregisterSync(MoviperPresenter presenter) {
        mPresenters.remove(presenter);
    }

    private Observable<Boolean> presenterWithGivenNameExists(MoviperPresenter presenter) {
        return Observable.fromEmitter(emitter -> {
            final boolean[] doesGivenPresenterExist = {false};
            Observable.from(mPresenters)
                    .filter(presenter1 -> presenter1.getClass().isInstance(presenter))
                    .filter(presenter1 -> presenter1.getName().equals(presenter.getName()))
                    .subscribe(
                            presenter1 -> doesGivenPresenterExist[0] = true,
                            emitter::onError,
                            () -> {
                                emitter.onNext(doesGivenPresenterExist[0]);
                                emitter.onCompleted();
                            });
        }, Emitter.BackpressureMode.BUFFER);
    }
}
