package com.mateuszkoslacz.moviper.annotation;

import com.mateuszkoslacz.moviper.iface.presenter.ViperPresenter;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by mateuszkoslacz on 25.10.2016.
 * <p/>
 * Annotates {@link ViperPresenter} method that is called from the outside of its VIPER screen using
 * the {@link com.mateuszkoslacz.moviper.presenterbus.Moviper} presenters bundle access mechanism.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface ExternalCall {
}
