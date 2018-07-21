package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class SettingsPresenter : BasePresenter<SettingsContract.View>(), SettingsContract.Presenter {
    init {
        view.showErrorMessage("mem")
        App.component.inject(this)
    }
}