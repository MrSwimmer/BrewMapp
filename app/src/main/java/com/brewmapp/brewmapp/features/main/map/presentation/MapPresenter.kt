package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter

class MapPresenter : BasePresenter<MapContract.View>(), MapContract.Presenter {
    init {
        App.component.inject(this)
    }


}