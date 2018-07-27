package com.brewmapp.brewmapp.features.main.product.data

import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Beer
import retrofit2.http.*
import rx.Observable

interface ProductApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("search/beer")
    fun getProduct(@Field("Beer[id]") id: String) : Observable<Beer>

}