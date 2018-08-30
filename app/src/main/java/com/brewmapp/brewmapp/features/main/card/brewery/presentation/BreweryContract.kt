package com.brewmapp.brewmapp.features.main.card.brewery.presentation

import com.brewmapp.brewmapp.core.presentation.base.BaseContract

interface BreweryContract {
    interface View : BaseContract.View {
        fun setReview(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>)
        fun setBrewery(model: com.brewmapp.brewmapp.features.main.card.brewery.data.model.Model)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getBrewery(id: String)
    }
}