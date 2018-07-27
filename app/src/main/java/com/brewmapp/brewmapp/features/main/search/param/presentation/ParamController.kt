package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.util.ParamDiffUtilCallback
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamContract
import com.brewmapp.brewmapp.features.main.search.param.presentation.ParamPresenter
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ParamPagingAdapter
import kotlinx.android.synthetic.main.controller_result.view.*

class ParamController() : BaseController<ParamContract.View, ParamContract.Presenter>(), ParamContract.View {
    lateinit var type: String
    lateinit var field: String

    constructor(type: String, field: String) : this() {
        this.type = type
        this.field = field
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_param, container, false)
        view.recycler.layoutManager = LinearLayoutManager(activity)
        return view
    }

    override fun createPresenter(): ParamContract.Presenter {
        return ParamPresenter()
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.setRecyclerData(type)
        showProgress()
    }

    override fun setAdapter(pagedList: PagedList<Model>) {
        val adapter = ParamPagingAdapter(ParamDiffUtilCallback(), field)
        adapter.submitList(pagedList)
        view!!.recycler.adapter = adapter
    }

}