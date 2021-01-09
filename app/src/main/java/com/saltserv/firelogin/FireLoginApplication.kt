package com.saltserv.firelogin

import android.app.Application
import com.saltserv.firelogin.koin.application
import com.saltserv.firelogin.koin.useCasesModule
import com.saltserv.firelogin.koin.viewModelsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class FireLoginApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@FireLoginApplication)
            modules(
                listOf(
                    application,
                    useCasesModule,
                    viewModelsModule
                )
            )
        }
    }
}