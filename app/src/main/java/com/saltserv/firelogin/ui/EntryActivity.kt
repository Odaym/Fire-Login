package com.saltserv.firelogin.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.saltserv.firelogin.R

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
    }

    companion object{
        fun start(activity: Activity){
            val intent = Intent(activity, EntryActivity::class.java)
            activity.startActivity(intent)
        }
    }
}