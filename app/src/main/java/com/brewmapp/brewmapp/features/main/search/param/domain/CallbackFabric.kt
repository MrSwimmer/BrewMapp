package com.brewmapp.brewmapp.features.main.search.param.domain

import android.arch.paging.PositionalDataSource
import android.util.Log
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.AdSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Name
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.searchnum.AdSearchNum
import org.greenrobot.eventbus.EventBus
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class CallbackFabric {

    companion object {
        fun initCallback(api: Observable<AdSearch>, callback: PositionalDataSource.LoadInitialCallback<Model>) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        EventBus.getDefault().post("hide")
                        callback.onResult(it.models, 0)
                    }, {
                        EventBus.getDefault().post("error")
                        Log.i("code", "range error ${it.message}")
                    })
        }
        fun initNumCallback(api: Observable<AdSearchNum>, callback: PositionalDataSource.LoadInitialCallback<Model>) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        EventBus.getDefault().post("hide")
                        val newModels = arrayListOf<Model>()
                        it.models.forEach {
                            val model = Model(it.id, Name(it.name), it.getThumb)
                            newModels.add(model)
                        }
                        callback.onResult(newModels, 0)
                    }, {
                        EventBus.getDefault().post("error")
                        Log.i("code", "range error ${it.message}")
                    })
        }
        fun rangeCallback(api: Observable<AdSearch>, callback: PositionalDataSource.LoadRangeCallback<Model>) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        callback.onResult(it.models)
                    }, {
                        EventBus.getDefault().post("error")
                        Log.i("code", "range error ${it.message}")
                    })
        }

        fun rangeNumCallback(api: Observable<AdSearchNum>, callback: PositionalDataSource.LoadRangeCallback<Model>) {
            api.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        EventBus.getDefault().post("hide")
                        val newModels = arrayListOf<Model>()
                        it.models.forEach {
                            val model = Model(it.id, Name(it.name), it.getThumb)
                            newModels.add(model)
                        }
                        callback.onResult(newModels)
                    }, {
                        EventBus.getDefault().post("error")
                        Log.i("code", "range error ${it.message}")
                    })
        }

    }
}