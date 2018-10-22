package com.brewmapp.brewmapp.core.di

import com.brewmapp.brewmapp.core.di.module.ApiModule
import com.brewmapp.brewmapp.core.di.module.RoomModule
import com.brewmapp.brewmapp.core.di.module.SharedPreferencesModule
import com.brewmapp.brewmapp.features.auth.presentation.AuthActivity
import com.brewmapp.brewmapp.features.core.city.CityPresenter
import com.brewmapp.brewmapp.features.main.MainActivity
import com.brewmapp.brewmapp.features.main.card.brewery.presentation.BreweryPresenter
import com.brewmapp.brewmapp.features.main.card.event.presentation.EventCardPresenter
import com.brewmapp.brewmapp.features.main.card.news.NewsCardPresenter
import com.brewmapp.brewmapp.features.main.news.news.data.NewsPositionalDataSource
import com.brewmapp.brewmapp.features.main.news.news.data.paging.ResultPositionalDataSource
import com.brewmapp.brewmapp.features.main.card.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.news.events.data.EventsPositionalDataSource
import com.brewmapp.brewmapp.features.main.news.review.data.ReviewsPositionalDataSource
import com.brewmapp.brewmapp.features.main.profile.*
import com.brewmapp.brewmapp.features.main.search.param.domain.CallbackFabric
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ParamRepository
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamPresenter
import com.brewmapp.brewmapp.features.main.search.result.presentation.ResultPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, SharedPreferencesModule::class, RoomModule::class])
interface AppComponent {
    fun inject(signInPresenter: SignInPresenter)
    fun inject(signInPresenter: SignUpPresenter)
    fun inject(productPresenter: ProductPresenter)
    fun inject(authActivity: AuthActivity)
    fun inject(paramPresenter: ParamPresenter)
    fun inject(searchPresenter: SearchPresenter)
    fun inject(newsPresenter: NewsPresenter)
    fun inject(callbackFabric: CallbackFabric)
    fun inject(restoPresenter: RestoPresenter)
    fun inject(messagesPresenter: MessagesPresenter)
    fun inject(mapPresenter: MapPresenter)
    fun inject(friendsPresenter: FriendsPresenter)
    fun inject(mainActivity: MainActivity)
    fun inject(resultPresenter: ResultPresenter)
    fun inject(apiProductService: ApiProductService)
    fun inject(newsPositionalDataSource: NewsPositionalDataSource)
    fun inject(resultPositionalDataSource: ResultPositionalDataSource)
    fun inject(paramRepository: ParamRepository)
    fun inject(settingsPresenter: SettingsPresenter)
    fun inject(breweryPresenter: BreweryPresenter)
    fun inject(reviewsPositionalDataSource: ReviewsPositionalDataSource)
    fun inject(eventsPositionalDataSource: EventsPositionalDataSource)
    fun inject(newsCardPresenter: NewsCardPresenter)
    fun inject(eventCardPresenter: EventCardPresenter)
    fun inject(settingsController: SettingsController)
    fun inject(cityPresenter: CityPresenter)
}