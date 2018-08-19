package com.brewmapp.brewmapp.features.main.search.result.domain.interactor

import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.search.result.data.ResultApi
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Result
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiResultService(private val api: ResultApi) {

    fun getResult(mode: Mode, map: java.util.HashMap<String, String>, callback: ResultCallback) {
        when (mode) {
            Mode.BEER -> {
                setCallback(api.getBeerResults(map), callback)
            }
            Mode.BREWERY -> {
                setCallback(api.getBreweryResults(map), callback)
            }
            Mode.RESTO -> {
                setCallback(api.getRestoResults(map), callback)
            }
        }

    }

    fun setCallback(api: Observable<Result>, callback: ResultCallback) {
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({callback.onSuccess(it)}, {callback.onError(it)})
    }

    interface ResultCallback {
        fun onSuccess(it: Result)
        fun onError(it: Throwable)
    }
}