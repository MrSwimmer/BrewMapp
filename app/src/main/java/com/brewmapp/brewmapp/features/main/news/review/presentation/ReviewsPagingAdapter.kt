package com.brewmapp.brewmapp.features.main.news.review.presentation

import android.arch.paging.PagedListAdapter
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bluelinelabs.conductor.Router
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.news.core.presentation.recycler.BaseViewHolder
import com.brewmapp.brewmapp.features.main.news.review.data.model.Model
import com.brewmapp.brewmapp.features.main.news.review.domain.util.ReviewsDiffUtilCallback
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_review.view.*

class ReviewsPagingAdapter(diffUtilCallback: ReviewsDiffUtilCallback, val router: Router) : PagedListAdapter<Model, BaseViewHolder>(diffUtilCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_review, parent, false)
        return BaseViewHolder(v)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val model = getItem(position)
        if (model!!.relatedModelData.title != null) {
            if (model!!.relatedModelData.title._1 == null)
                holder.itemView.title.text = model.relatedModelData.title.get58()
            else
                holder.itemView.title.text = model.relatedModelData.title._1
        }
        holder.itemView.type.text = model.relatedModel

        holder.itemView.scent.text = model.relatedModelData.evaluation[0].evaluationValue
        holder.itemView.color.text = model.relatedModelData.evaluation[1].evaluationValue
        holder.itemView.taste.text = model.relatedModelData.evaluation[2].evaluationValue
        holder.itemView.aftertaste.text = model.relatedModelData.evaluation[3].evaluationValue
        holder.itemView.text.text = Html.fromHtml(model.text).toString()
        holder.itemView.titleProd.text = "${model.userInfo.firstname} ${model.userInfo.lastname}"
        holder.itemView.date.text = model.relatedModelData.evaluation[0].createdAt
        holder.itemView.likes.text = model.like
        holder.itemView.dislikes.text = model.disLike

        if (model.relatedModelData.userGetThumb != null && model.relatedModelData.userGetThumb.url != null) {
            Glide.with(holder.itemView)
                    .load(model.relatedModelData.userGetThumb.url)
                    .into(holder.itemView.iconProd)
        }

        Glide.with(holder.itemView)
                .load(model.relatedModelData.getThumb)
                .into(holder.itemView.icon)
    }
}