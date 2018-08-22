package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.Param

interface ProductContract {
    interface View : BaseContract.View {
        fun setParams(paramsList: MutableList<Param>)
        fun setProduct(model: com.brewmapp.brewmapp.features.main.card.product.data.model.newmodel.Model)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getProduct(id: String)
    }
}