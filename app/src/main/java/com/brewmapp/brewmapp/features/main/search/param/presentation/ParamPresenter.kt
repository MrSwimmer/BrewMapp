package com.brewmapp.brewmapp.features.main.search.param.presentation

import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import com.brewmapp.brewmapp.features.main.search.param.data.paging.AdSearchPositionalDataSource
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ParamPresenter : MvpBasePresenter<ParamContract.View>(), ParamContract.Presenter {

    override fun setRecyclerData(type: String) {
        var positionalDataSource = AdSearchPositionalDataSource(type)
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