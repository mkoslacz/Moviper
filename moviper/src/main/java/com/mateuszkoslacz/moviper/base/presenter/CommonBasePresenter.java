package com.mateuszkoslacz.moviper.base.presenter;


import android.os.Bundle;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

abstract class CommonBasePresenter<V extends MvpView>
        extends MvpBasePresenter<V>
        implements ViperPresenter<V> {

    private Bundle args;

    CommonBasePresenter() {

    }

    CommonBasePresenter(Bundle args) {
        this.args = args;
    }

    private String getClassName() {
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
