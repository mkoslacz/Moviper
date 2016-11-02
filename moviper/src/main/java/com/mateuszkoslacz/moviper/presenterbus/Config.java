package com.mateuszkoslacz.moviper.presenterbus;

/**
 * Created by mateuszkoslacz on 29.10.2016.
 */
public class Config {

    private boolean presenterAccessUtilEnabled;

    private boolean instancePresentersEnabled;

    Config(){};

    private Config(Builder builder) {
        presenterAccessUtilEnabled = builder.presenterAccessUtilEnabled;
        instancePresentersEnabled = builder.instancePresentersEnabled;
    }

    public boolean isPresenterAccessUtilEnabled() {
        return presenterAccessUtilEnabled;
    }

    public boolean isInstancePresentersEnabled() {
        return instancePresentersEnabled;
    }

    public static final class Builder {
        private boolean presenterAccessUtilEnabled;
        private boolean instancePresentersEnabled;

        public Builder() {
        }

        public Builder withPresenterAccessUtilEnabled(boolean presenterAccessUtilEnabled) {
            this.presenterAccessUtilEnabled = presenterAccessUtilEnabled;
            return this;
        }

        public Builder withInstancePresentersEnabled(boolean instancePresentersEnabled) {
            this.instancePresentersEnabled = instancePresentersEnabled;
            return this;
        }

        public Config build() {
            return new Config(this);
        }
    }
}
