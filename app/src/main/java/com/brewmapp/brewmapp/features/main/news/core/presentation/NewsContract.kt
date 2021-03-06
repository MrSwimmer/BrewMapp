package com.brewmapp.brewmapp.features.main.profile

import androidx.paging.PagedList
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model

interface NewsContract {
    interface View : BaseContract.View {
        fun setNews(pagedList: PagedList<Model>)
        fun setReviews(pagedList: PagedList<com.brewmapp.brewmapp.features.main.news.review.data.model.Model>)
        fun setEvents(pagedList: PagedList<com.brewmapp.brewmapp.features.main.news.events.data.model.Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun setRecyclerData(mode: Mode, map: HashMap<String, String>)
        fun getUserId(): String
        fun getCityId(): String
        fun getCityName(): String
    }
}