package com.mateuszkoslacz.moviper.sample.viper.view.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.mateuszkoslacz.moviper.sample.R;
import com.mateuszkoslacz.moviper.sample.viper.contract.MainContract;
import com.mateuszkoslacz.moviper.sample.viper.presenter.MainPresenter;

/**
 * Created by mateuszkoslacz on 25.07.2016.
 * <p>
 * It's just an empty activity.
 */
public class MainActivity
        // you can change base class to any Mosby Activity, ie. MvpLceActivity, MvpViewStateActivity, etc.
        extends MvpActivity<MainContract.View, MainContract.Presenter>
        implements MainContract.View, MainContract.ViewHelper {

    //Viper-framework TODOs:
    //TODO implement sample with Dagger2 Viper injection (to use in example and maybe to remove passing
    // activity through presenter to let it be android-free. another (no-dagger) option is to pass
    // newly created  routing to presenter constructor)
    //TODO implement sample with component tests using Dagger & Mocks
    //TODO implement sample presenting rx approach
    //TODO create rx versions of base classes
    //TODO add proguard rules file
    //TODO add mosby version choosing in gradle
    //TODO add own lce views with TransitionManager.beginDelayedTransition(((ViewGroup) getView())); animations
    //TODO add own lce fragments with viewGroup error

    //TODO create Android Studio plugin for creating appropriate classes and interfaces set
    // choosing root viper dir
    // choosing view name
    // choosing framework (Wipe, Viper, Perv) with use-case description
    // for Viper and Perv - choosing Activity or Fragment base
    // for Viper and Perv - choosing if ViewHelper should be included
    // for Activities - adding Activity to manifest

    public static void start(Context context) {
        Intent starter = new Intent(context, MainActivity.class);
        context.startActivity(
                starter,
                ActivityOptionsCompat.makeSceneTransitionAnimation(((Activity) context)).toBundle());
    }

    public static void startWithTransition(Activity activity, View logo) {
        Intent starter = new Intent(activity, MainActivity.class);
        ActivityOptionsCompat options = ActivityOptionsCompat
                .makeSceneTransitionAnimation(
                        activity,
                        logo,
                        activity.getString(R.string.logoTransition));
        activity.startActivity(
                starter,
                options.toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }
}
