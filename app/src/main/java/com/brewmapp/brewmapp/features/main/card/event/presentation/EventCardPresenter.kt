package com.brewmapp.brewmapp.features.main.card.event.presentation

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model
import com.brewmapp.brewmapp.features.main.news.events.domain.interactor.ApiEventsService
import javax.inject.Inject

class EventCardPresenter : BasePresenter<EventCardContract.View>(), EventCardContract.Presenter {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiEventService: ApiEventsService

    override fun getEvent(id: String) {
        apiEventService.getEventById(id, object : ApiEventsService.EventCallback {
            override fun onSuccess(model: Model) {
                view.setEvent(model)
            }

            override fun onError(it: Throwable) {
            }

        })
    }

}