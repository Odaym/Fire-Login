package com.saltserv.firelogin

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable

abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    private lateinit var vmCommandSubs: Disposable

    protected abstract val viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vmCommandSubs = viewModel
            .commands
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleVMCommand(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
        vmCommandSubs.dispose()
    }

    open fun handleVMCommand(command: VMCommand): Boolean {
        when (command) {
            is ShowToast -> Toast.makeText(this, command.message, Toast.LENGTH_LONG).show()
            is CloseScreen -> finish()
        }

        return true
    }
}