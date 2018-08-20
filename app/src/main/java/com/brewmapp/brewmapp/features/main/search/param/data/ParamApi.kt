package com.brewmapp.brewmapp.features.main.search.param.data

import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.ParamResult
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum.ParamResultNum
import retrofit2.http.*
import rx.Observable

interface ParamApi {

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearch(@Path("param") param: String): Observable<ParamResult>

    @Headers("api-version: 1.04")
    @POST("beer/{param}")
    fun getSearchNum(@Path("param") param: String): Observable<ParamResultNum>

    @Headers("api-version: 1.04")
    @POST("geo/country?width=100&height=100&show_use_beer=1")
    fun getCountry(): Observable<ParamResult>

    @Headers("api-version: 1.04")
    @POST("brewery")
    fun getBrewery(): Observable<ParamResult>

    @Headers("api-version: 1.04")
    @GET("resto/type")
    fun getRestoType(): Observable<ParamResult>

    @Headers("api-version: 1.04")
    @GET("resto/kitchen")
    fun getKitchen(): Observable<ParamResult>

    @Headers("api-version: 1.04")
    @POST("resto/averageprice")
    fun getAveragePrice(): Observable<ParamResult>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("geo/city")
    fun getCity(@Field("City[name]") city: String): Observable<ParamResult>
}