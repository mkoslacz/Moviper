package com.mateuszkoslacz.moviper.rxsample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.specification.stream.UserByUsernameStreamSpecification;
import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.UserDetailsContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import rx.Observable;

public class UserDetailsInteractor
        extends BaseRxInteractor
        implements UserDetailsContract.Interactor {

    Repository<User> mUserRepository;
    UserByUsernameStreamSpecification mUserByUsernameStreamSpecification;

    public UserDetailsInteractor() {
        mUserRepository = DIProvider.getRepositoryComponent().provideUserRepository();
        mUserByUsernameStreamSpecification = DIProvider.getSpecificationComponent().provideUserByUsernameStreamSpecification();
    }

    @Override
    public Observable<User> getUserForUsername(String user) {
        return mUserRepository.streamQuery(mUserByUsernameStreamSpecification.setUserName(user));
    }

}
