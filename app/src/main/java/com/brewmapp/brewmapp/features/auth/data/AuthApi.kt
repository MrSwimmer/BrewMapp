package com.brewmapp.brewmapp.features.auth.data

import com.brewmapp.brewmapp.features.auth.data.model.req.UserLogIn
import com.brewmapp.brewmapp.features.auth.data.model.req.UserReg
import com.brewmapp.brewmapp.features.auth.data.model.res.User
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

interface AuthApi {
    @POST("stat/register")
    fun signUp(@Body user: UserReg): Observable<User>
    @POST("stat/login")
    fun signIn(@Body user: UserLogIn): Observable<User>
}