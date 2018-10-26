package com.brewmapp.brewmapp.features.main.search.param.presentation.recycler

import androidx.recyclerview.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.brewmapp.brewmapp.features.main.profile.ParamActivity
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_check.view.*

class ParamAdapter(private val models: MutableList<Model>, private val field: String) : androidx.recyclerview.widget.RecyclerView.Adapter<ModelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_check, parent, false)
        return ModelViewHolder(v)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = models[position]

        var map: HashMap<String, ArrayList<String>> = hashMapOf()

        when (ParamActivity.screen) {
            "search" -> {
                when (SearchController.mode) {
                    Mode.BEER -> map = SearchController.beerFieldMap
                    Mode.BREWERY -> map = SearchController.breweryFieldMap
                    Mode.RESTO -> map = SearchController.restoFieldMap
                }
            }
            "map" -> {
                when (ParamsMapController.mode) {
                    Mode.BEER -> map = ParamsMapController.beerFieldMap
                    Mode.RESTO -> map = ParamsMapController.restoFieldMap
                }
            }
        }

        if (map[field] == null)
            map[field] = arrayListOf()

        if (map[field]!!.contains(model.id))
            holder.itemView.checkBox.isChecked = true

        holder.itemView.checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked)
                map[field]!!.add(model.id)
            else
                map[field]!!.remove(model.id)
        }

        holder.itemView.title.text = model.name["1"]

        if (model.getThumb != null)
            Glide.with(holder.itemView)
                    .load(model.getThumb)
                    .into(holder.itemView.image)
    }
}