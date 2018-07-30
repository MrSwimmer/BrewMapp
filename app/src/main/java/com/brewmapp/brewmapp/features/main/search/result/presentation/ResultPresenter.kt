package com.brewmapp.brewmapp.features.main.search.result.presentation

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Result
import com.brewmapp.brewmapp.features.main.search.result.domain.interactor.ApiResultService
import java.util.*
import javax.inject.Inject

class ResultPresenter : BasePresenter<ResultContract.View>(), ResultContract.Presenter {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiService: ApiResultService

    override fun setRecyclerData() {
        var map: HashMap<String, String> = hashMapOf()
        SearchController.beerFieldMap.forEach {
            when (SearchController.mode) {
                Mode.BEER.name -> map["Beer[${it.key}]"] = it.value.joinToString(separator = ",")
                Mode.BREWERY.name -> map["Brewery[${it.key}]"] = it.value.joinToString(separator = ",")
                Mode.RESTO.name -> map["Resto[${it.key}]"] = it.value.joinToString(separator = ",")
            }
        }
        if (SearchController.mode == Mode.BREWERY.name)
            map["Brewery[id]"] = ""
            Log.i("code", "map0 $map")
        apiService.getResult(SearchController.mode, map, object : ApiResultService.ResultCallback {
            override fun onSuccess(it: Result) {
                view.setAdapter(it.models)
            }

            override fun onError(it: Throwable) {
                Log.i("code", "error ${it.message}")
                view.showErrorMessage("Ошибка")
                view.hideProgress()
            }

        })
    }
}