package com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R

class RestoAdapter : RecyclerView.Adapter<RestoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_beer_param, parent, false)
        return RestoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: RestoViewHolder, position: Int) {
        
    }
}