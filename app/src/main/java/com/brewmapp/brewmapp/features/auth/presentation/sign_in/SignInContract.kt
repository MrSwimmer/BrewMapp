package com.brewmapp.brewmapp.features.main.profile

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface SignInContract {
    interface View : MvpView
    interface Presenter: MvpPresenter<View> {
        fun signIn(toString: String, toString1: String)
    }
}