package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel.Model
import com.brewmapp.brewmapp.features.main.card.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.Param
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ParamRepository
import javax.inject.Inject

class ProductPresenter : BasePresenter<ProductContract.View>(), ProductContract.Presenter {

    var repository: ParamRepository

    init {
        App.component.inject(this)
        repository = ParamRepository()
    }

    @Inject
    lateinit var apiService: ApiProductService

    var paramsList = mutableListOf<Param>()

    override fun getProduct(id: String) {
        apiService.getProduct(id, object : ApiProductService.ProductCallback {
            override fun onSuccess(model: Model) {
                view.setProduct(model)
                paramsList.clear()
                paramsList.add(Param("Средняя цена:", "", R.drawable.ic_search_price))
                paramsList.add(Param("Страна производитель:", model.relations.country.name.get1(), R.drawable.ic_search_country))
                paramsList.add(Param("Бренд:", model.relations.beerBrand.name.get1(), R.drawable.ic_search_price))
                view.setParams(paramsList)
                /*getParam("Средняя цена:", TypeSearch.PRICERANGE, model.pricerangeId, R.drawable.ic_search_price)
                getParam("Страна производитель", TypeSearch.COUNTRY, model.countryId, R.drawable.ic_search_country)
                getParam("Бренд", TypeSearch.BRAND, model.brandId, R.drawable.ic_search_brand)*/
            }

            override fun onError(it: Throwable) {
                Log.i("code", it.message)
                view.showErrorMessage(it.message!!)
            }
        })
    }

    /*fun getParam(paramTitle: String, typeSearch: TypeSearch, id: String, iconId: Int) {
        repository.getParams(typeSearch, object : ParamRepository.ParamCallback {
            override fun onSuccess(params: List<com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model>) {
                params.forEach {
                    if(it.id == id) {
                        val param = Param(paramTitle, it.name["1"]!!, iconId)
                        paramsList.add(param)
                        if(paramsList.size == 3)
                            view.setParams(paramsList)
                    }
                }
            }

            override fun onError(e: Throwable) {

            }

        })
    }*/
}