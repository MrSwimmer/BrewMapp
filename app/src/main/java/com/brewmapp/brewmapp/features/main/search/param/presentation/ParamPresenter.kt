package com.brewmapp.brewmapp.features.main.search.param.presentation

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.profile.ParamActivity
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ParamRepository
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.RoomParamService
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import javax.inject.Inject

class ParamPresenter : MvpBasePresenter<ParamContract.View>(), ParamContract.Presenter {
    lateinit var paramRepository: ParamRepository
    init {
        App.component.inject(this)
        paramRepository = ParamRepository(apiParamService, roomParamService)
    }

    @Inject
    lateinit var roomParamService: RoomParamService

    @Inject
    lateinit var apiParamService: ApiParamService

    override fun setRecyclerCity(city: String?) {

        paramRepository.getCity(city!!, object : ApiParamService.ParamCallback {
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

    override fun setRecyclerData(field: TypeSearch) {
        paramRepository.getParams(field, object : ParamRepository.ParamCallback {
            override fun onSuccess(params: List<Model>) {

                if (view != null) {
                    view.initAdapter(params as MutableList<Model>)
                    view.hideProgress()
                }
            }

            override fun onError(it: Throwable) {
                Log.i("code", "error params ${it.message}")
                if (view != null) {
                    view.showErrorMessage(it.message!!)
                    view.hideProgress()
                }
            }

        })
    }
}