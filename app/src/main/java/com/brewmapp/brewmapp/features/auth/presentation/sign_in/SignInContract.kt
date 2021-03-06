package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface SignInContract {
    interface View : BaseContract.View {
        fun gotoMain()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun signIn(toString: String, toString1: String)
    }
}