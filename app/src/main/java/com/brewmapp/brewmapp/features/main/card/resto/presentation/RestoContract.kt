package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.card.resto.data.model.Model

interface RestoContract {
    interface View : BaseContract.View {
        fun setResto(model: Model)
        fun setReview(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getResto(id: String)
    }
}