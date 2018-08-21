package com.brewmapp.brewmapp.features.main.news.domain.interactor

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.news.data.NewsApi
import com.brewmapp.brewmapp.features.main.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.data.model.News
import org.greenrobot.eventbus.EventBus
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiNewsService(private val newsApi: NewsApi) {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>, mode: Mode) {
        when (mode) {
            Mode.NEWS -> setRangeCallback(newsApi.getNews(params.startPosition, params.startPosition + params.loadSize, map), callback)
            Mode.REVIEWS -> setRangeCallback(newsApi.getReviews(params.startPosition, params.startPosition + params.loadSize, map), callback)
            Mode.EVENTS -> setRangeCallback(newsApi.getEvents(params.startPosition, params.startPosition + params.loadSize, map), callback)
        }
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>, mode: Mode) {
        when (mode) {
            Mode.NEWS -> setInitialCallback(newsApi.getNews(0, params.pageSize, map), callback)
            Mode.REVIEWS -> setInitialCallback(newsApi.getReviews(0, params.pageSize, map), callback)
            Mode.EVENTS -> setInitialCallback(newsApi.getEvents(0, params.pageSize, map), callback)
        }
    }

    private fun setRangeCallback(api: Observable<News>, callback: PositionalDataSource.LoadRangeCallback<Model>) {
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.models)
                })
    }

    private fun setInitialCallback(api: Observable<News>, callback: PositionalDataSource.LoadInitialCallback<Model>) {
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.models, 0)
                    EventBus.getDefault().post("hide")
                })
    }

}