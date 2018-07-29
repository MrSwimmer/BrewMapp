package com.brewmapp.brewmapp.features.main.search.param.domain

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.AdSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Name
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum.AdSearchNum
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ApiParamService
import org.greenrobot.eventbus.EventBus
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class CallbackFabric {

    companion object {
        fun paramCallback(api: Observable<AdSearch>, callback: ApiParamService.ParamCallback) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ callback.onSuccess(it.models) }, { callback.onError(it) })
        }
        fun paramNumCallback(api: Observable<AdSearchNum>, callback: ApiParamService.ParamCallback) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        val newModels = arrayListOf<Model>()
                        it.models.forEach {
                            val model = Model(it.id, Name(it.name), it.getThumb)
                            newModels.add(model)
                        }
                        callback.onSuccess(newModels)
                    }, {
                        callback.onError(it)
                    })
        }

    }
}