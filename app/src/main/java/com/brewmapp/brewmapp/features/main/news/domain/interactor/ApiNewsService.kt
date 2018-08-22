package com.brewmapp.brewmapp.features.main.news.domain.interactor

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.news.data.NewsApi
import com.brewmapp.brewmapp.features.main.news.data.model.news.Model
import com.brewmapp.brewmapp.features.main.news.data.model.news.News
import com.brewmapp.brewmapp.features.main.news.data.model.reviews.Reviews
import org.greenrobot.eventbus.EventBus
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiNewsService(private val newsApi: NewsApi) {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>, mode: Mode) {
        when (mode) {
            Mode.NEWS -> setRangeCallback(newsApi.getNews(params.startPosition, params.startPosition + params.loadSize, map), callback)
            Mode.REVIEWS -> setRangeReviewsCallback(newsApi.getReviews(params.startPosition, params.startPosition + params.loadSize, map), callback)
            Mode.EVENTS -> setRangeCallback(newsApi.getEvents(params.startPosition, params.startPosition + params.loadSize, map), callback)
        }
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>, mode: Mode) {
        when (mode) {
            Mode.NEWS -> setInitialCallback(newsApi.getNews(0, params.pageSize, map), callback)
            Mode.REVIEWS -> setInitialReviewsCallback(newsApi.getReviews(0, params.pageSize, map), callback)
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

    private fun setRangeReviewsCallback(api: Observable<Reviews>, callback: PositionalDataSource.LoadRangeCallback<Model>) {
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val newmodels = mutableListOf<Model>()
                    it.models.forEach {
                        val map = hashMapOf<String, String>()
                        map["1"] = it.text
                        newmodels.add(Model(it.id, map, it.timestamp, it.getThumb, it.like, it.disLike, it.interested, it.noInterested))
                    }
                    callback.onResult(newmodels)
                })
    }

    private fun setInitialReviewsCallback(api: Observable<Reviews>, callback: PositionalDataSource.LoadInitialCallback<Model>) {
        api.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    val newmodels = mutableListOf<Model>()
                    it.models.forEach {
                        val map = hashMapOf<String, String>()
                        map["1"] = it.text
                        newmodels.add(Model(it.id, map, it.timestamp, it.getThumb, it.like, it.disLike, it.interested, it.noInterested))
                    }
                    callback.onResult(newmodels, 0)
                    EventBus.getDefault().post("hide")
                })
    }
}