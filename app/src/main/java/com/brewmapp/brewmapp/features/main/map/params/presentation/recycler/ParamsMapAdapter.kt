package com.brewmapp.brewmapp.features.main.map.params.presentation.recycler

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import android.view.LayoutInflater
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.core.city.CityActivity
import com.brewmapp.brewmapp.features.core.city.data.TypeCity
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.brewmapp.brewmapp.features.main.profile.NewsController
import com.brewmapp.brewmapp.features.main.profile.ParamActivity
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.SearchViewHolder
import kotlinx.android.synthetic.main.item_search.view.*

class ParamsMapAdapter(private val searches: MutableList<Search>, val activity: Activity?) : RecyclerView.Adapter<SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search, parent, false)
        return SearchViewHolder(v)
    }

    override fun getItemCount(): Int {
        return searches.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val search = searches[position]
        holder.itemView.title.text = search.title
        holder.itemView.icon.setImageResource(search.image!!)
        search.select = isFiltered(search.typeSearch)
        if (search.select)
            holder.itemView.background = activity!!.resources.getDrawable(R.color.green_transparent)
        holder.itemView.setOnClickListener {
            if (search.typeSearch == TypeSearch.MAP_RESTO_CITY) {
                val intent = Intent(activity, CityActivity::class.java)
                intent.putExtra("type", TypeCity.MAP.name)
                activity!!.startActivity(intent)
            } else {
                val intent = Intent(activity, ParamActivity::class.java)
                intent.putExtra("screen", "map")
                Log.i("code", "extra ${intent.getStringExtra("screen")}")
                ParamsMapController.field = search.typeSearch
                //intent.putExtra("field", search.typeSearch.field)
                activity!!.startActivity(intent)
            }
        }
    }

    private fun isFiltered(typeSearch: TypeSearch): Boolean {
        var map = hashMapOf<String, ArrayList<String>>()
        when (ParamsMapController.mode) {
            Mode.BEER -> map = ParamsMapController.beerFieldMap
            Mode.RESTO -> map = ParamsMapController.restoFieldMap
        }
        return if (map[typeSearch.field] != null) {
            map[typeSearch.field]!!.size > 0
        } else
            false
    }
}