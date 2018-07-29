package com.brewmapp.brewmapp.features.main.search.param.presentation

import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class ParamPresenter : MvpBasePresenter<ParamContract.View>(), ParamContract.Presenter {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiParamService

    override fun setRecyclerData(type: String) {
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