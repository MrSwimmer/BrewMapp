package com.brewmapp.brewmapp.features.main.search.param.presentation.recycler

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_check.view.*

class ParamAdapter(private val models: MutableList<Model>, private val field: String) : RecyclerView.Adapter<ModelViewHolder>() {
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
        Log.i("code", SearchController.mode)
        Log.i("code", model.toString())
        when (SearchController.mode) {
            Mode.BEER.name -> map = SearchController.beerFieldMap
            Mode.BREWERY.name -> map = SearchController.breweryFieldMap
            Mode.RESTO.name -> map = SearchController.restoFieldMap
        }
        if (map[field] == null)
            map[field] = arrayListOf()
        if (map[field]!!.contains(model!!.id)) {
            holder.itemView.checkBox.isChecked = true
        }
        holder.itemView.checkBox.setOnCheckedChangeListener({ _, isChecked ->
            if (isChecked)
                map[field]!!.add(model.id)
            else
                map[field]!!.remove(model.id)
            Log.i("code", "beer ${SearchController.beerFieldMap}")
            Log.i("code", "brewery ${SearchController.breweryFieldMap}")
            Log.i("code", "resto ${SearchController.restoFieldMap}")
        })
        Log.i("code", "field $field")

        if (field == "type")
            holder.itemView.title.text = model.nameEn
        else
            holder.itemView.title.text = model.id

        Glide.with(holder.itemView)
                .load(model.getThumb)
                .into(holder.itemView.image)
    }
}