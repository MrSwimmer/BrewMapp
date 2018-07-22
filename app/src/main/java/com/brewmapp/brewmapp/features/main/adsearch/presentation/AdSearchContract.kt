package com.brewmapp.brewmapp.features.main.adsearch.presentation

import android.arch.paging.PagedList
import com.brewmapp.brewmapp.features.main.adsearch.data.model.res.Model
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface AdSearchContract {
    interface View : MvpView {
        fun setAdapter(pagedList: PagedList<Model>)
    }

    interface Presenter: MvpPresenter<View> {
        fun setRecyclerData(type: String)
    }
}