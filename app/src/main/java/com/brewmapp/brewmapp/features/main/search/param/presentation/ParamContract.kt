package com.brewmapp.brewmapp.features.main.search.param.presentation

import android.arch.paging.PagedList
import com.brewmapp.brewmapp.core.presentation.base.BaseActivityContract
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface ParamContract {
    interface View : BaseActivityContract.View {
        fun initAdapter(models: MutableList<Model>)
    }

    interface Presenter: BaseActivityContract.Presenter<View> {
        fun setRecyclerData(type: String)
    }
}