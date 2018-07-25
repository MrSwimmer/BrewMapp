package com.brewmapp.brewmapp.core.di

import com.brewmapp.brewmapp.core.di.module.ApiModule
import com.brewmapp.brewmapp.core.di.module.SharedPreferencesModule
import com.brewmapp.brewmapp.features.auth.presentation.AuthActivity
import com.brewmapp.brewmapp.features.main.profile.SearchPresenter
import com.brewmapp.brewmapp.features.main.search.param.data.paging.AdSearchPositionalDataSource
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamPresenter
import com.brewmapp.brewmapp.features.main.profile.SettingsPresenter
import com.brewmapp.brewmapp.features.main.profile.SignInPresenter
import com.brewmapp.brewmapp.features.main.profile.SignUpPresenter
import com.brewmapp.brewmapp.features.main.search.result.data.paging.ResultPositionalDataSource
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApiModule::class, SharedPreferencesModule::class])
interface AppComponent {
    fun inject(signInPresenter: SignInPresenter)
    fun inject(signInPresenter: SignUpPresenter)
    fun inject(adSearchPositionalDataSource: AdSearchPositionalDataSource)
    fun inject(settingsPresenter: SettingsPresenter)
    fun inject(authActivity: AuthActivity)
    fun inject(paramPresenter: ParamPresenter)
    fun inject(resultPositionalDataSource: ResultPositionalDataSource)
    fun inject(searchPresenter: SearchPresenter)

}