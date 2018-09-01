package com.brewmapp.brewmapp.features.main.card.event

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController

class EventCardController: BaseController<EventCardContract.View, EventCardContract.Presenter>(), EventCardContract.View {
    override fun createPresenter(): EventCardContract.Presenter {
        return EventCardPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_card_event, container, false)
        return view
    }
}