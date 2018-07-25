package com.brewmapp.brewmapp.features.main.search.result.data.paging

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Beer
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import com.brewmapp.brewmapp.features.main.search.result.domain.interactor.ApiResultService
import javax.inject.Inject

class ResultPositionalDataSource(private val map: HashMap<String, String>, val mode: String) : PositionalDataSource<Model>() {

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiResult: ApiResultService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
        apiResult.loadRange(params, callback, map, mode)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
        apiResult.loadInitial(params, callback, map, mode)
    }
}