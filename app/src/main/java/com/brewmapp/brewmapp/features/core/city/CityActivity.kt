package com.brewmapp.brewmapp.features.core.city

import android.app.SearchManager
import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.View
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseMvpActivity
import com.brewmapp.brewmapp.features.core.city.data.TypeCity
import com.brewmapp.brewmapp.features.core.city.recycler.CityAdapter
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import kotlinx.android.synthetic.main.activity_param.*

class CityActivity : BaseMvpActivity<CityContract.View, CityContract.Presenter>(), CityContract.View {
    override fun getView(): View {
        return getView()
    }

    companion object {
        var curText = ""
        var type = ""
    }
    lateinit var params: MutableList<Model>

    override fun createPresenter(): CityContract.Presenter {
        return CityPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param)
        type = intent.getStringExtra("type")
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
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
                if (newText != "") {
                    curText = newText!!
                    presenter.setRecyclerCity(newText)
                    showProgress()
                }
                return false
            }

        })
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

}