package com.mateuszkoslacz.moviper.base.presenter;


import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

public abstract class MoviperBasePresenter<V extends MvpView>
        extends MvpBasePresenter<V>
        implements MoviperPresenter<V> {

    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getName() {
        return DEFAULT_NAME;
    }

    @Override
    public void attachView(V view) {
        super.attachView(view);
        Moviper.getInstance().register(this);
    }

    @Override
    public void detachView(boolean retainInstance) {
        Moviper.getInstance().unregister(this);
        super.detachView(retainInstance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MoviperBasePresenter)) return false;

        MoviperBasePresenter<?> that = (MoviperBasePresenter<?>) o;

        if (!getName().equals(that.getName())) return false;
        return getClassName().equals(that.getClassName());

    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getClassName().hashCode();
        return result;
    }
}
