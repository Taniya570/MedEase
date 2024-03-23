package com.example.medease.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.medease.R
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : AppCompatActivity() {

    var auth  = Firebase.auth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Handler().postDelayed({
            if(auth.currentUser?.uid != null){
                startActivity(Intent(this, ThirdActivity::class.java))
                this.finish()
            }else{
                startActivity(Intent(this, SecondActivity::class.java))
                this.finish()
            }

        },2000)


    }
}