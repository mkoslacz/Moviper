package com.mateuszkoslacz.moviper.rxsample.di;


import com.mateuszkoslacz.moviper.rxsample.di.components.DaggerRepositoryComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.DaggerSpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.RepositoryComponent;
import com.mateuszkoslacz.moviper.rxsample.di.components.SpecificationComponent;
import com.mateuszkoslacz.moviper.rxsample.di.modules.repository.UserRepositoryModule;
import com.mateuszkoslacz.moviper.rxsample.di.modules.specification.AllUsersSpecificationModule;
import com.mateuszkoslacz.moviper.rxsample.di.modules.specification.UserByUsernameStreamSpecificationModule;

/**
 * Created by bwilk on 11/24/16.
 */

public class DIProvider {

    static RepositoryComponent repositoryComponent;
    static SpecificationComponent specificationComponent;

    public static RepositoryComponent getRepositoryComponent() {
        if (repositoryComponent == null) {
            repositoryComponent = DaggerRepositoryComponent.builder()
                    .userRepositoryModule(new UserRepositoryModule())
                    .build();
        }
        return repositoryComponent;
    }

    public static SpecificationComponent getSpecificationComponent() {
        if (specificationComponent == null) {
            specificationComponent = DaggerSpecificationComponent.builder()
                    .allUsersSpecificationModule(new AllUsersSpecificationModule())
                    .userByUsernameStreamSpecificationModule(new UserByUsernameStreamSpecificationModule())
                    .build();
        }
        return specificationComponent;
    }

}
