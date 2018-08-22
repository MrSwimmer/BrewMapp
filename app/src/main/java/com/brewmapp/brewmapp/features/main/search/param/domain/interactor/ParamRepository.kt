package com.brewmapp.brewmapp.features.main.search.param.domain.interactor

import android.util.Log
import com.bignerdranch.android.osm.data.room.Param
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import javax.inject.Inject

class ParamRepository {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiParamService: ApiParamService
    @Inject
    lateinit var roomParamService: RoomParamService

    fun getParams(typeSearch: TypeSearch, callback: ParamCallback) {
        roomParamService.getAllParams(typeSearch.type, object : RoomParamService.ParamCallback {
            override fun onSuccess(params: List<Param>) {
                Log.i("code", "params empty ${params.isEmpty()}")
                if(params.isEmpty()) {
                   apiParamService.getParams(typeSearch, object : ApiParamService.ParamCallback {
                       override fun onSuccess(models: MutableList<Model>) {
                           Log.i("code", "success get api params ${params.size}")
                           callback.onSuccess(models)
                           val newparams = arrayListOf<Param>()
                           models.forEach {
                               Log.i("code", "getThumb ${it.getThumb}")
                               val thumb = "" + it.getThumb
                               newparams.add(Param(it.id, it.name["1"]!!, thumb, typeSearch.type))
                           }
                           roomParamService.addParams(newparams, object : RoomParamService.EditNoteCallback {
                               override fun onSuccess() {
                                   Log.i("code", "success add params to room")
                               }

                               override fun onError(e: Throwable) {
                                   Log.i("code", "error add params to room ${e.message}")
                               }

                           })
                       }

                       override fun onError(it: Throwable) {
                           Log.i("code", "error get params ${it.message}")
                           callback.onError(it)
                       }

                   })
                } else {
                    Log.i("code", "success full params ${params.size}")
                    val models = arrayListOf<Model>()
                    params.forEach {
                        val names = hashMapOf<String, String>()
                        names["1"] = it.name
                        models.add(Model(it.id, names, it.getThumb))
                    }
                    callback.onSuccess(models)
                }
            }

            override fun onError(e: Throwable) {
                Log.i("code", "error get room params ${e.message}")
                callback.onError(e)
            }
        })
    }

    fun getCity(city: String, callback: ApiParamService.ParamCallback) {
        apiParamService.getCity(city, callback)
    }

    interface ParamCallback {
        fun onSuccess(params: List<Model>)
        fun onError(e: Throwable)
    }
}