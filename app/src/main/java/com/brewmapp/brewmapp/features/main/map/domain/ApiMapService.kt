package com.brewmapp.brewmapp.features.main.map.domain

import com.brewmapp.brewmapp.features.main.map.data.MapApi
import com.brewmapp.brewmapp.features.main.map.data.model.Coordinates
import com.brewmapp.brewmapp.features.main.map.data.model.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiMapService(var api: MapApi) {

    fun getMarkers(begin: String, end: String, callback: mapCallback) {
        api.getMarkers(begin, end)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models)
                }, {
                    callback.onError(it)
                })
    }

    interface mapCallback {
        fun onSuccess(models: MutableList<Model>)
        fun onError(it: Throwable)
    }
}