package com.mateuszkoslacz.moviper.mvi.base.presenter;

import android.os.Bundle;

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by mateuszkoslacz on 14.02.2017.
 */

public abstract class CommonMviBasePresenter<ViewType extends MvpView, ViewStateType>
        extends MviBasePresenter<ViewType, ViewStateType>
        implements ViperPresenter<ViewType> {

    private Bundle args;

    CommonMviBasePresenter() {
    }

    CommonMviBasePresenter(Bundle args) {
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
        if (!(o instanceof CommonMviBasePresenter)) return false;

        CommonMviBasePresenter<?, ?> that = (CommonMviBasePresenter<?, ?>) o;

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
