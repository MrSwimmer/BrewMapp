package com.brewmapp.brewmapp.features.main.map.map.presentation

import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.*
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.MainActivity
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Model
import com.brewmapp.brewmapp.features.main.profile.MapContract
import com.brewmapp.brewmapp.features.main.profile.MapPresenter
import com.brewmapp.brewmapp.features.main.map.map.presentation.clustering.StringClusterItem
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterManager
import org.json.JSONObject

class MapController : BaseController<MapContract.View, MapContract.Presenter>(), OnMapReadyCallback, MapContract.View {
    lateinit var map: GoogleMap
    lateinit var clusterManager: ClusterManager<StringClusterItem>
    val TAG = "code"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val v = inflater.inflate(R.layout.activity_map, container, false)
        val activity = activity as MainActivity
        val mapFragment = activity.supportFragmentManager()!!.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        setHasOptionsMenu(true)
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
            callMarkers()
        }
        callMarkers()
        if (ActivityCompat.checkSelfPermission(activity!!,
                        android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(activity!!, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            return
        }
        map.uiSettings.isMyLocationButtonEnabled = true
        map.isMyLocationEnabled = true
    }

    private fun callMarkers() {
        val left = map.projection.visibleRegion.farLeft
        val right = map.projection.visibleRegion.farRight
        val pos = map.cameraPosition.target
        val begin = LatLng(left.latitude, left.longitude)
        val end = LatLng(pos.latitude - (right.latitude - pos.latitude), right.longitude)
        Log.i(TAG, "begin $begin")
        Log.i(TAG, "end $end")
        Log.i(TAG, "pos $pos")
        presenter.getMarkers(begin, end)
    }

    override fun setMarkers(models: MutableList<Model>) {
        clusterManager.clearItems()
        models.forEach {
            val lat = it.locationLat
            val lng = it.locationLon
            val pos = LatLng(lat.toDouble(), lng.toDouble())
            val name = JSONObject(it.name)
            clusterManager.addItem(StringClusterItem(name.getString("1"), pos))
        }
        clusterManager.cluster()
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

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        val activity = activity as MainActivity
        val f = activity.supportFragmentManager
                .findFragmentById(R.id.map)
        if (f != null)
            activity.supportFragmentManager()!!.beginTransaction().remove(f).commit()
    }
}