package pl.codebro.rxpresenter.viper.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.app.Activity;
import android.util.Log;

import com.mateuszkoslacz.moviper.base.presenter.ViperActivityBaseRxPresenter;

import pl.codebro.rxpresenter.viper.contract.SampleContract;
import pl.codebro.rxpresenter.viper.routing.SampleRouting;
import pl.codebro.rxpresenter.viper.interactor.SampleInteractor;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SamplePresenter
        extends ViperActivityBaseRxPresenter
                <SampleContract.View,
                        SampleContract.Interactor,
                        SampleContract.Routing>
        implements SampleContract.Presenter {

    public SamplePresenter(Activity activity) {
        super(activity);
    }

    @NonNull
    @Override
    public SampleContract.Routing createRouting(@NonNull Activity activity) {
        return new SampleRouting(activity);
    }

    @NonNull
    @Override
    public SampleContract.Interactor createInteractor() {
        return new SampleInteractor();
    }

    @Override
    public void onViewCreated(Bundle savedInstanceState) {
        if (savedInstanceState != null) return;

        addSubscription(Observable.interval(500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(number -> {
                    getView().showNumber(number);
                }, Throwable::printStackTrace));
    }
}
