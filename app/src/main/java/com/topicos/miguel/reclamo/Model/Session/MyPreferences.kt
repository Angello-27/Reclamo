package com.topicos.miguel.reclamo.Model.Session

import android.content.Context
import android.content.SharedPreferences

class MyPreferences(val context: Context) {

    val MODE_PRIVATE = 0
    val PREFERENCES_APP = "com.topicos.miguel.reclamo"
    val NAME = "name"
    val EMAIL = "email"
    val AVATAR = "avatar"

    val preferences : SharedPreferences = context.getSharedPreferences(PREFERENCES_APP, MODE_PRIVATE)

    var name : String
        get() = preferences.getString(NAME, "")
        set(value) = preferences.edit().putString(NAME, value).apply()

    var email : String
        get() = preferences.getString(EMAIL, "")
        set(value) = preferences.edit().putString(EMAIL, value).apply()

    var avatar : String
        get() = preferences.getString(AVATAR, "")
        set(value) = preferences.edit().putString(AVATAR, value).apply()

}