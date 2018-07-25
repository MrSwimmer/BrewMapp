package com.brewmapp.brewmapp.features.main.search.result.domain.interactor

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.features.main.search.result.data.ResultApi
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiResultService(private val api: ResultApi) {

    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>, mode: String) {
        api.getBeerResults(mode, params.startPosition, params.startPosition + params.loadSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.onResult(it.models) }, {})
    }

    fun loadInitial(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>, mode: String) {
        api.getBeerResults( mode,0, params.pageSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.onResult(it.models, 0) }, {})
    }

}