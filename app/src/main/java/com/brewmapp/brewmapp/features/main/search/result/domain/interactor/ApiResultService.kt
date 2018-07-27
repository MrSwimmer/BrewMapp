package com.brewmapp.brewmapp.features.main.search.result.domain.interactor

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.features.main.search.result.data.ResultApi
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiResultService(private val api: ResultApi) {

    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>, mode: String) {
        when (mode) {
            "beer" -> {
                api.getBeerResults(params.startPosition, params.startPosition + params.loadSize, map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ callback.onResult(it.models) }, { Log.i("code", "rangeres beer er ${it.message}") })
            }
            "brewery" -> {
                api.getBreweryResults(params.startPosition, params.startPosition + params.loadSize, map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ callback.onResult(it.models) }, { Log.i("code", "rangeres brewery er ${it.message}") })
            }
        }
    }

    fun loadInitial(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>, mode: String) {
        when (mode) {
            "beer" -> {
                api.getBeerResults(0, params.pageSize, map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ callback.onResult(it.models, 0) }, { Log.i("code", "initres er ${it.message}")})
            }
            "brewery" -> {
                api.getBreweryResults(0, params.pageSize, map)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ callback.onResult(it.models, 0) }, { Log.i("code", "initres brewery er ${it.message}")})
            }
        }

    }
}