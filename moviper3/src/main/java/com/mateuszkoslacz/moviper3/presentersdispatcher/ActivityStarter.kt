package com.mateuszkoslacz.moviper3.presentersdispatcher

import android.content.Context
import android.content.Intent
import com.mateuszkoslacz.moviper3.iface.presenter.ViperPresenter

data class ActivityStarter(val context: Context,
                           val intent: Intent,
                           val presenter: ViperPresenter<*>)
