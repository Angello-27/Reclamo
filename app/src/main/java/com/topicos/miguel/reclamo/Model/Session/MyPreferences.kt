package com.topicos.miguel.reclamo.Model.Session

import android.content.Context
import android.content.SharedPreferences
import com.topicos.miguel.reclamo.Model.User

class MyPreferences(private val context: Context) {

    private val MODE_PRIVATE = 0
    private val PREFERENCES_APP = "com.topicos.miguel.reclamo"
    private val UID = "UID"
    private val NAME = "name"
    private val EMAIL = "email"
    private val AVATAR = "avatar"

    private val preferences : SharedPreferences = context.getSharedPreferences(PREFERENCES_APP, MODE_PRIVATE)

    var name : String
        get() = preferences.getString(NAME, "")
        set(value) = preferences.edit().putString(NAME, value).apply()

    var uid : String
        get() = preferences.getString(UID, "")
        set(value) = preferences.edit().putString(UID, value).apply()

    var email : String
        get() = preferences.getString(EMAIL, "")
        set(value) = preferences.edit().putString(EMAIL, value).apply()

    var avatar : String
        get() = preferences.getString(AVATAR, "")
        set(value) = preferences.edit().putString(AVATAR, value).apply()

    fun createUser(user : User){
        uid = user.UID
        name = user.Name
        email = user.Email
        avatar = user.Avatar
    }

}