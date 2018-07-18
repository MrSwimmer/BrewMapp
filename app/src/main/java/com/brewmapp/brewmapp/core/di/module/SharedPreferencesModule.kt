package com.brewmapp.brewmapp.core.di.module

import android.content.Context
import android.content.SharedPreferences
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SharedPreferencesModule(var context: Context) {

    @Provides
    fun context(): Context {
        return context
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(): SharedPreferences {
        return context.getSharedPreferences("settings", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun settingsService(sharedPreferences: SharedPreferences): SettingsService {
        return SettingsService(sharedPreferences)
    }
}