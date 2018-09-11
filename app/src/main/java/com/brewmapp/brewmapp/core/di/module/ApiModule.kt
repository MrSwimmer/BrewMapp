package com.brewmapp.brewmapp.core.di.module

import com.brewmapp.brewmapp.features.auth.data.AuthApi
import com.brewmapp.brewmapp.features.auth.domain.ApiAuthService
import com.brewmapp.brewmapp.features.main.card.brewery.data.BreweryApi
import com.brewmapp.brewmapp.features.main.card.brewery.domain.ApiBreweryService
import com.brewmapp.brewmapp.features.main.news.news.data.NewsApi
import com.brewmapp.brewmapp.features.main.news.news.domain.interactor.ApiNewsService
import com.brewmapp.brewmapp.features.main.card.product.data.ProductApi
import com.brewmapp.brewmapp.features.main.card.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.news.events.data.EventsApi
import com.brewmapp.brewmapp.features.main.news.events.domain.interactor.ApiEventsService
import com.brewmapp.brewmapp.features.main.news.review.data.ReviewsApi
import com.brewmapp.brewmapp.features.main.news.review.domain.interactor.ApiReviewsService
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

    @Provides
    @Singleton
    fun providesBreweryService(retrofit: Retrofit): ApiBreweryService {
        val breweryApi = retrofit.create(BreweryApi::class.java)
        return ApiBreweryService(breweryApi)
    }

    @Provides
    @Singleton
    fun providesReviewsService(retrofit: Retrofit): ApiReviewsService {
        val reviewsApi = retrofit.create(ReviewsApi::class.java)
        return ApiReviewsService(reviewsApi)
    }

    @Provides
    @Singleton
    fun providesEventsService(retrofit: Retrofit): ApiEventsService {
        val eventsApi = retrofit.create(EventsApi::class.java)
        return ApiEventsService(eventsApi)
    }
}