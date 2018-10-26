package com.brewmapp.brewmapp.features.core.city.recycler

import android.app.Activity
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.core.city.CityActivity
import com.brewmapp.brewmapp.features.core.city.data.TypeCity
import com.brewmapp.brewmapp.features.main.map.params.presentation.ParamsMapController
import com.brewmapp.brewmapp.features.main.profile.NewsController
import com.brewmapp.brewmapp.features.main.profile.SignUpController
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ModelViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_city.view.*

class CityAdapter(private val models: MutableList<Model>, val activity: Activity) : androidx.recyclerview.widget.RecyclerView.Adapter<ModelViewHolder>() {
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
        holder.itemView.setOnClickListener {
            when (CityActivity.type) {
                TypeCity.SIGN_UP.name -> {
                    SignUpController.cityId = model.id
                    SignUpController.cityName = model.name["1"]!!
                }
                TypeCity.NEWS.name -> {
                    NewsController.cityNewsId = model.id
                    NewsController.cityNewsName = model.name["1"]!!
                }
                TypeCity.EVENTS.name -> {
                    NewsController.cityEventsId = model.id
                    NewsController.cityEventsName = model.name["1"]!!
                }
                TypeCity.REVIEWS.name -> {
                    NewsController.cityReviewsId = model.id
                    NewsController.cityReviewsName = model.name["1"]!!
                }
                TypeCity.MAP.name -> {
                    ParamsMapController.cityId = model.id
                    ParamsMapController.cityName = model.name["1"]!!
                }
            }
            activity.finish()
        }
        holder.itemView.title.text = model.name["1"]
        Glide.with(holder.itemView)
                .load(model.getThumb)
                .into(holder.itemView.image)
    }
}