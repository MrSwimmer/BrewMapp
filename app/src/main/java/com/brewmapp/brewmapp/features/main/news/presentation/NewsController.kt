package com.brewmapp.brewmapp.features.main.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController

class NewsController : BaseController<NewsContract.View, NewsContract.Presenter>(), NewsContract.View {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.controller_news, container, false)
    }

    override fun createPresenter(): NewsContract.Presenter {
        return NewsPresenter()
    }
}