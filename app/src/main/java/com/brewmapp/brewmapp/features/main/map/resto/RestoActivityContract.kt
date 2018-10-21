package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseActivityContract
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.card.resto.data.model.Model

interface RestoActivityContract {
    interface View : BaseActivityContract.View {
        fun setResto(model: Model)
        fun setReview(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>)
    }

    interface Presenter: BaseActivityContract.Presenter<View> {
        fun getResto(id: String)
    }
}