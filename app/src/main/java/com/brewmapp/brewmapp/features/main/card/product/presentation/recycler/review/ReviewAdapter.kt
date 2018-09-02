package com.brewmapp.brewmapp.features.main.card.product.presentation.recycler.param

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_beer_review.view.*

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
        holder.itemView.yes.text = "да ${review.interested}"
        holder.itemView.no.text = "нет ${review.noInterested}"
        holder.itemView.scent.text = review.relatedModelData.evaluation[0].evaluationValue
        holder.itemView.color.text = review.relatedModelData.evaluation[1].evaluationValue
        holder.itemView.taste.text = review.relatedModelData.evaluation[2].evaluationValue
        holder.itemView.aftertaste.text = review.relatedModelData.evaluation[3].evaluationValue
        holder.itemView.text.text = review.text
        holder.itemView.title.text = "${review.userInfo.firstname} ${review.userInfo.lastname}"
        holder.itemView.date.text = review.relatedModelData.evaluation[0].createdAt
        Glide.with(holder.itemView)
                .load(review.userGetThumb.urlPreview)
                .into(holder.itemView.icon)
    }
}