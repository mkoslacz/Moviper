package com.mateuszkoslacz.moviper.tests.rules;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;

import com.mateuszkoslacz.moviper.base.presenter.BaseRxPresenter;
import com.mateuszkoslacz.moviper.presenterbus.Moviper;

/**
 * Created by bwilk on 12/8/16.
 */
public class MoviperActivityTestRule<ActivityType extends Activity>
        extends ActivityTestRule<ActivityType> {

    public MoviperActivityTestRule(Class activityClass) {
        super(activityClass);
    }

    @Override
    protected void afterActivityFinished() {
            /*
                We need to unregister presenters manually because of threading issues.
                Ex: Sometimes the fragment's presenter inside the first test is not unregistered
                when we call another test and the same presenter is trying to be registered again.
             */
        super.afterActivityFinished();
        Moviper.getInstance().getPresenters(BaseRxPresenter.class)
                .subscribe(Moviper.getInstance()::unregister);
    }
}
