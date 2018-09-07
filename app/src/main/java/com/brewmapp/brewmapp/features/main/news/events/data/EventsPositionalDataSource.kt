package com.brewmapp.brewmapp.features.main.news.events.data

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model
import com.brewmapp.brewmapp.features.main.news.events.domain.util.interactor.ApiEventsService
import javax.inject.Inject

class EventsPositionalDataSource(val map: HashMap<String, String>, val mode: Mode) : PositionalDataSource<Model>() {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var eventsService: ApiEventsService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
        eventsService.loadRange(params, callback, map)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
        eventsService.loadInit(params, callback, map)
    }
}