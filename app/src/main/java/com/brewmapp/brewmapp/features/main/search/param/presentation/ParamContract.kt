package com.brewmapp.brewmapp.features.main.search.param.presentation

import android.arch.paging.PagedList
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface ParamContract {
    interface View : BaseContract.View {
        fun setAdapter(pagedList: PagedList<Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun setRecyclerData(type: String)
    }
}