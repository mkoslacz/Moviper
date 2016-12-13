package com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream;

import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.base.StreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

/**
 * Created by jjodelka on 23/11/2016.
 */
public interface UserByUsernameStreamSpecification extends StreamSpecification<User> {

    UserByUsernameStreamSpecification setUserName(String userName);
}
