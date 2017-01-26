package com.mateuszkoslacz.moviper.base.view.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.hannesdorfmann.mosby.mvp.delegate.BaseMvpDelegateCallback;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegate;
import com.hannesdorfmann.mosby.mvp.delegate.ViewGroupMvpDelegateImpl;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;
import com.mateuszkoslacz.moviper.iface.view.ViperDataView;

/**
 * Created by norbertbanaszek on 24.10.2016.
 * <p>
 * An {@link RecyclerView.Adapter} that uses an {@link MvpPresenter} to implement a
 * Model-View-Presenter
 * architecture.
 */

public abstract class ViperViewHolder<DataObject, View extends MvpDataView, Presenter extends MvpPresenter<View>>
        extends RecyclerView.ViewHolder
        implements BaseMvpDelegateCallback<View, Presenter>, ViperDataView<DataObject> {

    private Bundle args;
    private Presenter mPresenter;
    private ViewGroupMvpDelegate<View, Presenter> mvpDelegate;
    private DataObject mDataObject;

    public ViperViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @NonNull
    private ViewGroupMvpDelegate<View, Presenter> getMvpDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ViewGroupMvpDelegateImpl<>(this);
        }

        return mvpDelegate;
    }

    @NonNull
    public Context getContext() {
        return itemView.getContext();
    }

    @Override
    public Bundle getArgs() {
        return args;
    }

    public void setArgs(Bundle args) {
        this.args = args;
    }

    @Override
    public DataObject getDataObject() {
        return mDataObject;
    }

    @Override
    public void setDataObject(DataObject dataObject) {
        mDataObject = dataObject;
    }

    public void bindPresenter() {
        getMvpDelegate().onAttachedToWindow();
    }

    public void unbindPresenter() {
        getMvpDelegate().onDetachedFromWindow();
    }

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public View getMvpView() {
        return (View) this;
    }

    @Override
    public boolean isRetainInstance() {
        return true;
    }

    @Override
    public void setRetainInstance(boolean retainingInstance) {
        throw new UnsupportedOperationException("Retaining Instance is not supported / implemented yet");
    }

    @Override
    public boolean shouldInstanceBeRetained() {
        return true;
    }

}
