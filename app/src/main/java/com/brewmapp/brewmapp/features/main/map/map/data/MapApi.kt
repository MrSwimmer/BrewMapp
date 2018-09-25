package com.brewmapp.brewmapp.features.main.map.map.data

import com.brewmapp.brewmapp.features.main.map.map.data.model.Coordinates
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

interface MapApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("resto/getcoordinates")
    fun getMarkers(@Field("coordStart") begin: String, @Field("coordEnd") end: String) : Observable<Coordinates>
}