package com.brewmapp.brewmapp.core.domain.interactor

import android.content.SharedPreferences

class SettingsService(private val sharedPreferences: SharedPreferences) {
    val TOKEN = "token"
    val ERROR = "error"
    val FIRST = "first"
    val URL = "url"
    val CITY_ID = "city id"
    val CITY_NAME = "city name"
    val USER_ID = "user id"

    fun setToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(TOKEN, token)
        editor.apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString(TOKEN, "error")
    }

    fun getUsername(): String {
        return sharedPreferences.getString(FIRST, "Гость")
    }

    fun getUrl(): String {
        return sharedPreferences.getString(URL, ERROR)
    }

    fun getUserId(): String {
        return sharedPreferences.getString(USER_ID, ERROR)
    }

    fun setUsername(first: String) {
        val editor = sharedPreferences.edit()
        editor.putString(FIRST, first)
        editor.apply()
    }

    fun setCityId(cityId: String) {
        val editor = sharedPreferences.edit()
        editor.putString(CITY_ID, cityId)
        editor.apply()
    }

    fun setCityName(cityName: String) {
        val editor = sharedPreferences.edit()
        editor.putString(CITY_NAME, cityName)
        editor.apply()
    }

    fun setUrl(url: String) {
        val editor = sharedPreferences.edit()
        editor.putString(URL, url)
        editor.apply()
    }

    fun setUserId(id: String) {
        val editor = sharedPreferences.edit()
        editor.putString(USER_ID, id)
        editor.apply()
    }
}