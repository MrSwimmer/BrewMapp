package com.brewmapp.brewmapp.features.main.adsearch.domain.interactor

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.features.main.adsearch.data.SearchApi
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.adsearch.data.model.res.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiAdSearchService(val api: SearchApi) {

    fun loadRange(type: String, params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>) {
        when (type) {
            TypeSearch.COUNTRY.type -> {
                api.getCountry()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ callback.onResult(it.models) }, {})
            }
            TypeSearch.BREWERY.type -> {
                api.getBrewery(params.startPosition, params.startPosition + params.loadSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            callback.onResult(it.models)
                        }, {})
            }
            else -> {
                api.getSearch(type, params.startPosition, params.startPosition + params.loadSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Log.i("code", "range ${it.models.size}")
                            callback.onResult(it.models)
                        }, {})
            }
        }
    }

    fun loadInitial(type: String, params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>) {
        when (type) {
            TypeSearch.COUNTRY.type -> {
                api.getCountry()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ callback.onResult(it.models, 0) }, {})
            }
            TypeSearch.BREWERY.type -> {
                api.getBrewery(0, params.pageSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ callback.onResult(it.models, 0) }, {})
            }
            else -> {
                api.getSearch(type, 0, params.pageSize)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            Log.i("code", "init ${it.models.size}")
                            callback.onResult(it.models, 0)
                        }, {})
            }
        }
    }
}