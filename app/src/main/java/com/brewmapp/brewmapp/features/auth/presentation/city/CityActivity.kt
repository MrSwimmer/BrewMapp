package com.brewmapp.brewmapp.features.auth.presentation.city

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.core.presentation.base.BaseMvpActivity
import com.brewmapp.brewmapp.features.auth.presentation.city.recycler.CityAdapter
import com.brewmapp.brewmapp.features.main.profile.SignInContract
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ParamAdapter
import kotlinx.android.synthetic.main.activity_param.*
import kotlinx.android.synthetic.main.controller_sign_in.view.*

class CityActivity : BaseMvpActivity<CityContract.View, CityContract.Presenter>(), CityContract.View {
    override fun getView(): View {
        return getView()
    }

    lateinit var params: MutableList<Model>

    override fun createPresenter(): CityContract.Presenter {
        return CityPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param)
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        recycler.layoutManager = LinearLayoutManager(this)
        presenter.setRecyclerData()
        showProgress()
    }

    override fun initAdapter(models: MutableList<Model>) {
        params = models
        recycler.adapter = CityAdapter(models, this)
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
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
        }



        searchView!!.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                Log.i("code", "search $query")
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                Log.i("code", "search new $newText")
                searchInParams(newText)
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    fun searchInParams(newText: String?) {
        val newParams = mutableListOf<Model>()
        params.forEach {
            if (it.id.contains(newText!!, true))
                newParams.add(it)
        }
        recycler.adapter = CityAdapter(newParams, this)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}