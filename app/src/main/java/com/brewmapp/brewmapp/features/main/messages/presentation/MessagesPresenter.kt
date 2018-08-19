package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter

class MessagesPresenter : BasePresenter<MessagesContract.View>(), MessagesContract.Presenter {
    init {
        App.component.inject(this)
    }
}