package com.brewmapp.brewmapp.features.main.search.param.presentation.recycler

import android.arch.paging.PagedListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.search.param.data.model.res.search.Model
import com.brewmapp.brewmapp.features.main.search.param.domain.util.ParamDiffUtilCallback
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_check.view.*

class ParamPagingAdapter(diffUtilCallback: ParamDiffUtilCallback) : PagedListAdapter<Model, ModelViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_check, parent, false)
        return ModelViewHolder(v)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
        val model = getItem(position)
        holder.itemView.title.text = model!!.name.get1()
        Glide.with(holder.itemView)
                .load(model.getThumb)
                .into(holder.itemView.image)
    }

}