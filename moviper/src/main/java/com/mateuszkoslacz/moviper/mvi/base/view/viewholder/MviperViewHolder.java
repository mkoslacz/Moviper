package com.mateuszkoslacz.moviper.mvi.base.view.viewholder;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.hannesdorfmann.mosby3.ViewGroupMviDelegate;
import com.hannesdorfmann.mosby3.ViewGroupMviDelegateCallback;
import com.hannesdorfmann.mosby3.ViewGroupMviDelegateImpl;
import com.hannesdorfmann.mosby3.mvi.MviPresenter;
import com.mateuszkoslacz.moviper.iface.view.MvpDataView;
import com.mateuszkoslacz.moviper.iface.view.ViperDataView;

/**
 * Created by tomasznajda on 16.02.2017.
 */

public abstract class MviperViewHolder
        <DataObject,
                View extends MvpDataView,
                Presenter extends MviPresenter<View, ?>>
        extends RecyclerView.ViewHolder
        implements ViewGroupMviDelegateCallback<View, Presenter>, ViperDataView<DataObject> {

    private Bundle args;
    private ViewGroupMviDelegate<View, Presenter> mvpDelegate;
    private DataObject mDataObject;

    public MviperViewHolder(android.view.View itemView) {
        super(itemView);
    }

    @NonNull
    protected ViewGroupMviDelegate<View, Presenter> getMviDelegate() {
        if (mvpDelegate == null) {
            mvpDelegate = new ViewGroupMviDelegateImpl<>(this);
        }

        return mvpDelegate;
    }

    @Override
    public Parcelable superOnSaveInstanceState() {
        return null;
    }

    @Override
    public void superOnRestoreInstanceState(Parcelable state) {

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
        getMviDelegate().onAttachedToWindow();
    }

    public void unbindPresenter() {
        getMviDelegate().onDetachedFromWindow();
    }

    @Override
    public View getMvpView() {
        return (View) this;
    }

    @Override
    public void setRestoringViewState(boolean restoringViewState) {

    }
}
