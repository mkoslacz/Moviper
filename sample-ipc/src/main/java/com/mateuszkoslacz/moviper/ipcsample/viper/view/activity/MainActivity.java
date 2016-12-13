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
    public int getViewSlotIdForPosition(int position) {
        switch (position) {
            case 1:
                return R.id.fragment_first;
            case 2:
                return R.id.fragment_second;
            case 3:
                return R.id.fragment_third;
            default:
                throw new RuntimeException("Unexpected view position!");
        }
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }
}