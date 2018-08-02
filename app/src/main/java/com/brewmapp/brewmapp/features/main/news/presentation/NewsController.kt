package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.domain.util.NewsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.presentation.recycler.NewsPagingAdapter
import kotlinx.android.synthetic.main.controller_news.view.*

class NewsController : BaseController<NewsContract.View, NewsContract.Presenter>(), NewsContract.View {

    companion object {
        var mode = Mode.NEWS.name
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_news, container, false)
        view.recycler.layoutManager = LinearLayoutManager(activity)
        setTabs(view)
        view.news.setOnClickListener({
            mode = Mode.NEWS.name
            setTabs(view)
            presenter.setRecyclerData(mode)
        })
        view.events.setOnClickListener({
            mode = Mode.EVENTS.name
            setTabs(view)
            presenter.setRecyclerData(mode)

        })
        view.reviews.setOnClickListener({
            mode = Mode.REVIEWS.name
            setTabs(view)
            presenter.setRecyclerData(mode)
            //showSnack("В разработке")
        })
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.setRecyclerData(mode)
    }

    override fun createPresenter(): NewsContract.Presenter {
        return NewsPresenter()
    }

    fun setTabs(view: View) {
        view.news.background = resources!!.getDrawable(R.color.transparent)
        view.events.background = resources!!.getDrawable(R.color.transparent)
        view.reviews.background = resources!!.getDrawable(R.color.transparent)
        when (mode) {
            Mode.NEWS.name -> view.news.background = resources!!.getDrawable(R.drawable.tab_background_red)
            Mode.EVENTS.name -> view.events.background = resources!!.getDrawable(R.drawable.tab_background_red)
            Mode.REVIEWS.name -> view.reviews.background = resources!!.getDrawable(R.drawable.tab_background_red)
        }
    }

    override fun setAdapter(pagedList: PagedList<Model>) {
        val adapter = NewsPagingAdapter(NewsDiffUtilCallback(), router)
        adapter.submitList(pagedList)
        view!!.recycler.adapter = adapter
    }
}