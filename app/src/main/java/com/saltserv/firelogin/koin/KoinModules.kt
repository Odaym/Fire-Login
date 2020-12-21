package com.saltserv.firelogin.koin

import android.content.Context
import com.google.firebase.auth.FirebaseAuth
import com.saltserv.firelogin.SplashViewModel
import com.saltserv.firelogin.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val application = module {

    single {
        androidContext().getSharedPreferences(
            "FireLoginPrefs", Context.MODE_PRIVATE
        )
    }

    single(IoScheduler) {
        Schedulers.io()
    }

    single(UiScheduler) {
        AndroidSchedulers.mainThread()
    }

    single {
        FirebaseAuth.getInstance()
    }
}

val viewModelsModule = module {
    single {
        BaseViewModel.Dependencies(
            ioScheduler = get(IoScheduler),
            uiScheduler = get(UiScheduler)
        )
    }

    single {
        SplashViewModel(dependencies = get())
    }
}