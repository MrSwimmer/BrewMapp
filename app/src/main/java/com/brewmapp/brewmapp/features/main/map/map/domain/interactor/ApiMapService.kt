package com.brewmapp.brewmapp.features.main.map.map.domain.interactor

import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.map.map.data.MapApi
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Coordinates
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Model
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiMapService(var api: MapApi) {

    fun getMarkers(map: HashMap<String, String>, callback: MapCallback) {
        val data = when (ParamsMapController.mode) {
            Mode.RESTO -> api.getResto(map)
            else -> api.getBeer(map)
        }

        data
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