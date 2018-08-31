package com.brewmapp.brewmapp.features.main.news.news.presentation

import android.arch.paging.PagedListAdapter
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.news.news.data.model.Model
import com.brewmapp.brewmapp.features.main.news.news.domain.util.NewsDiffUtilCallback
import com.brewmapp.brewmapp.features.main.news.core.presentation.recycler.BaseViewHolder
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_news.view.*
import org.jsoup.Jsoup

class NewsPagingAdapter(diffUtilCallback: NewsDiffUtilCallback, val router: Router) : PagedListAdapter<Model, BaseViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return BaseViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val model = getItem(position)
        Log.i("code", "image ${model!!.getThumb}")
        Glide.with(holder.itemView)
                .load("https://www.brewmapp.com/${model.getThumb}")
                .into(holder.itemView.image)
        if (model.text.get1() != null)
            holder.itemView.text.text = Jsoup.parse(model.text.get1()).text()
        holder.itemView.date.text = model.timestamp
        holder.itemView.like.text = model.like
    }
}