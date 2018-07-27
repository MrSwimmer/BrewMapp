package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter

class MessagesPresenter : BasePresenter<NewsContract.View>(), NewsContract.Presenter {
    init {
        App.component.inject(this)
    }
}