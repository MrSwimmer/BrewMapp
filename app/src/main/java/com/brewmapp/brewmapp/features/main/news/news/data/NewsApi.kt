package com.brewmapp.brewmapp.features.main.news.news.data

import com.brewmapp.brewmapp.features.main.news.news.data.model.news.News
import com.brewmapp.brewmapp.features.main.news.news.data.model.reviews.Reviews
import retrofit2.http.*
import rx.Observable

interface NewsApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("news")
    fun getNews(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<News>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("event")
    fun getEvents(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<News>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("reviews")
    fun getReviews(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<Reviews>

}