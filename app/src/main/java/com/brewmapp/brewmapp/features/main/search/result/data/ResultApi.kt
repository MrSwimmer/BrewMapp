package com.brewmapp.brewmapp.features.main.search.result.data

import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Result
import retrofit2.http.*
import rx.Observable
import kotlin.collections.HashMap

interface ResultApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("beer/beer")
    fun getBeerResults(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<Result>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("brewery")
    fun getBreweryResults(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<Result>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("search/resto?lat=&lon=&user_id=")
    fun getRestoResults(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap map: HashMap<String, String>): Observable<Result>
}