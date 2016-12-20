package com.mateuszkoslacz.moviper.base.presenter;


import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.MoviperPresenter;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

public abstract class CommonBasePresenter<V extends MvpView>
        extends MvpBasePresenter<V>
        implements MoviperPresenter<V> {

    private Bundle args;

    public CommonBasePresenter() {
    }

    public CommonBasePresenter(Bundle args) {
        this.args = args;
    }

    public String getClassName() {
        return getClass().getName();
    }

    @Override
    public String getName() {
        return DEFAULT_NAME;
    }

    public Bundle getArgs() {
        return args;
    }

    public void setArgs(Bundle args) {
        this.args = args;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonBasePresenter)) return false;

        CommonBasePresenter<?> that = (CommonBasePresenter<?>) o;

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
