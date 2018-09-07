package com.brewmapp.brewmapp.features.main.news.events.data

import com.brewmapp.brewmapp.features.main.news.events.data.model.Events
import com.brewmapp.brewmapp.features.main.news.news.data.model.News
import retrofit2.http.*
import rx.Observable

interface EventsApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("event?width=550&height=320&isAspect=1")
    fun getEvents(@Query("limit_start") start: Int, @Query("limit_end") end: Int, @FieldMap fields: Map<String, String>) : Observable<Events>

}