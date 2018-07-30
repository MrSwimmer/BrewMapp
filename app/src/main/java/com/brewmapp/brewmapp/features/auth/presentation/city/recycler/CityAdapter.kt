package com.brewmapp.brewmapp.features.auth.presentation.city.recycler

import android.app.Activity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.profile.SignUpController
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ModelViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_check.view.*

class CityAdapter(private val models: MutableList<Model>, val activity: Activity) : RecyclerView.Adapter<ModelViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_city, parent, false)
        return ModelViewHolder(v)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = models[position]
        holder.itemView.setOnClickListener({
            SignUpController.cityId = model.id
            SignUpController.cityName = model.name["1"]!!
            activity.finish()
        })

        Glide.with(holder.itemView)
                .load(model.getThumb)
                .into(holder.itemView.image)
    }
}