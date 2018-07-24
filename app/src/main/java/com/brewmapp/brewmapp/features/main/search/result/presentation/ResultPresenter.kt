package com.brewmapp.brewmapp.features.main.search.result.presentation

import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.search.result.data.paging.ResultPositionalDataSource
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ResultPresenter : BasePresenter<ResultContract.View>(), ResultContract.Presenter {
    override fun setRecyclerData() {
        val map = HashMap<String, String>()
        var positionalDataSource = ResultPositionalDataSource(map)
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

    class MainThreadExecutor : Executor {
        override fun execute(command: Runnable?) {
            Handler(Looper.getMainLooper()).post(command)
        }
    }

}