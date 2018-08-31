package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.arch.paging.PositionalDataSource
import android.os.Handler
import android.os.Looper
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.news.events.data.EventsPositionalDataSource
import com.brewmapp.brewmapp.features.main.news.news.data.NewsPositionalDataSource
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.review.data.ReviewsPositionalDataSource
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NewsPresenter : BasePresenter<NewsContract.View>(), NewsContract.Presenter {

    override fun setRecyclerData(mode: Mode) {
        val positionalDataSource = when (mode) {
            Mode.NEWS -> NewsPositionalDataSource(hashMapOf(), mode)
            Mode.REVIEWS -> ReviewsPositionalDataSource(hashMapOf(), mode)
            Mode.EVENTS -> EventsPositionalDataSource(hashMapOf(), mode)
            else -> EventsPositionalDataSource(hashMapOf(), mode)
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

}