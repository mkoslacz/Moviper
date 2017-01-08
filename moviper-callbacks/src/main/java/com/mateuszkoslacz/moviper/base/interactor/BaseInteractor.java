package com.mateuszkoslacz.moviper.base.interactor;


import android.support.annotation.Nullable;

import com.mateuszkoslacz.moviper.iface.interactor.ViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.interactor.ViperPresenterForInteractor;
import com.mateuszkoslacz.moviper.util.WeakReferenceUtils;

import java.lang.ref.WeakReference;

/**
 * Created by lucas.urbas on 29/08/15.
 * <p/>
 * Adapted and modified by mateuszkoslacz on 08.08.2016.
 * <p/>
 * Base Interactor class. (see {@link ViperInteractor})
 * <p/>
 * It's responsible for manipulating data on behalf of presenter, ie. saving data to db, getting
 * data from remotes etc.
 * <p/>
 * It provides Presenter reference to return data to it using callbacks.
 * <p/>
 * If you are looking for solution adopted to Rx approach, see {@link BaseRxInteractor}.
 */
public abstract class BaseInteractor<PresenterType extends ViperPresenterForInteractor>
        implements ViperInteractor<PresenterType> {

    @Nullable
    private WeakReference<PresenterType> presenter;

    @Nullable
    @Override
    public PresenterType getPresenter() {
        return WeakReferenceUtils.get(presenter);
    }

    @Override
    public boolean isPresenterAttached() {
        return WeakReferenceUtils.isAttached(presenter);
    }

    @Override
    public void attach(PresenterType presenter) {
        this.presenter = new WeakReference<>(presenter);
    }

    @Override
    public void detach(boolean retainInstance) {
        WeakReferenceUtils.detach(presenter);
    }

}
