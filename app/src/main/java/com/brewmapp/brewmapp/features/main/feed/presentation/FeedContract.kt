package com.brewmapp.brewmapp.features.main.profile

import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface FeedContract {
    interface View : MvpView
    interface Presenter: MvpPresenter<View>
}