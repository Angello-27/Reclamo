package com.topicos.miguel.reclamo.Model.Session

import android.app.Application
import com.facebook.FacebookSdk
import com.facebook.appevents.AppEventsLogger

class SessionManager: Application() {

    companion object {
        lateinit var instance: MyPreferences
    }

    override fun onCreate() {
        super.onCreate()
        instance = MyPreferences(applicationContext)
        FacebookSdk.sdkInitialize(getApplicationContext())
        AppEventsLogger.activateApp(this)

    }
}