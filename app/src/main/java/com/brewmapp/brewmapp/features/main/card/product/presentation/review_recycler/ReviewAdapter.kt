package com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model

class ReviewAdapter(val reviewList: MutableList<Model>) : RecyclerView.Adapter<RestoViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_beer_review, parent, false)
        return RestoViewHolder(v)
    }

    override fun getItemCount(): Int {
        return reviewList.size
    }

    override fun onBindViewHolder(holder: RestoViewHolder, position: Int) {
        val review = reviewList[position]
    }
}