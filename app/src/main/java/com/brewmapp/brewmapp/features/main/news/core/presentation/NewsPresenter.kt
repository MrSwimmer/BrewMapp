package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.domain.interactor.SettingsService
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.news.events.data.EventsPositionalDataSource
import com.brewmapp.brewmapp.features.main.news.news.data.NewsPositionalDataSource
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.review.data.ReviewsPositionalDataSource
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class NewsPresenter : BasePresenter<NewsContract.View>(), NewsContract.Presenter {

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var settingsService: SettingsService

    override fun setRecyclerData(mode: Mode, map: HashMap<String, String>) {
        val positionalDataSource = when (mode) {
            Mode.NEWS -> NewsPositionalDataSource(map, mode)
            Mode.REVIEWS -> ReviewsPositionalDataSource(map, mode)
            Mode.EVENTS -> EventsPositionalDataSource(map, mode)
            else -> EventsPositionalDataSource(map, mode)
        }

        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(8)
                .build()
        val pagedList = PagedList.Builder(positionalDataSource, config)
                .setNotifyExecutor(MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build()
        when (mode) {
            Mode.NEWS -> view.setNews(pagedList as PagedList<Model>)
            Mode.REVIEWS -> view.setReviews(pagedList as PagedList<com.brewmapp.brewmapp.features.main.news.review.data.model.Model>)
            Mode.EVENTS -> view.setEvents(pagedList as PagedList<com.brewmapp.brewmapp.features.main.news.events.data.model.Model>)
        }
    }

    class MainThreadExecutor : Executor {
        override fun execute(command: Runnable?) {
            Handler(Looper.getMainLooper()).post(command)
        }
    }

    override fun getUserId(): String {
        val id = settingsService.getUserId()
        return if (id == settingsService.ERROR)
            "" else
            id
    }

    override fun getCityId(): String {
        val id = settingsService.getCityId()
        return if (id == settingsService.ERROR)
            ""
        else
            id
    }

    override fun getCityName(): String {
        val name = settingsService.getCityName()
        return if (name == settingsService.ERROR)
            ""
        else
            name
    }
}