package com.brewmapp.brewmapp.features.main.search.param.presentation

import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.core.presentation.base.BaseActivityContract
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model

interface ParamContract {
    interface View : BaseActivityContract.View {
        fun initAdapter(models: MutableList<Model>)
    }

    interface Presenter: BaseActivityContract.Presenter<View> {
        fun setRecyclerData(typeSearch: TypeSearch)
        fun setRecyclerCity(city: String?)
    }
}