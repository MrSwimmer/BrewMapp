package com.brewmapp.brewmapp.features.auth.data

import com.brewmapp.brewmapp.features.auth.data.model.req.UserLogIn
import com.brewmapp.brewmapp.features.auth.data.model.req.UserReg
import com.brewmapp.brewmapp.features.auth.data.model.res.User
import retrofit2.http.*
import rx.Observable
/*usermap["User[login]"] = user.login
usermap["User[firstname]"] = user.firstname
usermap["User[lastname]"] = user.lastname
usermap["User[birthday]"] = user.birthday
usermap["User[password]"] = user.password
usermap["User[email]"] = user.login*/
interface AuthApi {
    @FormUrlEncoded
    @Headers("api-version: 1.04")
    @POST("start/register")
    fun signUp(@Field("User[login]") login: String, @Field("User[firstname]") firstname: String, @Field("User[lastname]") lastname: String, @Field("User[birthday]") birthday: String, @Field("User[password]") password: String, @Field("User[email]") email: String): Observable<User>

    @POST("start/login/")
    fun signIn(@Body user: UserLogIn): Observable<User>
}