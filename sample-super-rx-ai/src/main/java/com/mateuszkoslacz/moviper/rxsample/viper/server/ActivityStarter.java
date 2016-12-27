package com.mateuszkoslacz.moviper.rxsample.viper.server;

import android.content.Context;
import android.content.Intent;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by bwilk on 12/22/16.
 */

public class ActivityStarter {

    private Context mContext;
    private Intent mIntent;
    private ViperPresenter mPresenter;

    public Context getContext() {
        return mContext;
    }

    public Intent getIntent() {
        return mIntent;
    }

    public ViperPresenter getPresenter() {
        return mPresenter;
    }

    private ActivityStarter(Builder builder) {
        mContext = builder.context;
        mIntent = builder.intent;
        mPresenter = builder.presenter;
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    public static final class Builder<ViewType extends MvpView> {

        private Context context;
        private Intent intent;
        private ViperPresenter<ViewType> presenter;

        private Builder() {
        }

        public Builder withContext(Context val) {
            context = val;
            return this;
        }

        public Builder withIntent(Intent val) {
            intent = val;
            return this;
        }

        public Builder withPresenter(ViperPresenter<ViewType> val) {
            presenter = val;
            return this;
        }

        public ActivityStarter build() {
            return new ActivityStarter(this);
        }
    }
}
