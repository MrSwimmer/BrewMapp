package com.brewmapp.brewmapp.features.main.news.presentation.recycler

import android.arch.paging.PagedListAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.news.data.model.news.Model
import com.brewmapp.brewmapp.features.main.news.domain.util.NewsDiffUtilCallback
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import org.jsoup.Jsoup

class NewsPagingAdapter(diffUtilCallback: NewsDiffUtilCallback, val router: Router) : PagedListAdapter<Model, NewsViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return NewsViewHolder(v)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val model = getItem(position)
        Log.i("code", "image ${model!!.getThumb}")
        Glide.with(holder.itemView)
                .load("https://www.brewmapp.com/${model!!.getThumb}")
                .into(holder.itemView.image)
        if (model.text["1"] != null)
            holder.itemView.text.text = Jsoup.parse(model.text["1"]).text()
        /*if (model.text["1"] != null)
            holder.itemView.text.text = model.text["1"]*/
        holder.itemView.date.text = model.timestamp
        holder.itemView.like.text = model.like
    }
}