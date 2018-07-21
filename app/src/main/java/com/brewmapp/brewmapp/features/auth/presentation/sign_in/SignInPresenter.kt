package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.auth.data.model.res.UserData
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class SignInPresenter : BasePresenter<SignInContract.View>(), SignInContract.Presenter {
    @Inject
    lateinit var apiService: ApiAuthService
    @Inject
    lateinit var settingsService: SettingsService

    override fun signIn(email: String, password: String) {
        apiService.signIn(email, password, object : ApiAuthService.AuthCallback {
            override fun onSuccess(user: UserData) {
                Log.i("code", "success sign in ${user.user.token}")
                settingsService.setToken(user.user.token)
                view.hideProgress()
                view.gotoMain()
            }

            override fun onError(e: Throwable) {
                Log.i("code", "error sign in ${e.message}")
                view.showErrorMessage(e.message!!)
                view.hideProgress()
            }

        })
    }

    init {
        App.component.inject(this)
    }
}