package com.brewmapp.brewmapp.features.main.search.result.data

import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Beer
import retrofit2.http.*
import rx.Observable

interface ResultApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("beer/beer")
    fun getResults(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<Beer>
}