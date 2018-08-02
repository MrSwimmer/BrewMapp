package com.brewmapp.brewmapp.core.di.module

import com.brewmapp.brewmapp.features.auth.data.AuthApi
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.brewmapp.brewmapp.features.main.news.data.NewsApi
import com.brewmapp.brewmapp.features.main.news.domain.interactor.ApiNewsService
import com.brewmapp.brewmapp.features.main.product.data.ProductApi
import com.brewmapp.brewmapp.features.main.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.search.param.data.ParamApi
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import com.brewmapp.brewmapp.features.main.search.result.data.ResultApi
import com.brewmapp.brewmapp.features.main.search.result.domain.interactor.ApiResultService
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
    fun providesSearchService(retrofit: Retrofit): ApiParamService {
        val searchApi = retrofit.create(ParamApi::class.java)
        return ApiParamService(searchApi)
    }

    @Provides
    @Singleton
    fun providesResultService(retrofit: Retrofit): ApiResultService {
        val resultApi = retrofit.create(ResultApi::class.java)
        return ApiResultService(resultApi)
    }

    @Provides
    @Singleton
    fun providesProductService(retrofit: Retrofit): ApiProductService {
        val productApi = retrofit.create(ProductApi::class.java)
        return ApiProductService(productApi)
    }

    @Provides
    @Singleton
    fun providesNewsService(retrofit: Retrofit): ApiNewsService {
        val newsApi = retrofit.create(NewsApi::class.java)
        return ApiNewsService(newsApi)
    }
}