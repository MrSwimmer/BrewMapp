package com.brewmapp.brewmapp.features.main.card.event

import com.brewmapp.brewmapp.core.presentation.base.BaseContract

interface EventCardContract {
    interface View : BaseContract.View {
        }

    interface Presenter: BaseContract.Presenter<View> {
    }
}