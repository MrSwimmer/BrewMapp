package com.brewmapp.brewmapp.features.auth.domain

import android.util.Log
import com.brewmapp.brewmapp.features.auth.data.AuthApi
import com.brewmapp.brewmapp.features.auth.data.model.res.UserData
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiAuthService(private val api: AuthApi) {
    fun signIn(email: String, password: String, callback: AuthCallback) {
        api.signIn(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    callback.onError(it)
                }
                .subscribe(callback::onSuccess, callback::onError)
    }

    fun signUp(email: String, first: String, last: String, dateString: String, password: String, callback: AuthCallback) {
        api.signUp(email, first, last, dateString, password, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    callback.onError(it)
                }
                .subscribe(callback::onSuccess, callback::onError)
    }

    interface AuthCallback {
        fun onSuccess(user: UserData)
        fun onError(e: Throwable)
    }
}