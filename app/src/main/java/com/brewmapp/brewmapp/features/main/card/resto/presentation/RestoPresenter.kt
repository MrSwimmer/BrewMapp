package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.card.product.data.model.product.RestoMenu
import com.brewmapp.brewmapp.features.main.card.product.data.model.resto.Model
import com.brewmapp.brewmapp.features.main.card.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.Param
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.resto.Resto
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search
import javax.inject.Inject

class RestoPresenter : BasePresenter<RestoContract.View>(), RestoContract.Presenter {
    init {
        App.component.inject(this)
    }
    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()

    @Inject
    lateinit var apiService: ApiProductService

    override fun getResto(id: String) {
        apiService.getResto(id, object : ApiProductService.RestoCallback {
            override fun onSuccess(model: Model) {
                view.setResto(model)
                getReview(id)
            }

            override fun onError(it: Throwable) {
                Log.i("code", "resto err ${it.message}")
            }
        })
    }

    fun getReview(id: String) {
        apiService.getReview(id, "resto", object : ApiProductService.ReviewCallback {
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