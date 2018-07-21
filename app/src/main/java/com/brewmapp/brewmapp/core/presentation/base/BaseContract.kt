package com.brewmapp.brewmapp.core.presentation.base

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface BaseContract {
    interface View : MvpView {
        fun showErrorMessage(message: String)
        fun showProgress()
        fun hideProgress()
    }
    interface Presenter<V: View> : MvpPresenter<V> {

    }
}