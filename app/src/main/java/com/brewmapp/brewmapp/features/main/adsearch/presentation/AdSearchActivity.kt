package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseActivity
import com.brewmapp.brewmapp.features.main.adsearch.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.adsearch.data.paging.AdSearchPositionalDataSource
import com.brewmapp.brewmapp.features.main.adsearch.domain.util.SearchDiffUtilCallback
import com.brewmapp.brewmapp.features.main.adsearch.presentation.AdSearchContract
import com.brewmapp.brewmapp.features.main.adsearch.presentation.recycler.SearchPagingAdapter
import kotlinx.android.synthetic.main.activity_adsearch.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class AdSearchActivity : BaseActivity(), AdSearchContract.View {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adsearch)



        Log.i("code", "create")
        recycler.layoutManager = LinearLayoutManager(this)
        val type = intent.extras.getString("type")
        Log.i("code", "type $type")

        var positionalDataSource = AdSearchPositionalDataSource(type)
        val config = PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setPageSize(10)
                .build()
        val pagedList = PagedList.Builder(positionalDataSource, config)
                .setNotifyExecutor(MainThreadExecutor())
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build()
        setAdapter(pagedList)
    }

    override fun setAdapter(pagedList: PagedList<Model>) {
        val adapter = SearchPagingAdapter(SearchDiffUtilCallback())
        adapter.submitList(pagedList)
        recycler.adapter = adapter
    }

    class MainThreadExecutor : Executor {
        override fun execute(command: Runnable?) {
            Handler(Looper.getMainLooper()).post(command)
        }
    }

}