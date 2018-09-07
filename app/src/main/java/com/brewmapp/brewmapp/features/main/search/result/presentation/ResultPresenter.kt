package com.brewmapp.brewmapp.features.main.search.result.presentation

import android.arch.paging.PagedList
import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.news.news.data.paging.ResultPositionalDataSource
import com.brewmapp.brewmapp.features.main.profile.NewsPresenter
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.search.result.domain.interactor.ApiResultService
import java.util.*
import java.util.concurrent.Executors
import javax.inject.Inject
import kotlin.collections.ArrayList

class ResultPresenter : BasePresenter<ResultContract.View>(), ResultContract.Presenter {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiResultService

    override fun setRecyclerData() {
        val map: HashMap<String, String> = hashMapOf()
        var curMap = hashMapOf<String, ArrayList<String>>()
        when (SearchController.mode) {
            Mode.BEER -> curMap = SearchController.beerFieldMap
            Mode.BREWERY -> curMap = SearchController.breweryFieldMap //brand or type
            Mode.RESTO -> curMap = SearchController.restoFieldMap //restoType
        }
        if (SearchController.mode == Mode.BREWERY)
            map["Brewery[id]"] = ""
        if(SearchController.mode == Mode.BEER) {
            map["Beer[brand_id]"] = ""
            map["Beer[type_id]"] = ""
        }
        curMap.forEach {
            when (SearchController.mode) {
                Mode.BEER -> map["Beer[${it.key}]"] = it.value.joinToString(separator = ",")
                Mode.BREWERY -> map["Brewery[${it.key}]"] = it.value.joinToString(separator = ",")
                Mode.RESTO -> map[it.key] = it.value.joinToString(separator = "|")
            }
        }
        Log.i("code", "map0 $map")
        var positionalDataSource = ResultPositionalDataSource(SearchController.mode, map)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(8)
                .build()
        val pagedList = PagedList.Builder(positionalDataSource, config)
                .setNotifyExecutor(NewsPresenter.MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build()
        view.setAdapter(pagedList)
    }
}