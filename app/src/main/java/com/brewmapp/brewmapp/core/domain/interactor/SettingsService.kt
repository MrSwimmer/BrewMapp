package com.brewmapp.brewmapp.core.domain.interactor

import android.content.SharedPreferences

class SettingsService(private val sharedPreferences: SharedPreferences) {
    val TOKEN = "token"

    fun setToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }
}