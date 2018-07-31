package com.brewmapp.brewmapp.core.di

import com.brewmapp.brewmapp.core.di.module.ApiModule
import com.brewmapp.brewmapp.core.di.module.SharedPreferencesModule
import com.brewmapp.brewmapp.features.auth.presentation.AuthActivity
import com.brewmapp.brewmapp.features.auth.presentation.city.CityPresenter
import com.brewmapp.brewmapp.features.main.MainActivity
import com.brewmapp.brewmapp.features.main.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.profile.*
import com.brewmapp.brewmapp.features.main.search.param.domain.CallbackFabric
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamPresenter
import com.brewmapp.brewmapp.features.main.search.result.presentation.ResultPresenter
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun inject(signInPresenter: SignInPresenter)
    fun inject(signInPresenter: SignUpPresenter)
    fun inject(productPresenter: ProductPresenter)
    fun inject(authActivity: AuthActivity)
    fun inject(paramPresenter: ParamPresenter)
    fun inject(searchPresenter: SearchPresenter)
    fun inject(newsPresenter: NewsPresenter)
    fun inject(callbackFabric: CallbackFabric)
    fun inject(settingsPresenter: SettingsPresenter)
    fun inject(messagesPresenter: MessagesPresenter)
    fun inject(mapPresenter: MapPresenter)
    fun inject(friendsPresenter: FriendsPresenter)
    fun inject(mainActivity: MainActivity)
    fun inject(resultPresenter: ResultPresenter)
    fun inject(cityPresenter: CityPresenter)
    fun inject(apiProductService: ApiProductService)
}