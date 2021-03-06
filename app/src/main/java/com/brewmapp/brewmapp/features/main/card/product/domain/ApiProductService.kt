package com.brewmapp.brewmapp.features.main.card.product.domain

import android.util.Log
import com.brewmapp.brewmapp.features.main.card.product.data.ProductApi
import com.brewmapp.brewmapp.features.main.card.product.data.model.product.Model
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

    fun getResto(id: String, callback: RestoCallback) {
        api.getResto(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models[0])
                }, {
                    Log.i("code", "rangeres beer er ${it.message}")
                    callback.onError(it)
                })
    }

    fun getReview(id: String, modelName: String, callback: ReviewCallback) {
        api.getReview(modelName, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models)
                }, {
                    Log.i("code", "rangeres beer er ${it.message}")
                    callback.onError(it)
                })
    }

    interface RestoCallback {
        fun onSuccess(model: com.brewmapp.brewmapp.features.main.card.resto.data.model.Model)
        fun onError(it: Throwable)
    }

    interface ProductCallback {
        fun onSuccess(model: Model)
        fun onError(it: Throwable)
    }

    interface ReviewCallback {
        fun onSuccess(model: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>)
        fun onError(it: Throwable)
    }

}