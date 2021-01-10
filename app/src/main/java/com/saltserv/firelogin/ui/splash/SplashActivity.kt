package com.saltserv.firelogin.ui.splash

import android.os.Bundle
import com.saltserv.firelogin.ui.main.MainActivity
import com.saltserv.firelogin.OpenEntryScreen
import com.saltserv.firelogin.OpenMainScreen
import com.saltserv.firelogin.VMCommand
import com.saltserv.firelogin.base.BaseActivity
import com.saltserv.firelogin.ui.EntryActivity
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity: BaseActivity<SplashViewModel>(){

    override val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.onScreenCreated()
    }

    override fun handleVMCommand(command: VMCommand) = when(command){
        is OpenEntryScreen ->{
            openEntryActivity()
            true
        }
        is OpenMainScreen ->{
            // Open the Main Activity
            openMainActivity()
            true
        }
        else -> super.handleVMCommand(command)
    }

    private fun openMainActivity(){
        MainActivity.start(this)
        finish()
    }

    private fun openEntryActivity(){
        EntryActivity.start(this)
        finish()
    }
}