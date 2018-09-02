package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.card.product.data.model.resto.Model
import com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param.Param
import com.hannesdorfmann.mosby3.mvp.MvpPresenter
import com.hannesdorfmann.mosby3.mvp.MvpView

interface RestoContract {
    interface View : BaseContract.View {
        fun setResto(model: Model)
        fun setReview(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getResto(id: String)
    }
}