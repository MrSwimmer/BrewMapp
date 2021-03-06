package com.brewmapp.brewmapp.features.main.search.result.presentation

import androidx.paging.PagedList
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.search.result.data.model.Model

interface ResultContract {
    interface View : BaseContract.View {
        fun setAdapter(pagedList: PagedList<Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun setRecyclerData()
    }
}