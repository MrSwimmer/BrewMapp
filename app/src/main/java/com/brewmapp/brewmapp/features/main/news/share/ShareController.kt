package com.brewmapp.brewmapp.features.main.news.share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController

class ShareController(): BaseController<ShareContract.View, ShareContract.Presenter>(), ShareContract.View {
    lateinit var id: String

    constructor(id: String) : this() {
        this.id = id
    }

    override fun createPresenter(): ShareContract.Presenter {
        return SharePresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val v = inflater.inflate(R.layout.controller_share, container, false)
        return v
    }
}