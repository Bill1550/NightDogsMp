package com.loneoaktech.tests.nightdogsmp.androidApp

import android.app.Application
import com.soywiz.klogger.Logger

class NightDogsMpApp : Application() {

    override fun onCreate() {
        super.onCreate()

        Logger.defaultLevel = Logger.Level.DEBUG
    }
}