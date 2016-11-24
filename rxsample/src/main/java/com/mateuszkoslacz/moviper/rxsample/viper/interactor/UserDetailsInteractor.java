package com.mateuszkoslacz.moviper.rxsample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.retrofit.UserRetrofitRepository;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.retrofit.impl.UserByUsernameRetrofitStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import rx.Observable;

public class UserDetailsInteractor
        extends BaseRxInteractor
        implements UserDetailsContract.Interactor {

    private Repository<User> mUserRepository = new UserRetrofitRepository();

    @Override
    public Observable<User> getUserForUsername(String user) {
        return mUserRepository.streamQuery(getUserByUsernameSpecification(user));
    }

    private UserByUsernameStreamSpecification getUserByUsernameSpecification(String username) {
        return new UserByUsernameRetrofitStreamSpecification().setUserName(username);
    }
}
