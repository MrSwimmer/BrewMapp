package com.brewmapp.brewmapp.features.main.search.param.domain.interactor

import android.arch.paging.PositionalDataSource
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
            else -> CallbackFabric.paramCallback(api.getSearch(type), callback)
        }
    }

    interface ParamCallback {
        fun onSuccess(models: MutableList<Model>)
        fun onError(it: Throwable)
    }
}