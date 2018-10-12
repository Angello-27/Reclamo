package com.topicos.miguel.reclamo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.topicos.miguel.reclamo.Model.Session.SessionManager

class SplashActivity : AppCompatActivity() {

    private val handler : Handler? = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        this.window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        startAplication()
    }

    fun startAplication(){
        val runnable = Runnable {
            if (SessionManager.instance.isLogged()) {
                startActivity(Intent(this, MainActivity::class.java))
            }else{
                startActivity(Intent(this, LoginActivity::class.java))
            }
            finish()
        }
        handler!!.postDelayed(runnable, 5000)
    }
}
