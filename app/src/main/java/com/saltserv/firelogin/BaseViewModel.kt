package com.saltserv.firelogin

import androidx.lifecycle.ViewModel
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject

class BaseViewModel: ViewModel() {

    private val commandsSubject: Subject<VMCommand> = PublishSubject.create()
    val commands: Observable<VMCommand> = commandsSubject.hide()

    protected fun emitCommand(command: VMCommand){
        commandsSubject.onNext(command)
    }
}