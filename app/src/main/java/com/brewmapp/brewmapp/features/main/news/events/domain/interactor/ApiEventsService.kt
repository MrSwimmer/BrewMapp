package com.brewmapp.brewmapp.features.main.news.events.domain.interactor

import androidx.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.features.main.news.events.data.EventsApi
import com.brewmapp.brewmapp.features.main.news.events.data.model.Model
import org.greenrobot.eventbus.EventBus
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiEventsService(private val eventsApi: EventsApi) {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>) {
        eventsApi.getEvents(params.startPosition, params.startPosition + params.loadSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.models)
                }, {
                    Log.i("code", "errror range ${it.message}}")
                })
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>) {
        eventsApi.getEvents(0, params.pageSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Log.i("code", "size ${it.models.size}")
                    callback.onResult(it.models, 0)
                    EventBus.getDefault().post("hide")
                }, {
                    Log.i("code", "errror init ${it.message}}")
                })
    }

    fun getEventById(id: String, callback: EventCallback) {
        val map = hashMapOf(Pair("Event[id]", id))
        eventsApi.getEvents(0, 10, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models[0])
                }, {
                    callback.onError(it)
                })
    }

    interface EventCallback {
        fun onSuccess(model: Model)
        fun onError(it: Throwable)
    }
}