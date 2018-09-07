package com.brewmapp.brewmapp.features.main.news.review.data

import com.brewmapp.brewmapp.features.main.news.review.data.model.Reviews
import retrofit2.http.*
import rx.Observable

interface ReviewsApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("reviews?width=550&height=320&isAspect=1")
    fun getReviews(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<Reviews>

}