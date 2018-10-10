package com.topicos.miguel.reclamo.Control

import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.facebook.AccessToken
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.topicos.miguel.reclamo.Model.Session.SessionManager
import com.topicos.miguel.reclamo.Model.User


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
        auth = FirebaseAuth.getInstance()
        val credential = FacebookAuthProvider.getCredential(token.token)
        auth!!.signInWithCredential(credential)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        val user = auth!!.currentUser
                        if (user != null) {
                            registerUser(user)
                        }
                        //startActivity(Intent(this@CreateAccount, MainActivity::class.java))
                    } else {
                        // If sign in fails, display a message to the user.
                    }
                }
    }

    private fun registerUser(firebaseUser: FirebaseUser){
        val user = User()
        user.Name = firebaseUser.displayName !!
        user.Email = firebaseUser.email !!
        user.UID = firebaseUser.uid
        SessionManager.instance.createUser(user)
        Toast.makeText(activity, user.Name + "  " + user.Email, Toast.LENGTH_LONG).show()
    }
}

