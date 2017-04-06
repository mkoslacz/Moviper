package com.mateuszkoslacz.moviper.base.presenter;


import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.interactor.CommonViperInteractor;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.moviper.iface.routing.CommonViperRouting;

import java.util.Random;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 */

abstract class CommonBasePresenter
        <ViewType extends MvpView>
        extends MvpBasePresenter<ViewType>
    implements ViperPresenter<ViewType>{

    private Bundle args;

    CommonBasePresenter() {

    }

    CommonBasePresenter(Bundle args) {
        this.args = args;
    }

    @Override
    @NonNull
    public String getName() {
        return this.getClassName() + "_" + new Random().nextInt();
    }

    public Bundle getArgs() {
        return args;
    }

    public void setArgs(Bundle args) {
        this.args = args;
    }

    private String getClassName() {
        return getClass().getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommonBasePresenter)) return false;

        CommonBasePresenter<?> that = (CommonBasePresenter<?>) o;

        return this.getName().equals(that.getName()) && this.getClassName().equals(that.getClassName());
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + getClassName().hashCode();
        return result;
    }
}
