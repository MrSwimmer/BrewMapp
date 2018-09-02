package com.brewmapp.brewmapp.features.main.card.event.presentation

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model

interface EventCardContract {
    interface View : BaseContract.View {
        fun setEvent(model: Model)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getEvent(id: String)
    }
}