package com.mateuszkoslacz.moviper.server;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;
import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

/**
 * Created by bwilk on 12/22/16.
 */

public class ActivityStarter {

    @NonNull
    private Context mContext;
    @NonNull
    private Intent mIntent;
    @NonNull
    private ViperPresenter mPresenter;

    @NonNull
    public Context getContext() {
        return mContext;
    }

    @NonNull
    public Intent getIntent() {
        return mIntent;
    }

    @NonNull
    public ViperPresenter getPresenter() {
        return mPresenter;
    }

    private ActivityStarter(Builder builder) {
        mContext = builder.context;
        mIntent = builder.intent;
        mPresenter = builder.presenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ActivityStarter that = (ActivityStarter) o;

//        if (!getIntent().equals(that.getIntent())) return false; // intent has no custom equals method
        return getPresenter().equals(that.getPresenter());

    }

    @Override
    public int hashCode() {
        int result = getIntent().hashCode();
        result = 31 * result + getPresenter().hashCode();
        return result;
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

        public Builder withContext(@NonNull Context val) {
            context = val;
            return this;
        }

        public Builder withIntent(@NonNull Intent val) {
            intent = val;
            return this;
        }

        public Builder withPresenter(@NonNull ViperPresenter<ViewType> val) {
            presenter = val;
            return this;
        }

        public ActivityStarter build() {
            if (context == null) {
                throw new RuntimeException("Context in ActivityStarter cannot be null!");
            }
            if (intent == null) {
                throw new RuntimeException("Intent in ActivityStarter cannot be null!");
            }
            if (presenter == null) {
                throw new RuntimeException("Presenter in ActivityStarter cannot be null!");
            }
            return new ActivityStarter(this);
        }
    }
}
