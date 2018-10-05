package com.topicos.miguel.reclamo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener{

    private var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        google_login.setOnClickListener(this)
        facebook_login.setOnClickListener(this)

        auth = FirebaseAuth.getInstance()
    }

    override fun onClick(p0: View?) {
        val i = p0!!.id

        if (i == R.id.google_login){
            
        } else if (i == R.id.facebook_login){

        }
    }

}
