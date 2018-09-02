package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.Param
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.resto.Resto

interface ProductContract {
    interface View : BaseContract.View {
        fun setParams(paramsList: MutableList<Param>)
        fun setProduct(model: com.brewmapp.brewmapp.features.main.card.product.data.model.product.Model)
        fun setResto(restoList: MutableList<Resto>)
        fun setReview(model: MutableList<Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getProduct(id: String)
    }
}