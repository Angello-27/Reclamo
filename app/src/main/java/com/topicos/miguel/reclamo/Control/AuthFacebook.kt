package com.topicos.miguel.reclamo.Control

import android.support.v4.app.FragmentActivity
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FacebookAuthProvider
import com.facebook.AccessToken
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth


class AuthFacebook(val activity: FragmentActivity) : FacebookCallback<LoginResult> {

    var auth : FirebaseAuth? = null

    override fun onSuccess(result: LoginResult?) {
        if (result != null) {
            accessToken(result.accessToken)
        }
    }

    override fun onCancel() {

    }

    override fun onError(error: FacebookException?) {

    }

    private fun accessToken(token: AccessToken) {
        val credential = FacebookAuthProvider.getCredential(token.token)
        auth!!.signInWithCredential(credential)
                .addOnCompleteListener(activity, OnCompleteListener<AuthResult> {
                    fun onComplete(task: Task<AuthResult>) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            val user = auth!!.getCurrentUser()
                        } else {
                            // If sign in fails, display a message to the user.
                        }
                    }
                })
    }
}

