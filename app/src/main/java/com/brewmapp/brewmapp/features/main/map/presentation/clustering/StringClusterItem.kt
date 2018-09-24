package com.brewmapp.brewmapp.features.main.map.presentation.clustering

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem


class StringClusterItem(val title: String, val latLng: LatLng) : ClusterItem {
    override fun getPosition(): LatLng {
        return latLng
    }
}