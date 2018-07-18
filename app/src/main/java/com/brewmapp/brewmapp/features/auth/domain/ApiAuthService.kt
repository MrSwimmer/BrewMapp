package com.brewmapp.brewmapp.features.auth.domain

import com.brewmapp.brewmapp.features.auth.data.AuthApi
import com.brewmapp.brewmapp.features.auth.data.model.req.UserLogIn
import com.brewmapp.brewmapp.features.auth.data.model.req.UserReg
import com.brewmapp.brewmapp.features.auth.data.model.res.User
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiAuthService(private val api : AuthApi) {
    fun signIn(user : UserLogIn, callback: AuthCallback) {
        api.signIn(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError)
    }

    fun signUp(user : UserReg, callback: AuthCallback) {
        api.signUp(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError)
    }

    interface AuthCallback {
        fun onSuccess(user : User)
        fun onError(e : Throwable)
    }
}