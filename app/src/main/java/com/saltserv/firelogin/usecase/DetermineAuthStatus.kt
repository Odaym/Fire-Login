package com.saltserv.firelogin.usecase

import com.google.firebase.auth.FirebaseAuth
import io.reactivex.Single
import io.reactivex.subjects.SingleSubject

class DetermineAuthStatus(
    private val firebaseAuth: FirebaseAuth
) {

    operator fun invoke() = firebaseAuth.currentUser?.let { currentUser ->
        val subject = SingleSubject.create<Boolean>()

        subject
            .hide()
            .doOnSubscribe {
                currentUser.getIdToken(false).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        subject.onSuccess(true)
                    } else {
                        task.exception?.let { subject.onError(it) }
                    }
                }
            }
    } ?: Single.just(false)
}