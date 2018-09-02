package com.brewmapp.brewmapp.features.main.card.brewery.data

import com.brewmapp.brewmapp.features.main.card.brewery.data.model.Brewery
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Headers
import retrofit2.http.POST
import rx.Observable

interface BreweryApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("brewery")
    fun getBrewery(@Field("Brewery[id]") id: String) : Observable<Brewery>
}