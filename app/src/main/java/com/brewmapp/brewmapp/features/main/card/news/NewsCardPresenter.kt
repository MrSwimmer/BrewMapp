package com.brewmapp.brewmapp.features.main.card.news

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.domain.interactor.ApiNewsService
import javax.inject.Inject

class NewsCardPresenter : BasePresenter<NewsCardContract.View>(), NewsCardContract.Presenter {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiNewsService: ApiNewsService

    override fun getNews(id: String) {
        apiNewsService.getNewsById(id, object : ApiNewsService.NewsCallback {
            override fun onSuccess(model: Model) {
                view.setCard(model)
            }

            override fun onError(it: Throwable) {
            }

        })
    }
}