package com.mateuszkoslacz.moviper.rxsample.viper.server;

import android.content.Context;
import android.content.Intent;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by bwilk on 12/22/16.
 */

public class Config<ViewType extends MvpView> {

    Context context;
    Intent intent;
    ViperPresenter<ViewType> presenter;

    private Config(Builder builder) {
        context = builder.context;
        intent = builder.intent;
        presenter = builder.presenter;
    }

    public static final class Builder<ViewType extends MvpView> {

        private Context context;
        private Intent intent;
        private ViperPresenter<ViewType> presenter;

        public Builder() {
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

        public Config build() {
            return new Config(this);
        }
    }
}
