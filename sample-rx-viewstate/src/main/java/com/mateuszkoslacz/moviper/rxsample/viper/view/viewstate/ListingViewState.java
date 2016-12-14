package com.mateuszkoslacz.moviper.rxsample.viper.view.viewstate;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.viewstate.RestorableViewState;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tomasznajda on 08.12.2016.
 */

public class ListingViewState
        implements RestorableViewState<ListingContract.View>, ListingContract.View.State {

    public static final int STATE_LOADING = 0;
    public static final int STATE_CONTENT = 1;
    private static final int STATE_ERROR = 2;
    private static final String KEY_STATE = "KEY_STATE";
    private static final String KEY_DATA = "KEY_DATA";
    private static final String KEY_ERROR = "KEY_ERROR";

    private int mState;
    private ArrayList<User> mData = new ArrayList<>();
    private Throwable mThrowable;

    @Override
    public void saveInstanceState(@NonNull Bundle out) {
        out.putInt(KEY_STATE, mState);
        out.putParcelableArrayList(KEY_DATA, mData);
        out.putSerializable(KEY_ERROR, mThrowable);
    }

    @Override
    public RestorableViewState<ListingContract.View> restoreInstanceState(Bundle in) {
        if(in == null) return null;

        mState = in.getInt(KEY_STATE);
        mData.clear();
        mData.addAll(in.getParcelableArrayList(KEY_DATA));
        mThrowable = ((Throwable) in.getSerializable(KEY_ERROR));

        return this;
    }

    @Override
    public void apply(ListingContract.View view, boolean retained) {
        if(retained) {
            switch (mState) {
                case STATE_LOADING:
                    view.showLoading();
                    return;
                case STATE_CONTENT:
                    view.setUserList(mData, true);
                    view.showContent();
                    return;
                case STATE_ERROR:
                    view.showError(mThrowable);
                    return;
            }
        }
    }

    @Override
    public void setUserList(List<User> userList) {
        mData.clear();
        mData.addAll(userList);
    }

    @Override
    public void setError(Throwable throwable) {
        mThrowable = throwable;
        mState = STATE_ERROR;
    }

    @Override
    public void setState(int state) {
        mState = state;
    }
}
