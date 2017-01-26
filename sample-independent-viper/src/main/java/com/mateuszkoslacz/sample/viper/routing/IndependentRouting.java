package com.mateuszkoslacz.sample.viper.routing;

import android.content.Context;
import android.widget.Toast;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.sample.viper.contract.IndependentContract;
import com.mateuszkoslacz.sample.viper.entity.User;

public class IndependentRouting
        extends BaseRxRouting<Context>
        implements IndependentContract.Routing {

    @Override
    public void showUserToast(User user) {
        if (isContextAttached())
            Toast.makeText(getRelatedContext(), user.getLogin(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorToast(Throwable throwable) {
        if (isContextAttached())
            Toast.makeText(getRelatedContext(), throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
