package com.brewmapp.brewmapp.features.main.map.map.domain

import com.brewmapp.brewmapp.features.main.map.map.data.MapApi
import com.brewmapp.brewmapp.features.main.map.map.data.model.req.Coords
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiMapService(var api: MapApi) {

    fun getMarkers(map: HashMap<String, String>, callback: MapCallback) {
        api.getMarkers(map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models)
                }, {
                    callback.onError(it)
                })
    }

    interface MapCallback {
        fun onSuccess(models: MutableList<Model>)
        fun onError(it: Throwable)
    }
}