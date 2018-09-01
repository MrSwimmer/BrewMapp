package com.brewmapp.brewmapp.features.main.card.news.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.controller_card_news.view.*

class NewsCardController(): BaseController<NewsCardContract.View, NewsCardContract.Presenter>(), NewsCardContract.View {
    lateinit var id: String

    constructor(id: String) : this() {
        this.id = id
    }

    override fun createPresenter(): NewsCardContract.Presenter {
        return NewsCardPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.controller_card_news, container, false)
        return view
    }

    override fun onAttach(view: View) {
        super.onAttach(view)
        presenter.getNews(id)
    }

    override fun setCard(model: Model) {
        view!!.title.text = model.userInfo.firstname
        view!!.text.text = model.text["1"]
        view!!.date.text = model.timestamp
        view!!.like.text = model.like

        if (model.userGetThumb != null && model.userGetThumb.url != null) {
            Glide.with(activity!!)
                    .load("https://www.brewmapp.com/${model.userGetThumb.url}")
                    .into(view!!.imageUser)
        }

        Glide.with(activity!!)
                .load("https://www.brewmapp.com/${model.relatedModelData.getThumb}")
                .into(view!!.image)
    }
}