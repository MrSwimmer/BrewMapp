package com.brewmapp.brewmapp.features.auth.data.model.req

class UserLogIn() {
    lateinit var login: String
    lateinit var password: String

    constructor(login: String, password: String) : this() {
        this.login = login
        this.password = password
    }
}