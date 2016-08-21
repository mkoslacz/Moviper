package com.mateuszkoslacz.moviper.sample.data.parse.util;

import android.app.Application;

import com.mateuszkoslacz.moviper.sample.config.ParseConsts;
import com.mateuszkoslacz.moviper.sample.data.parse.User;
import com.parse.Parse;
import com.parse.ParseObject;

/**
 * Created by mateuszkoslacz on 12.08.2016.
 */
public class ParseInitializator {

    public static void init(Application app) {
        registerSubclasses();
        initializeParse(app);
    }

    /**
     * Remember to register all of your subclasses here.
     */
    private static void registerSubclasses() {
        ParseObject.registerSubclass(User.class);
    }

    private static void initializeParse(Application app) {
        Parse.initialize(new Parse.Configuration.Builder(app)
                .applicationId(ParseConsts.APP_ID)
                .server(ParseConsts.SERVER_URL + ParseConsts.PARSE_PATH)
                .build());
    }
}
