package com.brewmapp.brewmapp.features.main.profile

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseMvpActivity
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamContract
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamPresenter
import kotlinx.android.synthetic.main.activity_param.*
import android.app.SearchManager
import android.content.Context
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ParamAdapter


class ParamActivity : BaseMvpActivity<ParamContract.View, ParamContract.Presenter>(), ParamContract.View {

    override fun getView(): View {
        return getView()
    }

    companion object {
        var cutText = ""
        lateinit var screen: String
    }

    lateinit var curField: TypeSearch

    lateinit var params: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param)
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        recycler.layoutManager = LinearLayoutManager(this)
        screen = intent.getStringExtra("screen")
        Log.i("code", "screen $screen")
        when (screen) {
            "search" -> {
                //if (SearchController.field != TypeSearch.CITY) {
                curField = SearchController.field
                presenter.setRecyclerData(curField)
                showProgress()

            }
            "map" -> {
                curField = ParamsMapController.field
                presenter.setRecyclerData(curField)
                showProgress()
            }
        }

    }

    override fun createPresenter(): ParamContract.Presenter {
        return ParamPresenter()
    }

    override fun initAdapter(models: MutableList<Model>) {
        Log.i("code", "initAdapter ${models.size}")
        params = models
        hideProgress()
        Log.i("code", "hide in initad")
        recycler.adapter = ParamAdapter(models, curField.field)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.dashboard, menu)

        val searchItem = menu.findItem(R.id.action_search)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager

        var searchView: SearchView? = null
        if (searchItem != null) {
            searchView = searchItem.actionView as SearchView
        }
        searchView?.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i("code", "search $query")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.i("code", "search new $newText")
                if (curField == TypeSearch.CITY) {
                    if (newText != "") {
                        cutText = newText!!
                        presenter.setRecyclerCity(newText)
                        showProgress()
                    }
                } else
                    searchInParams(newText!!)
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    fun searchInParams(newText: String) {
        val newParams = mutableListOf<Model>()
        params.forEach {
            if (it.name["1"]!!.contains(newText))
                newParams.add(it)
        }
        recycler.adapter = ParamAdapter(newParams, curField.field)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}