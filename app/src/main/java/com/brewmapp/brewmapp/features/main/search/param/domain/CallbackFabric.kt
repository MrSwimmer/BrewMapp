package com.brewmapp.brewmapp.features.main.search.param.domain

import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.ParamResult
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum.ParamResultNum
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class CallbackFabric {

    companion object {
        fun paramCallback(api: Observable<ParamResult>, callback: ApiParamService.ParamCallback) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ callback.onSuccess(it.models) }, { callback.onError(it) })
        }
        fun paramNumCallback(api: Observable<ParamResultNum>, callback: ApiParamService.ParamCallback) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        val newModels = arrayListOf<Model>()
                        it.models.forEach {
                            val model = Model(it.id, hashMapOf(Pair("1", it.name)), it.getThumb)
                            newModels.add(model)
                        }
                        callback.onSuccess(newModels)
                    }, {
                        callback.onError(it)
                    })
        }

    }
}