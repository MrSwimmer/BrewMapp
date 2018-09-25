package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.map.map.data.model.Model
import com.brewmapp.brewmapp.features.main.map.map.domain.ApiMapService
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
        apiMapService.getMarkers(beginStr, endStr, object : ApiMapService.mapCallback {
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