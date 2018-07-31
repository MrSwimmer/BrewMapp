package com.brewmapp.brewmapp.features.main.search.result.data

import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Result
import retrofit2.http.*
import rx.Observable
import java.util.HashMap

interface ResultApi {
    @FormUrlEncoded
    @Headers("api-version: 1.05")
    @POST("beer/beer")
    fun getBeerResults(@FieldMap fields: Map<String, String>) : Observable<Result>

    @FormUrlEncoded
    @Headers("api-version: 1.05")
    @POST("brewery?limit_start=&limit_end=")
    fun getBreweryResults(@FieldMap fields: Map<String, String>) : Observable<Result>

    @FormUrlEncoded
    @Headers("api-version: 1.05")
    @POST("search/resto?lat=&lon=&limit_start=&limit_end=&user_id=")
    fun getRestoResults(@FieldMap map: HashMap<String, String>): Observable<Result>
}