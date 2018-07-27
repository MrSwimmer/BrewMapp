package com.brewmapp.brewmapp.features.main.search.result.presentation

import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.search.result.data.paging.ResultPositionalDataSource
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class ResultPresenter : BasePresenter<ResultContract.View>(), ResultContract.Presenter {

    override fun setRecyclerData() {
        var map: HashMap<String, String> = hashMapOf()
        SearchController.beerFieldMap.forEach {
            when (SearchController.mode) {
                Mode.BEER.name -> map["Beer[${it.key}]"] = it.value.joinToString(separator = ",")
                Mode.BREWERY.name -> map["Brewery[${it.key}]"] = it.value.joinToString(separator = ",")
                //"resto" -> map["Brewery[${it.key}]"] = it.value.joinToString(separator = ",")
            }
            //map[it.key] = it.value.joinToString(separator = ",")
            //Log.i("code", "map[] ${map[it.key]}")
        }
        Log.i("code", "map $map")
        var positionalDataSource = ResultPositionalDataSource(map, SearchController.mode)
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