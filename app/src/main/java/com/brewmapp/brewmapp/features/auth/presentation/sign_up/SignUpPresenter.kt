package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.features.auth.data.model.req.UserReg
import com.brewmapp.brewmapp.features.auth.data.model.res.User
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class SignUpPresenter : MvpBasePresenter<SignUpContract.View>(), SignUpContract.Presenter {
    @Inject
    lateinit var apiService: ApiAuthService
    @Inject
    lateinit var settingsService: SettingsService

    override fun signUp(email: String, password: String, first: String, last: String, dateString: String) {
        val userReg = UserReg(email, first, last, dateString, password)
        apiService.signUp(email, first, last, dateString, password, object : ApiAuthService.AuthCallback {
            override fun onSuccess(user: User) {
                Log.i("code", "success sign up ${user.models[0].token}")
                settingsService.setToken(user.models[0].token)
                view.gotoMain()
            }

            override fun onError(e: Throwable) {
                Log.i("code", "error sign up ${e.message}")
            }

        })
    }

    init {
        App.component.inject(this)
    }
}