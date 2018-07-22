package com.brewmapp.brewmapp.features.main.adsearch.domain

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.brewmapp.brewmapp.features.main.adsearch.data.AdSearch
import com.brewmapp.brewmapp.features.main.adsearch.data.SearchApi
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiAdSearchService(val api: SearchApi) {
    enum class TypeSearch(val type: String) {
        COUNTRY("country"),
        TYPE("type"),
        BRAND("brand"),
        COLOR("color"),
        FRAGRANCE("fragrance"), //aromat
        TASTE("taste"),
        AFTERTASTE("aftertaste"),
        PACKING("packing"),
        STRENGTH("strength"), //crepost
        PRICERANGE("pricerange"),
        DENSITY("density"), //plotnost
        IBU("ibu")
    }

    fun loadRange(type: String, params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<AdSearch>) {
        when (type) {
            TypeSearch.COUNTRY.type -> {
                api.getCountry()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({callback.onResult(it.data)}, {})
            }
        }
    }

    fun loadInitial(type: String, params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<AdSearch>) {

    }

    interface SearchCallback {
        fun onSuccess(adSearch: AdSearch)
        fun onError(e: Throwable)
    }
}