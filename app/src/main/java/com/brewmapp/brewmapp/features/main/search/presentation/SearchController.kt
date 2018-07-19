package com.brewmapp.brewmapp.features.main.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import kotlinx.android.synthetic.main.controller_search.*
import kotlinx.android.synthetic.main.controller_search.view.*

class SearchController : MvpController<SearchContract.View, SearchContract.Presenter>(), SearchContract.View {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_search, container, false)
        view.recycler
        return view
    }

    override fun createPresenter(): SearchContract.Presenter {
        return SearchPresenter()
    }
}