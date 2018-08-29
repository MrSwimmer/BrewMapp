package com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import kotlinx.android.synthetic.main.item_beer_param.view.*

class ParamAdapter(private val paramsList: MutableList<Param>) : RecyclerView.Adapter<ParamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ParamViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_beer_param, parent, false)
        return ParamViewHolder(v)
    }

    override fun getItemCount(): Int {
        return paramsList.size
    }

    override fun onBindViewHolder(holder: ParamViewHolder, position: Int) {
        val param = paramsList[position]
        holder.itemView.param.text = param.param
        holder.itemView.text.text = param.text
        holder.itemView.icon.setImageResource(param.iconId)
    }
}