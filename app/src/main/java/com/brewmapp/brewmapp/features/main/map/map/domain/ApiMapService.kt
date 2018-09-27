package com.brewmapp.brewmapp.features.main.map.map.domain

import com.brewmapp.brewmapp.features.main.map.map.data.MapApi
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

    /*fun getResto(id: String, callback: RestoCallback) {
        api.getResto(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models[0])
                }, {
                    callback.onError(it)
                })
    }*/

    interface MapCallback {
        fun onSuccess(models: MutableList<Model>)
        fun onError(it: Throwable)
    }

    /*interface RestoCallback {
        fun onSuccess(resto: com.brewmapp.brewmapp.features.main.card.resto.data.model.Model)
        fun onError(it: Throwable)
    }*/
}