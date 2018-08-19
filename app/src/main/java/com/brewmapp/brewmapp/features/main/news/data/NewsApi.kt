package com.brewmapp.brewmapp.features.main.news.data

import com.brewmapp.brewmapp.features.main.news.data.model.News
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Result
import retrofit2.http.*
import rx.Observable

interface NewsApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("news")
    fun getNews(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<News>
}