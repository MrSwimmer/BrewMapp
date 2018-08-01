package com.brewmapp.brewmapp.features.main.profile

import android.annotation.SuppressLint
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.SearchAdapter
import com.brewmapp.brewmapp.features.main.search.result.presentation.ResultController
import kotlinx.android.synthetic.main.controller_search.view.*

class SearchController : BaseController<SearchContract.View, SearchContract.Presenter>(), SearchContract.View {
    companion object {
        val beerFieldMap: HashMap<String, ArrayList<String>> = hashMapOf()
        val breweryFieldMap: HashMap<String, ArrayList<String>> = hashMapOf()
        val restoFieldMap: HashMap<String, ArrayList<String>> = hashMapOf()
        var mode = Mode.BEER.name
    }

    @SuppressLint("ResourceType")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_search, container, false)
        Log.i("code", "ocv")
        view.recycler.layoutManager = LinearLayoutManager(activity)
        view.searchButton.setOnClickListener { router.pushController(RouterTransaction.with(ResultController())) }
        setTabs(view)
        view.beer.setOnClickListener({
            mode = Mode.BEER.name
            setTabs(view)
            presenter.setRecyclerData(mode)
        })
        view.brewery.setOnClickListener({
            mode = Mode.BREWERY.name
            setTabs(view)
            presenter.setRecyclerData(mode)

        })
        view.restaurants.setOnClickListener({
            mode = Mode.RESTO.name
            setTabs(view)
            presenter.setRecyclerData(mode)
            //showSnack("В разработке")
        })
        return view
    }

    fun setTabs(view: View) {
        view.beer.background = resources!!.getDrawable(R.color.transparent)
        view.brewery.background = resources!!.getDrawable(R.color.transparent)
        view.restaurants.background = resources!!.getDrawable(R.color.transparent)
        when (mode) {
            Mode.BEER.name -> view.beer.background = resources!!.getDrawable(R.drawable.tab_background_red)
            Mode.BREWERY.name -> view.brewery.background = resources!!.getDrawable(R.drawable.tab_background_red)
            Mode.RESTO.name -> view.restaurants.background = resources!!.getDrawable(R.drawable.tab_background_red)
        }
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        Log.i("code", "oa $mode")
        presenter.setRecyclerData(mode)
    }

    override fun createPresenter(): SearchContract.Presenter {
        return SearchPresenter()
    }

    override fun initAdapter(searches: ArrayList<Search>) {
        view!!.recycler.adapter = SearchAdapter(searches, activity)
    }

}