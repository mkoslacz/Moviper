package com.mateuszkoslacz.sample.viper.view.activity;

import android.support.annotation.NonNull;
import android.widget.Button;

import com.jakewharton.rxbinding.view.RxView;
import com.mateuszkoslacz.moviper.base.view.activity.autoinject.passive.butterknife.ViperButterKnifePassiveActivity;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;
import com.mateuszkoslacz.sample.R;
import com.mateuszkoslacz.sample.viper.contract.MainContract;
import com.mateuszkoslacz.sample.viper.presenter.MainPresenter;

import butterknife.BindView;
import rx.Observable;

public class MainActivity
        extends ViperButterKnifePassiveActivity<MainContract.View>
        implements MainContract.View {

    @BindView(R.id.btnStop)
    Button btnStop;
    @BindView(R.id.btnStart)
    Button btnStart;

    @NonNull
    @Override
    public ViperPresenter<MainContract.View> createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void enableStart() {
        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
    }

    @Override
    public void enableStop() {
        btnStart.setEnabled(false);
        btnStop.setEnabled(true);
    }

    @Override
    public Observable<Void> onStartClicks() {
        return RxView.clicks(btnStart);
    }

    @Override
    public Observable<Void> onStopClicks() {
        return RxView.clicks(btnStop);
    }
}
