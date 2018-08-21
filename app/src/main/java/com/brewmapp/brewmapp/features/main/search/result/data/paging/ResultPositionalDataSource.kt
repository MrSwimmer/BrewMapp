package com.brewmapp.brewmapp.features.main.news.data.paging

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import com.brewmapp.brewmapp.features.main.search.result.domain.interactor.ApiResultService
import javax.inject.Inject

class ResultPositionalDataSource(val mode: Mode, val map: HashMap<String, String>) : PositionalDataSource<Model>() {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiResultService: ApiResultService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
        apiResultService.loadRange(params, callback, map, mode)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
        apiResultService.loadInit(params, callback, map, mode)
    }
}