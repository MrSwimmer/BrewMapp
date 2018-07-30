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
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ParamAdapter


class ParamActivity : BaseMvpActivity<ParamContract.View, ParamContract.Presenter>(), ParamContract.View {

    override fun getView(): View {
        return getView()
    }

    lateinit var params: MutableList<Model>

    lateinit var type: String
    lateinit var field: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("code", "create 1")
        setContentView(R.layout.activity_param)
        Log.i("code", "create 2")
        setSupportActionBar(toolbar as Toolbar?)
        Log.i("code", "create 3")
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        Log.i("code", "create 4")
        recycler.layoutManager = LinearLayoutManager(this)
        Log.i("code", "create 5")
        type = intent.getStringExtra("type")
        Log.i("code", "create 6")
        field = intent.getStringExtra("field")
        Log.i("code", "create 7")
        Log.i("code", "type $type")
        presenter.setRecyclerData(type)
        showProgress()
    }

    override fun createPresenter(): ParamContract.Presenter {
        return ParamPresenter()
    }

    override fun initAdapter(models: MutableList<Model>) {
        params = models
        recycler.adapter = ParamAdapter(models, field)
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
        recycler.adapter = ParamAdapter(newParams, field)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}