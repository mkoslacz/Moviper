package com.mateuszkoslacz.moviper.iface.view;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by mateuszkoslacz on 15.12.2016.
 */

public interface ActivityHolder {

    Activity getActivity();

    Bundle getArgs();
}
