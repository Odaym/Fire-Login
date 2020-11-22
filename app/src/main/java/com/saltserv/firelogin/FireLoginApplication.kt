package com.saltserv.firelogin

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FireLoginApplication : Application(){

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin(){
        startKoin {
            androidContext(this@FireLoginApplication)
            modules(
                application
            )
        }
    }
}