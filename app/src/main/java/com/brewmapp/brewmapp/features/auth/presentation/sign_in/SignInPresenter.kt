package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.features.auth.data.model.req.UserLogIn
import com.brewmapp.brewmapp.features.auth.data.model.res.User
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class SignInPresenter : MvpBasePresenter<SignInContract.View>(), SignInContract.Presenter {
    @Inject
    lateinit var apiService: ApiAuthService

    override fun signIn(email: String, password: String) {
        val userLogIn = UserLogIn(email, password)
        apiService.signIn(userLogIn, object : ApiAuthService.AuthCallback {
            override fun onSuccess(user: User) {

            }

            override fun onError(e: Throwable) {

            }

        })
    }

    init {
        App.component.inject(this)
    }
}