package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter

class ProductPresenter : BasePresenter<ProductContract.View>(), ProductContract.Presenter {
    init {
        App.component.inject(this)
    }
}