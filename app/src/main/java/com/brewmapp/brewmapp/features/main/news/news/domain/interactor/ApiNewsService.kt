package com.brewmapp.brewmapp.features.main.news.news.domain.interactor

import androidx.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.features.main.news.news.data.NewsApi
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.data.model.News
import org.greenrobot.eventbus.EventBus
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.text.SimpleDateFormat

class ApiNewsService(private val newsApi: NewsApi) {
    val df = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val dfDelim = SimpleDateFormat("dd.MM")
    fun loadRange(params: PositionalDataSource.LoadRangeParams, callback: PositionalDataSource.LoadRangeCallback<Model>, map: HashMap<String, String>) {

        newsApi.getNews(params.startPosition, params.startPosition + params.loadSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(getModelsWithDates(it))
                }, {
                    Log.i("code", "error get range news ${it.message}")
                })
    }

    fun loadInit(params: PositionalDataSource.LoadInitialParams, callback: PositionalDataSource.LoadInitialCallback<Model>, map: HashMap<String, String>) {

        newsApi.getNews(0, params.pageSize, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onResult(getModelsWithDates(it), 0)
                    EventBus.getDefault().post("hide")
                }, {
                    Log.i("code", "error get init news ${it.message}")
                })
    }

    private fun getModelsWithDates(it: News): MutableList<Model> {
        val newmodels = arrayListOf<Model>()
        var prev = df.parse(it.models[0].timestamp)
        it.models.forEach {
            val curdate = df.parse(it.timestamp)
            if (curdate.day < prev.day) {
                val dateDelim = dfDelim.format(curdate)
                newmodels.add(Model("-1", dateDelim.toString()))
            }
            newmodels.add(it)
            prev = df.parse(it.timestamp)
        }
        return newmodels
    }

    fun getNewsById(id: String, callback: NewsCallback) {
        val map = hashMapOf(Pair("News[id]", id))
        newsApi.getNews(0, 10, map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    callback.onSuccess(it.models[0])
                }, {
                    callback.onError(it)
                })
    }

    interface NewsCallback {
        fun onSuccess(model: Model)
        fun onError(it: Throwable)
    }
}