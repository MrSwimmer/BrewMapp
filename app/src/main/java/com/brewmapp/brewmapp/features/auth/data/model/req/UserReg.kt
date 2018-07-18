package com.brewmapp.brewmapp.features.auth.data.model.req

class UserReg() {
    lateinit var login: String
    lateinit var firstname: String
    lateinit var lastname: String
    lateinit var birthday: String
    lateinit var password: String
    var gender: String? = null
    var phone: String? = null

    constructor(login: String, firstname: String, lastname: String, birthday: String, password: String, gender: String?, phone: String?) : this() {
        this.login = login
        this.firstname = firstname
        this.lastname = lastname
        this.birthday = birthday
        this.password = password
        this.gender = gender
        this.phone = phone
    }
}