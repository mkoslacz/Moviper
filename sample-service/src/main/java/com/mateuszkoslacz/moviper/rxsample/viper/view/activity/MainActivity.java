package com.mateuszkoslacz.moviper.rxsample.viper.view.activity;

import android.support.annotation.NonNull;
import android.widget.Button;

import com.mateuszkoslacz.moviper.base.view.activity.autoinject.butterknife.ViperButterKnifeActivity;
import com.mateuszkoslacz.moviper.rxsample.R;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.rxsample.viper.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.OnClick;
import rx.Observable;
import rx.subjects.PublishSubject;

public class MainActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends ViperButterKnifeActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View {

    @BindView(R.id.button)
    Button mButton;

    PublishSubject<Object> mUserClicks = PublishSubject.create();

    @Override
    public void setButtonText(String text) {
        runOnUiThread(() -> mButton.setText(text));
    }

    @OnClick(R.id.button)
    public void onUserClick() {
        mUserClicks.onNext(null);
    }

    @Override
    public Observable getButtonClicks() {
        return mUserClicks;
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
