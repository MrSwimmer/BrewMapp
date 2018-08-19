package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.news.data.model.Model
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface NewsContract {
    interface View : BaseContract.View {
        fun setAdapter(pagedList: PagedList<Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun setRecyclerData(mode: String)
    }
}