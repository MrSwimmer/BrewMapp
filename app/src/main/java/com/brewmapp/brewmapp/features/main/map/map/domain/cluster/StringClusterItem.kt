package com.brewmapp.brewmapp.features.main.map.map.domain.cluster

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem


class StringClusterItem(val id: String, val latLng: LatLng) : ClusterItem {
    override fun getPosition(): LatLng {
        return latLng
    }
}