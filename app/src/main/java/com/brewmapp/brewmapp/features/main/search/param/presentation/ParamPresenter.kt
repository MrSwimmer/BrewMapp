package com.brewmapp.brewmapp.features.main.search.param.presentation

import android.arch.paging.PagedList
import android.os.Handler
import android.os.Looper
import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.features.main.profile.ParamActivity
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import javax.inject.Inject

class ParamPresenter : MvpBasePresenter<ParamContract.View>(), ParamContract.Presenter {
    override fun setRecyclerCity(city: String?) {
        apiService.getCity(city!!, object : ApiParamService.ParamCallback {
            override fun onSuccess(models: MutableList<Model>) {
                if (ParamActivity.cutText == city) {
                    Log.i("code", "null view ${view == null}")
                    if (view != null) {
                        view.initAdapter(models)
                        view.hideProgress()
                    }
                }
            }

            override fun onError(it: Throwable) {
                if (ParamActivity.cutText == city) {
                    if (view != null) {
                        view.showErrorMessage(it.message!!)
                        view.hideProgress()
                    }
                }
            }
        })
    }

    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiParamService

    override fun setRecyclerData(type: String) {
        apiService.getParams(type, object : ApiParamService.ParamCallback {
            override fun onSuccess(models: MutableList<Model>) {
                Log.i("code", "null view ${view == null}")
                if (view != null) {
                    view.initAdapter(models)
                    view.hideProgress()
                }
            }

            override fun onError(it: Throwable) {
                if (view != null) {
                    view.showErrorMessage(it.message!!)
                    view.hideProgress()
                }
            }

        })
    }
}