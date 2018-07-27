package com.brewmapp.brewmapp.features.main.search.param.domain.interactor

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.features.main.search.param.data.SearchApi
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.CallbackFabric

class ApiParamService(val api: SearchApi) {

    fun loadRange(type: String, params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>) {
        when (type) {
            TypeSearch.COUNTRY.type -> {
                CallbackFabric.rangeCallback(api.getCountry(params.startPosition, params.startPosition + params.loadSize), callback)
            }
            TypeSearch.BREWERY.type -> {
                CallbackFabric.rangeCallback(api.getBrewery(params.startPosition, params.startPosition + params.loadSize), callback)
            }
            TypeSearch.STRENGTH.type, TypeSearch.IBU.type, TypeSearch.PACKING.type -> {
                CallbackFabric.rangeNumCallback(api.getSearchNum(type, params.startPosition, params.startPosition + params.loadSize), callback)
            }
            else -> {
                CallbackFabric.rangeCallback(api.getSearch(type, params.startPosition, params.startPosition + params.loadSize), callback)
            }
        }
    }

    fun loadInitial(type: String, params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>) {
        when (type) {
            TypeSearch.COUNTRY.type -> {
                CallbackFabric.initCallback(api.getCountry(0, params.pageSize), callback)
            }
            TypeSearch.BREWERY.type -> {
                CallbackFabric.initCallback(api.getBrewery(0, params.pageSize), callback)
            }
            TypeSearch.STRENGTH.type, TypeSearch.IBU.type, TypeSearch.PACKING.type -> {
                CallbackFabric.initNumCallback(api.getSearchNum(type, 0, params.pageSize), callback)
            }
            else -> {
                CallbackFabric.initCallback(api.getSearch(type, 0, params.pageSize), callback)
            }
        }
    }
}