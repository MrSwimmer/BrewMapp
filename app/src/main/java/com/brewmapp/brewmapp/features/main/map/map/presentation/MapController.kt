package com.brewmapp.brewmapp.features.main.map.map.presentation

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.*
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.MainActivity
import com.brewmapp.brewmapp.features.main.map.map.data.model.Model
import com.brewmapp.brewmapp.features.main.profile.MapContract
import com.brewmapp.brewmapp.features.main.profile.MapPresenter
import kotlinx.android.synthetic.main.activity_map.view.*
import com.brewmapp.brewmapp.features.main.map.map.presentation.clustering.StringClusterItem
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.maps.android.clustering.ClusterManager

class MapController : BaseController<MapContract.View, MapContract.Presenter>(), OnMapReadyCallback, MapContract.View {
    lateinit var map: GoogleMap
    lateinit var begin: LatLng
    lateinit var end: LatLng
    lateinit var clusterManager: ClusterManager<StringClusterItem>
    val TAG = "code"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val v = inflater.inflate(R.layout.activity_map, container, false)
        val activity = activity as MainActivity
        val mapFragment = activity.supportFragmentManager()!!.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setHasOptionsMenu(true)
        v.button.setOnClickListener {
            map.addMarker(MarkerOptions().position(begin).title("begin"))
            map.addMarker(MarkerOptions().position(end).title("end"))
        }
        return v
    }

    override fun createPresenter(): MapContract.Presenter {
        return MapPresenter()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        Log.i(TAG, "onMapReday")
        map = googleMap
        clusterManager = ClusterManager(activity, map)
        map.setOnCameraIdleListener(clusterManager)
        map.setOnCameraMoveListener {
            val left = map.projection.visibleRegion.farLeft
            val right = map.projection.visibleRegion.farRight
            val pos = map.cameraPosition.target
            begin = LatLng(left.latitude, left.longitude)
            end = LatLng(pos.latitude - (right.latitude - pos.latitude), right.longitude)
            Log.i(TAG, "begin $begin")
            Log.i(TAG, "end $end")
            Log.i(TAG, "pos $pos")
            presenter.getMarkers(begin, end)
        }
        for (i in 0..9) {
            val latLng = LatLng((-34 + i).toDouble(), (151 + i).toDouble())
            clusterManager.addItem(StringClusterItem("Marker #" + (i + 1), latLng))
        }
        clusterManager.cluster()
        if (ActivityCompat.checkSelfPermission(activity!!,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(activity!!, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return
        }
        map.isMyLocationEnabled = true
        map.uiSettings.isMyLocationButtonEnabled = true
    }

    override fun setMarkers(models: MutableList<Model>) {
        models.forEach {
            val lat = it.locationLat
            val lng = it.locationLon
            val pos = LatLng(lat.toDouble(), lng.toDouble())
            map.addMarker(MarkerOptions().position(pos))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.map_search_params, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_map_search -> router.pushController(RouterTransaction.with(ParamsMapController()))
        }
        return super.onOptionsItemSelected(item)
    }
}