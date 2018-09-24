package com.brewmapp.brewmapp.features.main.card.product.data

import com.brewmapp.brewmapp.features.main.card.product.data.model.product.Product
import com.brewmapp.brewmapp.features.main.card.resto.data.model.Resto
import com.brewmapp.brewmapp.features.main.card.product.data.model.review.Review
import retrofit2.http.*
import rx.Observable

interface ProductApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("beer/beer")
    fun getProduct(@Field("Beer[id]") id: String) : Observable<Product>

    @Headers("api-version: 1.04")
    @GET("resto/restodata")
    fun getResto(@Query("resto_id") id: String) : Observable<Resto>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("reviews")
    fun getReview(@Field("Review[related_model]") modelName: String, @Field("Review[related_id]") id: String) : Observable<Review>
}