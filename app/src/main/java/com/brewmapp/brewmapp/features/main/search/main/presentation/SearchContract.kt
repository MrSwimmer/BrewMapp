package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search

interface SearchContract {
    interface View : BaseContract.View {
        fun initAdapter(searches: ArrayList<Search>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun setRecyclerData(mode: Mode)
    }
}