package com.brewmapp.brewmapp.features.main.search.result.presentation

import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.search.result.data.model.Model
import com.brewmapp.brewmapp.features.main.search.result.domain.util.ResultDiffUtilCallback
import com.brewmapp.brewmapp.features.main.search.result.presentation.recycler.ResultPagingAdapter
import kotlinx.android.synthetic.main.controller_result.view.*

class ResultController : BaseController<ResultContract.View, ResultContract.Presenter>(), ResultContract.View {

    override fun createPresenter(): ResultContract.Presenter {
        return ResultPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_result, container, false)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        if (view.recycler.adapter == null) {
            view.recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(activity)
            presenter.setRecyclerData()
            showProgress()
        }
    }

    override fun setAdapter(pagedList: PagedList<Model>) {
        val adapter = ResultPagingAdapter(ResultDiffUtilCallback(), router)
        adapter.submitList(pagedList)
        view!!.recycler.adapter = adapter
    }
}