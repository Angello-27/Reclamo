package com.topicos.miguel.reclamo.Control

import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.topicos.miguel.reclamo.Model.Session.SessionManager

class AuthGoogle(val activity: FragmentActivity){

    var auth : FirebaseAuth ? = null

    fun loginGoogle(googleSignInAccount: GoogleSignInAccount) {
        auth = FirebaseAuth.getInstance()
        val credential = GoogleAuthProvider.getCredential(googleSignInAccount.idToken, null)
        auth!!.signInWithCredential(credential)
                .addOnCompleteListener(activity) { task ->
                    if (task.isSuccessful) {
                        // Sign in success
                        val user = auth!!.currentUser
                        if (user != null) {
                            registerUser(user)
                        }
                    } else {
                        // Sign in fails
                    }
                }
    }

    private fun registerUser(user : FirebaseUser){
        SessionManager.instance.createUser(user.uid, user.email !!)
        Toast.makeText(activity, SessionManager.instance.email, Toast.LENGTH_LONG).show()
    }

    fun signOut(googleApiClient: GoogleApiClient) {
        // sign out Firebase
        auth!!.signOut()
        // sign out Google
        Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback {  }
    }

    private fun revokeAccess(googleApiClient: GoogleApiClient) {
        // sign out Firebase
        auth!!.signOut()
        // revoke access Google
        Auth.GoogleSignInApi.revokeAccess(googleApiClient).setResultCallback {  }
    }

}