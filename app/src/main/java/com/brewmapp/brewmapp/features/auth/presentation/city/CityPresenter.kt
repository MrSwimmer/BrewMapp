package com.brewmapp.brewmapp.features.auth.presentation.city

import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class CityPresenter : MvpBasePresenter<CityContract.View>(), CityContract.Presenter {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiParamService

    override fun setRecyclerData() {
        val type = TypeSearch.CITY.type
        apiService.getParams(type, object : ApiParamService.ParamCallback {
            override fun onSuccess(models: MutableList<Model>) {
                view.initAdapter(models)
                view.hideProgress()
            }

            override fun onError(it: Throwable) {
                view.showErrorMessage(it.message!!)
                view.hideProgress()
            }

        })
    }

}