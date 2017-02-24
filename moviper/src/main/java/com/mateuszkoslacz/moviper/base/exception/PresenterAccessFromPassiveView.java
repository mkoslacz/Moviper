package com.mateuszkoslacz.moviper.base.exception;

/**
 * Created by mateuszkoslacz on 24.10.2016.
 * <p>
 *
 * Thrown when a passive view tries to access a presenter.
 *
 */

public class PresenterAccessFromPassiveView extends RuntimeException {

    public PresenterAccessFromPassiveView(ViperView view) {
        super(String.format(
                "Passive view %1$s tries to access presenter! You shall not call getPresenter() " +
                        "method in the passive view. Instead you should use getters to provide " +
                        "event sources that will notify presenter after presenter's registration " +
                        "to them. To use getPresenter() method you shall use non-passive Moviper view.",
                view.getClass().getName()));
    }
}
