package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.core.presentation.base.BaseContract
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Model
import com.google.android.gms.maps.model.LatLng

interface MapContract {
    interface View : BaseContract.View {
        fun setMarkers(models: MutableList<Model>)
    }

    interface Presenter: BaseContract.Presenter<View> {
        fun getMarkers(begin: LatLng, end: LatLng)
        fun getResto(curRestoId: String)
    }
}