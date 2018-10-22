package com.brewmapp.brewmapp.features.main.map.map.presentation

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.view.*
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BaseController
import com.brewmapp.brewmapp.features.main.MainActivity
import com.brewmapp.brewmapp.features.main.card.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.map.map.data.model.res.Model
import com.brewmapp.brewmapp.features.main.profile.MapContract
import com.brewmapp.brewmapp.features.main.profile.MapPresenter
import com.brewmapp.brewmapp.features.main.map.map.domain.cluster.StringClusterItem
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.bumptech.glide.Glide
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.maps.android.clustering.Cluster
import com.google.maps.android.clustering.ClusterManager
import kotlinx.android.synthetic.main.info_title.view.*
import android.graphics.Bitmap
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import com.brewmapp.brewmapp.features.main.profile.RestoController
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException


class MapController : BaseController<MapContract.View, MapContract.Presenter>(), OnMapReadyCallback, MapContract.View {
    lateinit var map: GoogleMap
    private lateinit var clusterManager: ClusterManager<StringClusterItem>
    val MY_LOC_CODE = 1
    lateinit var supportFragmentManager: FragmentManager
    lateinit var mapFragment: SupportMapFragment

    companion object {
        lateinit var saveView: View
    }

    private val TAG = "code"

    lateinit var curRestoId: String
    var curResto: com.brewmapp.brewmapp.features.main.card.resto.data.model.Model? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return try {
            val v = inflater.inflate(R.layout.activity_map, container, false)
            val activity = activity as MainActivity
            mapFragment = activity.supportFragmentManager()!!.findFragmentById(R.id.map) as SupportMapFragment
            mapFragment.getMapAsync(this)
            supportFragmentManager = activity.supportFragmentManager()!!
            setHasOptionsMenu(true)
            saveView = v
            v
        } catch (e: Exception) {
            saveView
        }
    }

    override fun createPresenter(): MapContract.Presenter {
        return MapPresenter()
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        map.animateCamera(CameraUpdateFactory.zoomTo(8.0f))
        clusterManager = ClusterManager(activity, map)

        map.setOnCameraIdleListener(clusterManager)
        map.setOnMarkerClickListener(clusterManager)
        map.setOnInfoWindowClickListener(clusterManager)
        map.setOnCameraMoveListener {
            getMarkers()
        }

        getMarkers()

        clusterManager.setOnClusterItemInfoWindowClickListener {
            Log.i("code", "click ${supportFragmentManager.fragments.size}")
            supportFragmentManager.beginTransaction().remove(supportFragmentManager.fragments[0]).runOnCommit {
                Log.i("code", "click2 ${supportFragmentManager.fragments.size}")
                router.pushController(RouterTransaction.with(RestoController(curRestoId)))
            }.commit()
        }

        clusterManager.setOnClusterItemClickListener(object : ClusterManager.OnClusterClickListener<StringClusterItem>, ClusterManager.OnClusterItemClickListener<StringClusterItem> {
            override fun onClusterClick(p0: Cluster<StringClusterItem>): Boolean {
                return false
            }

            override fun onClusterItemClick(p0: StringClusterItem?): Boolean {
                curRestoId = p0!!.id
                return false
            }

        })

        map.setInfoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
            override fun getInfoContents(p0: Marker): View? {
                val v = activity!!.layoutInflater.inflate(R.layout.info_title, null)
                if (curResto != null) {
                    if (curRestoId == curResto!!.resto[0].id) {
                        drawWindow(v, p0)
                        return v
                    }
                }
                loadResto(p0)
                return v
            }

            override fun getInfoWindow(p0: Marker?): View? {
                return null
            }
        })

        val permissionStatusFineLoc = ContextCompat.checkSelfPermission(activity!!, Manifest.permission.ACCESS_FINE_LOCATION)

        if (permissionStatusFineLoc == PackageManager.PERMISSION_GRANTED) {
            map.uiSettings.isMyLocationButtonEnabled = true
            map.isMyLocationEnabled = true
        } else {
            ActivityCompat.requestPermissions(activity!!, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), MY_LOC_CODE)
        }

    }

    private fun loadResto(p0: Marker) {
        try {
            presenter.getResto(curRestoId, object : ApiProductService.RestoCallback {
                override fun onSuccess(model: com.brewmapp.brewmapp.features.main.card.resto.data.model.Model) {
                    curResto = model
                    p0.showInfoWindow()
                }

                override fun onError(it: Throwable) {
                    Log.i("code", "eror resto ${it.message}")
                }
            })
        } catch (e: Exception) {

        }
    }

    private fun drawWindow(v: View, p0: Marker) {
        val resto = curResto!!.resto[0]
        val loc = resto.location
        v.title.text = resto.name.get1()
        v.mark.text = resto.avgBall
        v.city.text = loc.cityId.get1()
        if (loc.metro != null)
            v.metro.text = loc.metro.name.get1()
        val url = resto.getThumb
        if (url != null)
            drawImage(url, p0, v)
    }

    private fun drawImage(url: String, p0: Marker, v: View) {
        Glide.with(activity!!)
                .asBitmap()
                .load("https://www.brewmapp.com/$url")
                .listener(object : RequestListener<Bitmap> {
                    override fun onResourceReady(resource: Bitmap?, model: Any?, target: com.bumptech.glide.request.target.Target<Bitmap>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: com.bumptech.glide.request.target.Target<Bitmap>?, isFirstResource: Boolean): Boolean {
                        if (isFirstResource) p0.showInfoWindow()
                        return false
                    }
                })
                .into(v.icon)
    }

    private fun getMarkers() {
        val left = map.projection.visibleRegion.farLeft
        val right = map.projection.visibleRegion.farRight
        val pos = map.cameraPosition.target
        val begin = LatLng(left.latitude, left.longitude)
        this.begin = begin
        val end = LatLng(pos.latitude - (right.latitude - pos.latitude), right.longitude)
        Log.i("code", "begin $begin")
        Log.i("code", "end $end")
        presenter.getMarkers(begin, end)
    }

    override fun setMarkers(models: MutableList<Model>, begin: LatLng) {
        if (begin == this.begin) {
            Log.i("code", "begin sss")
            clusterManager.clearItems()
            Log.i("code", "setmarkers ${models.size}")
            models.forEach {
                val lat = it.locationLat
                val lng = it.locationLon
                val pos = LatLng(lat.toDouble(), lng.toDouble())
                clusterManager.addItem(StringClusterItem(it.restoId, pos))
            }
            clusterManager.cluster()
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

    override fun onDestroyView(view: View) {
        super.onDestroyView(view)
        val activity = activity as MainActivity
        val f = activity.supportFragmentManager
                .findFragmentById(R.id.map)
        if (f != null)
            activity.supportFragmentManager()!!.beginTransaction().remove(f).commit()
    }

    lateinit var begin: LatLng
}
