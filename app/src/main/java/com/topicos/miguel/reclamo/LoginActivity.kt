package com.topicos.miguel.reclamo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.topicos.miguel.reclamo.Control.AuthGoogle
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener ,GoogleApiClient.OnConnectionFailedListener {

    private val REQUEST_CODE_GOOGLE_SIGN = 1234
    private val REQUEST_CODE_FACEBOOK_SIGN = 2345

    lateinit var googleSignClient: GoogleApiClient
    lateinit var googleSignInOptions: GoogleSignInOptions
    lateinit var authGoogle : AuthGoogle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initGoogleOptions()
        google_login.setOnClickListener(this)
        facebook_login.setOnClickListener(this)
        authGoogle = AuthGoogle(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE_GOOGLE_SIGN){
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            if (result.isSuccess) {
                // successful -> authenticate with Firebase
                val account = result.signInAccount
                if (account != null) {
                    authGoogle.loginGoogle(account)
                }
            } else {
                // failed -> update UI
            }
        }
    }

    override fun onClick(p0: View?) {
        val i = p0!!.id
        when (i){
            R.id.google_login -> signGoogle()
        }
    }

    private fun initGoogleOptions(){
        googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.web_client_id))
                .requestEmail()
                .build()

        googleSignClient = GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API, googleSignInOptions)
                .build()
    }

    private fun signGoogle(){
        val intent = Auth.GoogleSignInApi.getSignInIntent(googleSignClient)
        startActivityForResult(intent, REQUEST_CODE_GOOGLE_SIGN)
    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }
}
