package com.brewmapp.brewmapp.core.domain.interactor

import android.content.SharedPreferences

class SettingsService(private val sharedPreferences: SharedPreferences) {
    val TOKEN = "token"
    val ERROR = "error"

    fun setToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString(TOKEN, "error")
    }
}