package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter

class FriendsPresenter : BasePresenter<FriendsContract.View>(), FriendsContract.Presenter {
    init {
        App.component.inject(this)
    }
}