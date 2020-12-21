package com.saltserv.firelogin

interface VMCommand

object CloseScreen : VMCommand

object OpenMainScreen : VMCommand

object OpenEntryScreen : VMCommand

data class ShowToast(val message: String) : VMCommand