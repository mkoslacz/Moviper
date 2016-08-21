package com.mateuszkoslacz.moviper.sample.data.parse;

import com.mateuszkoslacz.moviper.sample.util.StringUtils;
import com.parse.ParseClassName;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;

/**
 * Created by mateuszkoslacz on 11.08.2016.
 */
@ParseClassName(User.PARSE_CLASS_NAME)
public class User extends ParseUser {

    public static final String PARSE_CLASS_NAME = "_User";

    public static final String C_LOCALIZATION_PGP = "currentPosition";

    // just for reference
    private static ParseGeoPoint localization;

    public ParseGeoPoint getLocalization() {
        return getParseGeoPoint(C_LOCALIZATION_PGP);
    }

    public void setLocalization(ParseGeoPoint localization) {
        put(C_LOCALIZATION_PGP, localization);
    }

    public static class Builder {
        private String login;
        private String email;
        private String password;
        private ParseGeoPoint localization;


        public Builder withLogin(String login) {
            this.login = login;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder withLocalization(ParseGeoPoint localization) {
            this.localization = localization;
            return this;
        }

        public User build() {
            interruptEarlyIfNoEssentialDataProvided();
            User user = ParseUser.create(User.class);
            user.setUsername(login);
            user.setEmail(email);
            user.setPassword(password);
            if (localization != null) user.setLocalization(localization);
            return user;
        }

        private void interruptEarlyIfNoEssentialDataProvided() {
            if (StringUtils.isNullOrEmpty(login) ||
                    StringUtils.isNullOrEmpty(password) ||
                    StringUtils.isNullOrEmpty(email)) {
                throw new RuntimeException(
                        String.format("No essential data provided! " +
                                        "login: %s, password: %s, email: %s",
                                login, password, email));
            }
        }
    }
}
