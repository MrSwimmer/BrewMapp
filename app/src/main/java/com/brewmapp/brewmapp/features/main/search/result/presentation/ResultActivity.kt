package com.brewmapp.brewmapp.features.main.search.result.presentation

import android.arch.paging.PagedList
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.widget.LinearLayoutManager
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseMvpActivity
import com.brewmapp.brewmapp.features.main.search.param.domain.util.ParamDiffUtilCallback
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ParamPagingAdapter
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import com.brewmapp.brewmapp.features.main.search.result.domain.util.ResultDiffUtilCallback
import com.brewmapp.brewmapp.features.main.search.result.presentation.recycler.ResultPagingAdapter
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : BaseMvpActivity<ResultContract.View, ResultContract.Presenter>(), ResultContract.View {
    override fun createPresenter(): ResultContract.Presenter {
        return ResultPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_result)
        recycler.layoutManager = LinearLayoutManager(this)
        presenter.setRecyclerData()
        showProgress()
    }

    override fun setAdapter(pagedList: PagedList<Model>) {
        hideProgress()
        val adapter = ResultPagingAdapter(ResultDiffUtilCallback())
        adapter.submitList(pagedList)
        recycler.adapter = adapter
    }
}