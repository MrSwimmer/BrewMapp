package com.brewmapp.brewmapp.features.main.profile

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface SignUpContract {
    interface View : MvpView {
        fun gotoMain()
    }

    interface Presenter: MvpPresenter<View> {
        fun signUp(email: String, password: String, first: String, last: String, dateString: String)
    }
}