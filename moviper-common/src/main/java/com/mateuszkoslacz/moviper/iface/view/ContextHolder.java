package com.mateuszkoslacz.moviper.iface.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by mateuszkoslacz on 15.12.2016.
 * <p>
 * It's used for providing Context to the routing. Used in pair with {@link MvpView} in Moviper
 * views.
 * It's used in ViperService.
 */


public interface ContextHolder {

    @NonNull
    Context getContext();

    Bundle getArgs();
}
