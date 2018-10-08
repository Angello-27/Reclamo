package com.topicos.miguel.reclamo.Model.Session

import android.app.Application

class SessionManager: Application() {

    companion object {
        lateinit var instance: MyPreferences
    }

    override fun onCreate() {
        super.onCreate()
        instance = MyPreferences(applicationContext)
    }
}