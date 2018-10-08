package com.topicos.miguel.reclamo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import com.topicos.miguel.reclamo.Control.AuthGoogle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener ,GoogleApiClient.OnConnectionFailedListener {

    val GOOGLE_SIGN_INTENT = 1
    lateinit var googleSignClient: GoogleApiClient
    lateinit var googleSignInOptions: GoogleSignInOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initGoogleOptions()
        google_login.setOnClickListener(this)
        facebook_login.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val i = p0!!.id
        if (i == R.id.google_login){
            signGoogle()
        } else if (i == R.id.facebook_login){

        }
    }

    private fun initGoogleOptions(){
        googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()

        googleSignClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build()
    }

    private fun signGoogle(){
        val intent = Auth.GoogleSignInApi.getSignInIntent(googleSignClient)
        startActivityForResult(intent, GOOGLE_SIGN_INTENT)
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        
    }

}
