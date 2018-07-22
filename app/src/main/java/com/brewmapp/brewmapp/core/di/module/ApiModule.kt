package com.brewmapp.brewmapp.core.di.module

import com.brewmapp.brewmapp.features.auth.data.AuthApi
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.brewmapp.brewmapp.features.main.adsearch.data.SearchApi
import com.brewmapp.brewmapp.features.main.adsearch.domain.interactor.ApiAdSearchService
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
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl("https://brewmapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
    }

    @Provides
    @Singleton
    fun providesAuthService(retrofit: Retrofit): ApiAuthService {
        val authApi = retrofit.create(AuthApi::class.java)
        return ApiAuthService(authApi)
    }

    @Provides
    @Singleton
    fun providesSearchService(retrofit: Retrofit): ApiAdSearchService {
        val searchApi = retrofit.create(SearchApi::class.java)
        return ApiAdSearchService(searchApi)
    }
}