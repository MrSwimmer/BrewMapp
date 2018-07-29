package com.brewmapp.brewmapp.features.main.news.data.paging

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.features.main.news.data.model.Model

class NewsPositionalDataSource() : PositionalDataSource<Model>() {
    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
    }
}