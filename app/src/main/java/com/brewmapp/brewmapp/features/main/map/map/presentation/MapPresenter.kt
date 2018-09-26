package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.map.map.data.model.req.Coords
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Model
import com.brewmapp.brewmapp.features.main.map.map.domain.ApiMapService
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.google.android.gms.maps.model.LatLng
import javax.inject.Inject

class MapPresenter : BasePresenter<MapContract.View>(), MapContract.Presenter {
    init {
        App.component.inject(this)
    }

    @Inject
    lateinit var apiMapService: ApiMapService

    override fun getMarkers(begin: LatLng, end: LatLng) {
        val beginStr = "${begin.latitude}|${begin.longitude}"
        val endStr = "${end.latitude}|${end.longitude}"
        var curMap = hashMapOf<String, ArrayList<String>>()
        when (ParamsMapController.mode) {
            Mode.BEER -> curMap = ParamsMapController.beerFieldMap
            Mode.RESTO -> curMap = ParamsMapController.restoFieldMap
        }
        val map = hashMapOf<String, String>()
        Log.i("code", "curMap $curMap")
        /*Log.i("code", "beer ${ParamsMapController.beerFieldMap}")
        Log.i("code", "resto ${ParamsMapController.restoFieldMap}")*/
        curMap.forEach {
            map[it.key] = it.value.joinToString(separator = ",")
        }
        map["coordStart"] = beginStr
        map["coordEnd"] = endStr
        val coords = Coords(beginStr, endStr)
        Log.i("code", "map $map")
        apiMapService.getMarkers(map, object : ApiMapService.MapCallback {
            override fun onSuccess(models: MutableList<Model>) {
                Log.i("code", "success map ${models.size}")
                view.setMarkers(models)
            }

            override fun onError(it: Throwable) {
                Log.i("code", "error map ${it.message}")
            }
        })
    }
}