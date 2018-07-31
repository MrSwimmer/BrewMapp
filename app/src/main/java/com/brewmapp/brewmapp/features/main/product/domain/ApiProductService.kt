package com.brewmapp.brewmapp.features.main.product.domain

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.domain.interactor.RoomService
import com.brewmapp.brewmapp.features.main.product.data.ProductApi
import com.brewmapp.brewmapp.features.main.product.data.model.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class ApiProductService(private val api: ProductApi) {

    fun getProduct(id: String, callback: ProductCallback) {
        api.getProduct(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models[0])
                }, {
                    Log.i("code", "rangeres beer er ${it.message}")
                    callback.onError(it)
                })
    }

    interface ProductCallback {
        fun onSuccess(model: Model)
        fun onError(it: Throwable)
    }

}