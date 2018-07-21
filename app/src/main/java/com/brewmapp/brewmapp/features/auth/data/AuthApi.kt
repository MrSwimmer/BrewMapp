package com.brewmapp.brewmapp.features.auth.data

import com.brewmapp.brewmapp.features.auth.data.model.req.UserLogIn
import com.brewmapp.brewmapp.features.auth.data.model.res.UserData
import retrofit2.http.*
import rx.Observable

interface AuthApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("start/register")
    fun signUp(@Field("User[login]") login: String, @Field("User[firstname]") firstname: String, @Field("User[lastname]") lastname: String, @Field("User[birthday]") birthday: String, @Field("User[password]") password: String, @Field("User[email]") email: String): Observable<UserData>

    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("start/login")
    fun signIn(@Field("User[login]") login: String, @Field("User[password]") password: String): Observable<UserData>
}