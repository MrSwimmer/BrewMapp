package com.brewmapp.brewmapp.features.main.news.data.paging

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.features.main.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.domain.interactor.ApiNewsService
import javax.inject.Inject

class NewsPositionalDataSource(val map: HashMap<String, String>) : PositionalDataSource<Model>() {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiNewsService: ApiNewsService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
        apiNewsService.loadRange(params, callback, map)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
        apiNewsService.loadInit(params, callback, map)
    }
}