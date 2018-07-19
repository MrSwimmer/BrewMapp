package com.brewmapp.brewmapp.features.main.adsearch.domain

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.features.main.adsearch.data.AdSearch
import com.brewmapp.brewmapp.features.main.adsearch.data.SearchApi

class ApiAdSearchService(val api: SearchApi) {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<AdSearch>) {

    }

    fun loadInitial(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<AdSearch>) {

    }

}