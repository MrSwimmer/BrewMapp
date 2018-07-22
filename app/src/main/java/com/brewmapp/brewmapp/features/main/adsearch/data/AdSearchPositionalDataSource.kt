package com.brewmapp.brewmapp.features.main.adsearch.data

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.features.main.adsearch.domain.ApiAdSearchService
import javax.inject.Inject

class AdSearchPositionalDataSource(private val type: String) : PositionalDataSource<AdSearch>() {

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiSearch: ApiAdSearchService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<AdSearch>) {
        apiSearch.loadRange(type, params, callback)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<AdSearch>) {
        apiSearch.loadInitial(type, params, callback)
    }
}