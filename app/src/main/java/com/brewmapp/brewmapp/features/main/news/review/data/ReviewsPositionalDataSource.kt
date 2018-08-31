package com.brewmapp.brewmapp.features.main.news.review.data

import android.arch.paging.PositionalDataSource
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.news.events.domain.util.interactor.ApiEventsService
import com.brewmapp.brewmapp.features.main.news.news.domain.interactor.ApiNewsService
import com.brewmapp.brewmapp.features.main.news.review.data.model.Model
import com.brewmapp.brewmapp.features.main.news.review.domain.interactor.ApiReviewsService
import javax.inject.Inject

class ReviewsPositionalDataSource(val map: HashMap<String, String>, val mode: Mode) : PositionalDataSource<Model>() {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var reviewsService: ApiReviewsService

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Model>) {
        reviewsService.loadRange(params, callback, map)
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Model>) {
        reviewsService.loadInit(params, callback, map)
    }
}