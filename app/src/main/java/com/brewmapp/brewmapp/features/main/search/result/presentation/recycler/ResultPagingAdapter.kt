package com.brewmapp.brewmapp.features.main.search.result.presentation.recycler

import android.arch.paging.PagedListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.search.param.presentation.recycler.ModelViewHolder
import com.brewmapp.brewmapp.features.main.search.result.data.model.beer.Model
import com.brewmapp.brewmapp.features.main.search.result.domain.util.ResultDiffUtilCallback
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_result.view.*

class ResultPagingAdapter(diffUtilCallback: ResultDiffUtilCallback) : PagedListAdapter<Model, ResultViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_result, parent, false)
        return ResultViewHolder(v)
    }

    override fun onBindViewHolder(holder: ResultViewHolder, position: Int) {
        val model = getItem(position)
        holder.itemView.title.text = model!!.title.get1()
        Glide.with(holder.itemView)
                .load(model.getThumb)
                .into(holder.itemView.image)
        holder.itemView.mark.text = model.avgBall
        holder.itemView.description.text = model.shortText.get1()
    }
}