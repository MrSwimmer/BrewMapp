package com.brewmapp.brewmapp.features.main.search.param.domain.interactor

import com.brewmapp.brewmapp.features.main.search.param.data.ParamApi
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.CallbackFabric

class ApiParamService(val api: ParamApi) {

    fun getParams(type: String, callback: ParamCallback) {
        when (type) {
            TypeSearch.COUNTRY.type -> CallbackFabric.paramCallback(api.getCountry(), callback)
            TypeSearch.BREWERY.type -> CallbackFabric.paramCallback(api.getBrewery(), callback)
            TypeSearch.STRENGTH.type, TypeSearch.IBU.type, TypeSearch.PACKING.type -> CallbackFabric.paramNumCallback(api.getSearchNum(type), callback)
            TypeSearch.RESTO_TYPE.type -> CallbackFabric.paramCallback(api.getRestoType(), callback)
            TypeSearch.AVERAGE_PRICE.type -> CallbackFabric.paramCallback(api.getAveragePrice(), callback)
            TypeSearch.KITCHEN.type -> CallbackFabric.paramCallback(api.getKitchen(), callback)
            else -> CallbackFabric.paramCallback(api.getSearch(type), callback)
        }
    }

    fun getCity(city: String, callback: ParamCallback) {
        CallbackFabric.paramCallback(api.getCity(city), callback)
    }

    interface ParamCallback {
        fun onSuccess(models: MutableList<Model>)
        fun onError(it: Throwable)
    }
}