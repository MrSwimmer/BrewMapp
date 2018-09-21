package com.brewmapp.brewmapp.features.main.map.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.FragmentActivity
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.MainActivity
import com.brewmapp.brewmapp.features.main.profile.MapContract
import com.brewmapp.brewmapp.features.main.profile.MapPresenter
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.geometry.Point
import com.hannesdorfmann.mosby3.mvp.MvpActivity


class MapsController : BaseController<MapContract.View, MapContract.Presenter>(), OnMapReadyCallback {
    lateinit var map: GoogleMap
    val TAG = "code"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val v = inflater.inflate(R.layout.activity_map, container, false)
        val activity = activity as MainActivity
        val mapFragment = activity.supportFragmentManager()!!.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        return v
    }

    override fun createPresenter(): MapContract.Presenter {
        return MapPresenter()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        Log.i(TAG, "onMapReday")
        map = googleMap
        val sydney = LatLng(-34.0, 151.0)
        map.addMarker(MarkerOptions().position(sydney).title("KEKOS"))
        map.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        map.setOnCameraMoveListener {
            val zoom = map.cameraPosition.zoom
            Log.i(TAG, "zoom $zoom")
            val pos = map.cameraPosition.target
            val kostil = 8 / zoom
            val begin = LatLng(pos.latitude + kostil, pos.longitude - kostil)
            val end = LatLng(pos.latitude - kostil, pos.longitude + kostil)
            Log.i(TAG, "begin $begin")
            Log.i(TAG, "end $end")
            Log.i(TAG, "pos $pos")
            /*map.addMarker(MarkerOptions().position(begin).title("BEGIN"))
            map.addMarker(MarkerOptions().position(end).title("END"))*/
        }


    }
}