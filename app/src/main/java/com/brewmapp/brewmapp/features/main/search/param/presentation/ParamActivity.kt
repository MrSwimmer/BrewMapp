package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.AttributeSet
import android.view.View
import android.widget.ProgressBar
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseMvpActivity
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.util.ParamDiffUtilCallback
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamContract
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamPresenter
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ParamPagingAdapter
import kotlinx.android.synthetic.main.activity_adsearch.*

class ParamActivity : BaseMvpActivity<ParamContract.View, ParamContract.Presenter>(), ParamContract.View {


    private lateinit var field: String

    override fun createPresenter(): ParamContract.Presenter {
        return ParamPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adsearch)
        recycler.layoutManager = LinearLayoutManager(this)
        val type = intent.extras.getString("type")
        field = intent.extras.getString("field")
        presenter.setRecyclerData(type)
        showProgress()
    }

    override fun setAdapter(pagedList: PagedList<Model>) {
        hideProgress()
        val adapter = ParamPagingAdapter(ParamDiffUtilCallback(), field)
        adapter.submitList(pagedList)
        recycler.adapter = adapter
    }

}