package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.auth.data.model.res.UserData
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import javax.inject.Inject

class SignUpPresenter : BasePresenter<SignUpContract.View>(), SignUpContract.Presenter {
    @Inject
    lateinit var apiService: ApiAuthService
    @Inject
    lateinit var settingsService: SettingsService

    override fun signUp(email: String, password: String, first: String, last: String, dateString: String) {
        apiService.signUp(email, first, last, dateString, password, object : ApiAuthService.AuthCallback {
            override fun onSuccess(data: UserData) {
                Log.i("code", "success sign up ${data.user.token}")
                settingsService.setToken(data.user.token)
                settingsService.setUsername(data.user.firstname as String)
                settingsService.setCityId(SignUpController.cityId)
                settingsService.setCityName(SignUpController.cityName)
                settingsService.setUserId(data.user.id)
                view.hideProgress()
                view.gotoMain()
            }

            override fun onError(e: Throwable) {
                Log.i("code", "error sign up ${e.message}")
                view.showErrorMessage(e.message!!)
                view.hideProgress()
            }

        })
    }

    init {
        App.component.inject(this)
    }
}