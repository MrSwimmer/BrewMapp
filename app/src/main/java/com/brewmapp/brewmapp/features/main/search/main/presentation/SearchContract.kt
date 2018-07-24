package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface SearchContract {
    interface View : MvpView {
        fun initAdapter(searches: ArrayList<Search>)
    }

    interface Presenter: MvpPresenter<View> {
        fun setRecyclerData()
    }
}