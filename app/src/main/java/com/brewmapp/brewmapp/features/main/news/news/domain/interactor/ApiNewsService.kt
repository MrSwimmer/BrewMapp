package com.brewmapp.brewmapp.features.main.news.news.domain.interactor

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.news.news.data.NewsApi
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.data.model.News
import com.brewmapp.brewmapp.features.main.news.review.data.model.Reviews
import org.greenrobot.eventbus.EventBus
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class ApiNewsService(private val newsApi: NewsApi) {
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>) {

        newsApi.getNews(params.startPosition, params.startPosition + params.loadSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.models)
                }, {
                    Log.i("code", "error get range news ${it.message}")
                })
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>) {

        newsApi.getNews(0, params.pageSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(it.models, 0)
                    EventBus.getDefault().post("hide")
                }, {
                    Log.i("code", "error get init news ${it.message}")
                })
    }
}