package com.brewmapp.brewmapp.features.main.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController

class FriendsController : BaseController<FriendsContract.View, FriendsContract.Presenter>(), FriendsContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_friends, container, false)
    }

    override fun createPresenter(): FriendsContract.Presenter {
        return FriendsPresenter()
    }
}