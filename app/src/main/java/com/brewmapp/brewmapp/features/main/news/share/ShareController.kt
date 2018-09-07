package com.brewmapp.brewmapp.features.main.news.share

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.core.presentation.base.BaseController

class ShareController: BaseController<ShareContract.View, ShareContract.Presenter>(), ShareContract.View {
    override fun createPresenter(): ShareContract.Presenter {
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    }
}