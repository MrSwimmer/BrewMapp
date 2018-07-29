package com.brewmapp.brewmapp.features.main.search.param.data

import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.AdSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum.AdSearchNum
import retrofit2.http.*
import rx.Observable

//no
//фильтрации
//брожения
//

interface ParamApi {

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearch(@Path("param") param: String): Observable<AdSearch>

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearchNum(@Path("param") param: String): Observable<AdSearchNum>

    @Headers("api-version: 1.04")
    @POST("geo/country?width=100&height=100&show_use_beer=1")
    fun getCountry(): Observable<AdSearch>

    @Headers("api-version: 1.04")
    @POST("brewery")
    fun getBrewery(): Observable<AdSearch>



}