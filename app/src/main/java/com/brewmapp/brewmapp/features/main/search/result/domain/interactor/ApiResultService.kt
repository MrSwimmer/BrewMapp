package com.brewmapp.brewmapp.features.main.search.result.domain.interactor

import androidx.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.search.result.data.ResultApi
import com.brewmapp.brewmapp.features.main.search.result.data.model.Model
import com.brewmapp.brewmapp.features.main.search.result.data.model.Result
import org.greenrobot.eventbus.EventBus
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiResultService(private val api: ResultApi) {

    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>, mode: Mode) {
        when (mode) {
            Mode.BEER -> {
                setRangeCallback(api.getBeerResults(params.startPosition, params.startPosition + params.loadSize, map), callback)
            }
            Mode.BREWERY -> {
                setRangeCallback(api.getBreweryResults(params.startPosition, params.startPosition + params.loadSize, map), callback)
            }
            Mode.RESTO -> {
                setRangeCallback(api.getRestoResults(params.startPosition, params.startPosition + params.loadSize, map), callback)
            }
        }
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>, mode: Mode) {
        when (mode) {
            Mode.BEER -> {
                setInitialCallback(api.getBeerResults(0, params.pageSize, map), callback)
            }
            Mode.BREWERY -> {
                setInitialCallback(api.getBreweryResults(0, params.pageSize, map), callback)
            }
            Mode.RESTO -> {
                setInitialCallback(api.getRestoResults(0, params.pageSize, map), callback)
            }
        }
    }

    private fun setRangeCallback(api: Observable<Result>, callback: PositionalDataSource.LoadRangeCallback<Model>) {
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.models)
                    Log.i("code", "success range")
                }, {
                    Log.i("code", "error range")
                    EventBus.getDefault().post("error")
                })
    }

    private fun setInitialCallback(api: Observable<Result>, callback: PositionalDataSource.LoadInitialCallback<Model>) {
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.models, 0)
                    Log.i("code", "success init")
                    EventBus.getDefault().post("hide")
                }, {
                    Log.i("code", "error init ${it.message}")
                    EventBus.getDefault().post("error")
                })
    }
}