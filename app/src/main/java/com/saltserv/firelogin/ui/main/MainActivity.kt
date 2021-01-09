package com.saltserv.firelogin.ui.main

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saltserv.firelogin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    companion object{
        fun start(activity: Activity){
            val intent = Intent(activity, MainActivity::class.java)
            activity.startActivity(intent)
        }
    }
}