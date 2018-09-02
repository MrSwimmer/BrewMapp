package com.brewmapp.brewmapp.features.main.card.brewery.presentation

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.card.brewery.domain.ApiBreweryService
import com.brewmapp.brewmapp.features.main.card.product.domain.ApiProductService
import javax.inject.Inject

class BreweryPresenter : BasePresenter<BreweryContract.View>(), BreweryContract.Presenter {
    init {
        App.component.inject(this)
    }

    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()

    @Inject
    lateinit var apiProductService: ApiProductService
    @Inject
    lateinit var apiBreweryService: ApiBreweryService

    override fun getBrewery(id: String) {
        apiBreweryService.getBrewery(id, object : ApiBreweryService.BreweryCallback {
            override fun onSuccess(model: com.brewmapp.brewmapp.features.main.card.brewery.data.model.Model) {
                view.setBrewery(model)
                getReview(id)
            }

            override fun onError(it: Throwable) {
                Log.i("code", "resto err ${it.message}")
            }
        })
    }

    fun getReview(id: String) {
        apiProductService.getReview(id, "resto", object : ApiProductService.ReviewCallback {
            override fun onSuccess(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>) {
                reviewList = models
                view.setReview(models)
            }

            override fun onError(it: Throwable) {
                Log.i("code", "error review ${it.message}")
            }

        })
    }
}