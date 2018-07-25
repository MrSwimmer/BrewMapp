package com.brewmapp.brewmapp.features.main.profile

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.SearchAdapter
import com.brewmapp.brewmapp.features.main.search.result.presentation.ResultController
import com.hannesdorfmann.mosby3.mvp.conductor.MvpController
import kotlinx.android.synthetic.main.controller_search.view.*

class SearchController : BaseController<SearchContract.View, SearchContract.Presenter>(), SearchContract.View {
    companion object {
        val beerFieldMap: HashMap<String, ArrayList<String>> = hashMapOf()
        val breweryFieldMap: HashMap<String, ArrayList<String>> = hashMapOf()
        val restaurantsFieldMap: HashMap<String, ArrayList<String>> = hashMapOf()
        var mode = "beer"
    }

    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_search, container, false)
        view.recycler.layoutManager = LinearLayoutManager(activity)
        view.searchButton.setOnClickListener { router.replaceTopController(RouterTransaction.with(ResultController())) }
        view.beer.setOnClickListener({
            view.beer.background = resources!!.getDrawable(R.drawable.tab_background_red)
            view.brewery.background = resources!!.getDrawable(R.color.transparent)
            view.restaurants.background = resources!!.getDrawable(R.color.transparent)
            mode = "beer"
            presenter.setBeerRecyclerData()
        })
        view.brewery.setOnClickListener({
            view.beer.background = resources!!.getDrawable(R.color.transparent)
            view.brewery.background = resources!!.getDrawable(R.drawable.tab_background_red)
            view.restaurants.background = resources!!.getDrawable(R.color.transparent)
            mode = "brewery"
            presenter.setBreweryRecyclerData()
        })
        view.restaurants.setOnClickListener({
            /*view.beer.background = resources!!.getDrawable(R.color.transparent)
            view.brewery.background = resources!!.getDrawable(R.color.transparent)
            view.restaurants.background = resources!!.getDrawable(R.drawable.tab_background_red)
            mode = "restaurants"
            presenter.setRestaurantsRecyclerData()*/
            showSnack("В разработке")
        })
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.setBeerRecyclerData()
    }

    override fun createPresenter(): SearchContract.Presenter {
        return SearchPresenter()
    }

    override fun initAdapter(searches: ArrayList<Search>) {
        view!!.recycler.adapter = SearchAdapter(searches, activity)
    }

}