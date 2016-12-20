package com.mateuszkoslacz.rxpresenter.viper.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.mateuszkoslacz.moviper.base.view.activity.ViperActivity;
import com.mateuszkoslacz.rxpresenter.viper.contract.SampleContract;
import com.mateuszkoslacz.rxpresenter.viper.presenter.SamplePresenter;

import com.mateuszkoslacz.rxpresenter.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SampleActivity
        extends ViperActivity<SampleContract.View, SampleContract.Presenter>
        implements SampleContract.View {

    @BindView(R.id.txtNumber)
    TextView mTxtNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        ButterKnife.bind(this);
        getPresenter().onViewCreated(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        setRetainInstance(true);
    }

    @NonNull
    @Override
    public SampleContract.Presenter createPresenter() {
        return new SamplePresenter();
    }

    @Override
    public void showNumber(long number) {
        mTxtNumber.setText(String.valueOf(number));
    }
}
