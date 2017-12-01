package com.mateuszkoslacz.moviper3.annotation

import com.mateuszkoslacz.moviper3.iface.presenter.ViperRxPresenter
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by mateuszkoslacz on 25.10.2016.
 *
 *
 * Annotates [ViperRxPresenter] method that is called from the outside of its VIPER screen using
 * the [com.mateuszkoslacz.moviper3.presenterbus.Moviper] presenters bundle access mechanism.
 */
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(RetentionPolicy.SOURCE)
annotation class ExternalCall
