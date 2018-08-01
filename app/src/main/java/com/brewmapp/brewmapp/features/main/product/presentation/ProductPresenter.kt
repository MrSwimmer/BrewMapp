package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.product.data.model.AvgPrice
import com.brewmapp.brewmapp.features.main.product.data.model.Model
import com.brewmapp.brewmapp.features.main.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import javax.inject.Inject

class ProductPresenter : BasePresenter<ProductContract.View>(), ProductContract.Presenter {

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiProductService
    @Inject
    lateinit var apiParamsService: ApiParamService

    override fun getProduct(id: String) {
        apiService.getProduct(id, object : ApiProductService.ProductCallback {
            override fun onSuccess(model: Model) {
                view.setProduct(model)
                if(model.pricerangeId == null) {

                }
                setAdInfo(model.pricerangeId, model.countryId, model.brandId)
                view.hideProgress()
            }

            override fun onError(it: Throwable) {
                view.showErrorMessage(it.message!!)
                view.hideProgress()
            }

        })
    }

    fun setAdInfo(price: String?, countryId: String?, brandId: String?) {
        apiParamsService.getParams(TypeSearch.AVERAGE_PRICE.type, object : ApiParamService.ParamCallback {
            override fun onSuccess(models: MutableList<com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model>) {
                models.forEach {
                    if (it.id == price)
                        view.setPrice(it.price)
                }
            }

            override fun onError(it: Throwable) {
                Log.i("code", "price err ${it.message}")
            }

        })
        apiParamsService.getParams(TypeSearch.COUNTRY.type, object : ApiParamService.ParamCallback {
            override fun onSuccess(models: MutableList<com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model>) {
                models.forEach {
                    if (it.id == countryId)
                        view.setCountry(it.name["1"])
                }
            }

            override fun onError(it: Throwable) {
                Log.i("code", "price err ${it.message}")
            }

        })
        apiParamsService.getParams(TypeSearch.BRAND.type, object : ApiParamService.ParamCallback {
            override fun onSuccess(models: MutableList<com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model>) {
                models.forEach {
                    if (it.id == brandId)
                        view.setBrand(it.name["1"])
                }
            }

            override fun onError(it: Throwable) {
                Log.i("code", "price err ${it.message}")
            }

        })
        apiParamsService.getParams(TypeSearch.BRAND.type, object : ApiParamService.ParamCallback {
            override fun onSuccess(models: MutableList<com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model>) {
                models.forEach {
                    view.setBrand(it.name["1"])
                }
            }

            override fun onError(it: Throwable) {
                Log.i("code", "price err ${it.message}")
            }

        })
    }


}