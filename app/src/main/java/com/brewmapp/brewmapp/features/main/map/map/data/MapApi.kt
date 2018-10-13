package com.brewmapp.brewmapp.features.main.map.map.data

import com.brewmapp.brewmapp.features.main.card.resto.data.model.Resto
import com.brewmapp.brewmapp.features.main.map.map.data.model.req.Coords
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Coordinates
import retrofit2.http.*
import rx.Observable

interface MapApi {

    @Headers("api-version: 1.04")
    @POST("resto/getcoordinates?limit_start=0&limit_end=30")
    fun getResto(@Body coord: Coords): Observable<Coordinates>

    @Headers("api-version: 1.04")
    @POST("beer/getcoordinates?limit_start=0&limit_end=30")
    fun getBeer(@Body coord: Coords): Observable<Coordinates>
}