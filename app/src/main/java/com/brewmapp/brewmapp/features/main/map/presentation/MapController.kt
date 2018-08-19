package com.brewmapp.brewmapp.features.main.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController

class MapController : BaseController<MapContract.View, MapContract.Presenter>(), MapContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_map, container, false)
    }

    override fun createPresenter(): MapContract.Presenter {
        return MapPresenter()
    }
}