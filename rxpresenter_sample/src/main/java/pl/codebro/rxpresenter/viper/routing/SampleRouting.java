package pl.codebro.rxpresenter.viper.routing;

import android.support.annotation.NonNull;
import android.app.Activity;

import com.mateuszkoslacz.moviper.base.routing.ActivityBaseRxRouting;

import pl.codebro.rxpresenter.viper.contract.SampleContract;

public class SampleRouting
        extends ActivityBaseRxRouting
        implements SampleContract.Routing {

    public SampleRouting(@NonNull Activity activity) {
        super(activity);
    }
}
