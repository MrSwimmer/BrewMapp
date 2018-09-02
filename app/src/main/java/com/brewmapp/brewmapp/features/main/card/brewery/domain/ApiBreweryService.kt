package com.brewmapp.brewmapp.features.main.card.brewery.domain

import android.util.Log
import com.brewmapp.brewmapp.features.main.card.brewery.data.BreweryApi
import com.brewmapp.brewmapp.features.main.card.brewery.data.model.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiBreweryService(val api: BreweryApi){
    fun getBrewery(id: String, callback: BreweryCallback) {
        api.getBrewery(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models[0])
                }, {
                    Log.i("code", "rangeres brewery er ${it.message}")
                    callback.onError(it)
                })
    }

    interface BreweryCallback {
        fun onSuccess(model: Model)
        fun onError(it: Throwable)
    }
}