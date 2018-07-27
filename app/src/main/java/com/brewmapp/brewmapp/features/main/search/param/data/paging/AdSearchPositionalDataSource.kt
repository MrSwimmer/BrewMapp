package com.brewmapp.brewmapp.features.main.search.param.data.paging

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import javax.inject.Inject

class AdSearchPositionalDataSource(private val type: String) : PositionalDataSource<Model>() {

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiSearch: ApiParamService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
        apiSearch.loadRange(type, params, callback)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
        apiSearch.loadInitial(type, params, callback)
    }
}