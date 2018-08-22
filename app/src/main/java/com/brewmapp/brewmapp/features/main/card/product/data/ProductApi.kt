package com.brewmapp.brewmapp.features.main.card.product.data

import com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel.Product
import retrofit2.http.*
import rx.Observable

interface ProductApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("beer/beer")
    fun getProduct(@Field("Beer[id]") id: String) : Observable<Product>


}