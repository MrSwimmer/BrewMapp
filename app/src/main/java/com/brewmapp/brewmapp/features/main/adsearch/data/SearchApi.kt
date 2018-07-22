package com.brewmapp.brewmapp.features.main.adsearch.data

import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.adsearch.data.model.res.AdSearch
import retrofit2.http.*
import rx.Observable

//no
//фильтрации
//брожения
//

interface SearchApi {
    @FormUrlEncoded
    @Headers(R.string.api_version.toString())
    @POST("beer/{param}?limit_start={start}&limit_end={end}")
    fun getSearch(@Path("param") param: String, @Path("start") start: Int, @Path("end") end: Int): Observable<AdSearch>

    @FormUrlEncoded
    @Headers(R.string.api_version.toString())
    @POST("geo/country?width=100&height=100&show_use_beer=1")
    fun getCountry(): Observable<AdSearch>

    @FormUrlEncoded
    @Headers(R.string.api_version.toString())
    @POST("brewery?limit_start={start}&limit_end={end}")
    fun getBrewery(@Path("start") start: Int, @Path("end") end: Int): Observable<AdSearch>
}