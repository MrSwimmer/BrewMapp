package com.brewmapp.brewmapp.features.core.city

import com.brewmapp.brewmapp.core.presentation.base.BaseActivityContract
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model

interface CityContract {
    interface View : BaseActivityContract.View {
        fun initAdapter(models: MutableList<Model>)
    }

    interface Presenter: BaseActivityContract.Presenter<View> {
        fun setRecyclerCity(city: String)
    }
}