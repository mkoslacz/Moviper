package com.mateuszkoslacz.moviper.recyclerviewsample.viper.base;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegate;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegateImpl;

/**
 * Created by norbertbanaszek on 24.10.2016.
 */

public abstract class MvpViewHolder <V extends MvpView, P extends MvpPresenter<V>>
        extends RecyclerView.ViewHolder
        implements BaseMvpDelegateCallback<V, P>, MvpView {

    protected P presenter;
    protected ViewGroupMvpDelegate<V, P> mvpDelegate;

    public MvpViewHolder(View itemView) {
        super(itemView);
    }

    @NonNull protected ViewGroupMvpDelegate<V, P> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ViewGroupMvpDelegateImpl<>(this);
        }

        return mvpDelegate;
    }

    public void bindPresenter() {
        getMvpDelegate().onAttachedToWindow();
    }

    public void unbindPresenter() {
        getMvpDelegate().onDetachedFromWindow();
    }

    public abstract P createPresenter();

    @Override public P getPresenter() {
        return presenter;
    }

    @Override public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Override public V getMvpView() {
        return (V) this;
    }

    @Override public boolean isRetainInstance() {
        return true;
    }

    @Override public void setRetainInstance(boolean retainingInstance) {
        throw new UnsupportedOperationException("Retainining Instance is not supported / implemented yet");
    }

    @Override public boolean shouldInstanceBeRetained() {
        return true;
    }

 }