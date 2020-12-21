package com.saltserv.firelogin

import android.os.Bundle
import com.saltserv.firelogin.base.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<SplashViewModel>() {

    override val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        viewModel.onScreenCreated()
    }

    override fun handleVMCommand(command: VMCommand) = when (command) {
        is OpenEntryScreen -> {
            // Open the Entry screen
            true
        }
        is OpenMainScreen -> {
            // Open the Main Activity
            openMainActivity()
            true
        }
        else -> super.handleVMCommand(command)
    }

    private fun openMainActivity() {
        MainActivity.start(this)
        finish()
    }
}