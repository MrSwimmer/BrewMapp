package com.brewmapp.brewmapp.features.main.adsearch.data

import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.adsearch.data.model.res.beer.Beer
import com.brewmapp.brewmapp.features.main.adsearch.data.model.res.search.AdSearch
import com.brewmapp.brewmapp.features.main.adsearch.data.model.res.searchnum.AdSearchNum
import retrofit2.http.*
import rx.Observable

//no
//фильтрации
//брожения
//

interface SearchApi {

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearch(@Path("param") param: String, @Query("limit_start") start: Int, @Query("limit_end") end: Int): Observable<AdSearch>

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearchNum(@Path("param") param: String, @Query("limit_start") start: Int, @Query("limit_end") end: Int): Observable<AdSearchNum>

    @FormUrlEncoded
    @Headers(R.string.api_version.toString())
    @POST("geo/country?width=100&height=100&show_use_beer=1")
    fun getCountry(): Observable<AdSearch>

    @FormUrlEncoded
    @Headers(R.string.api_version.toString())
    @POST("brewery?limit_start={start}&limit_end={end}")
    fun getBrewery(@Path("start") start: Int, @Path("end") end: Int): Observable<AdSearch>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("beer/beer")
    fun getResults(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<Beer>
}