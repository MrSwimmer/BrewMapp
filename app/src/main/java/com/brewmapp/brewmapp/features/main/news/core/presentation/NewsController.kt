package com.brewmapp.brewmapp.features.main.profile

import android.arch.paging.PagedList
import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.core.city.CityActivity
import com.brewmapp.brewmapp.features.core.city.data.TypeCity
import com.brewmapp.brewmapp.features.main.news.core.data.Filter
import com.brewmapp.brewmapp.features.main.news.events.domain.util.EventsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.events.presentation.EventsPagingAdapter
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.domain.util.NewsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.news.presentation.NewsPagingAdapter
import com.brewmapp.brewmapp.features.main.news.review.domain.util.ReviewsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.review.presentation.ReviewsPagingAdapter
import kotlinx.android.synthetic.main.controller_news.view.*

class NewsController : BaseController<NewsContract.View, NewsContract.Presenter>(), NewsContract.View {

    var filterNews = Filter.NEWS_ALL
    var filterEvents = Filter.EVENTS_ALL
    var filterReviews = Filter.REVIEWS_ALL

    companion object {
        var mode = Mode.NEWS
        var isFilterShowed = false
        var mapNews = hashMapOf<String, String>()
        var mapEvents = hashMapOf<String, String>()
        var mapReviews = hashMapOf<String, String>()
        var cityNewsName = ""
        var cityNewsId = ""
        var cityEventsName = ""
        var cityEventsId = ""
        var cityReviewsName = ""
        var cityReviewsId = ""
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_news, container, false)
        view.recycler.layoutManager = LinearLayoutManager(activity)
        setTabs(view)
        setFilter(view)

        view.newsCity.setOnClickListener({
            val intent = Intent(activity, CityActivity::class.java)
            intent.putExtra("type", TypeCity.NEWS.name)
            startActivity(intent)
        })
        view.eventsCity.setOnClickListener({
            val intent = Intent(activity, CityActivity::class.java)
            intent.putExtra("type", TypeCity.EVENTS.name)
            startActivity(intent)
        })
        view.reviewsCity.setOnClickListener({
            val intent = Intent(activity, CityActivity::class.java)
            intent.putExtra("type", TypeCity.REVIEWS.name)
            startActivity(intent)
        })
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
        view.newsAll.setOnClickListener({
            if (filterNews != Filter.NEWS_ALL) {
                filterNews = Filter.NEWS_ALL
                setNewsFilter(view)
            }
        })
        view.newsSubs.setOnClickListener({
            if (filterNews != Filter.NEWS_SUBSCRIPTIONS) {
                filterNews = Filter.NEWS_SUBSCRIPTIONS
                setNewsFilter(view)
            }
        })
        view.newsMy.setOnClickListener({
            if (filterNews != Filter.NEWS_MY) {
                filterNews = Filter.NEWS_MY
                setNewsFilter(view)
            }
        })
        view.eventsAll.setOnClickListener({
            if (filterEvents != Filter.EVENTS_ALL) {
                filterEvents = Filter.EVENTS_ALL
                setEventsFilter(view)
            }
        })
        view.eventsIgo.setOnClickListener({
            if (filterEvents != Filter.EVENTS_I_WILL_GO) {
                filterEvents = Filter.EVENTS_I_WILL_GO
                setEventsFilter(view)
            }
        })
        view.eventsSubs.setOnClickListener({
            if (filterEvents != Filter.EVENTS_SUBSCRIPTIONS) {
                filterEvents = Filter.EVENTS_SUBSCRIPTIONS
                setEventsFilter(view)
            }
        })
        view.reviewsAll.setOnClickListener({
            if (filterReviews != Filter.REVIEWS_ALL) {
                filterReviews = Filter.REVIEWS_ALL
                setReviewsFilter(view)
            }
        })
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        if (presenter.getUserId() == "") {
            view.newsSubs.visibility = View.GONE
            view.newsMy.visibility = View.GONE
            view.eventsIgo.visibility = View.GONE
            view.eventsSubs.visibility = View.GONE
            view.reviewsMy.visibility = View.GONE
        }
        setCity(view)
        presenter.setRecyclerData(mode, mapNews)
        showProgress()
    }

    override fun createPresenter(): NewsContract.Presenter {
        return NewsPresenter()
    }

    private fun setNewsFilter(view: View) {
        view.newsCheckAll.setImageResource(R.color.transparent)
        view.newsCheckMy.setImageResource(R.color.transparent)
        view.newsCheckSubs.setImageResource(R.color.transparent)
        when (filterNews) {
            Filter.NEWS_ALL -> {
                view.newsCheckAll.setImageResource(R.drawable.ic_check_black_24dp)
                mapNews["News[subscription]"] = ""
                mapNews["News[user_friends]"] = ""
            }
            Filter.NEWS_SUBSCRIPTIONS -> {
                view.newsCheckSubs.setImageResource(R.drawable.ic_check_black_24dp)
                mapNews["News[subscription]"] = presenter.getUserId()
            }
            Filter.NEWS_MY -> {
                view.newsCheckMy.setImageResource(R.drawable.ic_check_black_24dp)
                mapNews["News[user_friends]"] = presenter.getUserId()
            }
        }
        presenter.setRecyclerData(mode, mapNews)
    }

    private fun setEventsFilter(view: View) {
        view.eventsCheckAll.setImageResource(R.color.transparent)
        view.eventsCheckSubs.setImageResource(R.color.transparent)
        view.eventsCheckIgo.setImageResource(R.color.transparent)
        when (filterEvents) {
            Filter.EVENTS_ALL -> {
                view.eventsCheckAll.setImageResource(R.drawable.ic_check_black_24dp)
                mapEvents["Event[user_subscription]"] = ""
                mapEvents["Event[user_id]"] = ""
            }
            Filter.EVENTS_SUBSCRIPTIONS -> {
                view.eventsCheckSubs.setImageResource(R.drawable.ic_check_black_24dp)
                mapEvents["Event[user_subscription]"] = presenter.getUserId()
            }
            Filter.EVENTS_I_WILL_GO -> {
                view.eventsCheckIgo.setImageResource(R.drawable.ic_check_black_24dp)
                mapEvents["Event[user_subscription]"] = presenter.getUserId()
            }
        }
        presenter.setRecyclerData(mode, mapEvents)
    }

    private fun setReviewsFilter(view: View) {
        view.reviewsCheckAll.setImageResource(R.color.transparent)
        view.reviewsCheckMy.setImageResource(R.color.transparent)
        when (filterReviews) {
            Filter.REVIEWS_ALL -> {
                view.reviewsCheckAll.setImageResource(R.drawable.ic_check_black_24dp)
                mapReviews["Reviews[user_id]"] = ""
            }
            Filter.REVIEWS_MY -> {
                view.reviewsCheckMy.setImageResource(R.drawable.ic_check_black_24dp)
                mapReviews["Reviews[user_id]"] = presenter.getUserId()
            }
        }
        presenter.setRecyclerData(mode, mapReviews)
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
        view.filterNews.visibility = View.GONE
        view.filterReviews.visibility = View.GONE
        view.filterEvents.visibility = View.GONE
    }

    private fun setFilter(view: View) {
        if (isFilterShowed) {
            when (mode) {
                Mode.NEWS -> view.filterNews.visibility = View.VISIBLE
                Mode.REVIEWS -> view.filterReviews.visibility = View.VISIBLE
                Mode.EVENTS -> view.filterEvents.visibility = View.VISIBLE
            }
        } else {
            view.filterNews.visibility = View.GONE
            view.filterReviews.visibility = View.GONE
            view.filterEvents.visibility = View.GONE
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

    private fun setCity(view: View) {
        val homeCityId = presenter.getCityId()
        val homeCityName = presenter.getCityName()
        when (mode) {
            Mode.NEWS -> {
                if(cityNewsId == "") {
                    if(homeCityId != "") {
                        cityNewsId = homeCityId
                        cityNewsName = homeCityName
                        view.newsCityText.text = cityNewsName
                    }
                } else {
                    view.newsCityText.text = cityNewsName
                }
            }
            Mode.EVENTS -> {
                if(cityEventsId == "") {
                    if(homeCityId != "") {
                        cityEventsId = homeCityId
                        cityEventsName = homeCityName
                        view.eventsCityText.text = cityEventsName
                    }
                } else {
                    view.eventsCityText.text = cityEventsName
                }
            }
            Mode.REVIEWS -> {
                if(cityReviewsName == "") {
                    if(homeCityId != "") {
                        cityReviewsId = homeCityId
                        cityReviewsName = homeCityName
                        view.reviewsCityText.text = cityReviewsName
                    }
                } else {
                    view.reviewsCityText.text = cityReviewsName
                }
            }
        }
    }
}