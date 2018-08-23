package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.news.news.data.model.news.Model

interface NewsContract {
    interface View : BaseContract.View {
        fun setAdapter(pagedList: PagedList<Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun setRecyclerData(mode: Mode)
    }
}