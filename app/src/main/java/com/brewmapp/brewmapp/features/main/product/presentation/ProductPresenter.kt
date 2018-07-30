package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import javax.inject.Inject

class ProductPresenter : BasePresenter<ProductContract.View>(), ProductContract.Presenter {

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiProductService

    override fun getProduct(id: String) {
        apiService.getProduct(id, object : ApiProductService.ProductCallback {
            override fun onSuccess(model: Model) {
                view.setProduct(model)
                view.hideProgress()
            }

            override fun onError(it: Throwable) {
                view.showErrorMessage(it.message!!)
                view.hideProgress()
            }

        })
    }
}