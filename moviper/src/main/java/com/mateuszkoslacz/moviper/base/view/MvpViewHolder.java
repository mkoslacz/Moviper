package com.mateuszkoslacz.moviper.base.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.MvpView;
import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegate;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegateImpl;

/**
 * Created by norbertbanaszek on 24.10.2016.
 * <p>
 * An {@link RecyclerView.Adapter} that uses an {@link MvpPresenter} to implement a Model-View-Presenter
 * architecture.
 */

public abstract class MvpViewHolder <View extends MvpView, Presenter extends MvpPresenter<View>>
        extends RecyclerView.ViewHolder
        implements BaseMvpDelegateCallback<View, Presenter>, MvpView {

    protected Presenter mPresenter;
    protected ViewGroupMvpDelegate<View, Presenter> mvpDelegate;

    public MvpViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @NonNull protected ViewGroupMvpDelegate<View, Presenter> getMvpDelegate() {
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

    public abstract Presenter createPresenter();

    @Override public Presenter getPresenter() {
        return mPresenter;
    }

    @Override public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override public View getMvpView() {
        return (View) this;
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