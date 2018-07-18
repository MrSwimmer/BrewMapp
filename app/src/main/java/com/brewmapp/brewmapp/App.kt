package com.brewmapp.brewmapp

import android.app.Application
import com.brewmapp.brewmapp.core.di.AppComponent
import com.brewmapp.brewmapp.core.di.DaggerAppComponent
import com.brewmapp.brewmapp.core.di.module.SharedPreferencesModule

class App : Application() {

    companion object {
        lateinit var component : AppComponent
    }
    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
                .sharedPreferencesModule(SharedPreferencesModule(applicationContext))
                .build()
    }
}