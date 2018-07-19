package com.brewmapp.brewmapp.features.auth.domain

import com.brewmapp.brewmapp.features.auth.data.AuthApi
import com.brewmapp.brewmapp.features.auth.data.model.req.UserLogIn
import com.brewmapp.brewmapp.features.auth.data.model.res.User
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiAuthService(private val api: AuthApi) {
    fun signIn(user: UserLogIn, callback: AuthCallback) {
        api.signIn(user)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError)
    }

    fun signUp(email: String, first: String, last: String, dateString: String, password: String, callback: AuthCallback) {
        /*var userarray = arrayOf(user.login, user.firstname, user.lastname, user.birthday, user.password, user.login)
        var usermap: Map<String, String> = hashMapOf()
        usermap["User[login]"] = user.login
        usermap["User[firstname]"] = user.firstname
        usermap["User[lastname]"] = user.lastname
        usermap["User[birthday]"] = user.birthday
        usermap["User[password]"] = user.password
        usermap["User[email]"] = user.login*/
        //var jsonObject = "{[User[login]:${user.login},User[firstname]:${user.firstname},User[lastname]:${user.lastname},User[birthday]:${user.birthday},User[password]:${user.password},User[email]:${user.login}]}"
        api.signUp(email, first, last, dateString, password, email)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError)
    }

    interface AuthCallback {
        fun onSuccess(user: User)
        fun onError(e: Throwable)
    }
}