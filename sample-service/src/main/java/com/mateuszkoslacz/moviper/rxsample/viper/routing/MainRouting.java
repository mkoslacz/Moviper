package com.mateuszkoslacz.moviper.rxsample.viper.routing;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;

import com.mateuszkoslacz.moviper.base.routing.BaseRxRouting;
import com.mateuszkoslacz.moviper.rxsample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.rxsample.viper.service.SampleService;

public class MainRouting
        extends BaseRxRouting<Activity>
        implements MainContract.Routing {

    private Class<?> sampleService = SampleService.class;

    @Override
    public void startService() {
        getRelatedContext().startService(new Intent((getRelatedContext()), sampleService));
    }

    @Override
    public void stopService() {
        getRelatedContext().stopService(new Intent((getRelatedContext()), sampleService));
    }

    @Override
    public void showToastWithUsername(String username) {
        getRelatedContext().runOnUiThread(()
                -> Toast.makeText(getRelatedContext(), username, Toast.LENGTH_SHORT).show());
    }
}
