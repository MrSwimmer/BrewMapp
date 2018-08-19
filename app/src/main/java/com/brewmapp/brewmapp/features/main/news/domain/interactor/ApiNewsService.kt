package com.brewmapp.brewmapp.features.main.news.domain.interactor

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.features.main.news.data.NewsApi
import com.brewmapp.brewmapp.features.main.news.data.model.Model
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiNewsService(private val newsApi: NewsApi) {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>) {
        newsApi.getNews(params.startPosition, params.startPosition + params.loadSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.onResult(it.models) })
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>) {
        newsApi.getNews(0, params.pageSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.onResult(it.models, 0) })
    }

}