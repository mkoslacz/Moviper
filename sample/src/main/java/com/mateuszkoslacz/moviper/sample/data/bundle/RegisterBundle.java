package com.mateuszkoslacz.moviper.sample.data.bundle;


import com.mateuszkoslacz.moviper.sample.util.StringUtils;

/**
 * Created by mateuszkoslacz on 12.08.2016.
 * <p>
 * Created to avoid passing 3 arguments to register methods.
 */
public class RegisterBundle {

    private final String login;
    private final String email;
    private final String password;

    private RegisterBundle(Builder builder) {
        login = builder.login;
        email = builder.email;
        password = builder.password;
    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public boolean isComplete() {
        return !StringUtils.isNullOrEmpty(login) &&
                !StringUtils.isNullOrEmpty(email) &&
                !StringUtils.isNullOrEmpty(password);
    }

    public static final class Builder {
        private String login;
        private String email;
        private String password;

        public Builder() {
        }

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

        public RegisterBundle build() {
            return new RegisterBundle(this);
        }
    }

}
