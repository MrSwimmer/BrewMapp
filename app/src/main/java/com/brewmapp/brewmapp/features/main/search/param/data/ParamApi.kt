package com.brewmapp.brewmapp.features.main.search.param.data

import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Param
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum.ParamNum
import retrofit2.http.*
import rx.Observable

interface ParamApi {

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearch(@Path("param") param: String): Observable<Param>

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearchNum(@Path("param") param: String): Observable<ParamNum>

    @Headers("api-version: 1.04")
    @POST("geo/country?width=100&height=100&show_use_beer=1")
    fun getCountry(): Observable<Param>

    @Headers("api-version: 1.04")
    @POST("brewery")
    fun getBrewery(): Observable<Param>

    @Headers("api-version: 1.04")
    @GET("resto/type")
    fun getRestoType(): Observable<Param>

    @Headers("api-version: 1.04")
    @GET("resto/kitchen")
    fun getKitchen(): Observable<Param>

    @Headers("api-version: 1.04")
    @POST("resto/averageprice")
    fun getAveragePrice(): Observable<Param>

    @FormUrlEncoded
    @Headers("api-version: 1.05")
    @POST("geo/city")
    fun getCity(@Field("City[name]") city: String): Observable<Param>
}