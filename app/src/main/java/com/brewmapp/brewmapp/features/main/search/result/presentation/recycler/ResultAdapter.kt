package com.brewmapp.brewmapp.features.main.search.result.presentation.recycler

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.features.main.profile.ProductController
import com.brewmapp.brewmapp.features.main.profile.SearchController
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_result.view.*
import org.jsoup.Jsoup

class ResultAdapter(private val models: List<Model>, val router: Router) : RecyclerView.Adapter<ResultViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_result, parent, false)
        return ResultViewHolder(v)
    }

    override fun getItemCount(): Int {
        return models.size
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val model = models[position]
        if (model.title == null) {
            holder.itemView.title.text = model.name["1"]
        } else
            holder.itemView.title.text = model.title["1"]
        //Log.i("code", "title ${model.title["1"]}")
        Log.i("code", "text ${model.text["1"]}")
        var url: String
        url = if (SearchController.mode == Mode.BEER.name)
            model.getThumb
        else
            "https://developer.brewmapp.com/${model.getThumb}"
        Glide.with(holder.itemView)
                .load(url)
                .into(holder.itemView.image)
        holder.itemView.mark.text = model.avgBall
        if (model.text["1"] != null)
            holder.itemView.description.text = Jsoup.parse(model.text["1"]).text()
        holder.itemView.setOnClickListener({

            //router.pushController(RouterTransaction.with(ProductController(model.id)))
        })
    }
}