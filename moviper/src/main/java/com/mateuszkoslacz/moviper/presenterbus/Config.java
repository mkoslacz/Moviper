package com.mateuszkoslacz.moviper.presenterbus;

import com.mateuszkoslacz.moviper.base.exception.PresenterInstancesAccessNotEnabled;
import com.mateuszkoslacz.moviper.base.exception.PresentersAccessUtilNotEnabled;

/**
 * Created by mateuszkoslacz on 29.10.2016.
 *
 * Pass it to {@link Moviper#setConfig(Config)} to enable IPC and IPC Presenter Instance Access in
 * app.
 */
public class Config {

    private boolean presenterAccessUtilEnabled;

    private boolean instancePresentersEnabled;

    Config() {
    }

    private Config(Builder builder) {
        presenterAccessUtilEnabled = builder.presenterAccessUtilEnabled;
        instancePresentersEnabled = builder.instancePresentersEnabled;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    boolean isPresenterAccessUtilEnabled() {
        return presenterAccessUtilEnabled;
    }

    boolean isInstancePresentersEnabled() {
        return instancePresentersEnabled;
    }


    public static final class Builder {
        private boolean presenterAccessUtilEnabled;
        private boolean instancePresentersEnabled;

        public Builder() {
        }

        /**
         * Set it to true if you want to use IPC {@link Moviper#getPresenters(Class)}. Enabling it
         * lets you avoid {@link PresentersAccessUtilNotEnabled} exceptions.
         */
        public Builder withPresenterAccessUtilEnabled(boolean presenterAccessUtilEnabled) {
            this.presenterAccessUtilEnabled = presenterAccessUtilEnabled;
            return this;
        }

        /**
         * Set it to true if you want to use IPC Presenter Instance Access {@link
         * Moviper#getPresenterInstance(Class, String)}. Enabling it lets you avoid {@link
         * PresenterInstancesAccessNotEnabled} exceptions.
         */
        public Builder withInstancePresentersEnabled(boolean instancePresentersEnabled) {
            this.instancePresentersEnabled = instancePresentersEnabled;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
