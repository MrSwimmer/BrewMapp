package com.brewmapp.brewmapp.features.main.card.news.presentation

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model

interface NewsCardContract {
    interface View : BaseContract.View {
        fun setCard(model: Model)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getNews(id: String)
    }
}