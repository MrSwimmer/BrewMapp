package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract

interface ProductContract {
    interface View : BaseContract.View {
        fun setProduct(model: com.brewmapp.brewmapp.features.main.product.data.model.Model)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getProduct(id: String)
    }
}