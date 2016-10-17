package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.RxContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.RxPresenter;

public class RxActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<RxContract.View, RxContract.Presenter>
        implements RxContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx);
    }

    @NonNull
    @Override
    public RxContract.Presenter createPresenter() {
        return new RxPresenter(this);
    }
}
