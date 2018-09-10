package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.news.events.domain.util.util.EventsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.events.presentation.EventsPagingAdapter
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.domain.util.NewsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.news.presentation.NewsPagingAdapter
import com.brewmapp.brewmapp.features.main.news.review.domain.util.ReviewsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.review.presentation.ReviewsPagingAdapter
import kotlinx.android.synthetic.main.controller_news.view.*

class NewsController : BaseController<NewsContract.View, NewsContract.Presenter>(), NewsContract.View {
    val NEWS_ALL = "news all"
    val NEWS_SUBSCRIPTIONS = "news subs"
    val NEWS_MY = "news my"

    var filterNews = NEWS_ALL
    var cityNews = ""

    companion object {
        var mode = Mode.NEWS
        var isFilterShowed = false
        var mapNews = hashMapOf(Pair("News[subscription]", ""), Pair("News[user_friends]", ""), Pair("News[city_id]", ""))
        var mapEvents = hashMapOf<String, String>()
        var mapReviews = hashMapOf<String, String>()
    }

    fun setNewsFilter(view: View) {
        view.newsCheckAll.setImageResource(R.color.transparent)
        view.newsCheckMy.setImageResource(R.color.transparent)
        view.newsCheckSubs.setImageResource(R.color.transparent)
        when (filterNews) {
            NEWS_ALL -> {
                view.newsCheckAll.setImageResource(R.drawable.ic_check_black_24dp)
                mapNews["News[subscription]"] = ""
                mapNews["News[user_friends]"] = ""
            }
            NEWS_SUBSCRIPTIONS -> {
                view.newsCheckSubs.setImageResource(R.drawable.ic_check_black_24dp)
                mapNews["News[subscription]"] = presenter.getUserId()

            }
            NEWS_MY -> {
                view.newsCheckMy.setImageResource(R.drawable.ic_check_black_24dp)
                mapNews["News[user_friends]"] = presenter.getUserId()
            }
        }
        presenter.setRecyclerData(mode, mapNews)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_news, container, false)
        view.recycler.layoutManager = LinearLayoutManager(activity)
        setTabs(view)
        setFilter(view)
        view.news.setOnClickListener({
            mode = Mode.NEWS
            setTabs(view)
            presenter.setRecyclerData(mode, mapNews)
            showProgress()

        })
        view.events.setOnClickListener({
            mode = Mode.EVENTS
            setTabs(view)
            presenter.setRecyclerData(mode, mapEvents)
            showProgress()

        })
        view.reviews.setOnClickListener({
            mode = Mode.REVIEWS
            setTabs(view)
            presenter.setRecyclerData(mode, mapReviews)
            showProgress()
        })
        view.showFilter.setOnClickListener({
            isFilterShowed = !isFilterShowed
            setFilter(view)
        })
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.setRecyclerData(mode, mapNews)
        showProgress()
    }

    override fun createPresenter(): NewsContract.Presenter {
        return NewsPresenter()
    }

    private fun setTabs(view: View) {
        view.news.background = resources!!.getDrawable(R.color.transparent)
        view.events.background = resources!!.getDrawable(R.color.transparent)
        view.reviews.background = resources!!.getDrawable(R.color.transparent)
        when (mode) {
            Mode.NEWS -> view.news.background = resources!!.getDrawable(R.drawable.tab_background_red)
            Mode.EVENTS -> view.events.background = resources!!.getDrawable(R.drawable.tab_background_red)
            Mode.REVIEWS -> view.reviews.background = resources!!.getDrawable(R.drawable.tab_background_red)
        }
    }

    private fun setFilter(view: View) {
        if (isFilterShowed) {
            when (mode) {
                Mode.NEWS -> view.filterNews.visibility = View.VISIBLE
                Mode.REVIEWS -> view.filterReviews.visibility = View.VISIBLE
                Mode.EVENTS -> view.filterEvents.visibility = View.VISIBLE
            }
        } else {
            when (mode) {
                Mode.NEWS -> view.filterNews.visibility = View.GONE
                Mode.REVIEWS -> view.filterReviews.visibility = View.GONE
                Mode.EVENTS -> view.filterEvents.visibility = View.GONE
            }
        }
    }

    override fun setNews(pagedList: PagedList<Model>) {
        val adapter = NewsPagingAdapter(NewsDiffUtilCallback(), router)
        adapter.submitList(pagedList)
        view!!.recycler.adapter = adapter
    }

    override fun setReviews(pagedList: PagedList<com.brewmapp.brewmapp.features.main.news.review.data.model.Model>) {
        val adapter = ReviewsPagingAdapter(ReviewsDiffUtilCallback(), router)
        adapter.submitList(pagedList)
        view!!.recycler.adapter = adapter
    }

    override fun setEvents(pagedList: PagedList<com.brewmapp.brewmapp.features.main.news.events.data.model.Model>) {
        val adapter = EventsPagingAdapter(EventsDiffUtilCallback(), router)
        adapter.submitList(pagedList)
        view!!.recycler.adapter = adapter
    }
}