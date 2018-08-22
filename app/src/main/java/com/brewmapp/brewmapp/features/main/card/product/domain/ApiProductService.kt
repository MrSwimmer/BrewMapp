package com.brewmapp.brewmapp.features.main.card.product.domain

import android.util.Log
import com.brewmapp.brewmapp.features.main.card.product.data.ProductApi
import com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

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