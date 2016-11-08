package com.mateuszkoslacz.moviper.ipcsample.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.ipcsample.R;
import com.mateuszkoslacz.moviper.ipcsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.ipcsample.viper.presenter.MainPresenter;

public class MainActivity
        extends MvpActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPresenter().onViewCreated();
    }

    @Override
    public int getViewIdFragmentFirst() {
        return R.id.fragment_first;
    }

    @Override
    public int getViewIdFragmentSecond() {
        return R.id.fragment_second;
    }

    @Override
    public int getViewIdFragmentThird() {
        return R.id.fragment_third;
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }
}
