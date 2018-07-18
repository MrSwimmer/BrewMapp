package com.brewmapp.brewmapp.core.di.module

import com.brewmapp.brewmapp.features.auth.data.AuthApi
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {
    @Provides
    @Singleton
    fun providesService(): ApiAuthService {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.mems.fun/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        val brewApi = retrofit.create(AuthApi::class.java)
        return ApiAuthService(brewApi)
    }
}