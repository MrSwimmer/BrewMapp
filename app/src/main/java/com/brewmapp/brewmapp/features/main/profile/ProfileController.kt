package com.brewmapp.brewmapp.features.main.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController

class ProfileController : MvpController<FeedContract.View, FeedContract.Presenter>(), FeedContract.View {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_profile, container, false)
    }

    override fun createPresenter(): FeedContract.Presenter {
        return FeedPresenter()
    }
}