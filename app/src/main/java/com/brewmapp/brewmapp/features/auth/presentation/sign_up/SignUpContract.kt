package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface SignUpContract {
    interface View : BaseContract.View {
        fun gotoMain()
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun signUp(email: String, password: String, first: String, last: String, dateString: String)
    }
}