package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter

class SettingsPresenter : BasePresenter<SettingsContract.View>(), SettingsContract.Presenter {
    init {
        App.component.inject(this)
    }
}