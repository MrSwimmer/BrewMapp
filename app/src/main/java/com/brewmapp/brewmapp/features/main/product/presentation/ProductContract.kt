package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract

interface ProductContract {
    interface View : BaseContract.View {
        fun setProduct(model: com.brewmapp.brewmapp.features.main.product.data.model.Model)
        fun setBrand(brand: String?)
        fun setCountry(country: String?)
        fun setPrice(price: String?)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getProduct(id: String)
    }
}