package com.mateuszkoslacz.moviper.rxsample.viper.interactor;

import com.mateuszkoslacz.moviper.base.interactor.BaseRxInteractor;
import com.mateuszkoslacz.moviper.rxsample.data.rdp.repository.Repository;
import com.mateuszkoslacz.moviper.rxsample.di.DIProvider;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.ListingContract;
import com.mateuszkoslacz.moviper.rxsample.viper.entity.User;

import java.util.List;

import io.reactivex.Observable;

public class ListingInteractor
        extends BaseRxInteractor
        implements ListingContract.Interactor {

    private Repository<User> mUserRepository;

    public ListingInteractor() {
        mUserRepository = DIProvider.getInstance().getRepositoryComponent().provideUserRepository();
    }

    @Override
    public Observable<List<User>> getUserList() {
        return mUserRepository.query(
                DIProvider.getInstance()
                        .getSpecificationComponent()
                        .provideAllUsersSpecification()
        );
    }
}
