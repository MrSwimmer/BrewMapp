package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseMvpActivity
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.util.ParamDiffUtilCallback
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamContract
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamPresenter
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ParamPagingAdapter
import kotlinx.android.synthetic.main.activity_param.*
import android.app.SearchManager
import android.content.Context
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu


class ParamActivity : BaseMvpActivity<ParamContract.View, ParamContract.Presenter>(), ParamContract.View {

    override fun getView(): View {
        return getView()
    }

    lateinit var type: String
    lateinit var field: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_param)
        setSupportActionBar(toolbar as Toolbar?)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        recycler.layoutManager = LinearLayoutManager(this)
        type = intent.getStringExtra("type")
        field = intent.getStringExtra("field")
        presenter.setPagingRecyclerData(type)
        showProgress()
    }

    override fun createPresenter(): ParamContract.Presenter {
        return ParamPresenter()
    }

    override fun setAdapter(pagedList: PagedList<Model>) {
        val adapter = ParamPagingAdapter(ParamDiffUtilCallback(), field)
        adapter.submitList(pagedList)
        recycler.adapter = adapter
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

                //presenter.setPagingRecyclerData(type)
                showProgress()
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