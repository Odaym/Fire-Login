package com.saltserv.firelogin.ui.splash

import com.saltserv.firelogin.OpenEntryScreen
import com.saltserv.firelogin.OpenMainScreen
import com.saltserv.firelogin.ShowToast
import com.saltserv.firelogin.base.BaseViewModel
import com.saltserv.firelogin.usecase.DetermineAuthStatus

class SplashViewModel(
    dependencies: Dependencies,
    private val determineAuthStatus: DetermineAuthStatus
) : BaseViewModel(dependencies) {

    fun onScreenCreated() {
        subscription {
            determineAuthStatus.invoke()
                .subscribeOn(ioScheduler)
                .observeOn(uiScheduler)
                .subscribe({ authenticated ->
                    if (authenticated) {
                        emitCommand(OpenMainScreen)
                    } else {
                        emitCommand(OpenEntryScreen)
                    }
                }, {
                    emitCommand(
                        ShowToast("Something went wrong, please try again later and don't worry!")
                    )
                })
        }
    }
}