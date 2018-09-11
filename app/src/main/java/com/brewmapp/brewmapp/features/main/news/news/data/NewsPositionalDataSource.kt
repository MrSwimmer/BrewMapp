package com.brewmapp.brewmapp.features.main.news.news.data

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.domain.interactor.ApiNewsService
import javax.inject.Inject

class NewsPositionalDataSource(val map: HashMap<String, String>, val mode: Mode) : PositionalDataSource<Model>() {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var newsService: ApiNewsService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
        newsService.loadRange(params, callback, map)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
        newsService.loadInit(params, callback, map)
    }
}