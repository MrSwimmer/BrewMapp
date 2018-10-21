package com.brewmapp.brewmapp.features.main.search.param.domain.interactor

import android.util.Log
import com.brewmapp.brewmapp.features.main.search.param.data.ParamApi
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.CallbackFabric

class ApiParamService(val api: ParamApi) {

    fun getParams(typeSearch: TypeSearch, callback: ParamCallback) {
        when (typeSearch) {
            TypeSearch.COUNTRY -> CallbackFabric.paramCallback(api.getCountry(), callback)
            TypeSearch.BREWERY -> CallbackFabric.paramCallback(api.getBrewery(), callback)
            TypeSearch.STRENGTH, TypeSearch.IBU, TypeSearch.PACKING -> CallbackFabric.paramNumCallback(api.getSearchNum(typeSearch.type), callback)
            TypeSearch.RESTO_TYPE -> CallbackFabric.paramCallback(api.getRestoType(), callback)
            TypeSearch.AVERAGE_PRICE -> CallbackFabric.paramCallback(api.getAveragePrice(), callback)
            TypeSearch.KITCHEN -> CallbackFabric.paramCallback(api.getKitchen(), callback)
            TypeSearch.MAP_RESTO_KITCHEN -> CallbackFabric.paramCallback(api.getKitchen(), callback)
            TypeSearch.MAP_RESTO_TYPE -> CallbackFabric.paramCallback(api.getRestoType(), callback)
            else -> {
                Log.i("code", "field ${typeSearch.field}")
                CallbackFabric.paramCallback(api.getSearch(typeSearch.type), callback)
            }
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