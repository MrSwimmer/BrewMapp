package com.brewmapp.brewmapp.features.main.news.share

import com.brewmapp.brewmapp.core.presentation.base.BaseContract

interface ShareContract {
    interface View : BaseContract.View

    interface Presenter: BaseContract.Presenter<View>
}