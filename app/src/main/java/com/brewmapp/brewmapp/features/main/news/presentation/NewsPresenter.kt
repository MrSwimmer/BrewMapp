package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.news.data.paging.NewsPositionalDataSource
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class NewsPresenter : BasePresenter<NewsContract.View>(), NewsContract.Presenter {
    override fun setRecyclerData(mode: Mode) {
        var positionalDataSource = NewsPositionalDataSource(hashMapOf(), mode)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(8)
                .build()
        val pagedList = PagedList.Builder(positionalDataSource, config)
                .setNotifyExecutor(MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build()
        view.setAdapter(pagedList)
    }

    init {
        App.component.inject(this)
    }

    class MainThreadExecutor : Executor {
        override fun execute(command: Runnable?) {
            Handler(Looper.getMainLooper()).post(command)
        }
    }

}