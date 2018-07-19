package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.features.auth.data.model.req.UserLogIn
import com.brewmapp.brewmapp.features.auth.data.model.res.RootObject
import com.brewmapp.brewmapp.features.auth.data.model.res.User
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class SignInPresenter : MvpBasePresenter<SignInContract.View>(), SignInContract.Presenter {
    @Inject
    lateinit var apiService: ApiAuthService
    @Inject
    lateinit var settingsService: SettingsService

    override fun signIn(email: String, password: String) {
        val userLogIn = UserLogIn(email, password)
        apiService.signIn(userLogIn, object : ApiAuthService.AuthCallback {
            override fun onSuccess(user: RootObject) {
                Log.i("code", "success sign in ${user.user.token}")
                settingsService.setToken(user.user.token)
                view.gotoMain()
            }

            override fun onError(e: Throwable) {
                Log.i("code", "error sign in ${e.message}")
            }

        })
    }

    init {
        App.component.inject(this)
    }
}