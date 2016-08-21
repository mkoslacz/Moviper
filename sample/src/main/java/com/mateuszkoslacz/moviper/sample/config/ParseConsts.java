package com.mateuszkoslacz.moviper.sample.config;

/**
 * Created by mateuszkoslacz on 12.08.2016.
 * <p>
 * If you want to see how logging in and stuff works in action you have to run your own
 * parse local instance described <a href="http://google.com">here</a> and change constants in
 * this class to point there. This sample should be probably migrated to some mocked up db-based
 * local logging in, but actually it's not needed to understand concepts of viper architecture.
 */
public class ParseConsts {

    public static final String SERVER_URL = "http://your.parse.server.com";
    public static final String PARSE_PATH = "/parse";
    public static final String APP_ID = "myAppId";
}
